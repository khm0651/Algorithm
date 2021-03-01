import java.lang.StringBuilder

fun main(){
    for(i in 1 .. 500000000) println(Number124().solution(i))
}

class Number124{
    var map = intArrayOf(4,1,2)

    fun solution(n : Int) : String{
        var sb = StringBuilder()
        change124Number(n,sb)
        return sb.toString()
    }

    private fun change124Number(n: Int, sb: StringBuilder) {
        var quotient = n/3
        var remainder = n%3
        if(quotient == 0 || n == 3){
            sb.append(map[remainder])
            return
        }
        if(remainder == 0) change124Number(quotient-1,sb)
        else change124Number(quotient, sb)
        sb.append(map[remainder])
        return
    }
}