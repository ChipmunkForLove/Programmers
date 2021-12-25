import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Solution {
    LinkedList<Edge>[] adj;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        adj = new LinkedList[n+1];
        for(int i=1;i<n+1;i++){
            adj[i] = new LinkedList<>();
        }
        for(int i=0;i<fares.length;i++){
            int start = fares[i][0];
            int end = fares[i][1];
            int weight = fares[i][2];
            adj[start].add(new Edge(end,weight));
            adj[end].add(new Edge(start,weight));
        }
        int ans = Integer.MAX_VALUE;
        int[] dist1 = dijkstra(s,n);
        int[] distA= dijkstra(a,n);
        int[] distB = dijkstra(b,n);
        for(int i=1;i<n+1;i++){
            ans = Math.min(ans,dist1[i]+distA[i]+distB[i]);
        }
        return ans;
    }
    public int[] dijkstra(int s,int n){
        int[] dist = new int[n+1];
        Arrays.fill(dist,20*100000+1);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(s,0));
        dist[s]=0;
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            if(dist[cur.e]<cur.w) continue;
            for (int i = 0; i < adj[cur.e].size(); i++) {
                Edge des = adj[cur.e].get(i);
                if(dist[des.e] > dist[cur.e]+des.w){
                    dist[des.e] = dist[cur.e]+des.w;
                    pq.add(new Edge(des.e,des.w));
                }
            }
        }
        return dist;
    }
}
class Edge implements Comparable<Edge>{
    int e;
    int w;
    Edge(int e,int w){
        this.e = e ;
        this.w = w;
    }
    @Override
    public int compareTo(Edge target){
        return this.w-target.w;
    }
}
