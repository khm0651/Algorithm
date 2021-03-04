import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main ()= with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var (R,C) = readLine().split(" ").map { it.toInt() }
    var map = Array(R){CharArray(C) }
    for(i in 0 until R) {
        var str = readLine()
        for(j in 0 until C){
            map[i][j] = str[j]
        }
    }
    var visitMap = BooleanArray('Z'-'A'+1)
    bw.write("${findMaxMoveNum(map,visitMap,0,0,0,map[0][0])}")
    bw.flush()

}

fun findMaxMoveNum(map: Array<CharArray>, visitMap: BooleanArray, idx: Int, jdx: Int, count: Int, c: Char) : Int {
    if(visitMap[c-'A']) return count
    visitMap[c-'A'] = true
    var num = count
    var dx = intArrayOf(1,0,-1,0)
    var dy = intArrayOf(0,1,0,-1)
    for(i in 0 until 4){
        var nextIdx = idx + dy[i]
        var nextJdx = jdx + dx[i]

        if(canMoveThere1987(map,nextIdx,nextJdx)){
            num = max(num,findMaxMoveNum(map, visitMap, nextIdx, nextJdx, count + 1 , map[nextIdx][nextJdx]))
        }
    }
    visitMap[c-'A'] = false
    return num
}

fun canMoveThere1987(map: Array<CharArray>, nextIdx: Int, nextJdx: Int): Boolean {
    return nextIdx in 0 until map.size && nextJdx in 0 until map[0].size
}
