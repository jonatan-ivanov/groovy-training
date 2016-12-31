years=23
switch (years) {
    case 1..10: interestRate = 0.076; break;
    case 11..25: interestRate = 0.052; break;
    default: interestRate = 0.037;
}
println interestRate

println([ 1, *3..5, 7, *9..<12 ])
