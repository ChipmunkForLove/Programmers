import java.util.*;
class Solution {
    public static int solution(int m, int n, String[] board) {
        int[] dx={1,1,0};
        int[] dy={-1,0,-1};
        HashSet<Index> set = new HashSet<Index>();
        int answer = 0;
        char[][] newboard = new char[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                newboard[i][j]=board[i].charAt(j);
            }
        }
        boolean isPop=true;
        while(isPop) {
            isPop=false;
            for (int i = m - 1; i >= 1; i--) {
                for (int j = 0; j < n - 1; j++) {
                    char c = newboard[i][j];
                    int cnt = 0;
                    if(c=='0') continue;
                    for (int k = 0; k < 3; k++) {
                        int nx = j + dx[k];
                        int ny = i + dy[k];
                        if (newboard[ny][nx] == c && newboard[ny][nx] != '0') {
                            cnt++;
                        } else {
                            break;
                        }
                    }
                    if (cnt == 3) {
                        isPop=true;
                        set.add(new Index(i, j));
                        set.add(new Index(i, j + 1));
                        set.add(new Index(i - 1, j));
                        set.add(new Index(i - 1, j + 1));
                    }
                }
            }
            Iterator<Index> it = set.iterator();
            while (it.hasNext()) {
                Index index = (Index) it.next();
                newboard[index.x][index.y] = '0';
                answer++;
            }
            set.clear();
            for(int j=0; j<n; ++j) {
                for(int i=m-2; i>=0; --i) {
                   if(newboard[i][j]!='0'){
                       int temp1=i;
                       int temp2=i+1;
                       while(temp2<=m-1&& newboard[temp2][j]=='0'){
                           newboard[temp2][j]=newboard[temp1][j];
                           newboard[temp1][j]='0';
                           temp1++;
                           temp2++;
                       }
                   }
                }
            }
        }

        return answer;
    }
}
class Index{
    int x;
    int y;
    Index(int x,int y){
        this.x=x;
        this.y=y;
    }
    @Override
    public boolean equals(Object o){
        Index obj = (Index)o;
        return (this.x==obj.x && this.y==obj.y);
    }
    @Override
    public int hashCode(){
        return (x+","+y).hashCode();
    }
}
