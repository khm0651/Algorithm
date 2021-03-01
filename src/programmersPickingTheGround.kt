import java.util.PriorityQueue
import kotlin.math.max

fun main(){
    PickingTheGround().solution(arrayOf(
            intArrayOf(4,3,2,1),
            intArrayOf(2,2,2,1),
            intArrayOf(6,6,6,4),
            intArrayOf(8,7,6,5),
    ))
}

class PickingTheGround{
    var dp = Array(100000){IntArray(4)}
    fun solution(land : Array<IntArray>) : Int{
        var answer = 0
        for(i in 0 until 4){
            dp[0][i] = land[0][i]
        }

        for(i in 1 until land.size){
            for(j in 0 until 4){
                for(k in 0 until 4){
                    if(j != k ) dp[i][j] = max( dp[i][j], dp[i-1][k] + land[i][j])
                }
            }
        }
        for(i in 0 until 4){
            answer = max(answer,dp[land.size-1][i])
        }
        return answer
    }

}