import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var num = readLine().toInt()
    var deque = Deque()
    for(i in 0 until num){
        var input = readLine().split(" ")
        if(input.size == 2){
            var op = input[0]
            var item = input[1].toInt()
            when(op){
                "push_back" -> deque.push_back(item)
                "push_front" -> deque.push_front(item)
            }
        }else{
            var op = input[0]
            when(op){
                "back" -> println(deque.back())
                "front" -> println(deque.front())
                "size" -> println(deque.size())
                "empty" -> println(deque.empty())
                "pop_front" -> println(deque.pop_front())
                "pop_back" -> println(deque.pop_back())
            }
        }

    }
}

class Deque(){
    private var list = LinkedList<Int>()

    fun push_front(item : Int){
        list.addFirst(item)
    }

    fun push_back(item : Int){
        list.addLast(item)
    }

    fun pop_front():Int{
        return if(list.size!=0) {
            list.first
            list.removeFirst()
        } else -1
    }

    fun pop_back():Int{
        return if(list.size!=0) {
            list.last
            list.removeLast()
        } else -1
    }

    fun size():Int{
        return list.size
    }

    fun empty():Int{
        return if(list.isEmpty()) 1 else 0
    }

    fun front():Int{
        return if(list.size!=0) list.first else -1
    }

    fun back():Int {
        return if(list.size!=0) list.last else -1
    }
}