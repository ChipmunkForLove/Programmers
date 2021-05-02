import java.util.*;
class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        LinkedList<Integer> answerlist = new LinkedList<>();
        HashMap<String,Integer> map = new HashMap<>();
        for(int k=1;k<27;k++){
            int alphabet = 'A'+k-1;
            map.put((char)alphabet+"",k);
        }
        while(msg.length()>0){
            int i=1;//substring length
            while(i<msg.length() && map.get(msg.substring(0,i))!=null){
                i++;
            }
            if(i==msg.length()){
                if(map.get(msg)!=null){
                    answerlist.add(map.get(msg));
                    msg="";
                }
                else {
                    answerlist.add(map.get(msg.substring(0,i-1)));
                    map.put(msg, map.size() + 1);
                    msg=msg.charAt(msg.length()-1)+"";
                }
            }
            else{
                answerlist.add(map.get(msg.substring(0,i-1)));
                map.put(msg.substring(0,i),map.size()+1);
                msg=msg.substring(i-1);
            }
        }
        answer = new int[answerlist.size()];
        for(int j=0;j<answerlist.size();j++){
            answer[j]=answerlist.get(j);
        }
        return answer;
    }
}
