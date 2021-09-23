<?php session_start(); ?>
<html>
    <body>
        <form action="displayview.php" method="Post">
            <p><label for="personid"> Enter the personid you want to find </label>
            <input type="text" name="personid" id="personid" placeholder="person id" autocomplete=off
            required value="<?php if (ISSET($_SESSION['personid'])) echo $_SESSION['personid']?>" />
            </p>

            <p><label for="firstname"> First Name </label>
            <input type="text" name="firstname" id="firstname" placeholder="first name" disabled
            value="<?php if (ISSET($_SESSION['firstname'])) echo $_SESSION['firstname']?>" />
            </p>

            <p><label for="surname"> Last Name </label>
            <input type="text" name="surname" id="surname" placeholder="Surname" disabled
            value="<?php if (ISSET($_SESSION['lastname'])) echo $_SESSION['lastname']?>" />
            </p>

            <p><label for="dob"> Date Of Birth </label>
            <input type="text" name="dob" id="dob" placeholder="Date Of Birth" disabled
            value="<?php if (ISSET($_SESSION['dob'])) echo $_SESSION['dob']?>" />
            </p>
            <br><br>

            <input type="submit" value="Submit" />
            <p>
        </form>
        <?php
        if (!ISSET($_SESSION['firstname']) and ISSET($_SESSION['personid']))
            {
                echo '<p style="color: red; text-align: center; font-size:20">
                No redcord found for a person with id...' . $_SESSION['personid'] . '
                <br> Please try again!
                </p>';
                unset ($_SESSION['personid']);
            }
        ?>
    </body>
</html>