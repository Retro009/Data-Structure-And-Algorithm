package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class SortingUsingStack {
    public static void main(String[] args) {
        System.out.println(sort(new ArrayList<>(Arrays.asList(5,2,8,10,12,6,1))));
    }
    static ArrayList<Integer> sort(ArrayList<Integer> A) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for(int i=A.size()-1;i>=0;i--)
            stack1.push(A.remove(i));
        if(!stack1.isEmpty())
            stack2.push(stack1.pop());
        while(!stack1.isEmpty()){
            int num = stack1.pop();
            int count=0;
            while(!stack2.isEmpty() && stack2.peek()<num){
                stack1.push(stack2.pop());
                count++;
            }
            stack2.push(num);
            while(count>0){
                stack2.push(stack1.pop());
                count--;
            }
        }

        while(!stack2.isEmpty())
            A.add(stack2.pop());
        return A;
    }
}
