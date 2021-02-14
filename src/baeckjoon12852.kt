import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var n = readLine().toInt()
    var dp = IntArray(n+1){Int.MAX_VALUE}
    var path = IntArray(n+1)
    dp[1] = 0
    for(i in 1 until n){
        if(dp[i+1] > dp[i]+1){
            dp[i+1] = dp[i]+1
            path[i+1] = i
        }
        if(i*2 in 1 .. n && dp[i*2] > dp[i]+1){
            dp[i*2] = dp[i]+1
            path[i*2] = i
        }
        if(i*3 in 1 .. n && dp[i*3] > dp[i]+1){
            dp[i*3] = dp[i]+1
            path[i*3] = i
        }
    }

    bw.write("${dp[n]}\n")
    while(true){
        bw.write("${n} ")
        if(n == 1) break
        n = path[n]
    }

    bw.flush()
}


