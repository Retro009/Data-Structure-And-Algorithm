package Tree;

import java.util.HashSet;
import java.util.Set;

public class TwoSumBST {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(14);
        A.right = new TreeNode(15);
        System.out.println(t2Sum(A,14));
    }
    static Set<Integer> set = new HashSet<>();
    static int t2Sum(TreeNode A, int B){
        if(inOrder(A,B))
            return 1;
        return 0;
    }

    static boolean inOrder(TreeNode A,int B){
        boolean left = false;
        boolean right = false;
        if(A.left!=null)
            left = inOrder(A.left, B);
        if(!set.isEmpty() && set.contains(B-A.val))
            return true;
        set.add(A.val);
        if(A.right!=null)
            right = inOrder(A.right, B);
        return left||right;
    }

    //also try another approach with forward stack and backward stack
}
