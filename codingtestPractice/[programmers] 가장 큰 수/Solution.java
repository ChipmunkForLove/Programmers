import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int len=numbers.length;
        String[] strnum = new String[len];
        for(int i=0;i<len;i++){
            strnum[i]= numbers[i]+"";
        }
        Arrays.sort(strnum,(o1,o2)->{
            return (o2+o1).compareTo(o1+o2);
        });
        if(strnum[0].startsWith("0")){
            answer="0";
        }
        else{
            for(int i=0;i<len;i++){
                answer+=strnum[i];
            }
        }
        return answer;
    }
}
