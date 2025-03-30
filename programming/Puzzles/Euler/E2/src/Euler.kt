fun main(){
    println(fib(0, 1, 4000000, 0))
}
fun fib(a : Int, b: Int, n : Int, s : Long) : Long{
    println(a+(2*b))
    if(a+(2*b)>n) return s
    return fib(a+(2*b), (a*2)+(3*b), n, s+a+(2*b))
}
//0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89,
//     a, b a+b, a+2b   a=a+b b=a+2b