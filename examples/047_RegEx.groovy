def input = "foobar"
def pattern = ~"foo.*" // Pattern.compile("foo.*")
println pattern.getClass()

def matcher = input =~ pattern // pattern.matcher(input)
boolean match = input =~ pattern
println matcher.getClass()
println match

println("foobar" ==~ "foo.*") // "foobar".matches("foo.*")
