class Person {
    private String name
    private int age

    // private void setName(String name) { this.name = "mr. X" }
}

Person p = new Person(name:"John Doe", age:30)
println(p.name + " " + p.age)
p.name = "Jane Doe"
p.age = 26
println(p.name + " " + p.age)
