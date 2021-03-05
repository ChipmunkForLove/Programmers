import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        for(int i=0;i<moves.length;i++){
            
            for(int j=0;j<board.length;j++){
                if(board[j][moves[i]-1]==0) {
                    continue;
                }
                if(basket.isEmpty()){
                    basket.push(board[j][moves[i]-1]);
                }
                else if(!basket.isEmpty() && basket.peek()!=board[j][moves[i]-1]){
                    basket.push(board[j][moves[i]-1]);
                }
                else if(!basket.isEmpty() && basket.peek()==board[j][moves[i]-1]){
                    basket.pop();
                    answer++;
                }
                board[j][moves[i]-1]=0;
                break;
            }
        }
        return answer*2;
    }
}
