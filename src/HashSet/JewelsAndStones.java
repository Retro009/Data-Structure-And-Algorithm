package HashSet;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public static void main(String[] args) {
        String jewels="aA";
        String stones="aAAbbbcccc";
        System.out.println(countJewels(jewels,stones));
    }
    static int countJewels(String jewels, String stones){
        int jewelCount = 0;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<jewels.length();i++){
            set.add(jewels.charAt(i));
        }
        for(int i=0;i<stones.length();i++){
            char ch = stones.charAt(i);
            if(set.contains(ch))
                jewelCount++;
        }
        return jewelCount;
    }
}
