/*
Write a function, that given a string of odd length, returns the string length 3 from its middle, so "Candy" yields "and". The string must be an odd length and at least 3 characters long, otherwise return an empty string.

middleThree("Candy") → "and"
middleThree("and") → "and"
middleThree("solving") → "lvi"
*/
function middleThree(oddLengthWord) {
  if (((oddLengthWord.length % 2) === 0) || (oddLengthWord.length < 3)) {
    // Even length string, or less than 3 characters in length
    return "";
  }
  var middle = Math.trunc(oddLengthWord.length / 2);
  return oddLengthWord.substring(middle - 1, middle + 2);
}
console.log(middleThree("seven"));
console.log(middleThree("ten"));
console.log(middleThree("even"));
console.log(middleThree("a"));
console.log(middleThree("david"));
