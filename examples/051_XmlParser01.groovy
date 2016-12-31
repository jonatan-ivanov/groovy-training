def PERSON =
"""
<person id='2'>
    <name>Jane Doe</name>
    <age>25</age>
</person>
"""

class Person {def id; def name; def age}
def xmlPerson = new XmlParser().parseText(PERSON);

println xmlPerson
println xmlPerson['age']
println xmlPerson.age
println xmlPerson['@id']
println xmlPerson.@id
