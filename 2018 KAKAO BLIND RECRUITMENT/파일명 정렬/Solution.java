import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        Arrays.sort(files,new Comparator<>(){
            @Override
            public int compare(String o1,String o2){
                String head1=o1.split("[0-9]")[0];
                String head2=o2.split("[0-9]")[0];
                if(head1.compareToIgnoreCase(head2)<0){
                    return -1;
                }
                else if(head1.compareToIgnoreCase(head2)>0){
                    return 1;
                }
                else{
                    o1=o1.replace(head1,"");
                    o2=o2.replace(head2,"");
                    String num1="";
                    String num2="";
                    for(int j=0;j<o1.length();j++){
                        if(Character.isDigit(o1.charAt(j)) && num1.length()<5 ){
                            num1+=o1.charAt(j);
                        }
                        else{
                            break;
                        }
                    }
                    for(int j=0;j<o2.length();j++){
                        if(Character.isDigit(o2.charAt(j)) && num2.length()<5 ){
                            num2+=o2.charAt(j);
                        }
                        else{
                            break;
                        }
                    }
                    if(Integer.parseInt(num1)<Integer.parseInt(num2)){
                        return -1;
                    }
                    else if(Integer.parseInt(num1)>Integer.parseInt(num2)){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
            }
        });
        answer=files;
        return answer;
    }
}
