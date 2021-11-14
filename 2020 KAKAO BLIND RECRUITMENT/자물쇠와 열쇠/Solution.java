class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        int keyLen = key.length;
        int lockLen = lock.length;
        int newLen = lockLen+2*keyLen-2;
        int[][] newArr = new int[newLen][newLen];
        for(int i=0;i<lockLen;i++){ // 새 배열 중앙에 lock 다시 배치
            for(int j=0;j<lockLen;j++) {
                newArr[keyLen - 1+i][keyLen - 1+j]=lock[i][j];
            }
        }
        int[][][] keyArr = new int[4][keyLen][keyLen]; //시계방향으로 돌린 키 저장
        keyArr[0]= key;

        for(int i=0;i<keyLen;i++) {
            for (int j = 0; j < keyLen; j++) {
                keyArr[1][j][keyLen - 1 - i] = key[i][j];
                keyArr[2][keyLen - 1 - i][keyLen - 1 - j] = key[i][j];
                keyArr[3][keyLen - 1 - j][i] = key[i][j];
            }
        }
        for(int i=0;i<4;i++){
            if(keyCheck(newArr,keyArr[i],lockLen)) return true;
        }
        return false;
    }
    public boolean keyCheck(int[][] newArr,int[][] key,int lockLen){
        int keyLen = key.length;
        int arrLen = newArr.length;
        int cnt=0;
        int[][] temp;

        for(int x=0;x<lockLen+keyLen-1;x++){
            for(int y=0;y<lockLen+keyLen-1;y++){
                temp = new int[arrLen][arrLen];
                for(int i=keyLen-1;i<lockLen+keyLen-1;i++){
                    for(int j=keyLen-1;j<lockLen+keyLen-1;j++){
                        temp[i][j]=newArr[i][j];
                    }
                }
                for(int i=0;i<keyLen;i++){
                    for(int j=0;j<keyLen;j++){
                        temp[x+i][y+j]+=key[i][j];
                    }
                }
                for(int i=keyLen-1;i<+keyLen-1+lockLen;i++){
                    for(int j=keyLen-1;j<keyLen-1+lockLen;j++){
                        if(temp[i][j]==0 || temp[i][j]==2) break;
                        cnt++;
                    }
                }
                if(cnt==lockLen*lockLen) return true;
                cnt=0;
            }
        }
        return false;
    }
}
