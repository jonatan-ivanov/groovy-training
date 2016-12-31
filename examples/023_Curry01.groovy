def add = { a, b, c -> a + b + c }

def partial1 = add.curry(1)
println partial1(2, 3)

def partial12 = add.curry(1, 2)
println partial12(3)

def partial3 = add.rcurry(3)
println partial3(1, 2)

def partial2 = add.ncurry(2, 2)
println partial2(1, 3)
