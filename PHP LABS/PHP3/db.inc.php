<?php
$hostname = "localhost";    //name of host or ip adddress
$username = "MyDBC00253239";    //MySQL Username
$password = "tommy1";       //MySQL Password

$dbname = "tomiwaphp_";

$con = mysqli_connect($hostname, $username, $password, $dbname);

if (!$con)
{
    die ("Failed to connect to MySQL " . mysqli_connect_error());
}
?>