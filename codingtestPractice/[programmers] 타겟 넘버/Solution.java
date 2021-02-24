class Solution {
     public int solution(int[] numbers, int target) {
        int answer=0;
        answer=dfs(numbers,0,0,target);
        return answer;
    }
    public int dfs(int[] numbers,int num,int idx,int target){
        if(idx==numbers.length){
            if(num==target) {
                return 1;
            }
            else{
                return 0;
            }
        }
        int plus=num+numbers[idx];
        int minus=num-numbers[idx];
        int ans=0;
        ans+=dfs(numbers,plus,idx+1,target);
        ans+=dfs(numbers,minus,idx+1,target);

        return ans;
    }
}
