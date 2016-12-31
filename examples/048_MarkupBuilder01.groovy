def writer = new StringWriter()
def builder = new groovy.xml.MarkupBuilder(writer)
builder.person(id:2) {
    name "Jane Doe"
    age 25
}
println writer
