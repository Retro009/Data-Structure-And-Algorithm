package Array;

public class MinSwaps {
    public static void main(String[] args) {
        int arr[] = {5, 17, 100, 11};
        int k = 20;
        System.out.println(miniumSwap(arr,k));
    }
    static int miniumSwap(int arr[],int k){
        int windowSize = 0;
        int biggerElement = 0;
        int minSwap = biggerElement;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=k)
                windowSize++;
        }
        for(int i=0;i<windowSize;i++){
            if(arr[i] > k)
                biggerElement++;
        }
        minSwap = biggerElement;
        int start = 1;
        int end = windowSize;

        while(end<arr.length){
            if(arr[start-1]>k)
                biggerElement--;
            if(arr[end]>k)
                biggerElement++;
            minSwap = Math.min(minSwap,biggerElement);
            end++;
            start++;
        }
        return minSwap;
    }
}
