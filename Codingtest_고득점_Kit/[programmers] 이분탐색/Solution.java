import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long maxtime=(long)times[times.length-1] *n;
        long right= maxtime;
        long left=1;
        long sum=0;
        while(left<=right){
            long mid=(left+right)/2;
            sum=0;
            //System.out.println(mid);
            for(int i=0;i<times.length;i++){
                sum+= (mid/times[i]);
            }
            if(sum>=n){
                if(answer==0) answer=mid;
                else{
                    answer=Math.min(answer,mid);
                }
               // System.out.println("answer:"+answer);
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return answer;
    }
}
