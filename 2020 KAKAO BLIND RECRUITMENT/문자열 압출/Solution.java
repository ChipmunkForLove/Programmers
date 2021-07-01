class Solution {
    public int solution(String s) {
        int answer = s.length();
        for(int i=1;i<=s.length()/2;i++){
            //1개부터 s.length()/2까지 쪼개보기
            String res="";
            String prev="";
            String cur="";
            int cnt=1;
            int j;
            for(j=0;j<s.length()-i-i+1;j=j+i){
                prev=s.substring(j,j+i);
                cur=s.substring(j+i,j+2*i);
                if(prev.equals(cur)) cnt++;
                else{//반복되지 않을 경우
                    if(cnt>1){
                        res=res+cnt+prev;
                        cnt=1;
                    }
                    else{
                    res=res+prev;
                    }
                }
            }
            if(cnt>1){
                res=res+cnt+s.substring(j);
            }
            else{
                res=res+s.substring(j);
            }
            answer=Math.min(answer,res.length());
        }

        return answer;
    }
}
