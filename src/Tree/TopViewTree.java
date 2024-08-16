package Tree;

import java.util.ArrayList;

public class TopViewTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
    }

    static ArrayList<Integer> topView(TreeNode curr){
        ArrayList<Integer> res = new ArrayList<>();
        res.add(curr.val);
        TreeNode left = curr.left;
        while(left!=null){
            res.add(left.val);
            left = left.left;
        }
        TreeNode right = curr.right;
        while(right!=null){
            res.add(right.val);
            right = right.right;
        }
        return res;
    }
}
