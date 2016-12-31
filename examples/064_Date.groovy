def today = new Date().clearTime() 
def nextWeek = today + 7

today.upto(nextWeek) {
    println it.format('EEEE')
}

println()

nextWeek.downto(today) {
    println it.format('E')
}
