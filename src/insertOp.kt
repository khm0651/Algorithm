import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

lateinit var visitMapOp : BooleanArray

var minOp : Long= 1000000000
var maxOp : Long= -1000000000

fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var size = reader.readLine().toInt()
    var arr = reader.readLine().split(" ")
    var opArr = reader.readLine().split(" ")
    var opList = ArrayList<String>()
    for(i in opArr.indices){
        when(i){
            0 -> for( j in 0 until opArr[i].toInt()) opList.add("+")
            1 -> for( j in 0 until opArr[i].toInt()) opList.add("-")
            2 -> for( j in 0 until opArr[i].toInt()) opList.add("*")
            3 -> for( j in 0 until opArr[i].toInt()) opList.add("/")
        }
    }
    visitMapOp = BooleanArray(opList.size){false}

    dfsOp(arr,opList,arr[0].toLong(),0)
    println(maxOp)
    println(minOp)
}

fun dfsOp(arr: List<String>, opList: ArrayList<String>, sum : Long, deep: Int) {

    if(deep == opList.size){
        if(maxOp < sum) maxOp = sum
        if(minOp > sum) minOp = sum
        return
    }

    for(i in 0 until opList.size){
        if(!visitMapOp[i]){
            visitMapOp[i] = true
            var _op = opList[i]
            var s : Long = sum
            when(_op){
                "+" -> s += arr[deep + 1].toLong()
                "-" -> s -= arr[deep + 1].toLong()
                "*" -> s *= arr[deep + 1].toLong()
                "/" -> {
                    if( s<0 ) {
                        s = -abs(s / arr[deep + 1].toLong())
                    }else{
                        s /= arr[deep + 1].toLong()
                    }
                }
            }
            dfsOp(arr, opList, s, deep + 1)
            visitMapOp[i] = false
        }
    }
}

