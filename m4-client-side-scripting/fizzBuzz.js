/*
Becuase you know you can't live without it, FizzBuzz.
Based on a traditional English children's game
Print the numbers 1..100
For multiples of 3, print "Fizz" instead of the number
For multiples of 5, print "Buzz" instead of the number
For multiples of 3 and 5, print "FizzBuzz" instead of the number
*/
function fizzBuzz() {
  for (var i = 1; i <= 100; i++) {
    var multipleOf3 = i % 3 === 0;
    var multipleOf5 = i % 5 === 0;
    if (multipleOf3 && multipleOf5) {
      console.log("FizzBuzz");
    }
    else if (multipleOf3) {
      console.log("Fizz");
    }
    else if (multipleOf5) {
      console.log("Buzz");
    }
    else {
      console.log(i);
    }
  }
}
fizzBuzz();
