import java.util.*;
class Solution {
     public int solution(int[] people, int limit) {
        int answer = 0;
        int len=people.length;
        int last=len;
        quicksort(people,0,len-1);
        int i=0;
        int j=len-1;
        for(i=0,j=len-1;i<=j;){
            if(people[i]+people[j]<=limit){
                i++;
                j--;
            }
            else{
                i++;
            }
            answer++;
        }
        return answer;
    }
    public void quicksort(int[] people,int l, int h){
        int low=l;
        int high=h;
        int mid=people[(low+high)/2];
        while(low<=high){
            while(people[low]>mid) low++;
            while(people[high]<mid) high--;
            if(low<=high){
                int tmp=people[low];
                people[low]=people[high];
                people[high]=tmp;
                low++;
                high--;
            }
        }

        if(l<h) {
            quicksort(people, l,high);
            quicksort(people, low, h);
        }
    }
}
