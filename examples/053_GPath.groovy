def PERSON =
"""
<person id='2'>
    <name>Jane Doe</name>
    <age>25</age>
</person>
"""

class Person {def id; def name; def age}
def xmlPerson = new XmlParser().parseText(PERSON);

Person p = new Person(id:xmlPerson?.@id, name:xmlPerson?.name?.text(), age:xmlPerson?.age?.text())
println("Person: ${p?.id}, ${p?.name}, ${p?.age}")
