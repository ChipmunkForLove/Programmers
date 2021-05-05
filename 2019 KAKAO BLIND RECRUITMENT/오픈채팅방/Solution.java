import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        LinkedList<String> answerlist =new LinkedList<>();
        HashMap<String,String> map = new HashMap<>();
        for(int i=0;i<record.length;i++){
            String[] res=record[i].split(" ");
            String order=res[0];
            String id=res[1];
            String nickname="";
            if(!order.equals("Leave")) {
                nickname = res[2];
            }
            if(order.equals("Enter") || order.equals("Change")){
                map.put(id,nickname);
            }
        }
        for(int i=0;i<record.length;i++){
            String[] res=record[i].split(" ");
            String order=res[0];
            String id=res[1];
            String nickname=map.get(id);
            if(order.equals("Change")) continue;
            else if(order.equals("Enter")){
                answerlist.add(nickname+"님이 들어왔습니다.");
            }else{
                answerlist.add(nickname+"님이 나갔습니다.");
            }
        }
        answer = answerlist.toArray(new String[answerlist.size()]);
        return answer;
    }
}
