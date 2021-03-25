import java.util.*;
class Solution {
    public long solution(String expression) {
        long answer = 0;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        boolean[] v = new boolean[4];
        int[] n = {1,2,3,4}; //*/+-
        ArrayList<Integer> list = new ArrayList<>();
        makepermu(arr,list,n,v);
        long max=0;
        for(int i=0;i<arr.size();i++){
            long abs = Math.abs(calculate(arr.get(i),expression));
            max= Math.max(max,abs);
        }
        return max;
    }
    public void makepermu(ArrayList<ArrayList<Integer>> arr,ArrayList<Integer>cur,int[] nums,boolean[] visited){
        if(cur.size()==4){
            arr.add(new ArrayList<>(cur));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]) continue;
            cur.add(nums[i]);
            visited[i]=true;
            makepermu(arr,cur,nums,visited);
            visited[i]=false;
            cur.remove(cur.size()-1);
        }
    }
    public long calculate(ArrayList<Integer> order,String str){
       Stack<String> stack = new Stack<>();
        HashMap<String,Integer> map = new HashMap<>();
        map.put("*",order.get(0));
        map.put("/",order.get(1));
        map.put("+",order.get(2));
        map.put("-",order.get(3));
        StringTokenizer tokens = new StringTokenizer(str,"*,/,+,-",true);
        ArrayList<String> post = new ArrayList<>();
        while(tokens.hasMoreTokens()){
            String token = tokens.nextToken();
            if(token.equals("*")||token.equals("/")||token.equals("+")||token.equals("-")) {
                while (!stack.isEmpty() && map.get(stack.peek()) >= map.get(token) ) {
                    String cur = stack.pop();
                    post.add(cur);
                }
                stack.push(token);
            }
            else{
                post.add(token);
            }
        }
        while(!stack.isEmpty()){
            post.add(stack.pop());
        }
        Stack<Long> nums= new Stack<>();
        for(int i=0;i<post.size();i++){
            String token = post.get(i);
            if(!token.equals("*")&&!token.equals("/")&&!token.equals("+")&&!token.equals("-")){ // if token is number
                long num = Long.parseLong(token);
                nums.push(num);
            }
            else{
                long op1;
                long op2;
                long temp;
                if(token.equals("*")){
                    op1 = nums.pop();
                    op2 = nums.pop();
                    temp = op1*op2;
                    nums.push(temp);
                }
                else if(token.equals("/")){
                    op1 = nums.pop();
                    op2 = nums.pop();
                    temp = op2/op1;
                    nums.push(temp);
                }
                else if(token.equals("+")){
                    op1 = nums.pop();
                    op2 = nums.pop();
                    temp = op1+op2;
                    nums.push(temp);
                }
                else if(token.equals("-")){
                    op1 = nums.pop();
                    op2 = nums.pop();
                    temp = op2-op1;
                    nums.push(temp);
                }
            }
        }
        return nums.pop();
    }
}
