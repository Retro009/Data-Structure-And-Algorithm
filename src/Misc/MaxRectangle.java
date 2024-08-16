package Misc;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxRectangle {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();

        A.add(new ArrayList<Integer>(Arrays.asList(1,1,1)));
        A.add(new ArrayList<Integer>(Arrays.asList(0,1,1)));
        A.add(new ArrayList<Integer>(Arrays.asList(1,0,0)));
        //displayMatrix(A);
        System.out.println(areaRectangle(A));
    }
    static int areaRectangle(ArrayList<ArrayList<Integer>> A){
        for(int i=0;i<A.size();i++){
            for(int j=1;j<A.get(i).size();j++){
                if(A.get(i).get(j) != 0)
                    A.get(i).set(j,A.get(i).get(j-1)+A.get(i).get(j));
            }
        }
        System.out.println("Transform Matrix:");
        displayMatrix(A);

        int maxArea = 0;
        for(int i=0;i<A.size();i++) {
            for (int j=0;j<A.get(i).size();j++) {
                if(A.get(i).get(j) != 0){
                    int width = A.get(i).get(j);
                    int length = 1;
                    for(int size=i;size>=0;size--){
                        if(A.get(size).get(j) < width)
                            width = A.get(size).get(j);
                        maxArea = Math.max(length*width,maxArea);
                        length++;
                    }
                }
            }
        }

        return maxArea;
    }

    static void displayMatrix(ArrayList<ArrayList<Integer>> A){
        for(int i=0;i<A.size();i++)
            System.out.println(A.get(i));
    }
}
