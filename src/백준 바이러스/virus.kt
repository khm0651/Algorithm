package `백준 바이러스`

import java.util.*

fun main(args:Array<String>){
    var list = ArrayList<Stack<Int>>()
    var sc =Scanner(System.`in`)
    var comNum = sc.nextLine().toInt()
    for(i in 0 until comNum){
        var st = Stack<Int>()
        list.add(st)
    }
    var connect = sc.nextLine().toInt()
    for(i in 0 until connect){
        var input = sc.nextLine()
        var one = input.split(" ")[0].toInt() -1
        var two = input.split(" ")[1].toInt() -1
        list[one].push(two)
        list[two].push(one)
    }
    var visit = Array(comNum,{false})
    while(!list[0].isEmpty()){
        visit[0] = true
        findVirus(list[0].pop(), visit, list)
    }
    var count = 0
    for(i in visit.indices){
        if(visit[i]) count++
    }
    print(count-1)
}

fun findVirus(pop: Int, visit: Array<Boolean>,list: ArrayList<Stack<Int>>) {
    if(list[pop].isEmpty() || visit[pop]) return
    visit[pop] = true
    while(!list[pop].isEmpty()){
        findVirus(list[pop].pop(), visit, list)
    }
}
