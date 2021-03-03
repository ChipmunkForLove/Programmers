class Solution {
    public int solution(int[] citations) {
        int answer = -1;
        int i=0;
        int len = citations.length;
        quicksort(citations,0,len-1);
        for(i=0;i<len;i++){
           if(citations[i]<=i) {
               answer=i;
               break;
           }
        }
        if(i==len) answer=i;
        return answer;
    }
    public void quicksort(int[] c,int low,int high){
        int pivot=c[(low+high)/2];
        int l=low;
        int h=high;
        while(l<=h){
            while(c[l]>pivot) l++;
            while(c[h]<pivot) h--;
            if(l<=h){
                int tmp=c[l];
                c[l]=c[h];
                c[h]=tmp;
                l++;
                h--;
            }
        }
        if(l<high) quicksort(c,l,high);
        if(h>low) quicksort(c,low,h);
    }
}
