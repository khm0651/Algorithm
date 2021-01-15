import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

var sb4 = StringBuilder()
var intArray4 = intArrayOf()

fun main(args:Array<String>){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var input = StringTokenizer(reader.readLine(), " ")
    var range = input.nextToken().toInt()
    var size = input.nextToken().toInt()

    intArray4 = IntArray(size)

    dfsNandM4(range,size,0,0)
    print(sb4)
}

fun dfsNandM4(range: Int, size: Int, deep: Int,start : Int) {

    if(size == deep){
        for(i in intArray4) sb4.append("${i} ")
        sb4.append("\n")
        return
    }

    for(i in start until range){

        intArray4[deep] = i+1
        dfsNandM4(range,size, deep+1, i)

    }
}

