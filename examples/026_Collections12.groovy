langs = ["Java", "Groovy", "Scala", "Clojure"]
langs.each({ print(it + ", ") })
println()
langs.eachWithIndex{ it, i -> print("$i:$it, ") }
println()
[0:'a', 1:'b', 2:'c'].each { key,value -> print "$key:$value " }
