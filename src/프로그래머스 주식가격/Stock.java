package `프로그래머스 주식가격`

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {

        ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int i=0; i<prices.length; i++){
            arr.add(0);
        }
        for(int i=0; i<prices.length-1 ; i++){
            for(int j =i+1; j<prices.length; j++){
                if(prices[i]<=prices[j]){
                    arr.set(i,arr.get(i)+1);
                }else {
                    arr.set(i,arr.get(i)+1);
                    break;
                }
            }
        }
        int [] answer = arr.stream().mapToInt(i->i).toArray();
        return answer;
    }
}