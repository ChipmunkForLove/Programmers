class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        int yelloww=yellow;
        int yellowh=1;
        answer[0]=yelloww+2;
        answer[1]=yellowh+2;
        for(int i=2;i<yellow;i++){
            if(2*(yelloww+2)+2*yellowh==brown){
                answer[0]=yelloww+2;
                answer[1]=yellowh+2;
                break;
            }
            if(yellow%i==0){
                yelloww=yellow/i;
                yellowh=i;
            }
        }
        if(answer[0]<answer[1]){
            int tmp = answer[0];
            answer[0]=answer[1];
            answer[1]=tmp;
        }
        return answer;
    }
}
