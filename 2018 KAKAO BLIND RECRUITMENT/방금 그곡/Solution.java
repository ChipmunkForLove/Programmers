import java.util.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        m=m.replace("C#","1");
        m=m.replace("D#","2");
        m=m.replace("F#","3");
        m=m.replace("G#","4");
        m=m.replace("A#","5");
        PriorityQueue<Music> pq = new PriorityQueue<>(new Comparator<Music>(){
            @Override
            public int compare(Music o1,Music o2){
                if(o1.playtime>o2.playtime){
                    return -1;
                }
                else if(o1.playtime<o2.playtime){
                    return 1;
                }
                else{
                    if(o1.idx<o2.idx){
                        return -1;
                    }
                    else{
                        return 1;
                    }
                }
            }
        });
        for(int i=0;i<musicinfos.length;i++){
            String musicinfo= musicinfos[i];
            String[] infosplit= musicinfo.split(",");
            int starttime =Integer.parseInt(infosplit[0].substring(0,2))*60+Integer.parseInt(infosplit[0].substring(3));
            int endtime = Integer.parseInt(infosplit[1].substring(0,2))*60+Integer.parseInt(infosplit[1].substring(3));
            int time = endtime-starttime;
            
            String melody = infosplit[3];
            melody=melody.replace("C#","1");
            melody=melody.replace("D#","2");
            melody=melody.replace("F#","3");
            melody=melody.replace("G#","4");
            melody=melody.replace("A#","5");
            String totalmelody="";
            int repeat = time/melody.length();
            for(int j=0;j<repeat;j++){
                totalmelody+=melody;
            }
            int left = time % melody.length();
            totalmelody+=melody.substring(0,left);
            if(totalmelody.contains(m)){
                pq.add(new Music(time,i));
            }
           // System.out.println(totalmelody);
        }
        if(pq.size()!=0){
            Music temp = pq.poll();
            answer=musicinfos[temp.idx].split(",")[2];
        }
        else{
            answer="(None)";
        }
        return answer;
    }
}
class Music{
    int playtime;
    int idx;
    Music(int playtime,int idx){
        this.playtime = playtime;
        this.idx = idx;
    }
}
