f/*
Write a function which displays a greeting to a visitor where the visitor's name is a global variable, and is NOT passed into the function as an argument.
*/
var visitorName = "Larry";

function sayHello() {
  console.log("Greetings " + visitorName);
}

sayHello();
