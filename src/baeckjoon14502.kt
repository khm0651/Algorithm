import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

var safeVirousAreaNum = Int.MIN_VALUE

fun main () = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var (n,m) = readLine().split(" ").map{it.toInt()}
    var map = Array(n){IntArray(m)}
    for(i in 0 until n){
        var st = StringTokenizer(readLine())
        for(j in 0 until m){
            map[i][j] = st.nextToken().toInt()
        }

    }

    makeWall(map, count = 0,start = 0,n,m)
    bw.write("$safeVirousAreaNum")
    bw.flush()
}

fun makeWall(map: Array<IntArray>, count: Int, start: Int, n: Int, m: Int) {
    if(count == 3){
        safeVirousAreaNum = max(safeVirousAreaNum,countSafeArea(map))
        return
    }
    for(i in start until n * m ){
        var curY = i / m
        var curX = i % m
        if(map[curY][curX] ==0){
            map[curY][curX] = 1
            makeWall(map, count+1, i+1, n,m)
            map[curY][curX] = 0
        }
    }
}

fun countSafeArea(map: Array<IntArray>): Int {
    var q : Queue<Virous14502> = LinkedList<Virous14502>()
    var cloneMap = Array(map.size){IntArray(map[0].size)}
    for(i in 0 until cloneMap.size){
        for(j in 0 until cloneMap[0].size){
            cloneMap[i][j] = map[i][j]
        }
    }

    var dx = intArrayOf(1,0,-1,0)
    var dy = intArrayOf(0,1,0,-1)
    for(i in 0 until cloneMap.size){
        for(j in 0 until cloneMap[0].size){
            if(cloneMap[i][j] == 2) q.add(Virous14502(j,i))
        }
    }
    while(q.isNotEmpty()){
        var virous = q.poll()
        for(i in 0 until 4){
            var nextXCoord =  virous.x + dx[i]
            var nextYCoord = virous.y + dy[i]
            if(canInfection(nextXCoord,nextYCoord,cloneMap)){
                cloneMap[nextYCoord][nextXCoord] = 2
                q.add(Virous14502(nextXCoord,nextYCoord))
            }
        }
    }

    var safeAreaNum = 0
    for(i in 0 until map.size){
        for(j in 0 until map[0].size){
            if(cloneMap[i][j] == 0) safeAreaNum++
        }
    }
    return safeAreaNum
}

fun canInfection(x: Int, y: Int, map: Array<IntArray>): Boolean {
    return x in 0 until map[0].size && y in 0 until map.size && map[y][x] == 0
}

data class Virous14502 (var x : Int, var y:Int)