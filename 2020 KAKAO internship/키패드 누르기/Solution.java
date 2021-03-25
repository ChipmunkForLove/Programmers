class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int leftcur=-2;
        int rightcur=-1;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7){
                answer+="L";
                leftcur=numbers[i];
            }
            else if(numbers[i]==3 || numbers[i]==6 ||numbers[i]==9){
                answer+="R";
                rightcur=numbers[i];
            }
            else{
        
                int num=numbers[i];
                int distleft= dist(num,leftcur);
                int distright= dist(num,rightcur);
                if(distleft>distright){
                    answer+="R";
                    rightcur=numbers[i];
                }
                else if(distleft<distright){
                    answer+="L";
                    leftcur=numbers[i];
                }
                else{
                    //same dist
                    if(hand.equals("right")){
                        answer+="R";
                        rightcur=numbers[i];
                    }
                    else{
                        answer+="L";
                        leftcur=numbers[i];
                    }
                }
            }
        }
        return answer;
    }
    public int dist(int num,int cur){
        int curx= (cur%3)==0? 3: cur%3;
        int cury= (cur-1)/3+1; 
        int numx= (num%3)==0? 3: num%3;
        int numy= (num-1)/3+1;
        if(num==0){
            numx=2;
            numy=4;
        }
        if(cur==0){
            curx=2;
            cury=4;
        }
        if(cur==-2){
            curx=1;
            cury=4;
        }
        if(cur==-1){
            curx=3;
            cury=4;
        }
        return Math.abs(curx-numx)+Math.abs(cury-numy);
    }
}
