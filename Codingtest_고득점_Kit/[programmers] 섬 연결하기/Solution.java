class Solution {
    int[] root=new int[100];
    public int find(int x){
        if(root[x]==x) return x;
        else{
            return root[x]=find(root[x]);
        }
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        for(int i=0;i<100;i++){
            root[i]=i;
        }
        int len=costs.length;
        quickSort(costs,0,len-1);
        for(int i=0;i<len;i++){
            int start=find(costs[i][0]);
            int end=find(costs[i][1]);
            int cost=costs[i][2];
            if(start!=end){ //not in same set
                root[end]=start;
                answer+=cost;
            }
        }
        return answer;
    }
    public void quickSort(int[][] edge,int low,int high){
        int l=low;
        int h=high;
        int pivot=edge[(low+high)/2][2];
        while(l<=h){
            while(edge[l][2]<pivot) l++;
            while(edge[h][2]>pivot) h--;
            if(l<=h){
                int[] tmp = edge[l];
                edge[l]=edge[h];
                edge[h]=tmp;
                l++;
                h--;
            }
        }
        if(low<h){
            quickSort(edge,low,h);
        }
        if(l<high){
            quickSort(edge,l,high);
        }
    }
}
