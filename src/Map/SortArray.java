package Map;

import java.util.*;

public class SortArray {
    public static void main(String[] args) {
        System.out.println(sort(new ArrayList<Integer>(Arrays.asList(3,20,17,17)),new ArrayList<Integer>(Arrays.asList(5,9,20,11,6,18,7,13))));
    }

    static ArrayList<Integer> sort(ArrayList<Integer> A, ArrayList<Integer> B){
        ArrayList<Integer> res = new ArrayList<>();
        SortedMap<Integer, Integer> map = new TreeMap<>();

        for(int i:A)
            map.put(i,map.getOrDefault(i,0)+1);

        for(int i=0;i<B.size();i++){
            while(map.containsKey(B.get(i)) && map.get(B.get(i))>0){
                map.put(B.get(i),map.get(B.get(i))-1);
                res.add(B.get(i));
            }
            if(map.containsKey(B.get(i)) && map.get(B.get(i))==0)
                map.remove(B.get(i));
        }
        while(!map.isEmpty()){
            res.add(map.firstKey());
            map.put(map.firstKey(),map.get(map.firstKey())-1);
            if(map.get(map.firstKey())==0)
                map.remove(map.firstKey());
        }
        return res;
    }
}
