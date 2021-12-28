import java.util.StringTokenizer;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playtime = stringToInt(play_time);
        int advtime = stringToInt(adv_time);
        if(playtime<=advtime){
            return "00:00:00";
        }
        long[] arr = new long[playtime+1];
        for(int i=0;i<logs.length;i++){
            StringTokenizer st = new StringTokenizer(logs[i],"-");
            int start = stringToInt(st.nextToken());
            int end = stringToInt(st.nextToken());
            arr[start] ++;
            arr[end] --;
        }
        for(int i=1;i<arr.length;i++){
            arr[i] += arr[i-1];
        }
        for(int i=1;i<arr.length;i++){
            arr[i] +=arr[i-1];
        }
        long max = -1;
        int idx =0;
        for(int i=advtime;i<arr.length;i++){
            if(max<arr[i]-arr[i-advtime]){
                max = arr[i]-arr[i-advtime];
                idx = i-advtime;
            }
        }
        if(idx!=0){
            idx++;
        }
        int hour = idx/3600;
        int min = (idx%3600)/60;
        int sec = (idx%3600)%60;

        String answer = String.format("%02d",hour)+":"+String.format("%02d",min)+":"+String.format("%02d",sec);
        System.out.println(answer);

        return answer;
    }
    public int stringToInt(String time){
        StringTokenizer st = new StringTokenizer(time,":");
        int timeToSecond = Integer.parseInt(st.nextToken())*3600+Integer.parseInt(st.nextToken())*60+Integer.parseInt(st.nextToken());
        return timeToSecond;
    }
}
