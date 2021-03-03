import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main()= with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var n = readLine().toInt()
    var arr = Array<Resignation?>(n+1){null}
    var dp = IntArray(n+2)
    for(i in 1 .. n){
        var item = readLine().split(" ").map{it.toInt()}
        arr[i] = Resignation(item[0],item[1])
    }
    for(i in n downTo 1){
        if(checkValidIdx(i + arr[i]!!.t,n)){
            dp[i] = max(dp[i+1], arr[i]!!.p + dp[i + arr[i]!!.t])
        }else{
            dp[i] = dp[i+1]
        }
    }

    bw.write("${dp[1]}")
    bw.flush()
}

fun checkValidIdx(i: Int, n: Int): Boolean {
    return i in 1 .. n+1
}

data class Resignation(var t :Int, var p :Int)
