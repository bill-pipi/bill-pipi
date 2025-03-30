fun main(){
    var a=3
    var b=5
    println(a+b)
    var sum=10
    while (true){
        val a2=a+b+b
        val b2=a2+a+b
        a=a2
        b=b2
        println(a2+b2)
        if(a+b>4000000) break;
        sum+=(a2+b2)
    }
    println(sum);
}