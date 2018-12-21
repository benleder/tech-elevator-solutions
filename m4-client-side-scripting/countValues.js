/*
Write a function that accepts an array of integer values, count of the number of times each value is found in the array, and then display the values and their count.
*/
function findByID(integers, id) {
  for (var i = 0; i < integers.length; i++) {
    if (integers[i].id === id) {
      return integers[i];
    }
  }
  return null;
}
function countValues(integersArray) {
  var countedIntegersArray = [];
  for (var i = 0; i < integersArray.length; i++) {
    countedInteger = findByID(countedIntegersArray, integersArray[i]);
    if (countedInteger !== null) {
      countedInteger.count += 1;
    }
    else {
      countedIntegersArray.push({id:integersArray[i], count:1});
    }
  }
  return countedIntegersArray;
}
var countedIntegers = countValues([1, 99, 43, 2, 55, 78, 99, 2345, 438, 2, 99, 107]);
for (var i = 0; i < countedIntegers.length; i++) {
  console.log(countedIntegers[i].id + " : " + countedIntegers[i].count);
}
