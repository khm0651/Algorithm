import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

var dx = intArrayOf(1,-1,0,0)
var dy = intArrayOf(0,0,1,-1)
var min2178 = Int.MAX_VALUE

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var (n,m) = readLine().split(" ").map { it.toInt() }
    var map = Array(n){IntArray(m)}
    var visitMap = Array(n){BooleanArray(m)}
    for(i in 0 until n){
        map[i] = readLine().map { it.toString().toInt() }.toIntArray()
    }
    bfs2718(visitMap,map)
    bw.write("${min2178}")
    bw.flush()
}

fun bfs2718(visitMap: Array<BooleanArray>, map: Array<IntArray>) {
    var q : Queue<Index2718> = LinkedList()
    var index = Index2718(0,0)
    q.add(index)
    while(q.isNotEmpty()){
        var idx = q.poll()
        var x = idx.x
        var y = idx.y
        visitMap[y][x] = true
        for(i in 0 until 4){
            var _x = x+dx[i]
            var _y = y+dy[i]
            if(check2718(_x,_y,visitMap, map)){
                index = Index2718(_x,_y)
                q.add(index)
                map[_y][_x] += map[y][x]
                if(_x == visitMap[0].size-1 && _y == visitMap.size-1){
                    min2178 = min(min2178,map[_y][_x])
                }
            }
        }
    }
}

fun check2718(x: Int, y: Int, visitMap: Array<BooleanArray>, map: Array<IntArray>): Boolean {
    return x in 0 until visitMap[0].size && y in 0 until  visitMap.size && map[y][x] == 1 && !visitMap[y][x]
}

data class Index2718 (val x : Int, val y : Int)



