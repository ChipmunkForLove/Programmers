class Solution {
    public int solution(int[] money) {
        int answer = -1;
        int[] db1=new int[money.length-1];
        int[] db2=new int[money.length];
        //steal the first house
        db1[0]=money[0];
        db1[1]=money[0];
        for(int i=2;i<money.length-1;i++){
            db1[i]=Math.max(db1[i-2]+money[i],db1[i-1]);
        }
        //do not steal the first house
        db2[0]=0;
        db2[1]=money[1];
        for(int j=2;j<money.length;j++){
            db2[j]=Math.max(db2[j-2]+money[j],db2[j-1]);
        }
        for(int i=0;i<money.length-1;i++){
            if(answer<db1[i]) answer=db1[i];
        }
        for(int j=0;j<money.length;j++){
            if(answer<db2[j]) answer=db2[j];
        }
        return answer;
    }
}
