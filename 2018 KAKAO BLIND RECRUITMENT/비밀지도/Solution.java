import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0;i<n;i++){
            int temp = arr1[i] | arr2[i];
            answer[i]=Integer.toBinaryString(temp);
            answer[i]=answer[i].replace("1","#");
            answer[i]=answer[i].replace("0"," ");
            if(answer[i].length()!=n){
                while(answer[i].length()!=n){
                    answer[i]=" "+answer[i];
                }
            }
        }
        return answer;
    }
}
