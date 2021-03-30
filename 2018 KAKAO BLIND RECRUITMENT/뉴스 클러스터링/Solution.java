import java.util.*;
import java.util.regex.Pattern;
class Solution {
    public static int solution(String str1, String str2) {
        int answer = 0;
        HashMap<String,Integer> map1 = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();
        String pattern = "^[a-zA-Z]*$";
        int total1=0;
        int total2=0;
        int common=0;
        for(int i=0;i<str1.length()-1;i++){
            String sub = str1.substring(i,i+2).toLowerCase();
            boolean itMatches = Pattern.matches(pattern,sub);
            if(itMatches){
                map1.put(sub,map1.getOrDefault(sub,0)+1);
                total1++;
            }
        }
        for(int j=0;j<str2.length()-1;j++){
            String sub = str2.substring(j,j+2).toLowerCase();
            boolean itMatches = Pattern.matches(pattern,sub);
            if(itMatches){
                map2.put(sub,map2.getOrDefault(sub,0)+1);
                total2++;
            }
        }
        for(String key : map2.keySet()){
            if(map1.containsKey(key)){
                common+=Math.min(map1.get(key),map2.get(key));
            }
        }
        float jaccard = (float)common/(total1+total2-common)*65536;
        answer = (int)jaccard;
        if(common==0 && total1+total2==0) answer=65536;
        return answer;
    }
}
