
import java.util.Arrays;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        int[][] adj = new int[n+1][n+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(i==j){
                    adj[i][j] = 0;
                }
                else{
                    adj[i][j] = 20000001;
                }
            }
        }
        for(int i=0;i<fares.length;i++){
            int start = fares[i][0];
            int end = fares[i][1];
            int weight = fares[i][2];
            adj[start][end] = weight;
            adj[end][start] = weight;
        }
        for(int k=1;k<n+1;k++){
            for(int i=1;i<n+1;i++){
                for(int j=1;j<n+1;j++){
                    if(adj[i][j] > adj[i][k]+adj[k][j]){
                        adj[i][j] = adj[i][k]+adj[k][j];
                    }
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                answer = Math.min(answer,adj[s][j]+adj[j][a]+adj[j][b]);
            }
        }
        return answer;
    }
}
