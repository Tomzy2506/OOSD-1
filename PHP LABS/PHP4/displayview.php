<?php
session_start();
include 'db.inc.php';

$sql = "Select * from Student where studentid = " . $_POST['studentid'];

if (!result = mysqli_query($con, $sql))
{
    die ('Error in querying the database' . mysqli_error());
}
$rowcount = mysqli_affected_rows($con);

$_SESSION['studentid']=$_POST['studentid'];
if($rowcount == 1)
{
    $row = mysqli_fetch_array($result);

    $_SESSION['studentid']=$row['studentid'];
    $_SESSION['studentName']=$row['studentName'];
    $_SESSION['studentAddress']=$row['studentAddress'];
    $_SESSION['studentPhone']=$row['studentPhone'];
    $_SESSION['gradePointAverage']=$row['gradePointAverage'];
    $_SESSION['dob']=$row['DOB'];
    $_SESSION['startYear']=$row['startYear'];
    $_SESSION['courseCode']=$row['courseCode'];
}
else if ($rowcount == 0)
{
    echo "No matching records";
    unset ($_SESSION['studentName']);
    unset ($_SESSION['dob']);
    unset ($_SESSION['courseCode']);
}
mysqli_close($con);
//Go back to the calling form - with the value that we need to display in session variables, if a record was found
header('Location: view.html.php');
//or alternatively use the following
//echo "<script> window.location.href = 'view.html.php'</script>";
?>