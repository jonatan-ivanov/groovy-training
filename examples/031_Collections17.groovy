list = [1, 2, 3]
Collections.fill(list, 'g')
//use(Collections){ list.fill( 'g' ) }
println list

list = [1, 2, 3]
Collections.swap(list, 0, 2)
println list

println(Collections.frequency(['a','b','a','c','a','a','d','e'], 'a'))

list= ['a','b','c','d','e']
Collections.rotate(list, 2)
println list
Collections.rotate(list, -2)
println list
