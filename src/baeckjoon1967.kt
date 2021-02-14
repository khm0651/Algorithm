import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var n = readLine().toInt()
    var tree = Array(n+1) {ArrayList<Node1967>()}
    repeat(n-1){
        var (a,b,c) = readLine().split(" ").map{it.toInt()}
        tree[a].add(Node1967(b,c))
        tree[b].add(Node1967(a,c))
    }
    var v1 = bfs1967(tree,start = 1)
    var result = bfs1967(tree,v1.to)
    bw.write("${result.w}")
    bw.flush()
}

fun bfs1967(tree: Array<ArrayList<Node1967>>, start: Int): Node1967 {
    var visitMap = BooleanArray(tree.size)
    var q : Queue<Node1967> = LinkedList()
    var answer = Node1967(start,0)
    q.add(Node1967(start,0))
    visitMap[start] =true
    while(q.isNotEmpty()){
        var node = q.poll()
        for(i in 0 until tree[node.to].size){
            var next = tree[node.to][i]
            if(!visitMap[next.to]){
                visitMap[next.to] = true
                q.add(Node1967(next.to,node.w + next.w))
                if(answer.w < node.w + next.w){
                    answer = Node1967(next.to,node.w + next.w)
                }
            }
        }
    }
    return answer

}

data class Node1967 (var to : Int , var w : Int)