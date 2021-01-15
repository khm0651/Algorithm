import java.util.*
import kotlin.collections.ArrayList

var max = 0
var min = 0
fun main(args:Array<String>){

    var sc= Scanner(System.`in`)
    var num = sc.nextLine().toInt()
    var numarr = ArrayList<Int>()
    var input = sc.nextLine().split(" ")
    var oparr = ArrayList<String>()
    for( i in 0 until  input.size){
        numarr.add(input[i].toInt())
    }
    input = sc.nextLine().split(" ")
    for(i in input.indices){
        when(i){

            0 -> for(j in 0 until input[i].toInt()) oparr.add("+")

            1 -> for(j in 0 until input[i].toInt()) oparr.add("-")

            2 -> for(j in 0 until input[i].toInt()) oparr.add("*")

            3 -> for(j in 0 until input[i].toInt()) oparr.add("/")

        }
    }

    var visit = Array(oparr.size,{false})


    opDFS(visit,numarr,0,numarr[0],oparr,1)
    println(max)
    println(min)
}

fun opDFS(visit: Array<Boolean>, numarr: ArrayList<Int>,idx:Int,sum:Int,oparr:ArrayList<String>,jdx : Int) {
    if(idx == oparr.size) {
        if(sum > max) max = sum
        if(min == 0 ) min = max
        else if(sum < min) min = sum
        return
    }
    for(i in oparr.indices){
        if(!visit[i]){
            visit[i] = true
            var s = sum
            when(oparr[i]){
                "+" -> s+=numarr[jdx]
                "-" -> s-=numarr[jdx]
                "*" -> s*=numarr[jdx]
                "/" -> s/=numarr[jdx]
            }
            opDFS(visit,numarr,idx+1,s,oparr,jdx+1)
            visit[i] = false
        }
    }


}
