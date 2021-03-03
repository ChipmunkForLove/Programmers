class Solution {
     public int solution(String begin, String target, String[] words) {
        int min = 0;
        boolean[] used = new boolean[words.length];
        for(int i=0;i<words.length;i++){
            used[i]=false;
        }
        min=dfs(words,begin,target,0,used);
        if(min==Integer.MAX_VALUE) min=0;
        return min;
    }
    public int dfs(String[] words,String begin,String target,int cnt,boolean[] used){
        int min=Integer.MAX_VALUE;
        if(begin.equals(target)){
            return cnt;
        }
        int i=0;
        for(i=0;i<words.length;i++){
            if(begin.equals(words[i])) continue; //begin이랑 같은 단어는 검사 x
            if(used[i]) continue; // 이전에 거쳐 온 것
            if(checkWords(begin,words[i])){
                used[i]=true;
                min=Math.min(min,dfs(words,words[i],target,cnt+1,used));
                used[i]=false;
            }
        }
        return min;
    }
    public boolean checkWords(String a, String b){
        for(int i=0;i<a.length();i++){
            String partA=a.substring(0,i)+a.substring(i+1);
            String partB=b.substring(0,i)+b.substring(i+1);
            if(partA.equals(partB)) return true;
        }
        return false;
    }
}
