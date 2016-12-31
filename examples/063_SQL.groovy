// Just snippets, not a working demo
method('SELECT ... ')
method('SELECT ...?,?', [x,y])
method("SELECT ... $x,$y")

boolean execute(PreparedStatement)
Integer executeUpdate(PreparedStatement)
void eachRow(PreparedStatement){row- > ...}
void query(PreparedStatement){resultSet -> ...}
List rows(PreparedStatement)
Object firstRow(PreparedStatement)
