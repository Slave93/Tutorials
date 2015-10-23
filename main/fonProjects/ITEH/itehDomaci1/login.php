<?php
require_once("/functions.php");
require_once("/DatabaseManager.php");
session_start();

if(isset($_POST["submit"])){
    $username = "";
    $password = "";

    if(isset($_POST["username"])){
        $username = $_POST["username"];
    }
    if(isset($_POST["password"])){
        $password = $_POST["password"];
    }

    DatabaseManager::initialize();
    $sql = "SELECT hashedpassword FROM users WHERE username='$username'";
    $result = $db->query($sql);
    $row = $result->fetch();
    if(!$row){
        //username does not exist in database
        login_redirect();
    }else{
        if(password_verify($password,$row['hashedpassword'])){
            $_SESSION["Username"] = $username;
            header("Location: loggedin.php");
        }else{ // failed pass
            login_redirect();
        }
    }












}else{ // This must be a get request...
    header("Location: loginpage.php");
}

