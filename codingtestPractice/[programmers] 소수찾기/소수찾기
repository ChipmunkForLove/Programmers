import java.util.*;
class Solution {
    public int solution(String numbers) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        int len = numbers.length();
        char[] num=numbers.toCharArray();
        int[] used= new int[numbers.length()];
        String cur="";
        makeNum(set,num,len,used,cur);
        for(int element : set){
            if(element==0 || element ==1) continue;
            if(checkPrime(element)) answer++;
        }
        return answer;
    }
    public void makeNum(HashSet<Integer> set,char[] num,int len,int[] used,String cur){
        int i;
        for(i=0;i<len;i++){
            if(used[i]==1) continue;
            cur+=num[i];
            set.add(Integer.parseInt(cur));
            used[i]=1;
            makeNum(set,num,len,used,cur);
            used[i]=0;
            cur=cur.substring(0,cur.length()-1);
        }
    }
    public boolean checkPrime(int num){
        for(int i=2;i<num;i++){
            if(num%i==0) return false;
        }
        return true;
    }
}
