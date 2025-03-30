import java.math.BigInteger

fun main(){
    var product: BigInteger=BigInteger("1")
    for( i in 1..1000){
        product=product.times(BigInteger("2"))
    }
    println(product)
    var string=product.toString()
    var sum=0;
    for(i in 0..string.length-1){
        sum+=Integer.parseInt(string.substring(i,i+1))
    }
    println(sum)
    var product2=1
    for(i in 1..15){
        product2*=2
    }
    println(product2)
}