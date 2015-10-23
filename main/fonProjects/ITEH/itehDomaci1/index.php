<?php
require_once("./DatabaseManager.php");
session_start();
//ONLY ADMINS(CHECK IF THE USER IS LOGGED IN)!
if(isset($_SESSION["Username"])){
    header("Location: loggedin.php");
 } else{ ?>
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="utf-8">
        <title>Orders</title>
    </head>
    <body>
    <div>
        <h1>Welcome</h1> <br>
        <?php
        DatabaseManager::showOrders(false);
        ?>
    </div>


    </body>
    </html>
<?php } ?>
