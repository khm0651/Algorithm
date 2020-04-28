import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap <String,Integer> map = new HashMap<String,Integer>();

        for(int i = 0 ; i< clothes.length; i++) {
            if(map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1],map.get(clothes[i][1])+1 );
            }else {
                map.put(clothes[i][1],map.getOrDefault(clothes[i][1], 1));
            }

        }
        answer = 1;
        System.out.println(map);
        for (int value : map.values()) {
            answer*=(value+1);
        }
        answer-=1;
        return answer;
    }
}