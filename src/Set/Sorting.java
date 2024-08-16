package Set;

import java.util.*;

public class Sorting {
    public static void main(String[] args) {
        System.out.println(sort(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 4)),new ArrayList<Integer>(Arrays.asList(5, 4, 2))));
    }
    static ArrayList<Integer> sort(ArrayList<Integer> A,ArrayList<Integer> B){
        SortedSet<Integer> set = new TreeSet<>();
        for(int i:A)
            set.add(i);
        for(int i:B)
            set.add(i);
        ArrayList<Integer> res = new ArrayList<>();

        for(int i:set)
            res.add(i);

        return res;
    }
}
