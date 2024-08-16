package GreedyAlgorithm;

public class CoinSorting {
    public static void main(String[] args) {
        System.out.println(minCoinsRequiredII(47));
    }
    static int minCoinsRequired(int A){
        int sum = 0;
        int count = 0;
        while(A>0){
            int coin = 1;
            while (coin*5 <= A){
                coin=coin*5;
            }
            A=A-coin;
            sum+=coin;
            count++;
        }
        return count;
    }

    static int minCoinsRequiredII(int A){
        int maxCoin = 1;
        int count = 0;
        while(maxCoin*5<=A)
            maxCoin*=5;
        while(A>0){
            count+=A/maxCoin;
            A = A%maxCoin;
            maxCoin/=5;
        }
        return count;
    }
}
