def range = 5..8
println range.getClass()
println range.size()
println range.get(2)
println range[2]
println range.from
println range.to
assert range.contains(5)
assert range.contains(8)
