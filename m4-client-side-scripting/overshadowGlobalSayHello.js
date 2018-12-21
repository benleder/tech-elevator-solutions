/*
Write a function which displays a greeting to a visitor where the function overshadows the global visitor name. Display the globally defined visitor name after the function has run.
*/
var visitorName = "Larry";

function sayHello() {
  visitorName = "Lulu"
  console.log("Greetings " + visitorName);
}

sayHello();
console.log(visitorName);
