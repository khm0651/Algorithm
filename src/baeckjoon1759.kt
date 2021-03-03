import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var (L,C) = readLine().split(" ").map{it.toInt()}
    var list = readLine().split(" ")
    list = list.sorted()
    var answerList = ArrayList<String>()

    for(i in 0 until (1 shl C) ){
        var str = ""
        if(Integer.bitCount(i) == L){
            for(j in 0 until C){
                if( i and (1 shl j) > 0 ){
                    str+=list[j]
                }
            }
            if(isValidStr(str)){
                answerList.add(str)
            }
        }
    }
    answerList.sort()
    for(i in answerList){
        bw.write("${i}\n")
    }
    bw.flush()
}

fun isValidStr(str: String): Boolean {
    var vowel = 0
    var consonant = 0
    for(i in 0 until str.length){
        if(str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u'){
            vowel++
        }else{
            consonant++
        }
        if( vowel >=1 && consonant >= 2) return true
    }
    return false
}
