import java.util.*;
class Solution{
    private static int[] dr={1,0,-1,0}; //dir = 0,1,2,3
    private static int[] dc={0,1,0,-1};
    private int[][] board;
    private int n;
    private int cost = Integer.MAX_VALUE;
    int[][] map;
    public int solution(int[][] map){
        this.map=map;
        board=map;
        n=board.length;
        int answer=0;
        dfs(0,0,-1,0);
        answer=cost;
        return answer;
    }
    public void dfs(int r,int c,int dir,int price){
        if(cost<price){
            return;
        }
        if(r==n-1 && c==n-1){
            cost = Math.min(cost,price);
            return;
        }
        for(int i=0;i<4;i++){
            int nc= c+dc[i];
            int nr= r+dr[i];
            int nprice;
            if(nc<0 || nr<0 || nc>=n || nr>=n || map[nc][nr]==1){
                continue;
            }
            if(dir==-1){
                //start
                nprice=price+100;
            }
            else if(dir==i){
                //same dir
                nprice= price+100;
            }
            else{
                //different dir, make corner
                nprice=price+600;
            }
            if(board[nc][nr]==0 || board[nc][nr]>=nprice) {
                board[nc][nr]=nprice;
                dfs(nr, nc, i, nprice);
            }
        }
    }

}
