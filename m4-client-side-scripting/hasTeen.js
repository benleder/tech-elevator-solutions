/*
We'll say that a number is "teen" if it is in the range 13..19 inclusive. Write a function that given 3 int values, returns true if 1 or more of them are teen.
*/
function hasTeen(a, b, c) {
  if ((a > 12) && (a < 20)) {
    return true;
  }
  if ((b > 12) && (b < 20)) {
    return true;
  }
  if ((c > 12) && (c < 20)) {
    return true;
  }
  return false;
}
console.log(hasTeen(1, 2, 3).toString());
console.log(hasTeen(11, 12, 13).toString());
console.log(hasTeen(18, 19, 20).toString());
