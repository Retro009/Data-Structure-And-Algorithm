package Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseBElement {
    public static void main(String[] args) {
        System.out.println(reverse(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6)),3));
    }
    static ArrayList<Integer> reverse(ArrayList<Integer> A, int B){
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<B;i++){
            queue.add(A.remove(0));
        }
        for (int i=0;i<B;i++){
            A.add(0,queue.poll());
        }
        return A;
    }
}
