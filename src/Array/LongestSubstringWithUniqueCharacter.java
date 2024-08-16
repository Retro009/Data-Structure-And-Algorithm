package Array;

import java.util.HashSet;

public class LongestSubstringWithUniqueCharacter {
    public static void main(String[] args) {
        System.out.println(longestUniqueSubstring("hello"));
    }

    public static String longestUniqueSubstring(String word){           //pnnben
        HashSet<Character> hs = new HashSet<>();
        StringBuilder curr = new StringBuilder();
        String result = "";
        int j=0;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(hs.contains(c)){
                while(word.charAt(j)!=c){
                    hs.remove(word.charAt(j));
                    curr.deleteCharAt(0);
                    j++;
                }
                hs.remove(word.charAt(j));
                curr.deleteCharAt(0);
                j++;
            }
            curr.append(c);
            hs.add(c);
            result = result.length() >= curr.length()?result: curr.toString();
        }
        if(curr.length()==word.length())
            return word;
        return result;
    }
}
