/*
* Problem Description
Given character matrix A of dimensions N×M consisting of O's and X's, where O = white, X = black.

Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)



Problem Constraints
1 <= N, M <= 1000

A[i][j] = 'X' or 'O'



Input Format
The First and only argument is character matrix A.



Output Format
Return a single integer denoting number of black shapes.



Example Input
Input 1:

 A = [ [X, X, X], [X, X, X], [X, X, X] ]
Input 2:

 A = [ [X, O], [O, X] ]


Example Output
Output 1:

 1
Output 2:

 2


Example Explanation
Explanation 1:

 All X's belong to single shapes
Explanation 2:

 Both X's belong to different shapes
* */

package Graph;

import java.util.ArrayList;
import java.util.List;

public class FindNoOfIslands {
    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(List.of("XOOXOOX","XXOOOXX"))));
    }
    public static int solve(ArrayList<String> A){
        int length = A.get(0).length();
        int size = A.size();
        int count = 0;

        boolean visited[][] = new boolean[size][length];
        final int dx[]={0,1,0,-1};
        final int dy[]={1,0,-1,0};

        for(int i=0;i<size;i++){
            for(int j=0;j<length;j++){
                if(A.get(i).charAt(j)=='X' && !visited[i][j]){
                    dfs(A,dx,dy,visited,i,j);
                    count++;
                }
            }
        }
        for(int i=0;i<visited.length;i++){
            for(int j=0;j<visited[0].length;j++){
                System.out.print(visited[i][j]+" ");
            }
            System.out.println("\n");
        }
        return count;
    }
    static void dfs(ArrayList<String> A,final int[] dx,final int[] dy, boolean[][] visited,int x,int y){
        int size = A.size();
        int length = A.get(0).length();
        visited[x][y]=true;
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if((nx>=0 && nx<size) && (ny>=0 && ny<length) && A.get(nx).charAt(ny)=='X' && !visited[nx][ny])
                dfs(A, dx, dy, visited, nx, ny);
        }
    }
}
