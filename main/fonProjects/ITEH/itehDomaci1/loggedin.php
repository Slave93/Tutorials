<?php
require_once("/DatabaseManager.php");
session_start();
//ONLY ADMINS(CHECK IF THE USER IS LOGGED IN)!
if(isset($_SESSION["Username"])){
?>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Welcome Back Admin</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h1>Welcome Back <?php echo $_SESSION["Username"]; ?></h1> <br>
    <?php
        DatabaseManager::showOrders(true);
    ?>
    <a href='logout.php'> Logout </a>
</div>


</body>
</html>
<?php } else{ // This must be a get request
    header("Location: loginpage.php");
} ?>