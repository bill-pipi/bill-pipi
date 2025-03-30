fun main(){
    println(f(13195))
}
fun f(n : Int) : Int{
    var i=2
    while(n%i!=0){
        i++
    }
    return f(n/i)
}