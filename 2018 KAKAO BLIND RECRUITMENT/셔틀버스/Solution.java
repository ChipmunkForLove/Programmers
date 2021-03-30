import java.util.*;
class Solution {
     public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int max = n*m;
        int starttime=540;
        int lasttime=0;//콘 이전에 타는 사람들 중 가장 늦게 타는 사람 저장
        int contime=0;//콘이 타는 시
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<timetable.length;i++){
            String[] splittime = timetable[i].split(":");
            int time = Integer.parseInt(splittime[0])*60+Integer.parseInt(splittime[1]);
            pq.add(time);
        }
        for(int i=0;i<n;i++){
            int takebustime = starttime+i*t;
            for(int j=0;j<m;j++){
                if (!pq.isEmpty() && pq.peek() <= takebustime) {
                    lasttime = pq.poll()-1;
                }
                else if(pq.isEmpty() || pq.peek()>takebustime){//자리가 남거나 다들 셔틀보다 늦게 오면
                    lasttime=takebustime;
                }
            }
        }
        contime=lasttime;
        int hour=contime/60;
        int min=contime%60;
        answer= String.format("%02d",hour)+":"+String.format("%02d",min);
        return answer;
    }
}
