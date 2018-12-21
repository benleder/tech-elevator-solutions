/*
Write a function that given two arrays of integers, interleaves the two arrays one element from each array at a time to return a new array made up of the interwoven elements of the original two arrays. If the two given arrays are of unequal lenghts, interleaf the elements up to the length of the shortest, and then append the reminder of the longer to the new array.
*/
function weave(integersArrayOne, integersArrayTwo) {
  var j = 0;
  var wovenArray = [];
  var minLength = Math.min(integersArrayOne.length, integersArrayTwo.length);
  for (var i = 0; i < minLength; i++) {
      wovenArray[j++] = integersArrayOne[i];
      wovenArray[j++] = integersArrayTwo[i];
  }
  if (integersArrayOne.length < integersArrayTwo.length) {
    wovenArray = wovenArray.concat(integersArrayTwo.slice(minLength));
  } else if (integersArrayOne.length > integersArrayTwo.length) {
    wovenArray = wovenArray.concat(integersArrayOne.slice(minLength));
  }
  return wovenArray;
}
console.log(weave([1, 3, 5], [2, 4, 6]));
console.log(weave([1, 3], [2, 4, 6, 8]));
console.log(weave([1, 3, 5, 7], [2, 4]));
