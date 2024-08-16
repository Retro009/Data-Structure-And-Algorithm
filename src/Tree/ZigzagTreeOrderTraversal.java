package Tree;

import java.util.ArrayList;
import java.util.Stack;

public class ZigzagTreeOrderTraversal {
    public static void main(String[] args) {
        TreeNode A=new TreeNode(3);
        A.left = new TreeNode(9);
        A.right = new TreeNode(20);
        A.right.left = new TreeNode(15);
        A.right.right = new TreeNode(7);

        System.out.println(zigZagLevelOrder(A));
    }
    static ArrayList<ArrayList<Integer>> zigZagLevelOrder(TreeNode A){
        Stack<TreeNode> evenStack = new Stack<>();
        Stack<TreeNode> oddStack = new Stack<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        oddStack.add(A);
        while(!oddStack.isEmpty() || !evenStack.isEmpty()){
            ArrayList<Integer> oddArr = new ArrayList<>();
            while(!oddStack.isEmpty()){
                TreeNode curr = oddStack.pop();
                if(curr.left!=null)
                    evenStack.add(curr.left);
                if(curr.right!=null)
                    evenStack.add(curr.right);
                oddArr.add(curr.val);
            }
            if(!oddArr.isEmpty())
                res.add(oddArr);

            ArrayList<Integer> evenArr = new ArrayList<>();
            while(!evenStack.isEmpty()){
                TreeNode curr = evenStack.pop();
                if(curr.right!=null)
                    oddStack.add(curr.right);
                if(curr.left!=null)
                    oddStack.add(curr.left);
                evenArr.add(curr.val);
            }
            if(!evenArr.isEmpty())
                res.add(evenArr);
        }
        return res;
    }
}
