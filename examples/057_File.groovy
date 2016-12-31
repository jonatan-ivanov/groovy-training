// def file = new File('C:\\Windows\\System32\\drivers\\etc\\hosts')
// def file = new File('/etc/hosts')
def file = new File('/private/etc/hosts')
println file.text
println file.readLines()

//cat
//args.each { println new File(it).getText() }
