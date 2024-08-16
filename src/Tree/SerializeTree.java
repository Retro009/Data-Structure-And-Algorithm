package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeTree {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);
        A.left.left = new TreeNode(4);
        A.left.right = new TreeNode(5);
        A.right.right = new TreeNode(6);

        System.out.println(serialize(A));
    }
    public static ArrayList<Integer> serialize(TreeNode A){
        ArrayList<Integer> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        int count = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node==null)
                res.add(-1);
            else{
                queue.add(node.left);
                queue.add(node.right);
                res.add(node.val);
            }
        }

        return res;
    }


}
