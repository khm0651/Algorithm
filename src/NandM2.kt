import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var visit : BooleanArray

fun main(args:Array<String>){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var input = reader.readLine()
    var range = input.split(" ")[0].toInt()
    var size = input.split(" ")[1].toInt()

    visit = BooleanArray(range) {false}

    for(i in 0 until range){
        visit[i] = true
        dfsNandM2(range,size,(i+1).toString(),i)
    }

}

fun dfsNandM2(range: Int, size: Int, target: String, start: Int) {

    if(size == target.replace(" ","").length){
        println(target)
        return
    }

    for(i in start until range){
        if(!visit[i]){
            visit[i] = true
            var s = "${target} ${i+1}"
            dfsNandM2(range, size, s, i)
            visit[i]= false
        }
    }

}
