import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int j=0;
        for(int i=0;i<dartResult.length();i++){
            Character cur =dartResult.charAt(i);
            int num=0;
            if(cur=='S'){
                num = Integer.parseInt(dartResult.substring(j,i));
                stack.push(num);
                j=i+1;
            }
            else if(cur=='D'){
                num = Integer.parseInt(dartResult.substring(j,i));
                stack.push(num*num);
                j=i+1;
            }
            else if(cur=='T'){
                num = Integer.parseInt(dartResult.substring(j,i));
                stack.push(num*num*num);
                j=i+1;
            }
            else if(cur=='*'){
                int fir=0;
                int sec=0;
                fir=stack.pop()*2;
                if(!stack.isEmpty()) {
                    sec = stack.pop()*2;
                }
                stack.push(sec);
                stack.push(fir);
                j++;
            }
            else if(cur=='#'){
                int fir=stack.pop();
                stack.push(-fir);
                j++;
            }
        }
        while(!stack.isEmpty()){
            answer+=stack.pop();
        }
        return answer;
    }
}
