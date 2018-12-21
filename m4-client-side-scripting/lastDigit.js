/*
Write a function that Given two non-negative int values, returns true if they have the same last digit, such as with 27 and 57.
*/
function lastDigit(a, b) {
  var lastDigitA = a % 10;
  var lastDigitB = b % 10;
  if (lastDigitA === lastDigitB) {
    return true;
  }
  return false;
}
console.log(lastDigit(1047, 23).toString());
console.log(lastDigit(147, 87).toString());
