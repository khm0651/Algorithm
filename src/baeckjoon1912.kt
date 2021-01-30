import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

var maxSum = Int.MIN_VALUE

fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var num = reader.readLine().toInt()
    var dt = reader.readLine().split(" ").map(String::toInt).toIntArray()
    var dp = IntArray(num)
    findMaxSum(dt,dp,0,num)
    println(maxSum)

}

fun findMaxSum(dt: IntArray, dp: IntArray, deep: Int, num: Int)  {
    if(deep == num-1){
        dp[deep] = dt[deep]
        maxSum = max(maxSum,dp[deep])
        return
    }

    if(dp[deep] == 0) {
        findMaxSum(dt, dp, deep+1, num)
        dp[deep] = max(dt[deep] + dt[deep+1],dt[deep] + dp[deep+1])
        dp[deep] = max(dt[deep] , dp[deep])
        maxSum = max(maxSum,dp[deep])
        return
    }

}
