fun main(){
    var n=0
    var c=0;
    while(true){
        n++
        if(isPrime(n)){
            c++;
            if(c==10001){
                println(n)
                break;
            }
        }
    }
}
fun isPrime(n: Int): Boolean{
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
