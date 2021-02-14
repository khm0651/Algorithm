import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var n = readLine().toInt()
    var list = readLine().split(" ").map{it.toInt()}
    list = list.sorted()
    var min = Int.MAX_VALUE
    var answerList = MutableList(2){0}
    var l = 0
    var r = list.size-1
    while(l<r){
        var sum = list[l]+list[r]
        if(abs(sum) < min) {
            min = abs(sum)
            answerList[0] = list[l]
            answerList[1] = list[r]
        }
        if(sum > 0){
            r--
        }else {
            l++
        }
    }
    answerList.sort()
    answerList.forEach { bw.write("${it} " ) }
    bw.flush()
}