builder = new groovy.json.JsonBuilder()
def json = builder.person(id:2) {
    name "Jane Doe"
    age 25
}
println builder