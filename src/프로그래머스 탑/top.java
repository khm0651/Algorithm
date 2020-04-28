class Solution {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        for(int i = 0; i< heights.length; i++) {
            boolean chk = false;
            for(int j=0; j<=i; j++) {
                if(heights[i]<heights[j]) {
                    answer[i] = j+1;
                    chk = true;
                }
            }
            if(!chk) {answer[i]=0;}
        }

        return answer;
    }
}