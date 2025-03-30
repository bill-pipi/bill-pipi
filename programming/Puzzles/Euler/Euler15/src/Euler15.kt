import java.math.BigInteger

fun main(){
    val length=40
    println(factorial(length, length.toBigInteger())/(2.toBigInteger().times(factorial(length/2, (length/2).toBigInteger()))))

    //rrdd
    //factorial/(2*factorial(4/2))

}
fun factorial(num : Int, factorial: BigInteger): BigInteger{
    if(num==1) return factorial
    return factorial(num-1, factorial.times((num-1).toBigInteger()))
}
