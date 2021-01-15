import java.io.BufferedReader
import java.io.InputStreamReader



fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var num = reader.readLine().toInt()
    for( i in 0 until num){
        var input = reader.readLine().toInt()
        when(input){
            1,2,3 -> println("1")
            4,5 -> println("2")
            else -> {
                var fadobanDp = LongArray(input+1)
                fadobanDp[1]=1
                fadobanDp[2]=1
                fadobanDp[3]=1
                fadobanDp[4]=2
                fadobanDp[5]=2
                println(printFadoban(input,fadobanDp))
            }
        }

    }

}

fun printFadoban(input: Int, fadobanDp: LongArray) : Long {
    for(i in 6 .. input){
        fadobanDp[i] = fadobanDp[i-1] + fadobanDp[i-5]
    }
    return fadobanDp[input]
}
