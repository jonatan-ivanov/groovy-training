// Run from GroovyConsole
Integer getTimesTenOf(Integer number) {
    10 * number
}
println getTimesTenOf(4)

//public final class Integer
Integer.metaClass.getTimesTen = {
    10 * delegate
}
println 4.timesTen
