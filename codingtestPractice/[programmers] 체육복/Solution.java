class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] clothes= new int[n+1];
        for(int i=0;i<lost.length;i++){
            for(int j=0;j<reserve.length;j++){
                if(lost[i]==reserve[j]){ //여벌 옷이 있는 사람이 자신의 옷을 도난 당한 경우
                    lost[i]=-1; 
                    reserve[j]=-1;
                }
            }
        }
        for(int i=0;i<lost.length;i++){
            if(lost[i]!=-1){ //여벌 옷이 있는 사람이 자신의 옷을 도난 당했을 경우 자신의 옷을 입기 때문에 더 이상 이 사람들은 옷이 없는 케이스에 넣지 않는다. 
                clothes[lost[i]]=-1;//check the people who don't have gym clothes
            }
        }
        for(int i=0;i<reserve.length;i++){
						 if(reserve[i]==-1) continue; //이미 자신의 여벌 옷을 사용했다. 
             if(reserve[i]>1 && clothes[reserve[i]-1]==-1){
                clothes[reserve[i]-1]++;
            }
            else if(reserve[i]<n && clothes[reserve[i]+1]==-1){
                clothes[reserve[i]+1]++;
            }
        }
        for(int i=1;i<n+1;i++){
            if(clothes[i]==0){
                answer++;
            }
        }
        return answer;
    }
}
