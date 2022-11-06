package cinema

fun main() {
    val numbers = "1 2 3 4 5 6 7 8 "
    val chars = "S S S S S S S S "

    println("Cinema:")

    for (a in 0..7 ) {
        println(
            if (a == 0) {
                "  $numbers"
            } else {
                "$a $chars"
            }
        )
    }
}