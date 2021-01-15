import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

lateinit var visitMap : BooleanArray
var sb = StringBuilder()
lateinit var intArray : IntArray

fun main(args:Array<String>){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var input = reader.readLine()
    var range = input.split(" ")[0].toInt()
    var size = input.split(" ")[1].toInt()

    visitMap = BooleanArray(range){false}
    intArray = IntArray(range)

    dfsNandM3(range,size,0)
    print(sb)
}

fun dfsNandM3(range: Int, size: Int, deep: Int) {

    if(size == deep){

        for(i in intArray){
            if(i==0)continue
            sb.append("${i} ")
        }
        sb.append("\n")
        return
    }

    for(i in 0 until range){
        intArray[deep] = i+1
        dfsNandM3(range,size, deep+1)
    }
}
