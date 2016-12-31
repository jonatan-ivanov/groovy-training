//Global scope, OK:
str = "aaa"

//Script -> Clear Script Context
//Local scope, Fail

// def str = "aaa"
// String str = "aaa"

printStr()
println str

void printStr() {
    println str
}
