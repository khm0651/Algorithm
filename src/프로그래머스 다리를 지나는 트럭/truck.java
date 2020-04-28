import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> truck_time = new LinkedList<>();
        Queue<Integer> ing = new LinkedList<>();
        Queue<Integer> finish = new LinkedList<>();
        int result = 0;
        int bridge_weight =0;
        int i=0;
        while(true) {
            result++;
            if(finish.size() == truck_weights.length)break;
            if(i < truck_weights.length  ) {
                if(weight - truck_weights[i] >= 0) {

                    ing.offer(truck_weights[i]);
                    truck_time.offer(0);
                    weight -=truck_weights[i];
                    i++;
                }

            }

            if(ing.size() != 0 ) {
                for (int j = 0 ; j < ing.size(); j++) {
                    truck_time.offer(truck_time.poll()+1);
                }
            }

            if(truck_time.peek() !=null && truck_time.peek() == bridge_length) {
                truck_time.poll();
                weight += ing.peek();
                finish.offer(ing.poll());
            }


        }
        return result;

    }
}