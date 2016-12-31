println([1, 2, 3].permutations())

list = ['abc', 'z', 'xyzuvw', 'Hello', '321']
println list.sort{ it.size() }

list = [7,4,-6,-1,11,2,3,-9,5,-13]
println list.sort { a,b -> a.equals(b) ? 0 : Math.abs(a) < Math.abs(b)? -1 : 1 }

comp = [ compare: { a,b -> a.equals(b) ? 0 : Math.abs(a) < Math.abs(b)? -1 : 1 } ] as Comparator
println list.sort(comp)

println([3,5,5,5,2].unique()) //Comparator
