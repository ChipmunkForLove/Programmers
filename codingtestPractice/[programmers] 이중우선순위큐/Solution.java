import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());

        for(int k=0;k<operations.length;k++){
            String[] command = operations[k].split(" ");
            if(command[0].equals("I")){
                int num=Integer.parseInt(command[1]);
                minheap.add(num);
                maxheap.add(num);
            }
            else{ 
                if(command[1].equals("1")){
                    if(!maxheap.isEmpty()){
                        int removed = maxheap.poll();
                        LinkedList<Integer> tmp= new LinkedList<>();
                        while(!minheap.isEmpty()){
                            if(removed==minheap.peek()){
                                minheap.poll();
                            }
                            if(!minheap.isEmpty()){
                             tmp.add(minheap.poll());
                            }
                        }
                        while(!tmp.isEmpty()){
                            minheap.add(tmp.removeFirst());
                        }
                    }
                }
                else{
                    if(!minheap.isEmpty()){
                       int removed= minheap.poll();
                        LinkedList<Integer> tmp= new LinkedList<>();
                        while(!maxheap.isEmpty()){
                            if(removed==maxheap.peek()){
                                maxheap.poll();
                            }
                            if(!maxheap.isEmpty()){
                                tmp.add(maxheap.poll());
                            }
                        }
                        while(!tmp.isEmpty()){
                            maxheap.add(tmp.removeFirst());
                        }
                    }
                }
            } 
        }
        if(maxheap.size()==0){
            answer[0]=0;
            answer[1]=0;
        }
        else{
            answer[0]=maxheap.poll();
            answer[1]=minheap.poll();
        }
        return answer;
    }
}
