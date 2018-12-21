$(document).ready(function () {

  /*
   1. Find the children of the "recipes" section.
   */
  console.log($("#recipes").children());

  /*
   2. Find the "titles" of "beef" recipes.
   */
  console.log($(".beef .title"));

  /*
   3. Find the children of the "blackened-catfish" recipe.
   */
  console.log($("#blackened-catfish").children());

  /*
   4. Find the parent of the "winter-fruit-salad" recipe.
   */
  console.log($("#winter-fruit-salad").parent());

  /*
   5. Find the parents of the "curried-tilapia" recipe.
   */
  console.log($("#curried-tilapia").parents());

  /*
   6. Find the siblings of "tailgate-chili" "made-it".
   */
  console.log($("#tailgate-chili .made-it").siblings());

  /*
   7. Find the siblings of "vegetarian" recipes.
   */
  console.log($(".vegetarian").siblings());

  /*
   8. Filter even items from the table-of-contents list.
   */
  console.log($("#table-of-contents li").filter(":even"));

  /*
   9. Filter "made-it" checkbox from "black-bean-burrito" children.
   */
  console.log($("#black-bean-burrito").children().filter( function() {return $(this).attr('class') !== "made-it";}));

  /*
   10. Get the text for all h3 elements.
   */
  console.log($("h3").text());

  /*
   11. Set the text for the "cabbage-pie" title to "Homemade Cabbage Pie -- Yum!".
   */
  $("#cabbage-pie .title").text("Homemade Cabbage Pie -- Yum!");

  /*
   12. Set the html for the "cabbage-pie" title to "Homemade Cabbage Pie<br>Yum!".
   */
  $("#cabbage-pie .title").html("Homemade Cabbage Pie<br>Yum!");

  /*
   13. Now for good measure, and to seal in the difference between text() and html(), set the text for the "cabbage-pie" title to "Homemade Cabbage Pie<br>Yum!".
   */
  $("#cabbage-pie .title").text("Homemade Cabbage Pie<br>Yum!");

  /*
   14. Add "Delicious recipe description and instructions go here." to all recipe introductory paragraphs.
   */
  $(".recipe > p").text("Delicious recipe description and instructions go here.");

  /*
   15. Get input type of all "remarks".
   */
  console.log($(".remarks").attr('type'));

  /*
   16. Set input type to "text" for all "remarks".
   */
  $(".remarks").attr('type', 'text');

  /*
   17. Set value for "remarks" to "Your remarks go here."
   */
  $(".remarks").val("Your remarks go here.");

  /*
   18. Check every other "made-it" checkbox
   */
  $(".made-it").prop('checked', true);

  /*
   19. Add "poultry" to "table-of-contents" list
   */
  $("#table-of-contents ul").append('<li class="poultry">Poultry</li>');

});
