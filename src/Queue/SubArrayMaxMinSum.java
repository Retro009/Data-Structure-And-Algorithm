package Queue;

import java.util.*;

public class SubArrayMaxMinSum {
    public static void main(String[] args) {
        System.out.println(minMaxSum(new ArrayList<Integer>(Arrays.asList(2, -1, 3)),2));
    }
    static int minMaxSum(ArrayList<Integer> A,int B){
        Deque<Integer> maxQ = new ArrayDeque<>();
        Deque<Integer> minQ = new ArrayDeque<>();
        long maxSum = 0;
        long minSum = 0;
        for(int i=0;i<B;i++){
            while(!maxQ.isEmpty() && A.get(maxQ.peekLast())<A.get(i)){
                maxQ.pollLast();
            }
            maxQ.offerLast(i);
            while(!minQ.isEmpty() && A.get(minQ.peekLast())>A.get(i)){
                minQ.pollLast();
            }
            minQ.offerLast(i);
        }
        maxSum+=A.get(maxQ.peekFirst());
        minSum+=A.get(minQ.peekFirst());

        for(int i=B;i<A.size();i++){
            if(!maxQ.isEmpty() && maxQ.peekFirst()==i-B)
                maxQ.pollFirst();
            while(!maxQ.isEmpty() && A.get(maxQ.peekLast())<A.get(i)){
                maxQ.pollLast();
            }
            maxQ.offerLast(i);
            maxSum+=A.get(maxQ.peekFirst());
            if(!minQ.isEmpty() && minQ.peekFirst()==i-B)
                minQ.pollFirst();
            while(!minQ.isEmpty() && A.get(minQ.peekLast())>A.get(i)){
                minQ.pollLast();
            }
            minQ.offerLast(i);
            minSum+=A.get(minQ.peekFirst());

        }
        return (int)(((maxSum+minSum)%1000000007)+1000000007)%1000000007;
    }
}
