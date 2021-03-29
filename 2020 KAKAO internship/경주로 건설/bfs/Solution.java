import java.util.*;

class Solution {
    private int n;
    private int[][] map;
    private boolean[][] visit;
    private static int[] dx = {-1, 0, 1, 0}; 
    private static int[] dy = {0, 1, 0 ,-1};
    private int cost = Integer.MAX_VALUE;

    public int solution(int[][] board) {
        int answer = 0;
        n = board.length;
        map = board;
        visit = new boolean[n][n];
        bfs(0,0,-1);
        answer = cost;
        return answer;
    }

    private void bfs(int x, int y, int dir) {

        Queue<Road> q = new LinkedList();
        q.add(new Road(x,y,dir,0));
        visit[x][y] = true;

        while (!q.isEmpty()) {
            Road road = q.poll();

            int qx = road.x;
            int qy = road.y;
            int qDir = road.dir;
            int qcost = road.cost;

            if (qx == n-1 && qy == n-1) {
                cost = Math.min(cost, qcost);
            }

            for (int i=0; i<dx.length; i++) {
                int nx = qx + dx[i];
                int ny = qy + dy[i];
                int nDir = i;
                int ncost = qcost;

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] == 1) {
                    continue;
                }

                if (qDir == -1) {
                    ncost += 100;
                } else if (qDir == nDir) {
                    ncost += 100;
                } else {
                    ncost += 600;
                }

                if (!visit[nx][ny] || map[nx][ny] >= ncost) {
                    visit[nx][ny] = true;
                    map[nx][ny] = ncost;
                    q.add(new Road(nx, ny, nDir, ncost));
                }

            }
        }

    }

}


class Road {
    int x;
    int y;
    int dir;
    int cost;

    Road(int x, int y, int dir, int cost) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.cost = cost;
    }
}
