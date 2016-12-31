println([1, 2, 3].collect{ it * 2 })
println([1, 2, 3]*.multiply(2))

println([1, 2, 3].find{ it > 1 })
println([1, 2, 3].findAll{ it > 1 })
