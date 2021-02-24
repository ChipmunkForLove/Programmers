import java.util.ArrayList;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        int[] first={1,2,3,4,5};
        int[] second={2,1,2,3,2,4,2,5};
        int[] third={3,3,1,1,2,2,4,4,5,5};
        int[] score={0,0,0};
        int firIdx=0;
        int secIdx=0;
        int thirIdx=0;
        int firLen=5;
        int secLen=8;
        int thirLen=10;
        for(int i=0;i<answers.length;i++){
            if(firIdx==firLen) firIdx=0;
            if(secIdx==secLen) secIdx=0;
            if(thirIdx==thirLen) thirIdx=0;

            if(first[firIdx]==answers[i]) score[0]++;
            if(second[secIdx]==answers[i]) score[1]++;
            if(third[thirIdx]==answers[i]) score[2]++;
            firIdx++;
            secIdx++;
            thirIdx++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int max=Math.max(Math.max(score[0],score[1]),score[2]);
        for(int i=0;i<3;i++){
            if(score[i]==max){
                list.add(i);
            }
        }
        answer=new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i)+1;
        }
        return answer;
    }
}
