package Tree;
/*
 *
 * Sum Binary Tree: A binary tree where each node value is sum of all node value present in its left subtree and right subtree
 *
 *           9
 *         /    \
 *        2      2           It's not a sum binary tree
 *       /  \    /
 *      2    2  2
 *
 *           26
 *         /    \
 *        10     3           It's a sum binary tree
 *       /  \     \
 *      6    4     3
 *
 * */
public class SumBinaryTree {
    public static void main(String[] args) {
        TreeNode A = new TreeNode(9);
        A.left = new TreeNode(2);
        A.right = new TreeNode(2);
        A.left.left = new TreeNode(2);
        A.left.right = new TreeNode(2);
        A.right.left = new TreeNode(2);


        int sum = solve(A);
        if(sum%2==0 && sum/2==A.val)
            System.out.println("Its a sum binary tree");
        else
            System.out.println("Its not a sum binary tree");
    }
    static int solve(TreeNode A){
        int lSum = 0;
        int rSum = 0;
        if(A.left!=null)
            lSum=solve(A.left);
        if(A.right!=null)
            rSum=solve(A.right);
        return lSum+rSum+ A.val;
    }
}
