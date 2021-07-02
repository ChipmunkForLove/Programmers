import java.util.*;
class Solution {
    HashMap<String,Integer> map ;
    HashMap<Integer,Integer> maxCnt;
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        LinkedList<String> ansList = new LinkedList<>();
        map = new HashMap<>();
        maxCnt = new HashMap<>();
        for(int i=0;i<orders.length;i++){
            for(int j=0;j<course.length;j++){
                char[] charOrder = orders[i].toCharArray();
                if(charOrder.length<course[j]) continue;
                Arrays.sort(charOrder);
                nCr(course[j],charOrder,"",0);
            }
        }
        for(String s : map.keySet()){
            if(maxCnt.get(s.length())==null){
                maxCnt.put(s.length(),map.get(s));
            }
            else{
                if(maxCnt.get(s.length())<map.get(s)){
                    maxCnt.put(s.length(),map.get(s));
                }
            }
        }
        for(String s : map.keySet()){
            if(maxCnt.get(s.length())==map.get(s) && map.get(s)>=2){
                ansList.add(s);
            }
        }
        answer = ansList.toArray(new String[ansList.size()]);
        Arrays.sort(answer);
        return answer;
    }
    public void nCr(int r,char[] chararr,String res,int start){
        if(res.length()==r){
            map.put(res,map.getOrDefault(res,0)+1);
        }
        for(int i=start;i<chararr.length;i++){
            nCr(r,chararr,res+chararr[i],i+1);
        }
    }
}
