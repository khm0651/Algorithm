import java.io.BufferedReader
import java.io.InputStreamReader

fun main () = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var (n,m) = readLine().split(" ").map{it.toInt()}
    var graph = Array(n+1){ArrayList<Node11675>()}
    var distance = LongArray(graph.size){Long.MAX_VALUE}
    distance[1] = 0
    repeat(m){
        var (a,b,c) = readLine().split(" ").map{it.toInt()}
        graph[a].add(Node11675(b,c))
    }
    if(bellmanFord(graph,distance)){
        bw.write("${-1}\n")
    }else{
        for(i in 2 .. n){
            if(distance[i] != Long.MAX_VALUE) bw.write("${distance[i]}\n")
            else bw.write("${-1}\n")
        }
    }
    bw.flush()
}

fun bellmanFord(graph: Array<ArrayList<Node11675>>, distance: LongArray) : Boolean {
    for(i in 1 until graph.size){
        for(node in 1 until graph.size){
            for(neighbour in graph[node]){
                if(distance[node] != Long.MAX_VALUE && distance[neighbour.to] > distance[node] + neighbour.w){
                    distance[neighbour.to] = distance[node] + neighbour.w
                    if(i == graph.size-1) return true
                }
            }
        }
    }
    return false
}

data class Node11675 ( var to : Int, var w : Int)