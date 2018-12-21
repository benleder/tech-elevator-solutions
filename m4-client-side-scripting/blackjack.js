/*
Write a function that given 2 int values greater than 0, returns whichever value is nearest to 21 without going over. Return 0 if they both go over.
*/
function blackjack(integerOne, integerTwo) {
  if ((integerOne <= 0) || (integerTwo <= 0)) {
    return 0; // Both must be greater than 0.
  }
  var diffOne = 21 - integerOne;
  var diffTwo = 21 - integerTwo;
  if ((diffOne < 0) && (diffTwo < 0)) {
    return 0; // Both integers went over 21.
  }
  else if (diffOne < 0) {
    return integerTwo; // integerOne went over 21, but integerTwo didn't , so integerTwo wins
  }
  else if (diffTwo < 0) {
    return integerOne; // integerTwo went over 21, but integerTwo didn't, so integerTwo wins
  }
  else if (diffTwo < diffOne) {
    return integerTwo; // Neither integerOne or integerTwo went over, but integerTwo was closer, so integerTwo wins
  }
  return integerOne; // Since integerTwo didn't win, it mus be integerOne
}
console.log(blackjack(19, 18));
console.log(blackjack(16, 17));
console.log(blackjack(22, 22));
console.log(blackjack(23, 1));
console.log(blackjack(1, 23));
