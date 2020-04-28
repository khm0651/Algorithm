import java.util.*;

class Solution {
    public int solution(String s) {
        int answer =0;

        for(int i = 1; i<=s.length(); i++) {
            Stack<String> st = new Stack<String>();
            int min=0;
            int c=1;
            for(int j = 0 ; j < s.length(); j+=i) {
                String r = "";
                if(j+i>s.length()) {
                    for(int k = j ; k<s.length();k++) {
                        r+=s.charAt(k);
                        st.push(r);
                        r="";
                    }
                    break;
                }
                for(int k = j; k<j+i;k++) {
                    r+=s.charAt(k);
                }
                if(st.empty()) {
                    st.push(r);
                }else {
                    if(c>1) {
                        System.out.println(st.peek().indexOf(r));
                        if(st.peek().indexOf(r)>-1) {
                            if(st.peek().substring(st.peek().indexOf(r)).equals(r)) {
                                String t = st.pop();
                                c++;
                                st.push(c+t.substring(t.indexOf(r)));
                            }else {
                                c=1;
                                st.push(r);
                            }
                        }else {
                            c=1;
                            st.push(r);
                        }
                    }else {
                        if(st.peek().equals(r)) {
                            c++;
                            st.push(c+st.pop());
                        }else {
                            c=1;
                            st.push(r);
                        }
                    }

                }


            }
            while(!st.isEmpty()) {
                if(i==1) {
                    min += st.pop().length();

                }else {
                    min += st.pop().length();

                }
            }
            if(i==1) {
                answer = min;

            }else {
                if(answer>min) {
                    answer=min;
                }

            }
        }


        return answer;
    }
}