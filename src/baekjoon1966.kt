import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var testCase = readLine().toInt()
    for(i in 0 until testCase){
        var input = readLine().split(" ").map(String::toInt)
        var n = input[0]
        var find = input[1]
        var list : Queue<PrintQ> = LinkedList<PrintQ>()
        var priority = readLine().split(" ").map(String::toInt)
        for(i in 0 until n) list.add(PrintQ(i,priority[i]))
        priority = priority.sortedByDescending { it }
        var i =0
        while(list.isNotEmpty()){

            if(priority[i] == list.peek().priority){
                var a = list.poll()
                i++
                if(find == a.num){
                    println("${i}")
                    break
                }
            }else{
                list.add(list.poll())
            }
        }
    }

}

data class PrintQ(val num : Int, val priority : Int)