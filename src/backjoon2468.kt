import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var n = readLine().toInt()
    var st : StringTokenizer
    var map = Array(n){IntArray(n)}
    var maxHeight = 0
    var max = Int.MIN_VALUE
    for(i in 0 until n){
        st = StringTokenizer(readLine())
        for(j in 0 until n){
            map[i][j] = st.nextToken().toInt()
            maxHeight = max(maxHeight,map[i][j])
        }
    }
    for(i in 0 .. maxHeight){
        var cloneMap = cloneMap2468(n,map)
        var floodedMap = floodedLocation(i,cloneMap)
        max = max(max,solve2468(floodedMap))
    }
    bw.write("${max}")
    bw.flush()
}

fun solve2468(floodedMap: Array<BooleanArray>): Int {
    var c = 0
    for(i in 0 until floodedMap.size){
        for(j in 0 until floodedMap[0].size){
            if(!floodedMap[i][j]){
                c++
                dfs2468(floodedMap,i,j)
            }
        }
    }
    return c
}

fun dfs2468(floodedMap: Array<BooleanArray>, idx: Int, jdx: Int) {
    if(floodedMap[idx][jdx]) return

    var dx = intArrayOf(1,0,-1,0)
    var dy = intArrayOf(0,1,0,-1)


    floodedMap[idx][jdx] = true
    for(i in 0 until 4){
        var nextIdx = idx + dy[i]
        var nextJdx = jdx + dx[i]
        if(check2468(floodedMap,nextJdx,nextIdx)) dfs2468(floodedMap, nextIdx, nextJdx)
    }

}

fun check2468(floodedMap: Array<BooleanArray>, jdx: Int, idx: Int): Boolean {
    return jdx in 0 until floodedMap[0].size && idx in 0 until floodedMap.size
}

fun floodedLocation(height: Int, cloneMap: Array<IntArray>) : Array<BooleanArray> {
    var floodedmap = Array(cloneMap.size){BooleanArray(cloneMap[0].size)}
    for(i in 0 until cloneMap.size){
        for(j in 0 until cloneMap[0].size){
            if(cloneMap[i][j] <= height) floodedmap[i][j] = true
        }
    }
    return floodedmap
}

fun cloneMap2468(n : Int,map : Array<IntArray>) : Array<IntArray>{
    var cloneMap = Array(n){IntArray(n)}
    for(i in 0 until n){
        for(j in 0 until n){
            cloneMap[i][j] = map[i][j]
        }
    }
    return cloneMap
}