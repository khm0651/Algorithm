import java.util.*

fun main(args : Array<String>){
    var sc = Scanner(System.`in`)
    var input = sc.nextLine()
    var height = input.split(" ")[0].toInt()
    var width = input.split(" ")[1].toInt()
    var arr = Array(height,{Array(width,{""})})
    var visit = Array(height,{Array(width,{false})})
    var history = ArrayList<String>()
    for(i in 0 until height){
        var word = sc.nextLine().toCharArray()
        for(j in 0 until width){
            arr[i][j] = word[j].toString()
        }

    }

    alphabetDFS(arr, visit, 0, 0, history, 1)
    println(history.size)
}

fun alphabetDFS(arr: Array<Array<String>>, visit: Array<Array<Boolean>>, idx: Int, jdx: Int, history: ArrayList<String>, count:Int) : Int {
    if(history.contains(arr[idx][jdx])) {
        history.removeAt(history.size-1)
        return count
    }else{
        if(!visit[idx][jdx]){
            history.add(arr[idx][jdx])
            visit[idx][jdx]
            var c = count
            if(jdx-1 >= 0) c = alphabetDFS(arr, visit, idx, jdx - 1, history, c)
            if(jdx+1 < arr[0].size) c = alphabetDFS(arr, visit, idx, jdx + 1, history, c)
            if(idx-1 >= 0) c = alphabetDFS(arr, visit, idx - 1, jdx, history, c)
            if(idx+1 < arr.size) c = alphabetDFS(arr, visit, idx + 1, jdx, history, c)

        }
    }



    return count

}
