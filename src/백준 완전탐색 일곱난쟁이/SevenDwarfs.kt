package `백준 완전탐색 일곱난쟁이`

import java.util.*
import kotlin.collections.ArrayList

var a = arrayListOf<Int>()
fun main(args:Array<String>){
    var sc = Scanner(System.`in`)
    var list = ArrayList<Int>()
    for(i in 0 until 9){
        list.add(sc.nextInt())
    }
    list.sort()
    var visit = Array<Boolean>(list.size,{false})
    var accumulateList = arrayListOf<Int>()
    so(list, visit, 0, arrayListOf())
    accumulateList.sort()
    for(i in a){
        println(i)
    }

}

fun so(list: ArrayList<Int>, visit: Array<Boolean> ,sum :Int,accumulatorList : ArrayList<Int>){
    if(sum == 100 && accumulatorList.size == 7){
        a = accumulatorList.clone() as ArrayList<Int>
        return
    }
    for(i in list.indices){
        if(!a.isEmpty()) return
        if(!visit[i] && accumulatorList.size != 7){
            visit[i] = true
            accumulatorList.add(list[i])
            var total = 0
            for(i in accumulatorList){
                total += i
            }
            so(list, visit, total, accumulatorList)
            visit[i] = false
            accumulatorList.removeAt(accumulatorList.size-1)

        }
    }

}



