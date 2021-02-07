import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main () = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var testcase = readLine().toInt()
    repeat(testcase){
        var l = readLine().toInt()
        var visitMap = Array(l){BooleanArray(l)}
        var (startX,startY) = readLine().split(" ").map{it.toInt()}
        var startIndex = Index7562(startX,startY)
        var (targetX,targetY) = readLine().split(" ").map{it.toInt()}
        var targetIndex = Index7562(targetX,targetY)
        var dx = intArrayOf(1,2,2,1,-1,-2,-2,-1)
        var dy = intArrayOf(-2,-1,1,2,2,1,-1,-2)
        var q : Queue<Index7562> = LinkedList()
        q.add(startIndex)
        visitMap[startY][startX] = true
        bw.write("${bfs7562(visitMap,q,targetIndex,dx,dy)}\n")

    }
    bw.flush()
}

fun bfs7562(visitMap: Array<BooleanArray>, q: Queue<Index7562>, targetIndex: Index7562, dx: IntArray, dy: IntArray) : Int {
    var count = 0
    while(q.isNotEmpty()){
        repeat(q.size){
            var idx = q.poll()
            var x = idx.x
            var y = idx.y
            if(targetIndex.x == x && targetIndex.y == y) return count
            for(i in 0 until 8){
                var _x = x+dx[i]
                var _y = y+dy[i]
                if(check7562(_x,_y,visitMap)){
                    if(!visitMap[_y][_x]){
                        q.add(Index7562(_x,_y))
                        visitMap[_y][_x]=true
                    }
                }
            }
        }
        count++
    }
    return count
}

fun check7562(_x: Int, _y: Int, visitMap: Array<BooleanArray>): Boolean {
    return _x in 0 until visitMap[0].size && _y in 0 until visitMap.size
}

data class Index7562(var x : Int , var y : Int)