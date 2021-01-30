import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var a = reader.readLine()
    var b = reader.readLine()
    var dp = Array(a.length+1){IntArray(b.length+1)}
    for(i in 1 until  dp.size){
        for(j in 1 until  dp[0].size){
            if(a[i-1] == b[j-1]) dp[i][j] = dp[i-1][j-1]+1
            else dp[i][j] = max(dp[i-1][j],dp[i][j-1])
        }
    }
    println(dp.last().last())

}