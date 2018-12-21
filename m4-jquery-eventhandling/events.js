
$(document).ready(function () {

  /*
   1. Add a click event handler to the "deepSkyBox" that displays an alert message: "Hey! You clicked me!" to the user.
   */
  $("#deepSkyBox").click(function() {
    alert("Hey! You clicked me!");
  });

  /*
   2. When any of the rainbow boxes are double clicked, show that they are selected by adding the "selected" class.
   3. If any of the rainbow boxes are double clicked, unselect them by removing the "selected" class.
   Note, you may want to look into jQuery selector wildcards.
   */
  $("#box-rainbow > [id^='box']").dblclick(function () {
    if ($(this).hasClass("selected")) {
      $(this).removeClass("selected");
    }
    else {
      $(this).addClass("selected");
    }
  });

  /*
    4. When the "Hide Selected Boxes" button is clicked, hide any of the selected boxes from the page.
   */
  $("#hideSelectedBoxes").click(function () {
    $(".selected").hide();
  });

  /*
   5. When the "Show All Boxes" button is clicked, show all of the boxes that are currently hidden.
   */
  $("#showAllBoxes").click(function () {
    $(".selected").show();
  });

  /*
   6. When the "Refresh List" button is clicked, update the list items in the "selectedBoxList" with the names of each selected box (i.e. Box 1, Box 7, Box
   */
  $("#refreshSelectedBoxList").click(function () {
    var selectedBoxesList = $("#selectedBoxList");
    selectedBoxesList.empty();
    $(".selected p").each(function () {
      selectedBoxesList.append('<li>' + $(this).text() + '</li>');
    });
    // A little bit of extra credit razzle dazzle to return the list to its original state if empty
    if (selectedBoxesList.children().length === 0) {
      selectedBoxesList.append('<li>No items selected...</li>');
    }
  });

  /*
   7. Add a border (css class .selected-field) to the textboxes on the page when they receives focus. Remove the border when they loses focus.
   */
  $("input:text").on('focus blur', function (event) {
    if (event.type === 'focus') {
      $(this).addClass("selected-field");
    }
    else {
      $(this).removeClass("selected-field");
    }
  });

  /*
   8. In the Form Address section, when the user indicates that they have a different billing address by checking the "My billing address is different box", display the fields in the "billingAddress" box. Make sure to hide those fields again if the user unchecks it.
  */
  $("#differentBillingAddress").click(function () {
    if ($(this).prop('checked')) {
      $("#billingAddress").show().children().show();
    }
    else {
      $("#billingAddress").hide().children().hide();
    }
  });

  /*
   9. As text is typed into the repeating text box repeat it out to the paragraph tag (#txtFieldOutput) element below it.
   */
  var clearOutput = true;
  $("#txtField").keypress(function(event) {
    if (clearOutput === true) {
      $("#txtFieldOutput").empty();
      clearOutput = false;
    }
    $("#txtFieldOutput").append(String.fromCharCode(event.keyCode));
  });

  /*
   10. Add an event that when the "Check all below" checkbox is checked, all of the sub-checkboxes are also checked.  Make sure when the user unchecks it, all checkboxes below are unchecked.
   */
  $("#checkAll").click(function () {
    if ($(this).prop('checked')) {
      $(".subcheck").prop('checked', true);
    }
    else {
      $(".subcheck").prop('checked', false);
    }
  });

  /*
   11. Make the swap buttons work. If the boxes in the 2-4 position are swapped, switch places with the box immediately preceding it (i.e. 3 is clicked therefore 3 and 2 swap places). If boxes in positions 5-7 are clicked swap places with the box immediately following it. For box 1 switches places with the box immediately following, and box 8 switch places with the box immediately before.
   */
  $("#box-rainbow > [id^='box'] > button").click(function () {
    // We have the button, now get its parent, i.e. the box that's holding the button
    var currentBox = $(this).parent();
    // Determine which direction the button is pointing
    if ($(this).text().indexOf("<") === 0) {
      // Button is pointing to the left, or "up" towards the beginning
      // Move unless already at the beginning
      if (currentBox.index() !== 0) {
        currentBox.insertBefore(currentBox.prev());
      }
      // Bonus! Reverse direction if necessary
      if (currentBox.index() === 0) {
        currentBox.find("button").text("Swap -->");
      }
    }
    else {
      // Button is pointing to the right, or "down" towards the end
      // Move unless already at the end
      if (currentBox.index() !== 7) {
        currentBox.insertAfter(currentBox.next());
      }
      // Bonus! Reverse direction if necessary
      if (currentBox.index() === 7) {
        currentBox.find("button").text("<-- Swap");
      }
    }
  });

});
