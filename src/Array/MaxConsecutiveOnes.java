//Find out the Maximum consecutive 1s in an array of 0 and 1;

package Array;
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int arr[]={0,0,0,1,0,1,1,1,0,0,0,1,1,1,1,0,0};
        System.out.println(maxConsecutive(arr));
    }
    public static int maxConsecutive(int arr[]){
        int count = 0;
        int maxCount = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1)
                count++;
            else
                count = 0;
            maxCount = Math.max(count,maxCount);
        }
        return maxCount;
    }
}
