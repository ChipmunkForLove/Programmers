import java.util.*;
class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] dx={1,0,-1,0};
        int[] dy={0,1,0,-1};

        int[] answer = new int[2];
        boolean[][] visited = new boolean[m][n];
        Queue<Pos> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]) continue;
                if(picture[i][j]>0){
                    numberOfArea++;
                    q.add(new Pos(i,j,picture[i][j]));
                    visited[i][j]=true;
                    int areaCnt=0;
                    while(!q.isEmpty()){
                        Pos cur = q.poll();
                        areaCnt++;
                        for(int k=0;k<4;k++){
                            int nx=cur.x+dx[k];
                            int ny=cur.y+dy[k];
                            if(nx>=0 && nx<m && ny>=0 && ny<n){
                                if(picture[nx][ny]==picture[cur.x][cur.y] && !visited[nx][ny]){
                                    q.add(new Pos(nx,ny,picture[cur.x][cur.y]));
                                    visited[nx][ny]=true;
                                }   
                            }
                        }
                    }
                    maxSizeOfOneArea=Math.max(maxSizeOfOneArea,areaCnt);
                }
            }
        }
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
class Pos{
    int x;
    int y;
    int c;//color
    Pos(int x,int y,int c){
        this.x=x;
        this.y=y;
        this.c=c;
    }
}
