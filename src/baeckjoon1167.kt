import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var n = readLine().toInt()
    var tree = Array(n+1){ArrayList<Node1167>()}
    repeat(n){
        var list = readLine().split(" ").map { it.toInt() }
        var v1 = list[0]
        for(i in 1 until list.size-1 step 2){
            tree[v1].add(Node1167(list[i],list[i+1]))
        }
    }
    var v1 = bfs1167(tree,start = 1)
    var result = bfs1167(tree,v1.to)
    bw.write("${result.distance}")
    bw.flush()
}

fun bfs1167(tree: Array<ArrayList<Node1167>>, start: Int): Node1167 {
    var q : Queue<Node1167> = LinkedList<Node1167>()
    var visitMap = BooleanArray(tree.size)
    q.add(Node1167(start,0))
    visitMap[start] = true
    var answer = Node1167(0,0)
    while(q.isNotEmpty()){
        var node = q.poll()
        for(i in 0 until tree[node.to].size){
            var next = tree[node.to][i]
            if(!visitMap[next.to]){
                visitMap[next.to] = true
                if(answer.distance < node.distance + next.distance){
                    answer = Node1167(next.to,node.distance + next.distance)
                }
                q.add(Node1167(next.to,node.distance + next.distance))
            }
        }
    }
    return answer
}

data class Node1167(var to : Int, var distance : Int) : Comparable<Node1167>{
    override fun compareTo(other: Node1167): Int {
        return other.distance - distance
    }
}