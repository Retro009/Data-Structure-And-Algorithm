package Set;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println(substringII("abcbe"));
    }
    static int substring(String A){
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        for(int i=0;i<A.length();i++){
            int j=i+1;
            int length = 1;
            while(j<A.length() && !set.contains(A.charAt(j))){
                set.add(A.charAt(j));
                length++;
                j++;
            }
            set.clear();
            maxLength = Math.max(maxLength,length);
        }
        return maxLength;
    }

    static int substringII(String A){
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        while(i<A.length() && j<A.length()){
            if(!set.contains(A.charAt(j))){
                set.add(A.charAt(j));
                j++;
                maxLength = Math.max(maxLength,j-i);
            }else{
                set.remove(A.charAt(i));
                i++;
            }
        }
        return maxLength;
    }
}
