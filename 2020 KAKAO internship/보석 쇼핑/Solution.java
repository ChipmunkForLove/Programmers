import java.util.*;
class Solution {
     public int[] solution(String[] gems){
        HashSet<String> set = new HashSet<>();
        HashMap<String,Integer> map = new HashMap<>();
        PriorityQueue<Dist> pq = new PriorityQueue<>(new Comparator<Dist>() {
            @Override
            public int compare(Dist o1, Dist o2) {
                if(o1.dist<o2.dist){
                    return -1;
                }
                else if(o1.dist>o2.dist){
                    return 1;
                }
                else{
                    if(o1.start<o2.start){
                        return -1;
                    }
                    else{
                        return 1;
                    }
                }
            }
        });
        int len=gems.length;
        int start=0;
        int last=0;
        for(int i=0;i<len;i++) {
            set.add(gems[i]);
        }
        for(int i=0;i<len;i++){
            map.put(gems[i],map.getOrDefault(gems[i],0)+1);
            if(map.size()>=set.size()){
                last=i;
                break;
            }
        }

        while(last<len){
            if(map.size()>=set.size()){
                pq.add(new Dist(start,last,last-start));
                if(map.get(gems[start])==1) map.remove(gems[start]);
                else{
                    map.put(gems[start],map.get(gems[start])-1);
                }
                start++;
            }
            else{
                last++;
                if(last<len) {
                    map.put(gems[last], map.getOrDefault(gems[last], 0) + 1);
                }
            }
        }
        Dist shortest = pq.poll();
        int[] res={shortest.start+1,shortest.end+1};
        return res;
    }
}
class Dist{
    int start;
    int end;
    int dist;
    Dist(int start,int end,int dist){
        this.start=start;
        this.end=end;
        this.dist=dist;
    }
}
