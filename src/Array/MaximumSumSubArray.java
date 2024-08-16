package Array;

public class MaximumSumSubArray {
    public static void main(String[] args) {
        System.out.println(find(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
    private static int find(int[] nums){
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            maxSum = maxSum > sum ? maxSum : sum;
            if(sum<0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}
