import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var num = readLine().toInt()
    var bw = System.out.bufferedWriter()
    var q = AbsoluteHeap(num)
    for(i in 0 until num){
        var op = readLine().toInt()
        when(op){
            0-> bw.write("${q.pop()}\n")
            else -> q.push(op)
        }
    }
    bw.flush()
}

class AbsoluteHeap(n : Int , private val list:Array<Int?> = Array(n+1){null},private var index : Int = 0){
    fun push(item : Int){
        list[++index] = item
        var idx = index
        while(idx/2 >= 1){
            if(abs(list[idx / 2]!!) > abs(list[idx]!!)) swap(idx,list)
            else if(abs(list[idx / 2]!!) == abs(list[idx]!!)){
                if(list[idx/2]!! > list[idx]!!) swap(idx,list)
            }
            idx /=2
        }
    }

    fun pop() : Int {
        if(index == 0) return 0
        var temp = list[1]!!
        list[1] = list[index]
        list[index--] = null
        var parent = 1
        while(parent*2 <= index){
            var left = parent *2
            var right = parent *2 +1
            var min = left

            if(right <= index && abs(list[right]!!) < abs(list[left]!!)) min = right
            else if(right <= index && abs(list[right]!!) == abs(list[left]!!)){
                if(list[right]!! < list[left]!!) min = right
            }

            if(abs(list[parent]!!) < abs(list[min]!!)) break
            if(abs(list[parent]!!) == abs(list[min]!!)){
                if(list[parent]!!<list[min]!!) break
            }
            swap(min,list)
            parent = min
        }
        return temp
    }

    private fun swap(idx: Int, list: Array<Int?>) {
        var temp = list[idx]
        list[idx] = list[idx/2]
        list[idx/2] = temp
    }
}