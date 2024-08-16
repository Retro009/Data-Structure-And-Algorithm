package HashSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountDistinctSubArray {
    public static void main(String[] args) {
        System.out.println(count(new ArrayList<Integer>(Arrays.asList(1, 1, 3))));
    }
    static int count(ArrayList<Integer> A){
        long count = 0;
        Set<Integer> set = new HashSet<>();
        int i=0;
        int j=0;
        while(j<A.size()){
            if(!set.contains(A.get(j))){
                set.add(A.get(j));
                count+=j-i+1;
                j++;
            }else{
                set.remove(A.get(i));
                i++;
            }

        }
        return (int)(((count%1000000007)+1000000007)%1000000007);
    }
}
