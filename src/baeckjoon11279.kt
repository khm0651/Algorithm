import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var number = readLine().toInt()
    var q = PriorityQueue()
    for(i in 0 until number){
        var op = readLine().toInt()
        when(op){
            0-> println(q.pop())
            else-> q.push(op)
        }
    }


}

class PriorityQueue(val list : Array<Int?> = Array(100000){null},var index : Int = 0){
    fun push(item : Int){
        var idx = ++index
        list[idx] = item
        while((idx != 1) && idx / 2 >=1){
            if(list[idx]!! > list[idx/2]!!) swap(idx,list)
            idx /= 2
        }
    }

    fun pop() : Int{
        if(index==0) return 0
        var parent = 1
        var temp = list[parent]!!
        list[1] = list[index]
        list[index] = null
        index--
        while(parent*2 <= index){
            var left = parent*2
            var right = parent*2+1
            var max = left

            if(right <= index && list[right]!! > list[left]!!) {
                max = right
            }
            if(list[parent]!! > list[max]!!) break
            swap(max,list)
            parent = max
        }
        return temp
    }

    private fun swap(idx: Int, list: Array<Int?>) {
        var temp = list[idx]
        list[idx] = list[idx/2]
        list[idx/2] = temp
    }
}