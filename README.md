#Groovy - A dynamic language for the Java platform
An old training that I held about Groovy, please check the code examples.  
Could be outdated (especially the links).

#Foundation - Facts, Advantages, Disadvantages
##Facts
- Founded in late 2003
- Runs on JVM (compiles to Java bytecode)
- Optional typing (runtime type checking, binding)
- Complements Java (dynamic capabilities)
- Most popular language on the JVM after Java (?)
- [http://www.groovy-lang.org/](http://www.groovy-lang.org/)

##Advantages
- Optional typing
- Additional powerful features (later)
    - Function literals/closures (see Java8 lambda expressions)
    - Cool operators, extensions
    - Native support for
        - Collections
        - Regular Expressions
        - XML processing
- Supports DSLs
- Can be used as a scripting language (parse, compile, generate, execute on JVM)
- You can write Java as Groovy (Java-like syntax)
- Easy learning curve
- Excellent rapid prototyping language
- Simplified testing (supports unit testing and mocking OOB)
- IDE support (Eclipse, IntelliJ, NetBeans)
- GroovyConsole
- (demo: 001\_Hello\_World, 002\_Zero)

##Disadvantages
- IDE support could be better
- Code checking/analysis/metrics etc. could be hard or impossible  
    (Checkstyle, PMD, Code Coverage)
- Performance  
    `GroovyObject#invokeMethod(String name, Object.. args)`  
    reflection, lookups, proxies  
    <=> invokedynamic (Java 7+, Groovy 2.1+)
- Optional typing (?)
- Free syntax (?)

#Groovy 101 - It's Groovy baby, yeah! (Austin Powers)
##Usage
- Java-like installation and usage
    - `GROOVY_HOME` ~ `JAVA_HOME`
    - `groovyc` ~ `javac`
    - `groovy` ~ `java`
    - `.groovy` ~ `.java`
- The Runtime can call groovyc (source must be on the *classpath*)
- `groovy -e "println 12.5*Math.PI"`
- `groovysh` - Groovy Shell
- `groovyConsole`
- `java2groovy`

##Syntax differences
- Not required
    - Semicolons at the end of the statements
    - `return` statements
    - Parentheses for method parameters
- `public` is the default access modifier (class, field, method)
- Auto-generated ctors, getters and setters
- Script: outside of Class

##Default imports
```
groovy.lang.*
groovy.util.*
java.lang.*
java.io.*
java.math.BigDecimal
java.math.BigInteger
java.net.*
java.util.*
```

##Numeric handling
- Literal floating point numbers (3.1415) are BigDecimals under the hood
- Principle of least surprise  
    - [BigDecimal(double)](http://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html#BigDecimal-double-)
    - `1 + 0.1 = 1.1` (using BigDecimal(String) automagically)
    - Swaps between numeric types as required (int-double)
    - BEDMAS order: Brackets, Exponents, Division, Multiplication, Addition, Subtraction
    - Power operator: `**`
- http://groovy.codehaus.org/Groovy+Math
- (demo: 003\_BigDecimal)

##Dynamic vs. Static
```
x = 1.0
x = new Date() //OK

def y = 1.0
y = new Date() //OK

int z = 1
z = new Date() //Exception
```
- Tip: Use static types where possible
- (demo)

##Scopes
- Classes: like Java: class, method, block
- Scripts: (not inside class)
    - binding - global scope
    - local - block scope

Variables are in the local scope if they have been **defined***  
***defined**: static type or `def` keyword  
**Methods declared in a script don't have access to the local scope**

- (demo: 004\_Scopes01, 005\_Scopes02)

##Collections pt. I.
- Native support
- No need to explicitly declare Collections
- List, Map, Set
- http://groovy.codehaus.org/Collections
- http://groovy.codehaus.org/JN1015-Collections
- http://groovy.codehaus.org/JN1025-Arrays
- (demo: 006\_Collections01 - 016\_Collections11)

##Exception handling
- There is no difference between checked and unchecked exceptions
- `throws` clauses are ignored

##Equality
- `==` is the same as `equals()` in Java
- `is()` for identity check same as `==` in Java
- null checking: `==` or `is()`
- (demo: 017\_Equality)

#Groovy 102 - Into the Groove (Madonna)
##Enhanced Strings
- GString - Extension to the Java String class
- For ordinary Strings apostrophes and double quotes are also valid  
    `println('Hello ' + "World!");`
- GStings must be defined with double quotes
- They can contain expressions
- GStrings are not Java Strings: You should not use as keys of maps or try to compare their equality
- Triple quoted Strings or GStrings: Wrap a string across multiple lines  

```
"""This GString wraps
across two lines"""
```

- http://groovy.codehaus.org/Strings+and+GString
- http://groovy.codehaus.org/JN1525-Strings
- (demo: 018\_GString)

##GroovyBeans
- Omit the explicit getters/setters but you can explicitly implement them
- Auto-generated ctors: pass a map
- `@Immutable`, `@Singleton` annotations
- (demo: 019\_GroovyBeans)

##Closures/Function literals/Anonymous function
- Special code block that is defined and then executed later
- It's like a "method pointer"
- Can be passed to methods
- Can be assigned to variables
- `{ [closureArguments->] statements }`
- Free variables
    - Variables that are not listed in the parameter list
    - Local, Scope
- Implicit variables
    - `it`: you can omit the single parameter definition
    - `this`: as in Java, the enclosing instance
    - `owner`: this or a surrounding Closure
    - `delegate`: the same as owner, but changeable
- (demo: 020\_Closures01, 021\_Closures02, 022\_Closures03)

##Curry
- A special function that takes a closure and default parameter(s)
- Returns another closure that only requires the missing parameter(s)
- `curry`, `rcurry`, `ncurry`

```
def add = { a, b -> a + b }
def curry = { fn, a -> { b -> fn(a,b) } }
def addFive = curry(add, 5)
println addFive(3)

def add = { a, b -> a + b }
def addFive = add.curry(5)
println addFive(3)
```

- (demo: 023\_Curry01, 024\_Curry02)

##Expando (Dynamic Object)
- Represents a dynamically expandable bean
- "Similar" to a Map
- Doesn't have to have their properties defined in advance
- It allows you to create dynamic objects via closures
- Different from a map: you can call methods on the object
- http://groovy.codehaus.org/gapi/groovy/util/Expando.html
- (demo: 025\_Expando)

##Collections pt. II.
- Pass method to the collection
- `each`, `eachWithIndex`
- `collect`
- `find`, `findAll`
- `every`, `any`
- `min`, `max`, `sum`
- `join`
- `inject`
- `intersect`
- `disjoint`
- `reverse`
- `removeAll`
- `retainAll`
- (demo: 026\_Collections12 - 030\_Collections16)
- `fill`
- `swap`
- `frequency`
- `rotate`
- `permutations`
- `sort`
- `unique`
- `subList`
- `groupBy`
- Set: Union, Intersection, Compliment
- `asImmutable()`, `asSynchronized()`
- (demo: 031\_Collections17 - 037\_Collections23)
- http://groovy.codehaus.org/Collections
- http://groovy.codehaus.org/JN1015-Collections
- http://groovy.codehaus.org/JN1025-Arrays
- http://groovy.codehaus.org/groovy-jdk/java/util/Collection.html
- http://groovy.codehaus.org/groovy-jdk/java/util/List.html
- http://groovy.codehaus.org/groovy-jdk/java/util/Set.html
- http://groovy.codehaus.org/groovy-jdk/java/util/Map.html
- http://groovy.codehaus.org/groovy-jdk/java/lang/Object[].html

##Ranges
- List of sequential values
- Extends `java.util.List`
- http://groovy.codehaus.org/gapi/groovy/lang/Range.html
- Inclusive range: `..`
- Half-open range: `..<`
- `5..8`
- `5..<8`
- `'a'..'d'`
- (demo: 038\_Ranges01 - 044\_Ranges07)

##Safe dereference operator - '?.'
```
if (person != null) {
    return person.name;
}
else {
    return null;
}

person?.name;
```
(demo: 045\_SafeDereference01, 046\_SafeDereference02)

##Elvis operator - '?:'
```
String travelerStatus = null;
status = (travelerStatus != null) ? travelerStatus : "Inactive";
status = travelerStatus ?: "Inactive";
```

##Spread operator - '\*.'
- Invokes an action on all items of an aggregate object
- It is equivalent to call `collect()`

```
(1..10).collect{it * 2}
(1..10)*.multiply(2)
```
```
parent*.action
parent.collect{ child -> child?.action }
println ['a', 'few', 'words']*.size() //[1, 3, 5]
```

##++ops
Name | Syntax | Description
---- | ------ | -----------
Spaceship | `<=>` | Compares the left and the right side: -1, 0, +1
Regex | `~ =~ ==~` | Native support for Regular Expressions, see laterField Override | `.@` | Can be used to override generated properties to provide access to a field
Spread Field | `*.@` | Amalgamation of Spread and Field Override operations
Method Reference | `.&` | Get a reference to a method, useful for creating closures from methods
asType | `as` | Used for groovy casting, coercing one type to another
Membership | `in` | Can be used as replacement for `collection.contains()`
Identity | `is` | Identity check. Since `==` is overridden in with the meaning of equality

- http://groovy.codehaus.org/Operators#Operators-ArithmeticandConditionalOperators
- http://www.javacodegeeks.com/2014/01/groovys-smooth-operators.html

##Regular Expressions
- `~` creates a Pattern from String `Pattern.compile(".*")`
- `=~` creates a Matcher `pattern.matcher("aaa")`
- `==~` tests, if the String matches the pattern `"aaa".matches("a.*")`
- (demo: 047\_RegEx)

##Dealing with treelike data structures
- XML, JSON, etc.
- Builders and native language support
- `XmlParser`: Supports GPath expressions for XML documents and allows updating
- `XmlSlurper`: Similar to XmlParser, but applies lazy evaluation
- `JsonSlurper`
- `DOMCategory`: Low-level parsing of a DOM object with some syntax support
- http://docs.codehaus.org/display/GROOVY/Processing+XML
- (demo: 048\_MarkupBuilder01 - 052\_XmlParser02)

##GPath
- GPath is a path expression language
- It has similar aims and scope as XPath does for XML
- Dealing with nested POJOs or dealing with XML, JSON, etc.
- http://groovy.codehaus.org/GPath
- (demo: 053\_GPath)

##Memoization
- Is an optimization technique
- Make functions faster by trading space for time
- Remembering results of method calls
    - Returning the remembered result rather than recomputing the result again
    - Creates a cache for the results
    - Mapping between the parameters and the return value
- `@Memoized`
- (demo: 054\_Memoize01, 055\_Memoize02)

#Grape
- Adds dependencies to your classpath
- `@Grab` http://groovy.codehaus.org/api/groovy/lang/Grab.html
- http://groovy.codehaus.org/Grape
- (demo: 056\_Grape)

##And so on...
- IO: `URL`, `File`, `Reader`, `Writer`, `InputStream`, `OutputStream`, `Socket`, `Process`
- Threads and Processes
- DSL http://joesgroovyblog.blogspot.hu/2007/09/and-miles-to-go-before-i-sleep.html
- SQL
- `Calendar` and `Date`
    http://groovy.codehaus.org/groovy-jdk/java/util/Calendar.html
    http://groovy.codehaus.org/groovy-jdk/java/util/Date.html
- `Object` http://groovy.codehaus.org/groovy-jdk/java/lang/Object.html
- (demo: 057\_File - 064\_Inspect)

##Wait, what?! Metaprogramming
- Writing of computer programs that write or manipulate other programs (or themselves)
- Runtime
    - Expando
    - Thru Closures' delegate
    - Categories (DOMBuilder, DOMCategory)
    - MetaObjectProtocol (MetaClass, ExpandoMetaClass)
- Compile Time
    - AST Transformations (Abstract Syntax Tree)  
    `@Immutable`, `@Singleton`, `@Memoized`, `@Synchronized`, `@Log`, `@Grab`
    Project Lombok http://projectlombok.org/features/index.html
- Extension Module
- (demo: 065\_MetaClass)
- http://java.dzone.com/articles/introduction-groovy-runtime
- http://www.infoq.com/presentations/groovy-metaprogramming-1
- http://www.infoq.com/presentations/groovy-metaprogramming-2
- http://groovy.codehaus.org/JN3525-MetaClasses
- http://groovy.codehaus.org/ExpandoMetaClass
- http://groovy.codehaus.org/Groovy+Categories
- http://groovy.codehaus.org/Creating+an+extension+module
- http://groovy.codehaus.org/Compile-time+Metaprogramming+-+AST+Transformations
- http://www.slideshare.net/aalmiray/groovy-ast-demystified-16213614
- http://glaforge.appspot.com/article/groovy-ast-transformations-tutorials

#See also - Feeling Groovy (Simon and Garfunkel)
##Interoperating
- Calling Java from Groovy
    - Use the classes as you would in Java
    - `.jar` on the `CLASSPATH`, `import`
- Calling Groovy from Java
    - Put `GROOVY_HOME/embeddable/groovy-all-*.jar` into `CLASSPATH`
    - `groovy.lang.GroovyShell`
    - `groovy.lang.GroovyClassLoader`
    - `groovy.util.Eval`
    - `groovy.util.GroovyScriptEngine`
    - Bean Scripting Framework (JSR-223)
    - Embedded Groovy console

##Interoperating - Ant

```
<taskdef name="groovyc" classname="org.codehaus.groovy.ant.Groovyc" classpathref="project.classpath" />
<groovyc>
    <classpath refid="project.classpath" />
    <javac>
        [...]
    </javac>
    [...]
</groovyc>
```

##Interoperating - Gradle
```
apply plugin: 'groovy'
```
https://docs.gradle.org/current/userguide/groovy_plugin.html

##Groovy-related projects
- Gradle (Build/project automation) http://www.gradle.org/
- Grails (Web Application framework) http://grails.org/
- GSP (Groovy Server Pages) http://groovy.codehaus.org/GSP
- Griffon (Rich Application Platform - application framework for desktop apps) http://griffon.codehaus.org/
- GroovyServ (Pre-invoking JVM as a server) http://kobo.github.io/groovyserv/
- EasyB (BDD framework) http://easyb.org/
- Gaelyk (Groovy toolkit for Google App Engine) http://gaelyk.appspot.com/
- Gant (Groovy-based build system that uses Ant tasks, but no XML) http://gant.codehaus.org/
- GMock (Mocking framework) http://groovy.codehaus.org/GMock
- Scriptom (ActiveX/COM scripting) http://groovy.codehaus.org/COM+Scripting
- Spock (Testing and specification framework) https://code.google.com/p/spock/
- [...] http://groovy.codehaus.org/Related+Projects

##What's next?
- Groovy docs http://groovy.codehaus.org/
- Groovy wiki snapshot http://docs.codehaus.org/download/attachments/63052/wiki-snapshot.pdf
- DZone Refcards: Groovy http://cdn.dzone.com/sites/all/files/refcardz/rc015-groovy_online.pdf
- Programming Groovy http://pragprog.com/book/vslg2/programming-groovy-2
- Groovy in Action http://www.manning.com/koenig2/
- Groovy Goodness Notebook https://leanpub.com/groovy-goodness-notebook/
