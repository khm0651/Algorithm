import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var input = readLine().split(" ").map(String::toInt)
    var n = input[0]
    var m = input[1]
    var v = input[2]
    var map = Array(n+1 ){ Array(n+1){0} }
    var visitmap = BooleanArray(n+1)
    for(i in 0 until m){
        var item = readLine().split(" ").map(String::toInt)
        map[item[0]][item[1]] = 1
        map[item[1]][item[0]] = 1
    }

    dfs1260(visitmap,map,v,bw)
    bw.write("\n")
    visitmap = BooleanArray(n+1)
    bfs1260(visitmap,map,v,bw)
    bw.flush()
}

fun bfs1260(visitmap: BooleanArray, map: Array<Array<Int>>, v: Int, bw: BufferedWriter) {
    var q : Queue<Int> = LinkedList<Int>()
    q.add(v)
    visitmap[v] = true
    while(q.isNotEmpty()){
        var item = q.poll()
        bw.write("${item} ")
        for(i in 1 until visitmap.size){
            if(!visitmap[i] && map[item][i] == 1) {
                q.add(i)
                visitmap[i] = true
            }
        }
    }
}

fun dfs1260(visitmap: BooleanArray, map: Array<Array<Int>>, v: Int, bw: BufferedWriter) {
    if(visitmap[v]) return
    visitmap[v] = true
    bw.write("${v} ")
    for(i in 1 until visitmap.size){
        if(!visitmap[i] && map[v][i] == 1) dfs1260(visitmap, map, i, bw)
    }
}
