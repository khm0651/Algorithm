import java.util.*;

class Solution {
    public int solution(String arg) {
        int answer = 0;
        arg = arg.replace("()", "0");
        Stack<Character> st = new Stack<Character>();
        for(int i = 0; i<arg.length(); i++) {
            if(!st.isEmpty() && st.peek() == '0') {
                st.pop();
                if(!st.isEmpty()) {
                    answer += st.size();
                }
            }
            if(!st.isEmpty() && st.peek() == '(' && arg.charAt(i) == ')') {
                st.pop();
                answer+=1;
                continue;
            }
            st.push(arg.charAt(i));
        }
        return answer;
    }
}