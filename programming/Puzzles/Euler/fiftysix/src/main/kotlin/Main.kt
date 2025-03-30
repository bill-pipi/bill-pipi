fun main(args: Array<String>) {
    var count = 1
    for(i in 1..9){
        count+=digitcount(i)
    }
    print(count)

fun digitcount(n: Int) : Int{
    var i = 1.0;
    while(Math.pow(n/10.0, i) > 0.1){
        i++
    }
    return i.toInt()-1
}