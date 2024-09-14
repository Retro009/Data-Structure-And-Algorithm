/*
* Problem Description
You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.

Given 2 towns find whether you can reach the first town from the second without repeating any edge.

B C : query to find whether B is reachable from C.

Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).

There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i for every 1 <= i < N.

NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.



Problem Constraints
1 <= N <= 100000



Input Format
First argument is vector A

Second argument is integer B

Third argument is integer C



Output Format
Return 1 if reachable, 0 otherwise.



Example Input
Input 1:

 A = [1, 1, 2]
 B = 1
 C = 2
Input 2:

 A = [1, 1, 2]
 B = 2
 C = 1


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 Tree is 1--> 2--> 3 and hence 1 is not reachable from 2.
Explanation 2:

 Tree is 1--> 2--> 3 and hence 2 is reachable from 1.
* */
package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PathExistOrNot {
    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(Arrays.asList(1,1,1,1,1)), 1, 1));
    }
    public static int solve(ArrayList<Integer> A, final int B, final int C) {
        if(B==C)
            return 1;
        ArrayList<ArrayList<Integer>> edgeArrays = new ArrayList<>();
        for(int i=0; i<A.size()+1; i++)
            edgeArrays.add(new ArrayList<>());
        for(int i=1;i<A.size();i++){
            edgeArrays.get(A.get(i)).add(i+1);
        }
        Set<Integer> path = new HashSet<>();

        boolean isReachable = dfs(edgeArrays,path,B,C);
        if(isReachable)
            return 1;
        return 0;
    }

    private static boolean dfs(ArrayList<ArrayList<Integer>> edgeArrays, Set<Integer> path, int B, int C) {
        if(edgeArrays.get(C).contains(B))
            return true;
        for(Integer node:edgeArrays.get(C)){
            if(path.contains(node))
                return false;
            path.add(node);
            if(dfs(edgeArrays,path,B,node))
                return true;
            path.remove(node);
        }
        return false;
    }
}
