import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var input = ""
    while(true){
        input = reader.readLine()
        if(input == ".") break
        var st = Stack<Char>()
        var list = input.toCharArray()
        for(i in list){
            if(i == '(' || i ==')' || i=='[' || i==']') {
                if(st.isNotEmpty()){
                    if(st.peek() == '(' && i==')' || st.peek() == '[' && i==']') st.pop()
                    else st.push(i)
                }else{
                    st.push(i)
                }
            }
        }
        if(st.isEmpty()) println("yes")
        else println("no")
    }
}