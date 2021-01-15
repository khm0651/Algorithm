import java.util.*

fun main(args : Array<String>){
    var m = "kkaxbycyz"
    var k = "abc"
    println(solution(m,k))
}

fun solution(m : String, k : String) : String{
    var kArray = k.toCharArray()
    var mArray = m.toCharArray()
    var st = Stack<Char>()
    for(i in kArray.size-1 downTo 0){
        st.push(kArray[i])
    }
    var replaceStr = ""
    for(i in mArray.indices){
        if(st.isNotEmpty()){
            if(st.peek() == m[i]){
                mArray[i] = ' '
                st.pop()
            }
        }else break
    }
    for(i in mArray){
        if(i != ' ') replaceStr += i.toString()
    }
    return replaceStr
}


