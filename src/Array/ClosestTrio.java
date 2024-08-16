package Array;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.Arrays;

public class ClosestTrio {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(3, 5, 6));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(2));
        ArrayList<Integer> C = new ArrayList<Integer>(Arrays.asList(3, 4));

        System.out.println(solveII(A,B,C));
    }
    static int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C){
        int ptrA=0;
        int ptrB=0;
        int ptrC=0;
        int maxAway = Integer.MAX_VALUE;
        while(ptrA<A.size() && ptrB<B.size() && ptrC<C.size()){
            int AB = Math.abs(A.get(ptrA)-B.get(ptrB));
            int BC = Math.abs(B.get(ptrB)-C.get(ptrC));
            int CA = Math.abs(C.get(ptrC)-A.get(ptrA));
            int max = Math.max(AB,Math.max(BC,CA));
            maxAway = Math.min(maxAway,max);
            if(A.get(ptrA)<=B.get(ptrB) && A.get(ptrA)<=C.get(ptrC))
                ptrA++;
            else if(B.get(ptrB)<=A.get(ptrA) && B.get(ptrB)<=C.get(ptrC))
                ptrB++;
            else
                ptrC++;
        }

        return maxAway;
    }

    static int solveII(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C){
        int ptrA=0;
        int ptrB=0;
        int ptrC=0;
        int maxAway = Integer.MAX_VALUE;
        while(ptrA<A.size() && ptrB<B.size() && ptrC<C.size()){
            maxAway = Math.min(maxAway, diffMaxMin(A.get(ptrA),B.get(ptrB),C.get(ptrC)));
            if(A.get(ptrA)<=B.get(ptrB) && A.get(ptrA)<=C.get(ptrC))
                ptrA++;
            else if(B.get(ptrB)<=A.get(ptrA) && B.get(ptrB)<=C.get(ptrC))
                ptrB++;
            else
                ptrC++;
        }

        return maxAway;
    }
    static int diffMaxMin(int a,int b,int c){
        int max,min;
        if(a<=b && a<=c)
            min=a;
        else if(b<=c && b<=a)
            min=b;
        else
            min=c;

        if(a>=b && a>=c)
            max=a;
        else if(b>=c && b>=a)
            max=b;
        else
            max=c;
        return Math.abs(max-min);
    }
}
