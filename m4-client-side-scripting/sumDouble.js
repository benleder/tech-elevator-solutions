/*
Write a function that given two int values, returns their sum. Unless the two values are the same, then returns double their sum.
*/
function sumDouble(a, b) {
  if (a===b) {
    return (a + b) * 2;
  }
  else {
    return a + b;
  }
}
console.log(sumDouble(10, 11));
console.log(sumDouble(44, 44));
