import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var num = reader.readLine().toInt()
    var st = Stack<Int>()
    var result = 0
    for(i in 0 until num){
        var input = reader.readLine().toInt()
        if(input == 0) {
            if(st.isNotEmpty()) st.pop()
        }else {
            st.push(input)
        }
    }
    for(i in st) result += i
    println(result)
}