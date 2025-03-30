fun main(){
    val num=999
    val three : Int=countDownSum(num/3)*3
    val five : Int=countDownSum(num/5)*5
    val fifteen : Int=countDownSum(num/15)*15
    println(three+five-fifteen)

}
fun countDownSum(num : Int) : Int{
    var count : Int=0
    for(i in 1..num){
        count+=i;
    }
    return count
}