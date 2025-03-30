fun main(){
    var sumSquare=0
    var squareSum=0
    for(i in 1..100){
        squareSum+=Math.pow(i.toDouble(), 2.0).toInt()
        sumSquare+=i
    }
    println((sumSquare*sumSquare)-squareSum)

}