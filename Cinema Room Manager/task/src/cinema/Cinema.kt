package cinema

fun main() {
    payback()
//    cinema()
}

// Stage 2/5
fun payback() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()

    val totalSeats = rows * seats

    val profit = when {
        // Calculate - price of each ticket is 10 dollars
        (totalSeats < 60) -> totalSeats * 10

        // Calculate - price front half of the rows and 8 dollars for the back half
        (totalSeats > 60) -> {
            val firstHalf = rows / 2 * seats
            val secondHalf = if (rows % 2 == 0) rows / 2 * seats else (rows / 2 + 1) * seats
            firstHalf * 10 + secondHalf * 8
        }

        // Check any errors
        else -> throw Exception("Error")
    }

    println("Total income: \n$$profit")
}


// Stage 1/5
fun cinema() {
    val numbers = "1 2 3 4 5 6 7 8 "
    val chars = "S S S S S S S S "

    println("Cinema:")

    for (a in 0..7) {
        println(
            if (a == 0) {
                "  $numbers"
            } else {
                "$a $chars"
            }
        )
    }
}