import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.properties.Delegates

fun main()= with(BufferedReader(InputStreamReader(System.`in`))){
    Solve1717().solve()
}

class Solve1717{
    lateinit var parent:IntArray
    var operation by Delegates.notNull<Int>()
    var a by Delegates.notNull<Int>()
    var b by Delegates.notNull<Int>()
    var bw = System.out.bufferedWriter()
    fun solve() = with(BufferedReader(InputStreamReader(System.`in`))){
        var st = StringTokenizer(readLine())
        var n = st.nextToken().toInt()
        var m = st.nextToken().toInt()
        parent = IntArray(n+1)
        for(i in 0 .. n) parent[i] = i
        for(i in 0 until m){
            st = StringTokenizer(readLine())
            operation = st.nextToken().toInt()
            a = st.nextToken().toInt()
            b = st.nextToken().toInt()

            when(operation){
                0 -> union(a,b)
                1 -> isSameParent(a,b)
            }
        }
    }

    private fun isSameParent(a: Int, b: Int) {
        if(find(a) == find(b)) bw.write("YES\n")
        else bw.write("NO\n")
        bw.flush()
    }

    private fun union(a: Int, b: Int) {
        var a = find(a)
        var b = find(b)
        if(a != b){
        parent[b] = a
        }
    }

    private fun find(x:Int) : Int{
        return if(parent[x] == x) x
        else{
            parent[x] = find(parent[x])
            parent[x]
        }
    }
}