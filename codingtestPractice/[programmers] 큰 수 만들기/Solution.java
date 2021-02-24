import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int len=number.length()-k;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<number.length();i++){
            while(!stack.isEmpty() && stack.peek()<number.charAt(i) && k>0){
                stack.pop();
                k--;
            }
            stack.push(number.charAt(i));
        }
        for(int i=0;i<stack.size();i++){
            answer+=stack.get(i);
        }
       answer=answer.substring(0,len);
        return answer;
    }
}
