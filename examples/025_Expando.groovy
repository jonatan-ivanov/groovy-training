def user = new Expando()
user.name = "John"
user.greeting = { "Hello, my name is $name" }

println user.greeting()
user.name = "Jane"
println user.greeting()
