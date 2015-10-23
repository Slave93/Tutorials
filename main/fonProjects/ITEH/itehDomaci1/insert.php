<?php
/**
 * Created by PhpStorm.
 * User: SlavkoiDragana
 * Date: 27.4.15.
 * Time: 21.22
 */
require_once("/DatabaseManager.php");
require_once("/functions.php");
session_start();
//ONLY ADMINS(CHECK IF THE USER IS LOGGED IN)!
if(isset($_SESSION["Username"])){ ?>
    <?php
        if(isset($_POST['submit'])){
            $errors = array();
            $name = $_POST['name'];
            if(strlen($name)==0){
                $errors['name'] = 'Name can\'t be blank!';
            }elseif(strlen($name)>=150){
                $errors['name']='Name is too long!';
            }
            $price = $_POST['price'];
            if(!(is_numeric($price))){
                $errors['price'] = 'Price must be numeric!';
            }
            $description = $_POST['description'];
            $quantity = $_POST['quantity'];
            if(strlen($quantity)==0){
                $errors['quantity'] = 'Quantity can\'t be blank!';
            }elseif(strlen($quantity)>=10){
                $errors['quantity'] = 'Quantity too long!';
            }
            if((empty($errors))){
            DatabaseManager::insertOrder($name,$description,$price,$quantity);
            header('Location:login.php');
            }


        }
    ?>
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="utf-8">
        <title>Insert order</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    </head>
    <body>
    <div class="container" style="margin-top:200px">
        <h1>Insert order</h1>
        <?php if(!(empty($errors))){
            foreach($errors as $error){
                echo "<h4  style='color: red'>". $error."</h4>";
            }
        }?>
        <form class="form-inline" action="insert.php" method="post">
            <div class="form-group">
           <label> Name: </label> <input type="text" name="name">
                <label> Price: </label> <input type="text" name="price">
                <label> Description: </label> <input type="text" name="description">
                <label> Quantity: </label> <input type="text" name="quantity">
           <input type="submit" name="submit" value="submit">
            </div>
        </form>

        <a href='loggedin.php'> <h1>Cancel</h1> </a>
    </div>


    </body>
    </html>



<?php }  else{ // This must be a get request
    header("Location: login.php");
} ?>