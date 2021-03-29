println("Hello world")
3 * 3
2.times(3)
2.plus(3)
3.0/2

var impostorsNum: Int = 2
when(impostorsNum) {
    0 -> println("No impostors")
    in 1..3 -> println("Some impostors")
    else -> println("A LOT of impostors, impossible to win")
}

val pets = arrayOf("Dog", "Cat")
for ((index, pet) in pets.withIndex()) {
    println("L'animal $index est un $pet")
}

//for (i in 0..pets.size) {
//    println("L'animal $i est un ${pets[i]}")
//}

val planets = mutableListOf("Mercure", "Vénus", "Terre", "Mars", "Jupiter", "Sature", "Uranus", "Neptune")
val planets2 =listOf("Mercure", "Vénus", "Terre", "Mars", "Jupiter", "Sature", "Uranus", "Neptune")

println(planets + planets2)

var numberOfBooks: Int? = 12
numberOfBooks = null

fun sayHelloTo(name: String) {
    println("Hello $name !")
}

sayHelloTo(name = "Léo")


fun helloWorld(): String {
    return "Hello, world !"
}

helloWorld()
