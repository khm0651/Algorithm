import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer =0;
        Queue<Integer> list = new LinkedList<Integer>();
        Queue<Integer> index = new LinkedList<Integer>();
        ArrayList<Integer> finish = new ArrayList<Integer>();
        int high =0;
        int highIndex=0;
        for(int i=0; i<priorities.length; i++) {
            list.offer(priorities[i]);
            index.offer(i);
        }
        while(true) {
            if(list.size()==0) {
                break;
            }
            boolean isMax = false;
            int j = list.peek();
            int jIndex = index.peek();

            for(int i=0; i<list.size();i++) {
                if(list.peek()>j) {
                    high = list.peek();
                    highIndex = index.peek();
                    isMax =true;
                    break;
                }else {
                    list.offer(list.poll());
                    index.offer(index.poll());
                }
            }
            if(!isMax) {
                finish.add(jIndex);
                index.poll();
                list.poll();
            }


        }

        for(int i=0; i<finish.size(); i++) {
            if(location == finish.get(i)) {
                answer = i+1;
                break;
            }
        }
        return answer ;
    }
}