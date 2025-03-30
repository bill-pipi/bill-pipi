fun main(){
    var i=0L
    while(true){
        i++
        val tri=i*(i+1)/2
        if(isPrime(tri.toInt())) continue
        if(countDivisors(tri.toInt())>500){
            println(tri)
            break
        }
    }
    //println(countDivisors(28))
}fun countDivisors(num :Int) : Int{
    var count: Int=1
    for(i in 1..num/2){
        if(num%i==0){
            count++
                //println(i)
        }
    }
    return count
}
fun isPrime(n: Int): Boolean {
    // Corner cases
    if (n <= 1) return false
    if (n <= 3) return true

    // This is checked so that we can skip
    // middle five numbers in below loop
    if (n % 2 == 0 || n % 3 == 0) return false

    var i = 5
    while (i * i <= n) {
        if (n % i == 0 || n % (i + 2) == 0)
            return false
        i = i + 6
    }

    return true
}
