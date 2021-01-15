import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args:Array<String>){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var input = reader.readLine()
    var range = input.split(" ")[0].toInt()
    var size = input.split(" ")[1].toInt()

    for(i in 1 .. range){
        findNum(i,size,"${i}",range)
    }
}

fun findNum(idx: Int, size: Int, target: String, range: Int) {
    for(i in 1 .. range){
        if(target.replace(" ","").length == size) {
            println(target)
            return
        }
        var s=target
        if( target.contains(i.toString()) ) continue
        s+=" ${i}"
        findNum(i+1, size, s, range)
    }

}
