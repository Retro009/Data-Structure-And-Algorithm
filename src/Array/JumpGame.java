package Array;

public class JumpGame {
    public static void main(String[] args) {
        int arr[]={2,3,1,1,4};
        if(canJump(arr))
            System.out.println("True");
        else
            System.out.println("False");
    }
    static boolean canJump(int arr[]){
        int reachable = 0;
        for(int i=0;i<arr.length;i++){
            if(i>reachable)
                return false;
            reachable = Math.max(reachable,i+arr[i]);
        }
        return true;
    }
}
