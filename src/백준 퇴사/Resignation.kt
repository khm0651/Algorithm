package `백준 퇴사`

import java.util.*
import kotlin.collections.ArrayList

var max = 0
fun main(args : Array<String>){
    var sc = Scanner(System.`in`)
    var targetNum = sc.nextLine().toInt()
    var t1 = ArrayList<Int>()
    var p1 = ArrayList<Int>()

    for(i in 0 until targetNum){
        var input = sc.nextLine()
        t1.add(input.split(" ")[0].toInt())
        p1.add(input.split(" ")[1].toInt())
    }

    for(i in t1.indices){
        var sum = i + t1[i]
        var psum = p1[i]
        if(sum > targetNum) continue

        solution(t1, p1, sum, targetNum, psum)

    }
    println(max)
}

fun solution(t1 : ArrayList<Int>, p1 : ArrayList<Int>,sum:Int,targetNum:Int,psum : Int){

    for(i in sum until t1.size){

        var total = i + t1[i]
        if(total > targetNum) return
        var ps = psum + p1[i]
        if(ps > max) max = ps
        solution(t1, p1, total, targetNum, ps)



    }
}

