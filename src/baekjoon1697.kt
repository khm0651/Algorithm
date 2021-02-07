import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.util.*

fun main () = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var (n,k) = readLine().split(" ").map{it.toInt()}
    var visitMap = BooleanArray(100001)
    bw.write("${dfs1697(visitMap,n,k,bw)}")
    bw.flush()
}

fun dfs1697(visitMap: BooleanArray, n: Int, k: Int, bw: BufferedWriter) : Int {
    var q : Queue<Int> = LinkedList()
    q.add(n)
    visitMap[n] = true
    var count = 0
    while(q.isNotEmpty()){
        repeat(q.size){
            var item = q.poll()

            if(item == k) return count
            if(check1697(item-1)) {
                if(!visitMap[item-1]){
                    q.add(item-1)
                    visitMap[item-1] = true
                }
            }
            if(check1697(item+1)){
                if(!visitMap[item+1]){
                    q.add(item+1)
                    visitMap[item+1] = true
                }
            }
            if(check1697(item*2)) {
                if(!visitMap[item*2]){
                    q.add(item*2)
                    visitMap[item*2] = true
                }
            }
        }
        count++
    }
    return count
}

fun check1697(i: Int): Boolean {
    return i in 0 .. 100000
}
