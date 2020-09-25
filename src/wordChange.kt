import java.util.*

fun main(args:Array<String>){
    var begin: String = "hit"
    var target: String = "cog"
    var words: Array<String> = arrayOf("hot", "dot", "dog", "lot", "log", "cog")
    var visit = Array(words.size,{false})

    findCount(begin,target,words,visit)
}

fun findCount(begin: String, target: String, words: Array<String>, visit: Array<Boolean>) {

    if (begin == target) {
        return
    }
    var matchCount = 0
    var barr = begin.toCharArray()
    var arr = ArrayList<Char>()
    var q: Queue<Char> = LinkedList<Char>()

    for (i in 0 until words.size) {
        if (visit[i]) continue
        for (c in words[i].toCharArray()) {
            q.offer(c)
        }
        var notContainIndex = 0
        while (q.size != 1) {
            var c = q.poll()
            var f = false
            var idx = 0
            for (b in 0 until barr.size) {
                if (barr[b] == c) {
                    f = true
                    break
                }
                if(!f) idx = b
            }
            if(!f){
                notContainIndex = idx
                q.offer(c)
            }
        }


        barr[notContainIndex] = q.poll()
        var str = barr.toString()

        if (str == words[i]) {
            visit[i] = true
            System.out.println(str)
            findCount(str, target, words, visit)
        }
    }


}


