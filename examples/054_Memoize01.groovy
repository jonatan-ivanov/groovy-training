fib = { it <= 1 ? it : (fib(it - 1) + fib(it - 2)) }//.memoize()

long begin = System.currentTimeMillis()
fib(35)
long end = System.currentTimeMillis()

println "${(end-begin) / 1000} seconds"
