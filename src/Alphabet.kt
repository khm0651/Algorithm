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

    alphabetDFS(arr, visit, 0, 0, history )
    println(max)

}

fun alphabetDFS(arr: Array<Array<String>>, visit: Array<Array<Boolean>>, idx: Int, jdx: Int, history: ArrayList<String>) {

    if (visit[idx][jdx]) {

        return
    } else {
        if (history.contains(arr[idx][jdx])) {
            return
        }

        history.add(arr[idx][jdx])
        visit[idx][jdx] = true

        if (jdx - 1 >= 0) {
            if (!visit[idx][jdx - 1]) alphabetDFS(arr, visit, idx, jdx - 1, history)
        }
        if (jdx + 1 < arr[0].size) {
            if (!visit[idx][jdx + 1]) alphabetDFS(arr, visit, idx, jdx + 1, history)
        }
        if (idx - 1 >= 0) {
            if (!visit[idx - 1][jdx]) alphabetDFS(arr, visit, idx - 1, jdx, history)
        }
        if (idx + 1 < arr.size) {
            if (!visit[idx + 1][jdx]) alphabetDFS(arr, visit, idx + 1, jdx, history)
        }
        if (history.size > max) max = history.size

        history.removeAt(history.size - 1)
        visit[idx][jdx] = false

    }

}
