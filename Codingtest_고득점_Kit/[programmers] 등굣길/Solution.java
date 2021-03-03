class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[m+1][n+1]; //(1,1)-> house, (m,n)-> school
        map[1][1]=1;
        for(int i=0;i<puddles.length;i++){
            map[puddles[i][0]][puddles[i][1]]=-1;
        }
        for(int j=1;j<m+1;j++){
            for(int k=1;k<n+1;k++){
                if(j==1 && k==1) continue;
                if(map[j][k]==-1){
                    map[j][k]++;
                }
                else{
                    map[j][k]=(map[j-1][k]+map[j][k-1])%1000000007;
                }
            }
        }
        answer=(map[m-1][n]+map[m][n-1])%1000000007;
        return answer;
    }
}
