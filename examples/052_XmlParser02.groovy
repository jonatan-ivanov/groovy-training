def PERSON =
"""
<person id='2'>
    <name>Jane Doe</name>
    <age>25</age>
</person>
"""

class Person {def id; def name; def age}
def xmlPerson = new XmlParser().parseText(PERSON);

println xmlPerson.name()
println xmlPerson.age.text()
println xmlPerson.age[0].parent().name()
println xmlPerson.children()
println xmlPerson.attributes()
println xmlPerson.depthFirst()
