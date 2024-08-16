package Tree;

import java.util.*;

public class DeserializeTree {
    public static void main(String[] args) {
        System.out.println(SerializeTree.serialize(deserialize(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1)))));
    }
    static TreeNode deserialize(ArrayList<Integer> A){
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = new TreeNode(A.get(0));
        queue.offer(node);
        int index = 1;
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(A.get(index)!=-1){
                curr.left = new TreeNode(A.get(index));
                queue.offer(curr.left);
            }
            index++;
            if(A.get(index)!=-1){
                curr.right = new TreeNode((A.get(index)));
                queue.offer(curr.right);
            }
            index++;
        }
        return node;
    }
}
