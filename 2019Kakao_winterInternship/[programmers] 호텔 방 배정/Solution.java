import java.util.*;
class Solution {
    HashMap<Long,Long> find = new HashMap<>();
    long[] answer;
    public long[] solution(long k, long[] room_number) {
        answer= new long[room_number.length];
        for(int i=0;i<room_number.length;i++){
            answer[i]=findroomnum(room_number[i]);
        }
        return answer;
    }
    public long findroomnum(long x){ //x is room number 
        if(find.get(x)==null){
            find.put(x,x+1);
            return x;
        }
        else{
            long y = findroomnum(find.get(x));
            find.put(x,y+1);
            return y;
        }
    }
}
