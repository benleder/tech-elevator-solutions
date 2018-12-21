/*
Write a function that given a day of the week encoded as 0=Sun, 1=Mon, 2=Tue, ...6=Sat, and a boolean indicating if we are on vacation, displays the weeday name, and the time in the form of "7:00" indicating when the alarm clock should ring. Weekdays, the alarm should be "7:00" and on the weekend it should be "10:00". Unless we are on vacation -- then on weekdays it should be "10:00" and weekends it should be "off".

alarmClock(1, false) → "Monday 7:00"
alarmClock(5, true) → "Frday 10:00"
alarmClock(0, false) → "Sunday 10:00"
*/
function alarmClock(weekday, isVacation) {
  var weekdayName;
  var alarmTime;
  switch (weekday) {
    case 0:
      weekdayName = "Sunday";
      alarmTime = isVacation ? "off" : "10:00";
      break;
    case 1:
      weekdayName = "Monday";
      alarmTime = isVacation ? "10:00" : "7:00";
      break;
    case 2:
      weekdayName = "Tuesday";
      alarmTime = isVacation ? "10:00" : "7:00";
      break;
    case 3:
      weekdayName = "Wednesday";
      alarmTime = isVacation ? "10:00" : "7:00";
      break;
    case 4:
      weekdayName = "Thursday";
      alarmTime = isVacation ? "10:00" : "7:00";
      break;
    case 5:
      weekdayName = "Friday";
      alarmTime = isVacation? "10:00" : "7:00";
      break;
    case 6:
      weekdayName = "Saturday";
      alarmTime = isVacation? "off" : "10:00";
      break;
  }
  console.log(weekdayName + " " + alarmTime);
}
alarmClock(0, false);
alarmClock(1, true);
alarmClock(5, false);
alarmClock(6, true);
