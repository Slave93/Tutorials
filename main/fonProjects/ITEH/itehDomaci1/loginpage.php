<?php
require_once("/DatabaseManager.php");
session_start();
if(isset($_SESSION["Username"])){
    header("Location: loggedin.php");
}else{
    $UserTry = "";
    $message = "";
    if(isset($_COOKIE["UserTry"])){
        $message =  "Wrong Username or Password.";
        $UserTry = $_COOKIE["UserTry"];
        if($UserTry=="EmptyUser"){
            $UserTry = "";
        }
        setcookie("UserTry",null,time()-3600);
    }
?>
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="utf-8">
        <title>Login page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    </head>
    <body>
    <div class="container" style="margin-top:200px">
        <h1>Please enter your username and password</h1>
        <h4 style="color: red">   <?php echo $message; ?> </h4>
        <form action='login.php' method='post' >

            Username: <input type="text" name="username" value=<?php echo $UserTry; ?>>
            Password   <input type="password" name='password' value=''>
            <button type="submit" value="submit" name="submit"">Submit</button>
        </form>
    </div>
    </body>
    </html>

<?php } ?>


