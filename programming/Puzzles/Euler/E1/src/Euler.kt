fun main(){
    val m = 1000-1
    val a = 3
    val b = 5
    val c = a * b
    val avA = av(a, m)
    val avB = av(b, m)
    val avC = av(c, m)
    println(avA+avB-avC)
}
fun av(n : Int, m : Int) = ((n+(m/n)*n)/2.0)*(m/n)