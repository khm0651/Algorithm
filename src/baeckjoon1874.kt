import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*
import kotlin.math.max

fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var bw = System.out.bufferedWriter()
    var num = reader.readLine().toInt()
    var list = arrayListOf<Int>()
    var st = Stack<Int>()
    var result = StringBuilder()
    var start = 0
    for(i in 0 until num) {
        var n = reader.readLine().toInt()
        if(start <= n){
            for(j in start+1 .. n){
                st.push(j)
                result.append("+\n")

                if(j==n){
                    list.add(st.pop())
                    result.append("-\n")
                }
            }
            start = max(start,n)
        }else{
            if(n==st.peek()){
                list.add(st.pop())
                result.append("-\n")
            }else{
                bw.write("NO\n")
                bw.flush()
                return
            }
        }
    }

    bw.write(result.toString())
    bw.flush()
}