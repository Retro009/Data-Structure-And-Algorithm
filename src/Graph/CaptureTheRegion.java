package Graph;

import java.util.ArrayList;
import java.util.Arrays;

public class CaptureTheRegion {
    static ArrayList<ArrayList<Character>> a = new ArrayList<>();
    public static void main(String[] args) {
        a = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList('X', 'X', 'X', 'X')),
                new ArrayList<>(Arrays.asList('X', 'O', 'O', 'X')),
                new ArrayList<>(Arrays.asList('X', 'X', 'O', 'X')),
                new ArrayList<>(Arrays.asList('X', 'O', 'X', 'X'))
        ));
        solve(a);
        System.out.println(a);
    }
    public static void solve(ArrayList<ArrayList<Character>> a) {
        int size = a.size();
        int length = a.get(0).size();
        int dx[] = {1,0,-1,0};
        int dy[] = {0,1,0,-1};
        boolean cantBeFlipped[][] = new boolean[size][length];
        for(int i=0;i<size;i++){
            char ch = a.get(i).get(0);
            if(ch=='O' && !cantBeFlipped[i][0])
                dfs(a,dx,dy,cantBeFlipped,i,0);
        }
        for(int i=0;i<length;i++){
            char ch = a.get(0).get(i);
            if(ch=='O' && !cantBeFlipped[0][i])
                dfs(a,dx,dy,cantBeFlipped,0,i);
        }
        for(int i=0;i<size;i++){
            char ch = a.get(i).get(length-1);
            if(ch=='O' && !cantBeFlipped[i][length-1])
                dfs(a,dx,dy,cantBeFlipped,i,length-1);
        }
        for(int i=0;i<length;i++){
            char ch = a.get(size-1).get(i);
            if(ch=='O' && !cantBeFlipped[size-1][i])
                dfs(a,dx,dy,cantBeFlipped,size-1,i);
        }

        for(int i=0;i<size;i++){
            for(int j=0;j<length;j++){
                if(a.get(i).get(j)=='O' && !cantBeFlipped[i][j])
                    a.get(i).set(j,'X');
            }
        }
    }
    static void dfs(ArrayList<ArrayList<Character>> a, int dx[], int dy[], boolean[][] cantBeFlipped, int x, int y){
        cantBeFlipped[x][y]=true;
        int size = a.size();
        int length = a.get(0).size();

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if((nx>=0 && nx<size) && (ny>=0 && ny<length) && a.get(nx).get(ny)=='O' && !cantBeFlipped[nx][ny])
                dfs(a,dx,dy,cantBeFlipped,nx,ny);
        }
    }
}
