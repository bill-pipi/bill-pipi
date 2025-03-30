import java.lang.Exception
import java.math.BigInteger

/**00
0|0

000
0|00
0|0|0

0000
0|000
0|0|00
0|0|0|0
00|00

00000
0|0000
0|0|000
0|0|0|00
0|0|0|0|0
0|00|00
00|000

000000
0|00000
0|0|0000
0|0|0|000
0|0|0|0|00
0|0|0|0|0|0
0|0|00|00
0|00|000
00|0000
00|00|00
000|000

0000000
0|000000
0|0|00000
0|0|0|0000
0|0|0|0|000
0|0|0|0|0|00
0|0|0|0|0|0|0
0|0|0|00|00
0|0|00|000
0|00|0000
0|00|00|00
0|000|000
00|00000
00|00|000
000|0000

00000000
0|0000000
0|0|000000
0|0|0|00000
0|0|0|0|0000
0|0|0|0|0|000
0|0|0|0|0|0|00
0|0|0|0|0|0|0|0
0|0|0|0|00|00
0|0|0|00|000
0|0|00|0000
0|0|00|00|00
0|0|000|000
0|00|00000
0|00|00|000
0|000|0000
00|000000
00|00|0000
00|00|00|00
00|000|000
000|00000
0000|0000

000000000
0|00000000
0|0|0000000
0|0|0|000000
0|0|0|0|00000
0|0|0|0|0|0000
0|0|0|0|0|0|000
0|0|0|0|0|0|0|00
0|0|0|0|0|0|0|0|0
0|0|0|0|0|00|00
0|0|00||00|000
0|0|0|00|0000
0|0|0|00|00|00
0|0|0|000|000
0|0|00|00000
0|0|00|00|000
0|0|000|0000
0|00|000000
0|00|00|0000
0|00|00|00|00
0|00|000|000
0|000|00000
0|0000|0000
00|0000000
00|00|00000
00|00|00|000
00|000|0000
000|000000
000|000|000
0000|00000
**/

fun sumList(list: MutableList<BigInteger>, from: Int): BigInteger{
    try{
        var sum = BigInteger.ONE
        for(x in list.subList(from, list.size)){
            sum = sum.add(x)
        }
        return sum
    }
    catch (e : Exception){
        return BigInteger.ONE
    }
}


fun main() {

    var archive = HashMap<Int, MutableList<BigInteger>>()
    archive[1] = mutableListOf(BigInteger.ONE)
    archive[2] = mutableListOf(BigInteger.ONE)
    archive[3] = mutableListOf(BigInteger.ONE, BigInteger.TWO)

    for(x in 4..60000){

        if(x%1000 == 0 ) println(x)

        var elements : MutableList<BigInteger> = mutableListOf(BigInteger.ONE)
        for(i in 1..x/2){
            elements.add(sumList(archive[x-i]!!, i))
        }
        archive[x] = elements
        if(archive[x]!!.get(1).mod(BigInteger.valueOf(100000L)).equals(BigInteger.ZERO))
            println("x  ${x-1}   n  ${archive[x]!!.get(1)} ")
    }



}