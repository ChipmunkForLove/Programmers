import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int maxidx=-1;
        int max=-100;
        Queue<Node> q = new LinkedList<>();
        for(int i=0;i<priorities.length;i++){
            q.add(new Node(i,priorities[i]));
        }
        while(location != maxidx){
            maxidx=-1;
            max=-100;
            for(int i=0;i<q.size();i++){
                Node tmp = q.poll();
                if(tmp.p>max){
                       maxidx=tmp.idx;
                       max=tmp.p;
                }
                q.add(tmp);
            }
             while(!q.isEmpty() && q.peek().idx!=maxidx){
                Node tmp = q.poll();
                q.add(tmp);
            }
            q.poll();
            answer++;
        }
        return answer;
    }
}
class Node {
    int idx=0;
    int p=0;
    Node(int idx,int priorities){
        this.idx=idx;
        this.p=priorities;
    }
}
