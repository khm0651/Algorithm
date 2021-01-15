import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args:Array<String>){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var input = reader.readLine()
    var range = input.split(" ")[0].toInt()
    var size = input.split(" ")[1].toInt()

    var visit = BooleanArray(range) {false}

    dfsNandM(range,size,visit,"")
}

fun dfsNandM(range: Int, size: Int, visit: BooleanArray, target: String) {
    if(target.replace(" ","").length == size){
        println(target)
        return
    }
    for(i in 0 until range){
        if(!visit[i]){
            var s = "${target} ${i+1}".trim()
            visit[i] = true
            dfsNandM(range,size,visit,s)
            visit[i] = false
        }
    }
}
