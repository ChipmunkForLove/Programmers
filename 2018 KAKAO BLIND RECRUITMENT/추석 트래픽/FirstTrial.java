import java.util.*;
class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        LinkedList<int[]> start_end_time = new LinkedList<>();
        LinkedList<Integer> changetime = new LinkedList<>();
        for(int i=0;i<lines.length;i++){
            String currenttime = lines[i].split(" ")[1];
            String during = lines[i].split(" ")[2];
            during=during.substring(0,during.length()-1);//remove s
            String[] timesplits=currenttime.split(":");
            int hour = Integer.parseInt(timesplits[0])*60*60*1000;
            int min = Integer.parseInt(timesplits[1])*60*1000;
            int sec = Integer.parseInt(timesplits[2].substring(0,2)+timesplits[2].substring(3));
            int duringtime = (int)(Float.parseFloat(during)*1000);
            int starttime = hour+min+sec-duringtime+1;
            int endtime = hour+min+sec;
            int[] temp ={starttime,endtime};
            start_end_time.add(temp);
            changetime.add(starttime);
            changetime.add(endtime);
        }
        Collections.sort(changetime);
        for(int i=0;i<changetime.size();i++){
            int changetimeplusone = changetime.get(i)+999;
            int changetimestart=changetime.get(i);
            int total=0;
            for(int j=0;j<start_end_time.size();j++){
                int starttime=start_end_time.get(j)[0];
                int endtime = start_end_time.get(j)[1];
                if(changetimeplusone<starttime) continue;
                if(endtime<changetimestart) continue;
                if(starttime>=changetimestart && endtime<=changetimeplusone){
                    total++;
                }
                else if(starttime>=changetimestart && starttime<=changetimeplusone && endtime>changetimeplusone){
                   total++; 
                }
                else if(endtime>=changetimestart && endtime<=changetimeplusone && starttime<changetimestart){
                    total++;
                }
                else if(endtime>changetimeplusone && starttime<changetimestart){
                    total++;
                }
            }
            answer=Math.max(answer,total);
        }
        
        return answer;
    }
}
