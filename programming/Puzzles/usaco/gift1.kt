import kotlin.*
import java.io.File
data class Block(
    val money : Int,
    val given : ArrayList<String>,
    val giver : String 
)


  
fun bank(name : String){
    var input : ArrayList<String> = ArrayList(File(name).readLines())
    val length = input[0].toInt()

    val people : ArrayList<String> = ArrayList(input.subList(1, length+1))
    var blocks = ArrayList<Block>()
    interpret(blocks, ArrayList(input.subList(length+1, input.size)))

    var bank = mutableMapOf<String, Int>()
    for(p in people) bank[p] = 0

    for(block in blocks){
        val given = block.given
        val money = block.money
        if(money != 0) { 

            val n = money / given.size
            val left = (money%n) - money

            for(g in given) {
                bank[g] = bank.get(g)!!.plus(n) 
            }
            bank[block.giver] = bank.get(block.giver)!!.plus(left)
        }


    }

    print(bank)
}


fun interpret(blocks : ArrayList<Block>, input : ArrayList<String>)  {
    if(input.size > 2) {
        val giver : String = input[0]
        val (money, n) = (input[1].split(" "))
        input.removeAt(0) ; input.removeAt(0)

        var given : ArrayList<String> = ArrayList<String>()
        for(i in 0..(n.toInt())-1) {
            given.add(input[0])
            input.removeAt(0)
        }
        val b : Block = Block(money.toInt(), given, giver)
        blocks.add(b)

        interpret(blocks, input)
    }
} 



fun main(){
    bank("input.txt")
    
}

