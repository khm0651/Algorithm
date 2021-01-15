import java.util.*
var an = 0
var c = 0
var found = false
fun main(args:Array<String>){
    var begin: String = "hit"
    var target: String = "cog"
    var words: Array<String> = arrayOf("hot", "dot", "dog", "lot", "log")
    var visit = Array(words.size,{false})

    findCount(begin,target,words,visit,0)
    println(an)
    println(c)
}

fun findCount(begin: String, target: String, words: Array<String>, visit: Array<Boolean>,total : Int) {

    if(!words.contains(target)){
        an = 0
        return
    }
    for(i in 0 until words.size){
        if(found)return
        if(!visit[i]){
            visit[i]=true
            if(begin.length == words[i].length){
                var bf = Array(begin.length,{false})
                var wf = Array(begin.length,{false})
                var tf =Array(begin.length,{false})
                var bArr = begin.toCharArray()
                var wArr = words[i].toCharArray()
                var tArr = target.toCharArray()
                var f = false
                var finshf = false
                var count =0
                c++

                for(b in 0 until bArr.size){
                    for(w in 0 until tArr.size){
                        if(bArr[b] == tArr[w] ) {
                            bf[b] = true
                            tf[w] = true
                            count++
                            if(count == begin.length-1) {
                                finshf = true
                            }
                            break
                        }
                    }
                }
                count=0
                if(finshf){
                    found = true
                    an = total + 1
                    return
                }else{
                    for(b in 0 until bArr.size){
                        if(count == begin.length-1) {
                            f = true
                            break
                        }
                        for(w in 0 until wArr.size){
                            if(bArr[b] == wArr[w] ) {
                                bf[b] = true
                                wf[w] = true
                                count++
                                if(count == begin.length-1) {
                                    f = true
                                }
                                break
                            }
                        }
                    }

                    if(f){
                        for(b in 0 until bf.size){
                            if(bf[b]) continue
                            for(w in 0 until wf.size){
                                if(wf[w]) continue
                                bArr[b] = wArr[w]
                            }
                        }
                        var str = ""
                        for(c in bArr) str += c
                        findCount(str, target, words, visit,total+1)
                    }else{
                        findCount(begin, target, words, visit,total)
                    }

                }
                visit[i]=false

            }
        }
    }
}


