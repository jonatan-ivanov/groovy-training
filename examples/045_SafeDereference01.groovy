class Person {
    private String name
    private int age
}

List<Person> people = [new Person(name:"John Doe", age:30), null]
for(Person person : people) {
    println person?.name //NPE
}
