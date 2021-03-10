import java.util.*;
class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        HashSet<HashSet<String>> set = new HashSet<>();
        LinkedList<String> list = new LinkedList<>();
        permu(set,list,user_id,banned_id);
        answer=set.size();
        return answer;
    }
    public static void permu(HashSet<HashSet<String>> set,LinkedList<String> id_list,String[] user_id,String[] banned){
        if(id_list.size()==banned.length){
            HashSet<String> bannedset=new HashSet<>();
            if(checkBanned(id_list,banned)){
                for(int i=0;i<id_list.size();i++){
                    bannedset.add(id_list.get(i));
                }
                set.add(bannedset);
            }

            return;
        }
        for(int i=0;i<user_id.length;i++){
            if(!id_list.contains(user_id[i])){
                id_list.add(user_id[i]);
                permu(set,id_list,user_id,banned);
                id_list.remove(user_id[i]);
            }
        }
    }
    public static boolean checkBanned(LinkedList<String> a,String[] banned){
        int i=0;
        for(String name : a){
            if(!(checkSameString(name,banned[i++]))){
                return false;
            }
        }
        return true;
    }
    public static boolean checkSameString(String a, String b){
        if(a.length()!=b.length()) return false;
        for(int i=0;i<a.length();i++){
            if(b.charAt(i)=='*') continue;
            if(a.charAt(i)!=b.charAt(i)) return false;
        }
        return true;
    }
}
