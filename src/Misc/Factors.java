package Misc;

public class Factors {
    public static void main(String[] args) {
        System.out.println(factors(20));
        //{1,2,4,5,10,20}
    }
    static int factors(int n){
        int count = 0;
        int size = (int)Math.floor(Math.sqrt((double)n));
        for(int i=1;i<=size;i++){
            if(n%i==0){
                if(i < n/i)
                    count+=2;   //
                else
                    count++;
            }
        }
        return count;
    }
}
