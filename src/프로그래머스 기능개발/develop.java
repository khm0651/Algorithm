import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int [] count = new int [progresses.length];
        int [] answer = null;
        ArrayList<Integer> an = new ArrayList<Integer>();
        ArrayList <Integer> pro = new ArrayList<Integer>();
        ArrayList <Integer> result = new ArrayList<Integer>();
        for(int i=0; i<progresses.length; i++) {
            pro.add(i,progresses[i]);
        }

        for(int i=0;i<pro.size();i++) {
            int j=0;
            for(j=0; pro.get(i)<100; j++) {
                pro.set(i, pro.get(i)+speeds[i]);

            }
            count[i] = j;
            an.add(1);

        }
        for(int i=0; i<count.length;i++) {
            for(int j=i+1; j<count.length;j++) {
                if(an.get(i)==0) break;
                if(count[i]>=count[j]) {
                    an.set(i, an.get(i)+an.get(j));
                    an.set(j, 0);

                }else {
                    break;
                }
            }
        }

        for(int i=0; i<an.size();i++) {
            if(an.get(i)!=0) {
                result.add(an.get(i));

            }

        }
        answer = new int[result.size()];
        for(int i=0; i<result.size();i++) {
            answer[i]=result.get(i);

        }
        return answer;
    }
}