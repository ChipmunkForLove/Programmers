import java.util.*;
class Solution {
    public int[] solution(String s) {
       int[] answer = {};
        int length=s.length();
        s= s.substring(1,s.length()-1);
        s = s.replace("}", "$");
        s = s.replace("{","$");
        s = s.replace(",","$");
        StringTokenizer stk = new StringTokenizer(s,"$",false);
        HashMap<String,Integer> map = new HashMap<>();
        while(stk.hasMoreTokens()){
            String token = stk.nextToken();
            map.put(token,map.getOrDefault(token,0)+1);
        }
        answer= new int[map.size()];
        for(String str : map.keySet()){
            answer[map.size()-map.get(str)]= Integer.parseInt(str);
        }
        return answer;
    }
}
