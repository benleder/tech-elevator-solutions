/*
Write a function that given a string, and the string begins with "red" or "blue", returns that color string, otherwise returns the empty string.
*/
function seeColor(colorWord) {
  // One approach for "red"
  if (colorWord.startsWith("red")) {
    return "red";
  }
  // Another approach for "blue", just to liven things up
  if (colorWord.indexOf("blue")===0) {
    return "blue";
  }
  return "";
}
console.log(seeColor("redo"));
console.log(seeColor("bored"));
console.log(seeColor("bluejay"));
console.log(seeColor("trueblue"));
