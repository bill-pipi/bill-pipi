import java.io.*
import java.util.SortedMap


val cardinal : Array<Pair<Int, Int>> = arrayOf(
    Pair(0,1),
    Pair(0, -1),
    Pair(1, 0),
    Pair(-1, 0)
)

class Node(val cdt : Pair<Int, Int>, val wt : Int)

fun Node.

fun toIntArray(list : List<String>) : IntArray {

    return list.map { it.toInt() }.toIntArray()

}

fun Pair<Int, Int>.concatenate(other : Pair<Int, Int>) : Pair<Int, Int>{
    return Pair(this.first + other.first, this.second + other.second)
}


fun read(name : String) : Array<IntArray> {

    val lines = File(name).bufferedReader().readLines()
    var matrix  = ArrayList<IntArray>()

    for(l in lines){
        matrix.add(toIntArray(l.split(",")))
    }
    return matrix.toTypedArray()

}


fun findLeafs(shoot : Pair<Int, Int>, w : Int, l : Int) : List<Pair<Int, Int>>{

    var leafs  = arrayListOf<Pair<Int, Int>>()

    for(dir in cardinal){
        val leaf : Pair<Int, Int> = shoot.concatenate(dir)
        if(leaf.first in (0..w - 1)){
            if(leaf.second in (0 .. l - 1)){
                leafs.add(leaf)
            }
        }
    }
    return leafs
}



/**
fun dijkstra(leafs : SortedMap<Int, Pair<Int, Int>>, tree : Array<Array<Int>>, weights : Array<Array<Int>>){

    if(leafs.size > 0) {
        val weight = leafs.firstKey()
        val shoot: Pair<Int, Int>? = leafs.remove(weight)
        val next = leaf(shoot, dimensions)
        for (leaf in next) {
            if (tree.get(leaf.first).get(leaf.second) == inf) {
                leafs[weight + weights.get(leaf.first).get(leaf.second)] = leaf
            }
        }

        if(tree[shoot!!.first][shoot.second!!] > weight) {
            tree[shoot!!.first][shoot.second!!] = weight
        }
        dijkstra(leafs, tree, weights)
    }
}

**/
val inf = 1000000

fun emptyMatrix(w : Int, l : Int) : Array<Array<Int>> {

    var matrix = arrayListOf<Array<Int>>()
    for(y in 0..l - 1){
        var row = arrayListOf<Int>()
        for(x in 0 .. l-1) {
            row.add(inf)
        }
        matrix.add(row.toTypedArray())
    }
    return matrix.toTypedArray()

}

val weights = read("src/main/kotlin/matrix.txt")
val w = weights[0].size; val l = weights.size

fun dijkstra(leafs : List<Node>, tree : Array<Array<Int>>, shoot : Node){

    val wt = leafs.firstKey(); val cdt = leafs.remove(wt)


}

fun main(){


    dijkstra(sortedMapOf(), emptyMatrix(w, l))

}