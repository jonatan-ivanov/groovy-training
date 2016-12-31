def rdr = new StringReader('Hello ')
def out = new StringWriter()
out << rdr << 'World!'
println out.toString()
