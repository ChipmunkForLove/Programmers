import java.util.*;
class Solution{
    Node root;
    LinkedList<Integer> preorder;
    LinkedList<Integer> postorder;
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        preorder=new LinkedList<>();
        postorder=new LinkedList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.y>o2.y){
                    return -1;
                }
                else{
                return 1;
                }
            }
        });
        for(int i=0;i<nodeinfo.length;i++){
            pq.add(new Node(nodeinfo[i][0],nodeinfo[i][1],i+1));
        }
        if(!pq.isEmpty()) {
            root = pq.poll();
        }
        while(!pq.isEmpty()){
            makeTree(root, pq.poll());
        }
        System.out.println();
        makePostorder(root);
        makePreorder(root);
        answer = new int[2][preorder.size()];
        for(int i=0;i<preorder.size();i++){
            answer[0][i]=preorder.get(i);
            answer[1][i]=postorder.get(i);
        }
        return answer;
    }
    public Node makeTree(Node root,Node node){
        if(root==null){
            return node;
        }
        else if(root.x<node.x){
            root.right = makeTree(root.right,node);
        }
        else{
            root.left= makeTree(root.left,node);
        }
        return root;
    }
    public void makePreorder(Node node){
        if(node!=null){
            preorder.add(node.value);
            makePreorder(node.left);
            makePreorder(node.right);
        }
    }
    public void makePostorder(Node node){
        if(node!=null){
            makePostorder(node.left);
            makePostorder(node.right);
            postorder.add(node.value);
        }
    }
}
class Node{
    int value;
    int x;
    int y;
    Node left;
    Node right;
    Node(int x,int y,int value){
        this.value=value;
        this.x=x;
        this.y=y;
        this.left=null;
        this.right=null;
    }
}
