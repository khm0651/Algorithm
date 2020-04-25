package `프로그래머스 가운데숫자출력`

class Solution {
    fun solution(s: String): String {
        var answer = ""
        var c = s.length/2
        if(s.length % 2 ==0){
            answer += s.get(c-1)
            answer += s.get(c)
        }else{
            answer += s.get(c)
        }

        return answer
    }
}

fun main (args:Array<String>){
    var s = "abcd"
    Solution().solution(s)
}