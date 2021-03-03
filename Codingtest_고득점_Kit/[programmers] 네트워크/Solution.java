import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            visited[i]=false;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(visited[i]) continue;
            q.add(i);
            visited[i]=true;
            while(q.size()!=0){
                int cur=q.poll();
                for(int j=0;j<n;j++){
                    if(computers[cur][j]==1 && cur!=j && !visited[j]){
                        visited[j]=true;
                        q.add(j);
                    }
                }
            }
            answer++;
        }
        return answer;
    }
}
