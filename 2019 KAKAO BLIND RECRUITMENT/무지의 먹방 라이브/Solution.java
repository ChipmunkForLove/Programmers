import java.util.*;
class Solution {
    public int solution(int[] food_times, long k) {
        int answer = -1;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] arg0, int[] arg1) {
                return Integer.compare(arg0[0], arg1[0]);
            }
        });
        for(int i=0; i<food_times.length; i++) pq.add(new int[] {food_times[i], i});
        long curTime = 0;
        loop:while(!pq.isEmpty()) {
            int[] cur = pq.peek();
            long spendTime = (cur[0]-curTime)*pq.size();
            if(k<spendTime) {
                k%=pq.size();
                k++;
                int count = 0;
                for(int i=0; i<food_times.length; i++) {
                    if(food_times[i]!=0) {
                        count++;
                        if(count==k)  {
                            answer = i+1;
                            break loop;
                        }
                    }
                }
            } else {
                k -= spendTime;
                food_times[cur[1]] = 0;
                curTime = cur[0];
                pq.poll();
            }
        }
        return answer;
    }
}
