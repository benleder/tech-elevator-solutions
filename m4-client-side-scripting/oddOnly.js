/*
Write a function that given an array of integer of any length, filters out the even number, and returns a new array of just the the odd numbers.
*/
function oddOnly(numbersArray) {
  var j = 0;
  var oddNumbersArray = [];
  for (var i = 0; i < numbersArray.length; i++) {
    if ((numbersArray[i] % 2) !== 0) {
      oddNumbersArray[j++] = numbersArray[i];
    }
  }
  return oddNumbersArray;
}
console.log(oddOnly([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]));
console.log(oddOnly([]));
console.log(oddOnly([87, 86, 85, 77, 76, 57, 56]));
