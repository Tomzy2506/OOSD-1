<?php //Calculate the day given in the date details

$dateInMonth = $_POST['datenum'];

$MonthNum = $_POST['monthnum'];

$Yearnum = $_POST['yearnum'];

/*  Find the day matching the inputted details
    mktime (hour, minute, second, month, day, year, is_dst) */

$day = date("1", mktime(0,0,0,$MonthNum, $dateInMonth, $Yearnum));

//Format the date from the inputs

$FormattedDate = date("d/F/Y", mktime(0,0,0,$MonthNum, $dateInMonth, $Yearnum));

//Display the results
echo "The day of the week for $FormattedDate is: $day";

?>