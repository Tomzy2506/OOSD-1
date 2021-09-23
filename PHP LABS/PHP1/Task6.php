<?php

$cart = array("Bread", "Butter", "Mayonnaise", "Tomatoes", "Ham");
echo "<h1>The following are the items in my cart</h1>" . "</br></br>";
echo "<h2>Without a loop </h2></br>";

echo $cart[0]. "</br>";
echo $cart[1]. "</br>";
echo $cart[2]. "</br>";
echo $cart[3]. "</br>";
echo $cart[4]. "</br>";

echo "<h2> Or using a loop </h2></br>";

for ($i = 0; $i <= 4; $i++)
    {
        echo "$cart[$i] </br>";       //Echoing all within double quotes
    }
?>