class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String changednums="0";
        int number=0;
        for(int i=0;i<t;i++){
            while (changednums.length() < p) {
                    changednums += addnum(++number, n);
            }
            answer+=changednums.charAt(p-1);
            p+=m;//position index
        }
        return answer;
    }
    public String addnum(int number,int digit){
        String changednum="";
        while(number>0){
            int left=number%digit;
            if(left==10){
                changednum='A'+changednum;
            }
            else if(left==11){
                changednum='B'+changednum;
            }
            else if(left==12){
                changednum='C'+changednum;
            }
            else if(left==13){
                changednum='D'+changednum;
            }
            else if(left==14){
                changednum='E'+changednum;
            }
            else if(left==15){
                changednum='F'+changednum;
            }
            else{
                changednum=left+changednum;
            }
            number=number/digit;
        }
        return changednum;
    }
}
