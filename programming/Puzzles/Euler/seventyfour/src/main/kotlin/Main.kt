
fun factorial(n : Int) : Int {
    if(n == 1 || n==0) return 1
    return n * factorial(n-1)
}



fun Int.digitfact() : Int{
    return this.toString().map { it.toString() }.map{factorial(it.toInt())}.sum()
}

fun loopfact(root: Int) : Int{

    val path : HashMap<Int, Int> = hashMapOf(root to 0)
    var n = root.digitfact() ; var c = 0

    while(!path.contains(n)){
        c++
        path[n] = c; n = n.digitfact()
    }
    return c+1

}


fun main(args: Array<String>) {
    var c: Int = 0
    for(i in 1..1000000){
        val nrlength = loopfact(i)
        if(nrlength >= 60) {
            c++
            println("Root is $i and length of unrepeat is $nrlength")
        }
    }
    print(c)
}



