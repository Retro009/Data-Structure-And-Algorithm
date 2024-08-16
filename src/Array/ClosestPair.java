package Array;

import java.util.ArrayList;
import java.util.Arrays;

public class ClosestPair {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(1));
        ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(2, 4));

        System.out.println(solve(arr1, arr2, 4));
    }
    static ArrayList<Integer> solve(ArrayList<Integer> A,ArrayList<Integer> B, int C){
        int left = 0;
        int right = B.size()-1;
        ArrayList<Integer> res = new ArrayList<>(2);
        res.add(A.get(left));
        res.add(B.get(right));

        int minSum = Integer.MAX_VALUE;
        while(left<A.size() && right>=0){
            int sum = A.get(left)+B.get(right);
            if(Math.abs(sum-C)<minSum){
                res.set(0,A.get(left));
                res.set(1,B.get(right));
                minSum = Math.abs(sum-C);
            } else if (Math.abs(sum-C)==minSum && res.get(0)==A.get(left)) {
                res.set(1,B.get(right));
            }
            if(sum > C)
                right--;
            else
                left++;
        }
        return res;
    }
}
