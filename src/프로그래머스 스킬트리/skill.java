import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer =0;

        for(int i=0; i<skill_trees.length; i++) {
            boolean f = true;
            Stack<Character> st = new Stack<Character>();
            for(int j=skill.length()-1; j>=0 ; j--) {
                st.push(skill.charAt(j));
            }
            for(int k=0; k<skill_trees[i].length();k++) {
                if(st.contains(skill_trees[i].charAt(k))) {
                    if(skill_trees[i].charAt(k) == st.peek()) {
                        st.pop();
                    }else {
                        f= false;
                        break;
                    }
                }else {
                    continue;
                }
            }
            if(f) {
                answer++;
            }
        }

        return answer;
    }
}