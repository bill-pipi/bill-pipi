fun main(){
    var largest=0
    var largestStart=0;
    for(i in 1..1000000){
        val list : MutableList<Long> = mutableListOf()
        findCollatz(i.toLong(), list)
        val collatz=list.size+1
        if(collatz>largest){
            largest=collatz
            largestStart=i
        }
    }
    println(largestStart)
    val list : MutableList<Long> = mutableListOf()
    findCollatz(13L, list)
    println(list)
}
fun findCollatz(start : Long, mutableList: MutableList<Long>) {
    if (start == 1L) return
    if(start%2L==0L) mutableList.add(start/2L)
    else{ mutableList.add((3*start)+1)}
    findCollatz(mutableList.last(), mutableList)
}

