import java.util.*;
class Solution {
    public String solution(String id) {
        String answer = "";
        String new_id = id.toLowerCase();
        new_id= new_id.replaceAll("[^-_.a-z0-9]","");
        new_id= new_id.replaceAll("[.]{2,}",".");
        if(new_id.startsWith(".")){
            new_id=new_id.substring(1,new_id.length());
        }
        if(new_id.endsWith(".")){
            new_id=new_id.substring(0,new_id.length()-1);
        }
        if(new_id.equals("")){
            new_id+="a";
        }
        if(new_id.length()>=16){
            new_id=new_id.substring(0,15);
        }
        if(new_id.endsWith(".")){
            new_id=new_id.substring(0,new_id.length()-1);
        }
        if(new_id.length()<=2){
            while(new_id.length()<3){
            new_id+=new_id.charAt(new_id.length()-1);
            }
        }
       // System.out.println(new_id);
        return new_id;
    }
}
