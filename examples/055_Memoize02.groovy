@groovy.transform.Memoized
int sum(int a, int b) {
    println "$a + $b = ${a + b}" 
    a + b
}
println sum(1,2)
println sum(1,2)
