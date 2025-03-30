fun main(){
    loop@
    for(x in 999 downTo 0){
        for(y in 999 downTo 0){
            if((x*y).toString().equals((x*y).toString().reversed())){
                println(x*y)

            }
        }
    }
}