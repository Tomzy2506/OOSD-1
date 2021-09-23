<?php
$hostname = "localhost";    //name of host or ip address
$username = "C00253239";    //MySQL username - Students need to change this to their own
$password = "tommy1";       //MySQL password - Students need to change this to their own

$dbname = "MyDBC00253239";

$con = mysqli_connect($hostname,$username,$password, $dbname);

if(!$con)
{
    echo "Failed to connect to MySQL: ". mysqli_connect_error();
}

$sql = "Select * from persons";

$result = mysql_query($con,$sql);

echo "<br> The persona table contains the following records: <br> ";

while ($row=mysql_fetch_array($result))
{
    echo $row['personId']. " ". $row['firstName']. " ". $row['lastName']. "<br> ";
}
mysqli_close($con);

?>
