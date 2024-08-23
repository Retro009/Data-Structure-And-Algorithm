package BitWiseProblems;

public class CheckParity {
    //if even no. of set bit then return 0 else return 1
    public static void main(String[] args) {
        //System.out.println(3^1);                    // 1^1=0, 0^0=0, 1^0=1, 0^1=1  ans: 0011(3) ^ 0001(1) = 0010(2)
        //System.out.println(3&1);                    // 1&1=1, 1&0=0, 0&0=0  ans: 0011(3) & 0001(1) = 0001(1)
        //System.out.println(3<<1);                   // shift bits left by 1 ans: 0011(3) << 1 = 0110(6)

        //System.out.println(checkParity(15));
        System.out.println(checkParityKerninghams(12));
    }

    //below algorithm take O(n) where n is the no. of bits of num
    private final static int checkParity(int num){
        int result = 0;
        while(num!=0){
            result ^= (num&1);
            num >>= 1;
        }
        return result;
    }

    // Brian Kerningham's Algorithm will take O(k) where k is no. of set bits in num.
    // Kerningham algorithm states that if we num & (num-1) the result will be num with rightmost set bit unset
    // 1110(14) & 1101(13) = 1100(12)
    private final static int checkParityKerninghams(int num){
        int result = 0;
        while(num!=0){
            result ^= 1;
            num &=(num-1);
        }
        return result;
    }

}
