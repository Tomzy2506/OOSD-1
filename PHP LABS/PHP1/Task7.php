<?php

$items = array("Cereal" => 5.00, "Coffee" => 2.50, "Bread" => 1.69, "Wedges" => 4.20, "Apple Tarts" => 0.75, "A&B Squash" => 2.50)

echo "<h2> Not using a loop</h2></br>";

echo "Cereal costs " . $items["Cereal"] . " euros </br></br>";
echo "Coffee costs " . $items["Coffee"] . " euros </br></br>";
echo "Bread costs " . $items["Bread"] . " euros </br></br>";
echo "Wedges cost " . $items["Wedges"] . " euros </br></br>";
echo "Apple Tart costs " . $items["Apple Tart"] . " euros </br></br>";
echo "A&B Squash costs " . $items["A&B Squash"] . " euros </br></br>";

echo "<h2> Or using a Foreach loop:</h2></br>";

foreach($items as $x => $x_value)
{
    echo $x . " costs " . $x_value . " euros" . "</br></br>";
}

?>
