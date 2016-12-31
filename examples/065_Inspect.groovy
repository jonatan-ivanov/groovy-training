def obj = "Aladár"

import groovy.inspect.swingui.*
ObjectBrowser.inspect(obj)

println obj.dump()
println()
println obj.properties
println()
println obj.class.methods.name
println()
println obj.class.fields.name
