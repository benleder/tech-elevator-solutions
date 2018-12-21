/*
Given an array of ints of even length, return a new array length 2 containing the middle two elements from the original array. If the original array is not even, or is not at least 2 elements in length, return an empty array.
*/
function makeMiddle(numbersArray) {
    if ((numbersArray.length < 2) || ((numbersArray.length % 2) !== 0)) {
      return {};
    }
    var half =  Math.trunc(numbersArray.length / 2);
    return [numbersArray[half-1], numbersArray[half]];
}
console.log(makeMiddle([6, 8, 10, 88]));
console.log(makeMiddle([777]));
console.log(makeMiddle([91, 1000, 2, 6, 9]));
console.log(makeMiddle([98973, 3819, 3412, 2, 900, 9009, 1001, 4592]));
