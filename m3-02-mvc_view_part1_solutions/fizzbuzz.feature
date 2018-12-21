Feature: Printing FizzBuzz
    As an instructor
    I want students to visuallly display FizzBuzz on a webpage
    So I can assess the student's understanding of views.

Background: 
    When the FizzBuzz page is displayed

Example: Numbers that are divisible by three and not five should display Fizz.
    Then Fizz should be displayed for all numbers that are divisble by 3 but not 5

Example: Numbers that are divisible by five and not three should display Buzz.
    Then Buzz should be displayed for all numbers that are divisble by 5 but not 3

Example: Numbers that are divisible by both three and five should display FizzBuzz.
    Then FizzBuzz should be displayed for all numbers that are divisible by 3 and 5.

Example: Numbers that are not divisible by three or five should be displayed.
    Then the number should be displayed for all numbers that are not divisible by 3 or 5.
    