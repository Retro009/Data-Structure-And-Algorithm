package Array;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int arr[]={0,0,0,1,0,1,1,1,0,0,0,1,1,1,1,0,0};
        System.out.println(maxConsecutive(arr,2));
    }
    static int maxConsecutive(int arr[], int k){
        int noOfZeroes = 0;
        int maxCount = 0;
        int start = 0;

        for(int end=0;end<arr.length;end++){
            if(arr[end]==0)
                noOfZeroes++;
            while(noOfZeroes>k){
                if(arr[start]==0)
                    noOfZeroes--;
                start++;
            }
            maxCount = Math.max(maxCount,end-start+1);
        }
        return maxCount;
    }
}
