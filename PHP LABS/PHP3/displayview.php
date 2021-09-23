<?php
session_start();
include 'db.inc.php';

$sql = "Select * from Persons where personid = " . $_POST['personid'];

if (!result = mysqli_query($con, $sql))
{
    die ('Error in querying the database' . mysqli_error());
}
$rowcount = mysqli_affected_rows($con);

$_SESSION['personid']=$_POST['personid'];
if($rowcount == 1)
{
    $row = mysqli_fetch_array($result);

    $_SESSION['personid']=$row['personId'];
    $_SESSION['firstname']=$row['firstName'];
    $_SESSION['lastname']=$row['lastName'];
    $_SESSION['dob']=$row['DOB'];
}
else if ($rowcount == 0)
{
    echo "No matching records";
    unset ($_SESSION['firstname']);
    unset ($_SESSION['lastname']);
    unset ($_SESSION['dob']);
}
mysqli_close($con);
//Go back to the calling form - with the value that we need to display in session variables, if a record was found
header('Location: view.html.php');
//or alternatively use the following
//echo "<script> window.location.href = 'view.html.php'</script>";
?>