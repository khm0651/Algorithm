import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var st = StringTokenizer(readLine())
    var N = st.nextToken().toInt()
    var M = st.nextToken().toInt()
    var graph = Array(N+1){ArrayList<Int>()}
    var visitMap = BooleanArray(N+1)
    for(i in 0 until M){
        st = StringTokenizer(readLine())
        var u = st.nextToken().toInt()
        var v = st.nextToken().toInt()
        graph[u].add(v)
        graph[v].add(u)
    }
    var count = 0
    for(i in 1 .. N){
        if(!visitMap[i]){
            count++
            bfs11724(visitMap,graph,i)
        }

    }
    bw.write("${count}")
    bw.flush()
}

fun dfs11724(visitMap: BooleanArray, graph: Array<ArrayList<Int>>, idx: Int) {
    if(visitMap[idx]) return
    visitMap[idx] = true
    for(i in 0 until graph[idx].size){
        dfs11724(visitMap, graph, graph[idx][i])
    }
}

fun bfs11724(visitMap: BooleanArray, graph: Array<ArrayList<Int>>, idx: Int) {
    if(visitMap[idx]) return
    visitMap[idx] = true
    var q : Queue<Int> = LinkedList<Int>()
    for(i in 0 until graph[idx].size){
        q.add(graph[idx][i])
    }
    while(q.isNotEmpty()){
        var item = q.poll()
        if(!visitMap[item]){
            visitMap[item] = true
            for(i in 0 until graph[item].size){
                q.add(graph[item][i])
            }
        }
    }
}
