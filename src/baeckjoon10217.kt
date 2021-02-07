import java.io.BufferedReader
import java.io.InputStreamReader

fun main () = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var t = readLine().toInt()
    repeat(t){
        var (n,m,k) = readLine().split(" ").map{it.toInt()}
        var INF = 1001
        var graph = Array(n+1) {IntArray(n+1) {INF} }
        var cost = Array(n+1) {IntArray(n+1) }
        repeat( k) {
            var (u, v, c, d) = readLine().split(" ").map { it.toInt() }
            graph[u][v] = d
            cost[u][v] = c
        }
        for(i in 1 until graph.size) graph[i][i] = 0

        floyd10217(graph,cost,m)
    }
}

fun floyd10217(graph: Array<IntArray>, cost: Array<IntArray>, m: Int) {
    for(via in 1 until graph.size){
        for(from in 1 until graph.size){
            for(to in 1 until graph.size){
                if(graph[from][to] > graph[from][via] + graph[via][to]){
//                    if( m > cost[from][via] + cost[via][] )
//                    graph[from][to] = graph[from][via] + graph[via][to]
//                    cost[from][to] =
                }
            }
        }
    }
}

