import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[] visited=new boolean[n+1];
        int[] depth=new int[n+1];
        int deep=0;
        LinkedList<Integer> adj[]= new LinkedList[n+1];
        for(int i=1;i<n+1;i++){
            adj[i]=new LinkedList<>();
        }
        for(int i=0;i<edge.length;i++){
            adj[edge[i][0]].add(edge[i][1]);
            adj[edge[i][1]].add(edge[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1]=true;
        depth[1]=0;
        while(!q.isEmpty()){
            int s=q.poll();
            Iterator<Integer> it = adj[s].listIterator();
            while(it.hasNext()){
                int node=it.next();
                if(!visited[node]){
                    visited[node]=true;
                    depth[node]=depth[s]+1;
                    deep=depth[node];
                    q.add(node);
                }
            }
        }
        for(int i=1;i<n+1;i++){
            if(depth[i]==deep) answer++; 
        }
        return answer;
    }
}
