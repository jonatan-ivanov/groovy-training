def range = 'a'..'d'
println range.getClass()
println range.size()
println range.from
println range.to
assert range.contains('a')
assert range.contains('d')
assert ! range.contains('e')
