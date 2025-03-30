fun main(){
    loop@for(a in 1..1000){
        for(b in 1..1000){
            val c: Double=Math.sqrt(Math.pow(a.toDouble(), 2.0)+Math.pow(b.toDouble(), 2.0))
            if(c%1.0==0.0){
               if((a+b+c).toInt()%1000==0){
                   println("$a,$b,$c")
                   break@loop
               }
            }
        }
    }
    println((200*200)+(375*375))
    println(425*425)
    println(425*375*200)
}