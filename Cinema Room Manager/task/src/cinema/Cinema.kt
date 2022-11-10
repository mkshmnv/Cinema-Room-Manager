package cinema

var MENU_CHOICE = 0
var ROWS = 0
var SEATS = 0
var ROW_NUMBER = 0
var SEAT_NUMBER = 0
var ALL_TICKETS = mutableListOf(listOf<Int>())
var SUM_PURCHASED_TICKETS = 0

fun main() {
    startCinema()
    menu()
}

fun startCinema() {
    println("Enter the number of rows:")
    ROWS = readln().toInt()
    println("Enter the number of seats in each row:")
    SEATS = readln().toInt()
}

fun menu() {
    println("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit")
    MENU_CHOICE = readln().toInt()
    when (MENU_CHOICE) {
        1 -> printCinema()
        // Buy a ticket and save value
        2 -> {
            choseTicket()
            menu()
        }
        3 -> {
            statistics()
            menu()
        }
        // Exit from program and clear all
        0 -> {
            MENU_CHOICE = 0
            ROWS = 0
            SEATS = 0
            ROW_NUMBER = 0
            SEAT_NUMBER = 0
            ALL_TICKETS.clear()
            SUM_PURCHASED_TICKETS = 0
        }
    }
}

fun choseTicket() {
    println("\nEnter a row number:")
    ROW_NUMBER = readln().toInt()
    println("Enter a seat number in that row:")
    SEAT_NUMBER = readln().toInt()

    when {
        ROW_NUMBER > ROWS || SEAT_NUMBER > SEATS -> {
            println("\nWrong input!")
            choseTicket()
        }
        ALL_TICKETS.contains(listOf(ROW_NUMBER, SEAT_NUMBER)) -> {
            println("\nThat ticket has already been purchased!")
            choseTicket()
        }
        else -> {
            ALL_TICKETS.add(listOf(ROW_NUMBER, SEAT_NUMBER))
            priceTicket()
        }
    }
}

fun printCinema() {
    val seats = mutableListOf<String>()

    println("\nCinema:")

    for (a in 0..ROWS) {
        if (a == 0) {
            for (i in 0..SEATS) {
                if (i == 0) seats.add(" ") else seats.add(i.toString())
            }
            println(seats.joinToString(" "))
            seats.clear()
        } else {
            seats.add("$a")
            for (b in 1..SEATS) {
                if (ALL_TICKETS.contains(listOf(a, b))) {
                    seats.add("B")
                } else {
                    seats.add("S")
                }
            }
            println(seats.joinToString(" "))
            seats.clear()
        }
    }
    menu()
}

fun priceTicket() : Int {
    val totalSeats = ROWS * SEATS
    val firstHalf = 1..ROWS / 2
    var price = 0

    price = when {
            // Calculate - price of each ticket is 10 dollars
            (totalSeats in 1..60) -> 10

            // Calculate - price 10 to front half of the rows and 8 dollars for the back half
            (totalSeats > 60) -> if (ROW_NUMBER in firstHalf) 10 else 8

            // Check any errors
            else -> throw Exception("Error")
        }
    SUM_PURCHASED_TICKETS += price
    println("\nTicket price: $$price")
    return price
}

fun statistics() {
    println("\nNumber of purchased tickets: ${ALL_TICKETS.size - 1}")
    println("Percentage: ${"%.2f".format(percentage())}%")
    println("Current income: $$SUM_PURCHASED_TICKETS")
    println("Total income: $${income()}")
}

fun percentage(): Double = SUM_PURCHASED_TICKETS.toDouble() * 100.00 / income().toDouble()

fun income() : Int {
    val totalSeats = ROWS * SEATS

    return when {
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
}