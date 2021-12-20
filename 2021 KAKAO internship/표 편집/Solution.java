import java.util.*;
 
class Solution {
     public String solution(int n, int k, String[] cmd) {
        String answer = "";
        int[] prev = new int[n];
        int[] next = new int[n];
        for(int i=0;i<n;i++){
            prev[i]=i-1;
            next[i]=i+1;
        }
        next[n-1]=-1;
        Stack<Integer> stack = new Stack();
        StringBuilder sb = new StringBuilder("O".repeat(n));
        for(int i=0;i<cmd.length;i++){
            StringTokenizer st = new StringTokenizer(cmd[i]," ");
            String curcmd = st.nextToken();
            if(curcmd.equals("D")){
                int num = Integer.parseInt(st.nextToken());
                for(int j=0;j<num;j++){
                    k=next[k];
                }
            }
            else if(curcmd.equals("U")){
                int num = Integer.parseInt(st.nextToken());
                for(int j=0;j<num;j++){
                    k=prev[k];
                }

            }
            else if(curcmd.equals("C")){
                stack.push(k);
                if(prev[k]!=-1) next[prev[k]]=next[k];
                if(next[k]!=-1) prev[next[k]]=prev[k];
                sb.setCharAt(k,'X');
                if(next[k]!=-1){
                    k=next[k];
                }
                else{
                    k=prev[k];
                }
            }
            else{
                int restore = stack.pop();
                sb.setCharAt(restore,'O');
                if(next[restore]!=-1){
                    prev[next[restore]]=restore;
                }
                if(prev[restore]!=-1){
                    next[prev[restore]]=restore;
                }
            }
        }
        return sb.toString();
    }
}
