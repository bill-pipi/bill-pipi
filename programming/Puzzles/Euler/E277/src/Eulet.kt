fun main(){
    foo()
}




fun foo() {
    val e = 15.0
    val string = "UDDDUdddDDUDDddDdDddDDUDDdUUDd"
    val max = Math.pow(10.0, e)
    var x = 0L
    loop@
    while(true){
        x++
        val y = read(x, string)
        if(y==0L) continue@loop
        println("$y   $x")
        if(y>max){
            println("$y   $x")
            break@loop
        }
    }
}

    fun D(x : Long) = x * 3

    fun U(x : Long) : Long {
        val y = (x * 3) - 2
        if(y%4L == 0L) return y/4L
        return 0L
    }

    fun d(x : Long) : Long{
        val y = (x * 3) + 1
        if(y%2L == 0L) return y/2L
        return 0L
    }

    fun step(x : Long, s : String) =
        when (s){
            "D" -> D(x)
            "U" -> U(x)
            "d" -> d(x)
            else -> 0
        }

    fun read(x : Long, string : String) : Long{
        var y : Long = x
        for(s in string.reversed().toCharArray()){
            if(y==0L) return 0L
            y = step(y, s.toString())
        }
        return y
    }