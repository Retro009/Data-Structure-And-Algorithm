package Tree;

public class BSTNodeRange {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(8);
        A.left = new TreeNode(6);
        A.left.left = new TreeNode(1);
        A.right = new TreeNode(21);
        A.left.right = new TreeNode(7);
        System.out.println(count(A,2,20));
    }
    static int count(TreeNode A, int B, int C){
        int count = 0;
        if(A.val>=B && A.val<=C)
            count++;
        if(A.left!=null)
            count+=count(A.left,B,C);
        if(A.right!=null)
            count+=count(A.right,B,C);
        return count;
    }
}
