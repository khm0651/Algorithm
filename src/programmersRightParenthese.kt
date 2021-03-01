import java.util.*

fun main(){
    RightParenThese().solution("()()")
}

class RightParenThese{
    fun solution(s : String) : Boolean{
        var answer = true
        var st = Stack<Char>()
        for(i in s){
            if(st.isEmpty()) st.push(i)
            else{
                if(i == ')' && st.peek() == '(') st.pop()
                else st.push(i)
            }
        }
        answer = st.isEmpty()
        return answer
    }
}