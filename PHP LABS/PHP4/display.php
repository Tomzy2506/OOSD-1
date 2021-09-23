<?php
$hostname = "localhost";    //name of host or ip address
$username = "MyDBC00253239";    //MySQL username
$password = "tommy1";       //MySQL password

$dbname = "tomiwaphp_";

$con = mysqli_connect($hostname,$username,$password, $dbname);

if(!$con)
{
    echo "Failed to connect to MySQL: ". mysqli_connect_error();
}

$sql = "Select * from Student";

$result = mysqli_query($con,$sql);

echo "<br> The persona table contains the following records: <br> ";

while ($row=mysqli_fetch_array($result))
{
    echo $row['studentid']. " ". $row['studentName']. " ". $row['studentAddress']. " ". $row['studentPhone']." ". $row['gradePointAverage']." ". $row['DOB']." ". $row['startYear']." ". $row['courseCode']. "<br> ";
}
mysqli_close($con);

?>
