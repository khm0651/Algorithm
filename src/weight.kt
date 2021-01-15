import java.util.*
import kotlin.collections.ArrayList

fun main(args:Array<String>){
    var sc = Scanner(System.`in`)
    var num = sc.nextLine().toInt()
    var list = ArrayList<ArrayList<Int>>()
    for(i in 0 until num){
        var input = sc.nextLine()
        var w = input.split(" ")[0].toInt()
        var h = input.split(" ")[1].toInt()
        var arr = ArrayList<Int>()
        arr.add(w)
        arr.add(h)
        list.add(i,arr)
    }
    var rank = Array(num,{1})

    for(i in 0 until num){
        for(j in 0 until num){
            if( i == j ) continue
            if(list[i][0] < list[j][0] && list[i][1] < list[j][1]) rank[i]++
        }
    }
    for(i in rank){
        print("${i} ")
    }
}