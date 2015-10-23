<?php

 function login_redirect(){
     global $username;
     if(!$username){
         setcookie("UserTry","EmptyUser",time()+60);
        }else{
         setcookie("UserTry",$username,time()+60);
        }
     //echo "<script>setTimeout(\"location.href = 'login.php';\",4500);</script>"; //JavaScript redirection
     header('Location:loginpage.php'); //Refresh: 1;
 }


