def a = [1,2,3,4] as Set
def b = [1,3,5] as Set
def c = [1,2,5,6,7,8] as Set

//Union
println a + b
println a.plus(b)
println a + b + c
println a.plus(b).plus(c)
