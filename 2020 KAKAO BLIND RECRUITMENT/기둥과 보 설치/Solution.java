import java.util.ArrayList;

class Solution {
    int[][][] map;
    int N;
    public int[][] solution(int n, int[][] build_frame) {
        map = new int[n+1][n+1][2];
        N = n;
        for(int i=0;i<build_frame.length;i++){
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int shape = build_frame[i][2];
            int isInstall = build_frame[i][3];
            if(shape==0){ //기둥이면
                if(isInstall==0){
                    map[x][y][0]=0;
                    if(!canDelete(x,y)){
                        map[x][y][0]=1;
                    }
                }
                else{
                   if(checkbar(x,y)){
                       map[x][y][0]=1;
                   }
                }
            }
            else{ //보이면
                if(isInstall==0) {
                    map[x][y][1]=0;
                    if(!canDelete(x,y)){
                        map[x][y][1]=1;
                    }
                }
                else{
                    if(checkbeam(x,y)){
                        map[x][y][1]=1;
                    }
                }
            }
        }
        ArrayList<int[]> temp = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                for(int k=0;k<2;k++){
                    if(map[i][j][k]==1){
                        int[] arr = {i,j,k};
                        temp.add(arr);
                    }
                }
            }
        }
        int[][] answer = temp.toArray(new int[temp.size()][3]);
        return answer;
    }
    public boolean canDelete(int x,int y){
        for(int i=0;i<=N;i++){
            for(int j=0;j<=N;j++){
                if(map[i][j][0]==1 && !checkbar(i,j)) return false;
                if(map[i][j][1]==1 && !checkbeam(i,j)) return false;
            }
        }
        return true;
    }
    public boolean checkbar(int x,int y){
        if(y==0) return true;
        if((x<N && map[x][y][1]==1) || (x>0 && map[x-1][y][1]==1)){
            return true;
        }
        if(map[x][y-1][0]==1) return true;
        return false;
    }
    public boolean checkbeam(int x,int y){
        if(y==0) return true;
        if(map[x][y-1][0]==1 || map[x+1][y-1][0]==1){
            return true;
        }
        if(x>0 && map[x-1][y][1]==1 && x<N && map[x+1][y][1]==1){
            return true;
        }
        return false;
    }
}
