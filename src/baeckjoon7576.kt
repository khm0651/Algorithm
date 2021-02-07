import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main () = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var (m,n) = readLine().split(" ").map { it.toInt() }
    var map = Array(n){IntArray(m)}
    var visitMap = Array(n){BooleanArray(m)}
    for(i in 0 until n){
        map[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    var q : Queue<Index7576> = LinkedList<Index7576>()
    var dx = intArrayOf(-1,1,0,0)
    var dy = intArrayOf(0,0,-1,1)
    var total = m*n
    var ripeTomatoes = 0
    for(i in 0 until n){
        for(j in 0 until m){
            if(map[i][j] == 1){
                var idx = Index7576(j,i)
                q.add(idx)
                visitMap[i][j] = true
                ripeTomatoes++
            }
            if(map[i][j]==-1) total--
        }
    }
    bw.write("${bfs7576(map,visitMap,q,count = 0,dx,dy,total,ripeTomatoes)}")
    bw.flush()
}

fun bfs7576(
    map: Array<IntArray>,
    visitMap: Array<BooleanArray>,
    q: Queue<Index7576>,
    count: Int,
    dx: IntArray,
    dy: IntArray,
    total: Int,
    ripeTomatoes: Int
) : Int {
    var c = count
    var rt = ripeTomatoes
    while(q.isNotEmpty()){
        repeat(q.size){
            var idx = q.poll()
            var x = idx.x
            var y = idx.y

            for(i in 0 until 4){
                var _x = x+dx[i]
                var _y = y+dy[i]
                if(check7576(_x,_y,visitMap,map)){
                    var idx = Index7576(_x,_y)
                    q.add(idx)
                    visitMap[_y][_x]=true
                    rt++
                }
            }
        }
        c++
    }
    c--
    if(rt != total) return -1
    return c
}

fun check7576(_x: Int, _y: Int, visitMap: Array<BooleanArray>, map: Array<IntArray>): Boolean {
    return _x in 0 until visitMap[0].size && _y in 0 until visitMap.size && map[_y][_x] == 0 && !visitMap[_y][_x]
}

data class Index7576 (val x : Int, val y : Int)

