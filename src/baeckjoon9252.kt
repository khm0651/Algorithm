import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main () = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var list1 = readLine()
    var list2 = readLine()
    var map = Array(list2.length+1){IntArray(list1.length+1)}
    var path = Stack<Char>()
    for(i in 0 until list2.length){
        for( j in 0 until list1.length){
            if(list2[i] == list1[j]){
                map[i+1][j+1] = map[i][j] + 1
            }else{
                map[i+1][j+1] = max(map[i][j+1], map[i+1][j])
            }
        }
    }

    bw.write("${map[list2.length][list1.length]}\n")
    var y = list2.length-1
    var x = list1.length-1
    while(map[y+1][x+1] != 0){
        if(list2[y] != list1[x]){
            if(map[y+1][x] > map[y][x+1]){
                x--
            }else{
                y--
            }
        }else if (list2[y] == list1[x]){
            path.push(list1[x])
            x--
            y--
        }
    }
    while(path.isNotEmpty()) bw.write("${path.pop()}")
    bw.flush()
}