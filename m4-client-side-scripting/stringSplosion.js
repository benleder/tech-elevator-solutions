/*
Given a non-empty string like "Code" return a string like "CCoCodCode".

stringSplosion("Code") → "CCoCodCode"
stringSplosion("abc") → "aababc"
stringSplosion("ab") → "aab"
*/
function stringSplosion(wordToSplode) {
  var splodedWord = "";
  for (var i = 0; i <= wordToSplode.length; i++) {
    splodedWord += wordToSplode.substring(0, i);
  }
  return splodedWord;
}
console.log(stringSplosion("Sam"));
console.log(stringSplosion("supercalifragilisticexpialidocious"));
