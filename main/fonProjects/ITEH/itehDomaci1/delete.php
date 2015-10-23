<?php
/**
 * Created by PhpStorm.
 * User: SlavkoiDragana
 * Date: 27.4.15.
 * Time: 15.06
 */
require_once("/DatabaseManager.php");
require_once("/functions.php");
session_start();
//ONLY ADMINS(CHECK IF THE USER IS LOGGED IN)
if(isset($_SESSION["Username"])){

    if(isset($_GET['id'])){
        $id = $_GET['id'];
        DatabaseManager::deleteOrder($id);
        header('Location:loggedin.php');
    }else{
        //this must be a get request
        header('Location:loggedin.php');// loggedin.php će ga poslati na login page ako nije uligovan!
    }
}else
{ // This must be a get request
    header("Location: loginpage.php");
}
?>




