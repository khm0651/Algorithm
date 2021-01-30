import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var input = readLine().split(" ")
    var n = input[0].toInt()
    var m = input[1].toInt()
    var mList = readLine().split(" ").map(String::toInt).toIntArray()
    var deque = ArrayDeque<Int>()
    var count = 0
    for (i in 1 .. n) deque.add(i)
    for(i in 0 until m){
        var size = 0
        if(deque.size % 2 == 0){
            size = deque.size/2 - 1
        }else{
            size = deque.size/2
        }

        var idx = deque.indexOf(mList[i])
        if(idx <= size){
            while(deque.first() != mList[i]){
                deque.addLast(deque.removeFirst())
                count++
            }
        }else{
            while(deque.first() != mList[i]){
                deque.addFirst(deque.removeLast())
                count++
            }
        }
        deque.removeFirst()
    }
    println(count)
}
