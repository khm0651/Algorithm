import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    while(true){
        var (w,h) = readLine().split(" ").map{it.toInt()}
        if( w == 0 && h == 0 )break
        var map = Array(h){IntArray(w)}
        var visitMap = Array(h){BooleanArray(w)}
        for(i in 0 until h){
            map[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
        }
        var count = 0
        for(i in 0 until h){
            for(j in 0 until w){
                if(!visitMap[i][j] && map[i][j] == 1){
                    count++
                    findLand(visitMap,map,i,j)
                }
            }
        }
        bw.write("${count}\n")
    }
    bw.flush()
}

fun findLand(visitMap: Array<BooleanArray>, map: Array<IntArray>, idx: Int, jdx: Int) {
    if(visitMap[idx][jdx]) return
    visitMap[idx][jdx] = true
    var dx = intArrayOf(1,1,0,-1,-1,-1,0,1)
    var dy = intArrayOf(0,1,1,1,0,-1,-1,-1)
    for(i in 0 until dx.size){
        var nextY = idx + dy[i]
        var nextX = jdx + dx[i]
        if(canMoveThere(map,nextY,nextX)){
            findLand(visitMap, map, nextY, nextX)
        }
    }
}

fun canMoveThere(map: Array<IntArray>, nextY: Int, nextX: Int): Boolean {
    return nextX in 0 until map[0].size && nextY in 0 until map.size && map[nextY][nextX] == 1
}
