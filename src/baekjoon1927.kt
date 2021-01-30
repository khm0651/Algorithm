import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var num = readLine().toInt()
    var bw = System.out.bufferedWriter()
    var q = MinHeap(num)
    for(i in 0 until num){
        var op = readLine().toInt()
        when(op){
            0 -> bw.write("${q.pop()}\n")
            else -> q.push(op)
        }
    }
    bw.flush()
}

class MinHeap(n : Int,val list : Array<Int?> = Array(n+1){null}, var index : Int = 0){
    fun push(item : Int){
        var idx = ++index
        list[idx] = item
        while(idx / 2 >=1){
            if(list[idx /2]!! > list[idx]!! ) swap(idx,list)
            idx /=2
        }
    }

    fun pop() : Int{
        if(index ==0) return 0
        var parent = 1
        var temp = list[1]!!
        list[1] = list[index]
        list[index--] = null
        while(parent*2 <= index){
            var left = parent * 2
            var right = parent * 2 + 1
            var min = left

            if( right <= index && list[left]!! > list[right]!!) min = right

            if(list[parent]!! < list[min]!!) break

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