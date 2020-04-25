package `프로그래머스 모의고사`

import kotlin.collections.HashMap

class Solution{
    fun solution(answers : IntArray) : IntArray{
        var answer = arrayListOf<Int>()
        var p1 = intArrayOf(1,2,3,4,5)
        var p2 = intArrayOf(2,1,2,3,2,4,2,5)
        var p3 = intArrayOf(3,3,1,1,2,2,4,4,5,5)
        var score :HashMap<Int,Int> = HashMap<Int,Int>()
        var maxScore : Int =0;
        for(i in answers.indices){
            if(p1[i%p1.size] == answers[i]) score.set(1,score.getOrDefault(1,0) + 1)
            if(p2[i%p2.size] == answers[i]) score.set(2,score.getOrDefault(2,0) + 1)
            if(p3[i%p3.size] == answers[i]) score.set(3,score.getOrDefault(3,0) + 1)
        }
        score.forEach { t, u ->  if(maxScore<u){
            maxScore=u
        } }
        score.forEach { t, u ->  if(maxScore==u){
            answer.add(t)
        } }
        var result = answer.toIntArray()
        result.sort()
        return result
    }


}

fun main (args : Array<String>){
    var answers : IntArray = intArrayOf(1,3,2,4,2,2,5,3,4,1,3,2,5,1,2,3)
    Solution().solution(answers)
}