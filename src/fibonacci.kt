import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var n = reader.readLine().toInt()
    var arr = arrayListOf<Int>()
    for( i in 0 until n){
        arr.add(reader.readLine().toInt())
    }
    printZeroOne(arr)
}

fun printZeroOne(list: ArrayList<Int>) {

    var zeroFibo = Fibo(1, 0)
    var oneFibo = Fibo(0,1)

    for(num in list){
        var arr = arrayListOf<Fibo>()
        arr.add(zeroFibo)
        arr.add(oneFibo)
        when(num){
            0 -> println("${zeroFibo.zero} ${zeroFibo.one}")
            1 -> println("${oneFibo.zero} ${oneFibo.one}")
            else -> {
                for(i in 2 .. num){
                    arr.add(Fibo(arr[i-2].zero + arr[i-1].zero,arr[i-2].one + arr[i-1].one))
                }
                var last = arr.last()
                println("${last.zero} ${last.one}")
            }
        }
    }

}

data class Fibo(var zero : Int, var one : Int)