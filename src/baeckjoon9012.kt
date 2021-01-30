import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var num = reader.readLine().toInt()
    for(i in 0 until num){
        var st = Stack<Char>()
        var list = reader.readLine().toCharArray()
        for(i in list.indices){
            if(st.isEmpty()){
                st.push(list[i])
            }else{
                if(st[st.size-1] == '(' && list[i] == ')') st.pop()
                else st.push(list[i])
            }

        }
        if(st.isEmpty()) println("YES")
        else println("NO")
    }
}