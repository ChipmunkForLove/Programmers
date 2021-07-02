import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows+1][columns+1];
        for(int i=1;i<rows+1;i++){
            for(int j=1;j<columns+1;j++){
                map[i][j]=(i-1)*columns+j;
            }
        }
        for(int i=0;i<queries.length;i++){
            int r1=queries[i][0];
            int c1=queries[i][1];
            int r2=queries[i][2];
            int c2=queries[i][3];
            LinkedList<Integer> temp = new LinkedList<>();
            int min=Integer.MAX_VALUE;
            for(int j=c1;j<=c2;j++){
                temp.add(map[r1][j]);
                if(map[r1][j]<min) min=map[r1][j];
            }
            for(int j=r1+1;j<=r2;j++){
                temp.add(map[j][c2]);
                if(map[j][c2]<min) min = map[j][c2];
            }
            for(int j=c2-1;j>=c1;j--){
                temp.add(map[r2][j]);
                if(map[r2][j]<min) min = map[r2][j];
            }
            for(int j=r2-1;j>r1;j--){
                temp.add(map[j][c1]);
                if(map[j][c1]<min) min = map[j][c1];
            }
            int lastNum = temp.removeLast();
            temp.addFirst(lastNum);
            int idx=0;
            for(int j=c1;j<=c2;j++){
                map[r1][j]=temp.get(idx);
                idx++;
            }
            for(int j=r1+1;j<=r2;j++){
                map[j][c2]=temp.get(idx);
                idx++;
            }
            for(int j=c2-1;j>=c1;j--){
                map[r2][j]=temp.get(idx);
                idx++;
            }
            for(int j=r2-1;j>r1;j--){
                map[j][c1]=temp.get(idx);
                idx++;
            }
            answer[i]=min;
        }
        return answer;
    }
}
