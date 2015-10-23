<?php
session_start();
if(isset($_SESSION["Username"])){
$_SESSION = array();
if(isset($_COOKIE[session_name()])){
    setcookie(session_name(), '', time()-42000, '/');
} // session_name() is SESID
session_destroy();
header("Location: index.php");
}else{ // This must be a get request
    header("Location: login.php");
}
?>