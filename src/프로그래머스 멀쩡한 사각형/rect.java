class Solution {
    public static long solution(int w, int h) {
        long answer =1;
        long max=0;
        long min=0;
        if(w == 1 || h == 1) {
            return 0;
        }
        if(w>h) {
            max=(long)w;
            min=(long)h;
        }else {
            max=(long)h;
            min=(long)w;
        }

        long total = max*min;


        long broken = max+min -gcd(max,min);
        answer = total-broken;
        return answer;

    }

    public static long gcd (long max, long min) {
        return max % min == 0 ? min : gcd(min,max%min);
    }
}