import java.io.BufferedReader
import java.io.InputStreamReader

var memo = Array(21){Array(21){IntArray(21) } }

fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    while(true){
        var input = reader.readLine().split(" ").map(String::toInt)
        var a = input[0]
        var b = input[1]
        var c = input[2]

        if( a == -1 && b == -1 && c == -1) break

        var buffer = StringBuffer()
        buffer.append("w(${a}, ${b}, ${c}) = ")
        if(a>20) a=20
        if(b>20) b=20
        if(c>20) c=20
        if(a<0) a=0
        if(b<0) b=0
        if(c<0) c=0
        var result = w(a,b,c)
        buffer.append(result)
        println(buffer)

    }
}

fun w(a: Int, b: Int, c: Int): Int {

    if(memo[a][b][c] == 0){
        if(a<=0 || b<= 0 || c<=0) return 1
        else if(a>20 || b>20 || c>20) w(20,20,20)
        else if(a<b && b<c){
            memo[a][b][c]=  w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
        }
        else{
            memo[a][b][c]= w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)
        }
    }
    return memo[a][b][c]
}
