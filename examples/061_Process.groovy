// proc = 'cmd /c hostname'.execute()
proc = 'hostname'.execute()
Thread.start { System.out << proc.in }
Thread.start { System.err << proc.err }
proc.waitForOrKill(0)
