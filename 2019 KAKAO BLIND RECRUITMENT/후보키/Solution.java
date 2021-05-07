import java.util.*;
class Solution {
    HashSet<HashSet<Integer>> candidate;
    public int solution(String[][] relation) {
        int answer = 0;
        candidate = new HashSet<>();
        int maxColumn=relation[0].length;
        for(int i=1;i<=maxColumn;i++){
            HashSet<Integer> permu = new HashSet<>();
            nCr(permu,relation,i,maxColumn,0);
        }
        return candidate.size();
    }
    public void nCr(HashSet<Integer> permu,String[][] relation,int r,int n,int start){
        if(permu.size()==r){
           // System.out.println(permu.toString());
            if(checkCandidate(relation,permu)){
                if(checkMinimum(permu)){
                    candidate.add(new HashSet<>(permu));
                }
            }
        }else{
            for(int i=start;i<n;i++){
                permu.add(i);
                nCr(permu,relation,r,n,i+1);
                permu.remove(i);
            }
        }
    }
    public boolean checkCandidate(String[][] relation,HashSet<Integer> permu){
        HashSet<String> candidatetest = new HashSet<>();
        for(int i=0;i<relation.length;i++){
            String row="";
            for(Integer a : permu){
                row=row+"+"+relation[i][a];
            }
            //System.out.println(row);
            candidatetest.add(row);
        }
        if(candidatetest.size()==relation.length){
            //System.out.println("candidate");
            return true;
        }
        return false;
    }
    public boolean checkMinimum(HashSet<Integer> permu){
        for(HashSet<Integer> a : candidate){
            int cnt=0;
            for(Integer b : a){
                if(permu.contains(b)){
                   cnt++;
                }
            }
            if(cnt==a.size()) return false;
        }
        //System.out.println("//min//");
        return true;
    }
}
