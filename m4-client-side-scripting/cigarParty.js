/*
When squirrels get together for a party, they like to have cigars. A squirrel party is successful when the number of cigars is between 40 and 60, inclusive. Unless it is the weekend, in which case there is no upper bound on the number of cigars. Return true if the party with the given values is successful, or false otherwise.

cigarParty(30, false) → false
cigarParty(50, false) → true
cigarParty(70, true) → true
*/
function cigarParty(numberOfCigars, isWeekend) {
  if (numberOfCigars < 40) {
    return false;
  }
  else if ((isWeekend === true) && (numberOfCigars >= 60)) {
    return true;
  }
  else if ((isWeekend === false) && (numberOfCigars > 60)) {
    return false;
  }
  return true;
}
console.log(cigarParty(30, false));
console.log(cigarParty(40, false));
console.log(cigarParty(60, false));
console.log(cigarParty(61, false));
console.log(cigarParty(61, true));
console.log(cigarParty(40, true));
console.log(cigarParty(30, true));
