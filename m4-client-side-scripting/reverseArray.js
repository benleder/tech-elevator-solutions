/*
Write an function that accepts an array of integer values, and display them in the reverse order they appeared in the array. One obvious solution is to simply loop through the command line arguments in reserve order, but see if you can come up with an alternative.
*/
function reverseArray(integersArray) {
  var reversedArray = [];
  for (var i = 0; i < integersArray.length; i++) {
    reversedArray.push(integersArray[i]);
  }
  while (reversedArray.length > 0) {
    console.log(reversedArray.pop());
  }
}
reverseArray([1, 99, 43, 2, 55, 78, 99, 2345, 438, 2, 99, 107]);
