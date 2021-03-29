import kotlin.math.sqrt

/**
 * EXO 1
 * Ecrire une fonction qui affiche les x premiers
 * nombres pairs ou impairs
 */
fun firstNumbers(x: Int, even: Boolean = true) {
    var n = 0
    if (!even) {
        n = 1
    }
    for (i in n..(x * 2 - 1) step 2) {
        println(i)
    }
}

firstNumbers(20, true)
firstNumbers(10, false)

/**
 * EXO 2
 * Ecrire une fonction qui affiche les x premiers
 * nombres de la suite Fibonacci
 */
fun fibonacci(x: Int) {
    var prev = 0
    var current = 1
    for (i in 1..x) {
        val result = prev + current
        println(result)
        prev = current
        current = result
    }
}

fibonacci(10)


/**
 * EXO 3
 * Ecrire une fonction qui calcule le factoriel d’un nombre x,
 * utiliser 10 par défaut si aucun nombre n’est spécifié.
 */

fun factoriel(x: Int = 10): Int {
    var result: Int = 1;
    for (i in 2..x) {
        result *= i
    }
    return result
}

factoriel(18)


/**
 * EXO 4
 * Ecrire une fonction qui affiche les x premiers nombres premiers
 */

fun isPrime(n: Int): Boolean {
    // Nombres de fois où le nombre est divisible
    var times = 0
    for (i in 1..n) {
        if (n % i == 0) {
            times++
        }
    }
    return times <= 2
}

fun prime(x: Int): MutableList<Int> {
    val primes = mutableListOf<Int>()
    var n: Int = 2
    while (primes.size < x) {
        if (isPrime(n)) {
            primes.add(n)
        }
        n++
    }
    return primes
}

prime(100).forEach {
    println(it)
}
