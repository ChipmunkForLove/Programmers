import java.util.*;
class Solution {
    public int solution(String[] words) {
        int answer = 0;
        Node root = new Node();
        for(int i=0;i<words.length;i++){
            Node cur = root;
            for(int j=0;j<words[i].length();j++){
                char c =words[i].charAt(j);
                cur = cur.insert(c);
            }
            cur.childmap.put('*',new Node()); //check end
        }
        for(int i=0;i<words.length;i++){
            Node cur=root;
            int j;
            for(j=0;j<words[i].length();j++){
                char c =words[i].charAt(j);
                if(cur.childnum==1){
                    break;
                }
                cur=cur.childmap.get(c);
            }
            if(j==words[i].length()){
                answer+=words[i].length();
            }
            else{
                answer+=j;
            }
            //System.out.println("a:"+answer);
        }
        return answer;
    }
}
class Node{
    HashMap<Character,Node> childmap = new HashMap<>();
    int childnum=0;
    Node insert(char c){
        if(!childmap.containsKey(c)){
            childmap.put(c,new Node());
        }
        childmap.get(c).childnum++;
        return childmap.get(c);
    }
}
