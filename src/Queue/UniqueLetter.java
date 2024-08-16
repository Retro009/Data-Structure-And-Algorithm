package Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class UniqueLetter {
    public static void main(String[] args) {
        System.out.println(solve("abadbc"));
    }
    static String solve(String A){
        Map<Character,Integer> occurence = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        for(int i=0;i<A.length();i++){
            char ch = A.charAt(i);
            queue.add(ch);
            occurence.put(ch,occurence.getOrDefault(ch,0)+1);
            while(!queue.isEmpty() && occurence.get(queue.peek())>1)
                queue.poll();
            if(queue.isEmpty())
                res.append('#');
            else
                res.append(queue.peek());
        }
        return res.toString();
    }
}
