package cinema

var ROWS = 0
var SEATS = 0
var ROW_NUMBER = 0
var SEAT_NUMBER = 0

fun main() {
    sizeCinema()
    choseTicket()
//    payback()
}

fun sizeCinema() {
    println("Enter the number of rows:")
    ROWS = readln().toInt()
    println("Enter the number of seats in each row:")
    SEATS = readln().toInt()
    println(" ")
    printCinema()
}

fun choseTicket() {
    println("\nEnter a row number:")
    ROW_NUMBER = readln().toInt()
    println("Enter a seat number in that row:")
    SEAT_NUMBER = readln().toInt()
    printTicket()
}

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

    println("\nTotal income: $$profit\n")
}


fun printCinema() {
    val numbers = "1 2 3 4 5 6 7 8 "
    val chars = "S S S S S S S S "

    println("Cinema:")

    for (a in 0..ROWS) {
        println(
            if (a == 0) {
                "  $numbers"
            } else {
                "$a $chars"
            }
        )
    }
}

fun printTicket() {
    val seats = mutableListOf<String>()

    println("Cinema:\n")

    for (a in 0..ROWS) {
        if (a == 0) {
            for (i in 0..SEATS) {
                if (i == 0) seats.add(" ") else seats.add(i.toString())
            }
            println(seats.joinToString(" "))
            seats.clear()
        } else {
            seats.add("$a")
            for (i in 1..SEATS) {
                seats.add("S")
            }
            if (a == ROW_NUMBER) seats[SEAT_NUMBER] = "B"
            println(seats.joinToString(" "))
            seats.clear()
        }
    }
    println("\nTicket price: $${priceTicket()}")
}

fun priceTicket() : Int {
    val totalSeats = ROWS * SEATS
    val firstHalf = 1..ROWS / 2

    return when {
        // Calculate - price of each ticket is 10 dollars
        (totalSeats < 60) -> 10

        // Calculate - price 10 to front half of the rows and 8 dollars for the back half
        (totalSeats > 60) -> if (ROW_NUMBER in firstHalf) 10 else 8

        // Check any errors
        else -> throw Exception("Error")
    }
}