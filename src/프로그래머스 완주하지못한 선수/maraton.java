import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> map = new HashMap<String,Integer>();

        for(int i = 0 ; i<participant.length; i++) {
            if(!map.containsKey(participant[i])) {
                map.put(participant[i], 1);
            }else {
                int c = map.get(participant[i]);
                map.put(participant[i],c+1);
            }
        }


        for(int i=0; i<completion.length; i++) {
            if(map.containsKey(completion[i])) {
                if(map.get(completion[i]) == 1) {
                    map.remove(completion[i]);
                }else {
                    int c = map.get(completion[i]);
                    map.put(completion[i],c-1);
                }
            }
        }

        int len = map.keySet().toString().length();
        answer = map.keySet().toString().substring(1,len-1);
        return answer;
    }
}