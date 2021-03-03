import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len=commands.length;
        int[] answer = new int[len];
        for(int i=0;i<len;i++){
            int a=commands[i][1];
            int b=commands[i][0];
            int[] newarr= Arrays.copyOfRange(array,b-1,a);
            quickSort(newarr,0,a-b);
            answer[i]=newarr[commands[i][2]-1];    
        }
        return answer;
    }
   public int partition(int[] a,int low,int high){
        int pivot=a[(low+high)/2];
        while(low<=high){
            while(a[low]<pivot) low++;
            while(a[high]>pivot) high--;
            if(low<=high){
                swap(a,low,high);
                low++;
                high--;
            }
        }
        return low;
    }
   public void quickSort(int[] a,int low, int high){
            //if low and high are same, return;
        if(low<high) {
            int mid = partition(a, low, high);
            quickSort(a, low, mid - 1);
            quickSort(a, mid, high);
        }

    }
    public void swap(int[] a,int low,int high){
        int temp =a[low];
        a[low]=a[high];
        a[high]=temp;
    }
}
