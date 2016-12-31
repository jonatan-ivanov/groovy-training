class Example {
    def closure = {
        println("this: " + this.class.name)
        println("owner: " + owner.class.name)
        println("delegate: " + delegate.class.name)
    def nestedClosure = {
      println("owner: " + owner.class.name)
    }
    nestedClosure()
  }
}

def closure = new Example().closure
// closure.delegate = this
closure()
