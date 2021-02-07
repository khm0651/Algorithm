import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var n = readLine().toInt()
    var m = readLine().toInt()
    var graph = Array(n+1){IntArray(n+1){ Int.MAX_VALUE} }
    var next = Array(n+1){Array<Int?>(n+1){ null} }

    for(i in 1 until graph.size) graph[i][i] = 0
    repeat(m){
        var (from,to,w) = readLine().split(" ").map{it.toInt()}
        graph[from][to] = min(graph[from][to],w)
        next[from][to] = to
    }
    floyd11404(graph,next)
    for(i in 1 until graph.size){
        for(j in 1 until graph.size){
            if(graph[i][j] == Int.MAX_VALUE) bw.write("0 ")
            else bw.write("${graph[i][j]} ")
        }
        bw.write("\n")
    }
    for(i in 1 until graph.size){
        for(j in 1 until graph.size){
            printPath(next,i,j)
        }
    }
    bw.flush()
}

fun printPath(next: Array<Array<Int?>>, from: Int, to: Int) {
    if(next[from][to] == null) return
    print("[ ${from} -> ${to} ] 경로 = ${from} -> ")
    var via = next[from][to]
    while(via != to){
        print("${via} -> ")
        via = next[via!!][to]!!
    }
    print("${to}\n")
}

fun floyd11404(graph: Array<IntArray>, next: Array<Array<Int?>>) {
    for(via in 1 until graph.size){
        for(from in 1 until graph.size){
            for(to in 1 until graph.size) {
                if (graph[from][via] != Int.MAX_VALUE && graph[via][to] != Int.MAX_VALUE) {
                    if(graph[from][to] > graph[from][via] + graph[via][to]){
                        graph[from][to] = min(graph[from][to], graph[from][via] + graph[via][to])
                        next[from][to] = next[from][via]
                    }
                }
            }
        }
    }

}
