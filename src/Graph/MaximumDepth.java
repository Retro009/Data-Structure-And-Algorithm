/*
* Problem Description
Given a Tree of A nodes having A-1 edges. Each node is numbered from 1 to A where 1 is the root of the tree.

You are given Q queries. In each query, you will be given two integers L and X. Find the value of such node which lies at level L mod (MaxDepth + 1) and has value greater than or equal to X.

Answer to the query is the smallest possible value or -1, if all the values at the required level are smaller than X.

NOTE:

Level and Depth of the root is considered as 0.
It is guaranteed that each edge will be connecting exactly two different nodes of the tree.
Please read the input format for more clarification.


Problem Constraints
2 <= A, Q(size of array E and F) <= 105

1 <= B[i], C[i] <= A

1 <= D[i], E[i], F[i] <= 106



Input Format
The first argument is an integer A denoting the number of nodes.

The second and third arguments are the integer arrays B and C where for each i (0 <= i < A-1), B[i] and C[i] are the nodes connected by an edge.

The fourth argument is an integer array D, where D[i] denotes the value of the (i+1)th node

The fifth and sixth arguments are the integer arrays E and F where for each i (0 <= i < Q), E[i] denotes L and F[i] denotes X for ith query.



Output Format
Return an array of integers where the ith element denotes the answer to ith query.



Example Input
Input 1:

 A = 5
 B = [1, 4, 3, 1]
 C = [5, 2, 4, 4]
 D = [7, 38, 27, 37, 1]
 E = [1, 1, 2]
 F = [32, 18, 26]
Input 2:

 A = 3
 B = [1, 2]
 C = [3, 1]
 D = [7, 15, 27]
 E = [1, 10, 1]
 F = [29, 6, 26]


Example Output
Output 1:

 [37, 37, 27]
Output 2:

 [-1, 7, 27]


Example Explanation
Explanation 1:

      1[7]
     /    \
   5[1]  4[37]
        /    \
       2[38]  3[27]

 Query 1:
    L = 1, X = 32
    Nodes for level 1 are 5, 4
    Value of Node 5 = 1 < 32
    Value of Node 4 = 37 >= 32
    Ans = 37
Explanation 2:

      1[7]
     /    \
   2[15]  3[27]

 Query 1:
    L = 1, X = 6
    Nodes for level 1 are 2, 3 having value 15 and 27 respectively.
    Answer = -1 (Since no node is greater or equal to 29).
 Query 1:
    L = 10 % 2 = 0, X = 6
    Nodes for level 0 is 1 having value 7.
    Answer = 7.
* */
package Graph;

import java.util.*;

public class MaximumDepth {
    public static void main(String[] args) {
        int A = 3;
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(3, 1));
        ArrayList<Integer> D = new ArrayList<>(Arrays.asList(7, 15, 27));
        ArrayList<Integer> E = new ArrayList<>(Arrays.asList(1, 10, 1));
        ArrayList<Integer> F = new ArrayList<>(Arrays.asList(29, 6, 26));
        System.out.println(solve(A,B,C,D,E,F));
    }
    public static ArrayList<Integer> solve(int A, ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> D, ArrayList<Integer> E, ArrayList<Integer> F) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        boolean[] visited = new boolean[A];
        for(int i=0;i<A;i++){
            adjacencyList.add(new ArrayList<>());
        }

        for(int i=0;i<B.size();i++){
            int node1 = B.get(i);
            int node2 = C.get(i);
            adjacencyList.get(node1-1).add(node2);
            adjacencyList.get(node2-1).add(node1);
        }

        System.out.println(adjacencyList);

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> levelWiseValues = new ArrayList<>();
        queue.add(1);
        while(!queue.isEmpty()){
            int nodeCount = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            while(nodeCount>0){
                int node = queue.poll();
                visited[node-1]=true;
                level.add(D.get(node-1));
                for(Integer i:adjacencyList.get(node-1)){
                    if(!visited[i-1])
                        queue.offer(i);
                }
                nodeCount--;
            }
            level.sort((num1,num2)->num1-num2);
            levelWiseValues.add(level);
        }


        for(int i=0;i<E.size();i++){
            int L = E.get(i);
            int X = F.get(i);

            L = L % (levelWiseValues.size());
            for(int j=0;j<levelWiseValues.get(L).size();j++){
                if(levelWiseValues.get(L).get(j)>=X){
                    result.add(levelWiseValues.get(L).get(j));
                    break;
                }
                if(j==levelWiseValues.get(L).size()-1)
                    result.add(-1);
            }

        }
        return result;
    }
}
