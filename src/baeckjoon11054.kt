import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var num = reader.readLine().toInt()
    var rdp = IntArray(num+1)
    var ldp = IntArray(num+1)
    var list = IntArray(num+1)
    reader.readLine().split(" ").map(String::toInt).forEachIndexed { index, i ->
        list[index+1] = i
    }
    rdp[num] = 1
    ldp[1] = 1
    var result = 0

    for(i in 2 .. num){
        for (j in 1 until i){
            if(list[i]>list[j]) ldp[i] = max(ldp[i],ldp[j])
        }
        ldp[i]+=1
    }

    for(i in num-1 downTo 1){
        for(j in num downTo i+1){
            if(list[i]>list[j]) rdp[i] = max(rdp[i],rdp[j])
        }
        rdp[i]+=1
    }

    for(i in 1 .. num){
        result = max(result,rdp[i]+ldp[i]-1)
    }
    println(result)

}