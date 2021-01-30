import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    var reader = BufferedReader(InputStreamReader(System.`in`))
    var num = reader.readLine().toInt()
    var map = Array(num){IntArray(num)}
    var zeroNone = IntArray(2)
    for(i in 0 until num) map[i]=reader.readLine().split(" ").map(String::toInt).toIntArray()
    findCountWhiteBlue(0,0,num,map,zeroNone)
    println(zeroNone[0])
    println(zeroNone[1])
}

fun findCountWhiteBlue(idx: Int, jdx: Int, num: Int, map: Array<IntArray>, zeroNone: IntArray) {

    var color = map[idx][jdx]
    var flag = false
    for(i in idx until idx+num){
        if(flag) break
        for(j in jdx until jdx+num){
            if(color != map[i][j]){
                flag=true
                break
            }
        }
    }
    if(flag){
        findCountWhiteBlue(idx,jdx,num/2, map, zeroNone)
        findCountWhiteBlue(idx,jdx+num/2,num/2, map, zeroNone)
        findCountWhiteBlue(idx+num/2,jdx,num/2 ,map, zeroNone)
        findCountWhiteBlue(idx+num/2,jdx+num/2,num/2,map, zeroNone)
    }else{
        zeroNone[color]++
        return
    }

}
