
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.*

var dfsAnswer = arrayListOf<Int>()
lateinit var dfsVisit : Array<String>
var bfsAnswer = arrayListOf<Int>()
lateinit var bfsVisit : Array<String>
var q  : Queue<Int> = LinkedList<Int>()

fun main (args:Array<String>){
    var sc : Scanner = Scanner(System.`in`)
    var str = sc.nextLine()
    var nodeNumber = str.split(" ")[0].toInt()
    var lineNumber = str.split(" ")[1].toInt()
    var startNumber = str.split(" ")[2].toInt()
    var hashMap :HashMap<Int,ArrayList<Int>> = hashMapOf()
    dfsVisit = Array<String>(nodeNumber,{""})
    bfsVisit = Array<String>(nodeNumber,{""})

    for(i in 1 .. nodeNumber){
        hashMap.put(i, arrayListOf())
    }
    for(i in 0 until lineNumber){
        var lineStr = sc.nextLine().split(" ")
        var arrayList1 = hashMap.get(lineStr[0].toInt())
        arrayList1!!.add(lineStr[1].toInt())
        arrayList1.sort()
        hashMap.put(lineStr[0].toInt(),arrayList1)

        var arrayList2 = hashMap.get(lineStr[1].toInt())
        arrayList2!!.add(lineStr[0].toInt())
        arrayList2.sort()
        hashMap.put(lineStr[1].toInt(),arrayList2)
    }


    dfs(hashMap, startNumber)
    bfs(hashMap, startNumber)

    for(i in 0 until dfsAnswer.size){
        print("${dfsAnswer[i]} ")
    }
    println()
    for(i in 0 until bfsAnswer.size){
        print("${bfsAnswer[i]} ")
    }
}

fun bfs(hashMap: HashMap<Int, ArrayList<Int>>, startNumber: Int) {

    bfsVisit[startNumber-1] = "visit"
    bfsAnswer.add(startNumber)
    q.offer(startNumber)
    while(!q.isEmpty()){
        var number = q.poll()
        for(i in hashMap.get(number)!!){
            if(bfsVisit[i-1] != "visit"){
                q.offer(i)
                bfsVisit[i-1] = "visit"
                bfsAnswer.add(i)
            }
        }

    }
}

fun dfs(hashMap: HashMap<Int, ArrayList<Int>>, startNumber: Int) {

    if(dfsVisit[startNumber-1] != "visit"){
        dfsVisit[startNumber-1] = "visit"
        dfsAnswer.add(startNumber)
        for(i in hashMap.get(startNumber)!!){
            dfs(hashMap,i)
        }
    }

}



