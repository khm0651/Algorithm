import java.io.BufferedReader
import java.io.InputStreamReader

fun main () = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var (n,m) = readLine().split(" ").map { it.toInt() }
    var map = Array(n){IntArray(m)}
    for(i in 0 until n){
        map[i] = readLine().split(" ").map{it.toInt()}.toIntArray()
    }
    var dp = Array(n){IntArray(m){-1} }
    bw.write("${dfsWithDp(dp,map,0,0)}")
    bw.flush()
}

fun dfsWithDp(dp: Array<IntArray>, map: Array<IntArray>, idx: Int, jdx: Int) :Int{
    if(idx == map.size-1 && jdx == map[0].size-1) return 1
    if(dp[idx][jdx] != -1) return dp[idx][jdx]
    if(dp[idx][jdx] == -1){
        dp[idx][jdx] = 0
        var dx = intArrayOf(1,0,-1,0)
        var dy = intArrayOf(0,1,0,-1)
        for(i in 0 until 4){
            var nextIdx = idx + dy[i]
            var nextJdx = jdx + dx[i]
            if(nextIdx in 0 until map.size && nextJdx in 0 until map[0].size){
                if(map[idx][jdx] > map[nextIdx][nextJdx]){
                    dp[idx][jdx] += dfsWithDp(dp,map, nextIdx, nextJdx)
                }
            }
        }
    }
    return dp[idx][jdx]
}
