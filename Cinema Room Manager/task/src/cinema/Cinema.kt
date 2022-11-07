package cinema

var ROWS = 0
var SEATS = 0
fun main() {
    sizeCinema()
    cinema()
    choseTicket()
    ticket()

    //    payback()
}

fun sizeCinema() {
    println("Enter the number of rows:")
    ROWS = readln().toInt()
    println("Enter the number of seats in each row:")
    SEATS = readln().toInt()
}

fun choseTicket() {
    println("Enter a row number:")
    ROWS = readln().toInt()
    println("Enter a seat number in that row:")
    SEATS = readln().toInt()
}

// Stage 2/5
fun payback() {
    val totalSeats = ROWS * SEATS

    val profit = when {
        // Calculate - price of each ticket is 10 dollars
        (totalSeats < 60) -> totalSeats * 10

        // Calculate - price front half of the rows and 8 dollars for the back half
        (totalSeats > 60) -> {
            val firstHalf = ROWS / 2 * SEATS
            val secondHalf = if (ROWS % 2 == 0) ROWS / 2 * SEATS else (ROWS / 2 + 1) * SEATS
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

fun ticket() {
    var price = 0

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
    println("Ticket price: $$price")
}