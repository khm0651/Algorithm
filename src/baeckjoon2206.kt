import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.min
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var (n,m) = readLine().split(" ").map { it.toInt() }
    var map = Array(n){IntArray(m)}
    var cache = Array(n){IntArray(m)}
    cache[0][0]=1
    for(i in 0 until n){
        map[i] = readLine().map { it.toString().toInt() }.toIntArray()
    }
    var visitMap = Array(n){BooleanArray(m)}
    bw.write("${dfs2206(visitMap,map,cache)}")
    bw.flush()
}

fun dfs2206(visitMap: Array<BooleanArray>, map: Array<IntArray>, cache: Array<IntArray>): Int {
    var q : Queue<Index2206> = LinkedList()
    q.add(Index2206(0,0,false))
    visitMap[0][0] = true
    var dy = intArrayOf(0,1,0,-1)
    while(q.isNotEmpty()){

            var idx = q.poll()
            var x = idx.x
            var y = idx.y
            var isBroken = idx.isBroken
            for(i in 0 until 4){
                var _x = x + dx[i]
                var _y = y + dy[i]
                if(check2206(_x,_y,visitMap)){
                    if(map[_y][_x] == 1 && !isBroken && !visitMap[_y][_x]){
                        q.add(Index2206(_x,_y,true))
                        visitMap[_y][_x] = true
                        cache[_y][_x] = cache[y][x]+1
                    }else if (map[_y][_x] == 0 && !isBroken && visitMap[_y][_x]){
                        q.add(Index2206(_x,_y,isBroken))
                        cache[_y][_x] = cache[y][x]+1
                    } else if( map[_y][_x] == 0 && !visitMap[_y][_x]){
                        q.add(Index2206(_x,_y,isBroken))
                        visitMap[_y][_x] = true
                        cache[_y][_x] = cache[y][x]+1
                        cache[_y][_x] = min(cache[_y][_x],cache[y][x]+1)
                    }
                }
            }


    }
    if(cache[cache.size-1][cache[0].size-1]==0) return -1
    return cache[cache.size-1][cache[0].size-1]
}

fun check2206(_x: Int, _y: Int, visitMap: Array<BooleanArray>): Boolean {
    return _x in 0 until visitMap[0].size && _y in 0 until visitMap.size
}

data class Index2206(var x : Int, var y : Int, var isBroken : Boolean)