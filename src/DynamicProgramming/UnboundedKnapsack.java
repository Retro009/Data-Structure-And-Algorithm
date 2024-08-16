package DynamicProgramming;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int A[]={6,7};
        int B[]={5,5};
        System.out.println(unboundedKnapsack(10,A,B));
    }
    public static int unboundedKnapsack(int A, int[] B, int[] C) {
        int[] dp = new int[A + 1];

        for (int j = 1; j <= A; j++) {
            for (int i = 0; i < B.length; i++) {
                if (C[i] <= j) {
                    dp[j] = Math.max(dp[j], dp[j - C[i]] + B[i]);
                }
            }
        }

        return dp[A];
    }
}
