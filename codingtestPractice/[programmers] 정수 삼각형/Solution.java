class Solution {
    public int solution(int[][] triangle) {
        int len=triangle.length;
        int prevlen=1;
        int max=-1;
        for(int i=1;i<len;i++){
            for(int j=0;j<i+1;j++){
                if(j==0){
                    triangle[i][j]+=triangle[i-1][j];
                }
                else if(j==triangle[i].length-1){
                    triangle[i][j]+=triangle[i-1][prevlen-1];
                }
                else{
                    triangle[i][j]+=Math.max(triangle[i-1][j-1],triangle[i-1][j]);
                }
            }
            prevlen=triangle[i].length;
        }
        for(int i=0;i<prevlen;i++){
            max=Math.max(max,triangle[len-1][i]);
        }
        return max;
    }
}
