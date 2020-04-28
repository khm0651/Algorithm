class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        for(int i=0; i<phone_book.length;i++) {
            int len = phone_book[i].length();
            for(int j = 0 ; j<phone_book.length; j++) {
                if(i==j) {
                    continue;
                }
                if(phone_book[j].length()<len) {
                    break;
                }else {
                    if(phone_book[i].compareTo(phone_book[j].substring(0,len)) == 0) {
                        answer =false;
                    }
                }
            }
        }
        return answer;
    }
}