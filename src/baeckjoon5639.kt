import java.io.BufferedReader
import java.io.InputStreamReader

fun main () = with(BufferedReader(InputStreamReader(System.`in`))){
    var tree = BinaryTree5639(null,null,null)
    while(true){
        try {
            tree.add(readLine().toInt())
        }catch (e: Exception){
            break
        }
    }
    tree.printPost()
}

class BinaryTree5639 ( var v : Int? , var left : BinaryTree5639?, var right : BinaryTree5639?){
    fun add(data : Int){
        if(v == null) v = data
        else{
            if(data < v!!){
                if(left == null) left = BinaryTree5639(data,null,null)
                else left!!.add(data)
            }else{
                if(right == null) right = BinaryTree5639(data,null,null)
                else right!!.add(data)
            }
        }
    }
    fun printPost(){
        left?.printPost()
        right?.printPost()
        println(v)
    }
}
