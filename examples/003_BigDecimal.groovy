BigDecimal a = new BigDecimal(1);
BigDecimal b = new BigDecimal(0.1);
System.out.println(a.add(b));

BigDecimal c = new BigDecimal("1");
BigDecimal d = new BigDecimal("0.1");
System.out.println(c.add(d));

def x = 1.1
println x.getClass()

assert 12.34 == new BigDecimal("12.34"); //OK
assert 12.34 == new BigDecimal(12.34); //Fail
