import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var n = readLine()
    var bw = System.out.bufferedWriter()
    var count = 0
    if(n.toInt() < 10) {
        for(i in 1 .. n.toInt()) count++
    }
    else{
        count = 9
        for(i in 10 .. n.toInt()){
            var num = i.toString()
            var diff = num[1] - num[0]
            var isHanSu = true
            for(j in 0 until num.length-1){
                if(num[j+1].toInt() - num[j].toInt() != diff){
                    isHanSu = false
                }
            }
            if(isHanSu) count++
        }
    }
    bw.write("${count}")
    bw.flush()
}