package DynamicProgramming;

public class Decoding {
    public static void main(String[] args) {
        waysOfDecode("4126");
    }

    static int waysOfDecode(String A){
        if(A.length()<2)
            return 1;
        int dp[] = new int[A.length()+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=A.length();i++){
            if(A.charAt(i-1)>'0' && A.charAt(i-1)<='9')
                dp[i]=dp[i-1];
            if(A.charAt(i-2)=='1')
                dp[i]+=dp[i-2];
            else if(A.charAt(i-2)=='2' && A.charAt(i-1)>='0' && A.charAt(i-1)<='6')
                dp[i]+=dp[i-2];
        }

        return dp[A.length()];
    }
}
