/*
Write a function that given a string, returns true if the first 2 chars in the string also appear at the end of the string, such as with "edited". Return false if string length is less than 2.

frontAgain("edited") → true
frontAgain("edit") → false
frontAgain("ed") → true
*/
function frontAgain(wordToExamine) {
  if (wordToExamine.length < 2) {
    return false;
  }
  var wordLength = wordToExamine.length;
  var firstTwoChars = wordToExamine.substring(0, 1);
  if (wordToExamine.substring(wordLength - 2, wordLength - 1) === firstTwoChars) {
    return true;
  }
  return false;
}
console.log(frontAgain("edited").toString());
console.log(frontAgain("edit").toString());
console.log(frontAgain(""))
