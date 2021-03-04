import java.io.BufferedReader
import java.io.InputStreamReader

fun main () = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var n = readLine().toInt()
    var map = Array(n){IntArray(n) }
    var INF = 100
    for(i in 0 until n) map[i] = readLine().split(" ").map { if(it.toInt() == 0) INF else it.toInt()  }.toIntArray()

    for(mid in 0 until n){
        for(start in 0 until n){
            for(end in 0 until n){
                if(map[start][end] > map[start][mid] + map[mid][end]){
                    map[start][end] = 1
                }
            }
        }
    }
    for(i in 0 until n){
        for(j in 0 until n){
            if(map[i][j] == INF) bw.write("0 ")
            else bw.write("${map[i][j]} ")
        }
        bw.write("\n")
    }
    bw.flush()
}