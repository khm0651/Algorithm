import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var bw = System.out.bufferedWriter()
    var n = readLine().toInt()
    var tree = ArrayList<Node1991>()
    repeat(n){
        var (v,l,r) = readLine().split(" ")
        tree.add(Node1991(v,l,r))
    }
    var start = tree.find { it.v == "A" }
    preorder1991(tree,start,bw)
    bw.write("\n")
    inorder1991(tree,start,bw)
    bw.write("\n")
    postorder1991(tree,start,bw)
    bw.flush()
}

fun postorder1991(tree: ArrayList<Node1991>, start: Node1991?, bw: BufferedWriter) {
    if(start == null) return
    postorder1991(tree, tree.find { it.v == start!!.left }, bw)
    postorder1991(tree, tree.find { it.v == start!!.right }, bw)
    bw.write(start!!.v)
}

fun inorder1991(tree: ArrayList<Node1991>, start: Node1991?, bw: BufferedWriter) {
    if(start == null) return
    inorder1991(tree, tree.find { it.v == start!!.left }, bw)
    bw.write(start!!.v)
    inorder1991(tree, tree.find { it.v == start!!.right }, bw)
}

fun preorder1991(tree: ArrayList<Node1991>, start: Node1991?, bw: BufferedWriter) {
    if(start == null) return
    bw.write(start!!.v)
    preorder1991(tree, tree.find { it.v == start!!.left }, bw)
    preorder1991(tree, tree.find { it.v == start!!.right }, bw)
}

data class Node1991 (var v : String, var left : String, var right : String)