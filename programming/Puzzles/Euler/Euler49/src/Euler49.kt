fun main(){
    var permutations : MutableList<String> = mutableListOf()
    permutations("abc", "", permutations)
    println(permutations)
}
fun permutations(prefix: String, suffix: String, permutations: MutableList<String>){
    if(prefix.length==0){
        permutations.add(suffix)
        return
    }
    for(i in 1..prefix.length){
        val newPrefix: String = prefix.substring(0, i-1)+prefix.substring(i, prefix.length)
        val newSuffix: String = suffix+prefix.substring(i-1, i)
        permutations(newPrefix, newSuffix, permutations)
    }
}