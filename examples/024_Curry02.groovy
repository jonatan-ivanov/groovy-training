def greeter = { greeting, name -> println "${greeting}, ${name}!" }
def sayHello = greeter.curry('Hello')

sayHello('Groovy')
def sayHi = greeter.curry('Hi')
sayHi('Groovy')
