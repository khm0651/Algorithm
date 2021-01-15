fun main(args:Array<String>){
    var blocks = arrayOf(
            intArrayOf(0,50),
            intArrayOf(0,22),
            intArrayOf(2,10),
            intArrayOf(1,4),
            intArrayOf(4,-13))
    var arr = solution(blocks)
    for(i in arr){
        print("${i} ")
    }
}

fun solution(blocks:Array<IntArray>) : IntArray{
    var arr = Array(blocks.size,{Array(blocks.size,{""})})
    var aculist = ArrayList<Int>()
    var count = 0
    for(i in 0 until blocks.size ){
        for(j in 0 .. i){
            if(blocks[i][0] == j){
                count++
                arr[i][j] = blocks[i][1].toString()
                aculist.add(blocks[i][1])
            }
            else {
                count++
                arr[i][j] = "0"
            }
        }
    }
    
    while (count != aculist.size){

        pdfs(arr,0,0,arr[0][0],aculist)

    }
    var answer = arrayListOf<Int>()
    for(i in arr) {
        for ( j in i) {
            if(j == "") break
            answer.add(j.toInt())
        }
    }
    return answer.toIntArray()
}

fun pdfs(arr: Array<Array<String>>, idx: Int, jdx: Int, target: String,aculist :ArrayList<Int> ) {

    if(idx == arr.size - 1 || target == "0") return
    var t = target.toInt()
    var n = arr[idx+1][jdx].toInt()
    var m = arr[idx+1][jdx+1].toInt()
    if((n == 0 && m == 0))return
    if(n!=0 && m != 0){
        pdfs(arr,idx+1,jdx,arr[idx+1][jdx],aculist)
        pdfs(arr,idx+1,jdx+1,arr[idx+1][jdx+1],aculist)
    }else{
        var f = ""
        if(n == 0) f="left"
        else f="right"
        var num = t-n-m
        if(f == "left"){
            arr[idx+1][jdx] = num.toString()
        }else{
            arr[idx+1][jdx+1] = num.toString()
        }
        aculist.add(num)
    }



}
