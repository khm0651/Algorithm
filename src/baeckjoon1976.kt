import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var n = readLine().toInt()
    var m = readLine().toInt()
    var parent = IntArray(n+1)

    for(i in 1 .. n){
        parent[i] = i
    }

    fun find (x : Int) : Int{
        return if(parent[x] == x) x
        else{
            parent[x] = find(parent[x])
            parent[x]
        }
    }

    fun union (x: Int, y : Int){
        var parentX = find(x)
        var parentY = find(y)
        if(parentX != parentY) parent[parentY] = parentX
    }

    for(i in 1 .. n){
        var item = readLine().split(" ").map{it.toInt()}
        for(j in 0 until item.size){
            if(item[j] == 1) union(i,j+1)
        }
    }

    var travelList = readLine().split(" ").map { it.toInt() }
    var p = find(travelList[0])
    var flag = true
    for(i in 1 until travelList.size){
        if(p != find(travelList[i])){
            flag = false
            break
        }
    }
    if(flag) bw.write("YES\n")
    else bw.write("NO\n")
    bw.flush()

}

