import java.util.*;
class Solution {
    public String solution(String p) {
        String answer = "";
        answer=change(p);
        return answer;
    }
    public String change(String str){
        String answer="";
        if(str.equals("")) return "";
        String temp =str;
        int left=0;
        int right=0;
        int i;
        String u="";
        String v="";
        for(i=0;i<str.length();i++){
            if(str.charAt(i)=='(') left++;
            else right++;
            if(left==right) break;
        }
        u=str.substring(0,i+1);
        v=str.substring(i+1);
        if(isRight(u)){
            answer=u+change(v);
        }
        else{
            answer=makeRight(u,v);
        }
        return answer;
    }
    public boolean isBalanced(String str){
        int left=0;
        int right=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='(') left++;
            else right++;
        }
        if(left==right) return true;
        return false;
    }
    public boolean isRight(String str){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='(') stack.push('(');
            else{
                if(!stack.isEmpty()){
                stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
    public String makeRight(String u,String v){
        String makeURight="("+change(v)+")";
        if(!u.equals("")){
            u=u.substring(1,u.length()-1);
        }
        u=u.replaceAll("\\(","a");
        u=u.replaceAll("\\)","\\(");
        u=u.replaceAll("a","\\)");
        return makeURight+u;
    }
}
