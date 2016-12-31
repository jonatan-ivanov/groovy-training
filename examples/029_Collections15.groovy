println([1, 2, 3].join('-'))

println([1, 2, 3].inject('counting: '){ str, item -> str + item })
println([1, 2, 3].inject(0, { sum, item -> sum + item }))

println([1, 2, 3].intersect([1, 3, 5]))
println([1, 2, 3].disjoint([4, 6, 1]))
println([1, 2, 3].reverse())
