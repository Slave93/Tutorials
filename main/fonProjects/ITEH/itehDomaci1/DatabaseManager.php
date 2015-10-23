<?php
/**
 * Created by PhpStorm.
 * User: SlavkoiDragana
 * Date: 27.4.15.
 * Time: 11.00
 */



class DatabaseManager {

    private static $greeting = 'Hello';
    private static $initialized = false;
    public static $db;

    public static function initialize()
    {
        if (self::$initialized)
            return;
        global $db;
        $dsn = 'mysql:host=localhost;dbname=Zadatak5';
        $db = new PDO($dsn,'root','ol93om');
        self::$initialized = true;
    }

    public static function showOrders($admin)
    {
    self::initialize();
    global $db;
    $sql = "SELECT * FROM orders";
    $result = $db->query($sql);

    echo "<table border='2'>
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Description</th>
            <th>Quantity</th>";
        if($admin){echo "<th>Delete</th>";}
        echo "</tr>";

    while($row = $result->fetch()){
        echo "<tr>
            <td>".$row['name']. "</td>
            <td>".$row['price']."</td>
            <td>".$row['description']."</td>
            <td>".$row['quantity']."</td>";
            if($admin){echo "<td><a". " onclick='return confirm( \"Are you sure you want to delete this order?\" );' " ."href='delete.php?id=".$row['id']."'>Delete order</a> </td>" ;}
        echo "</tr>";
    }
    if($admin) {echo " </table> <a href='insert.php'>Insert order</a><br>";} else{ echo " </table> <h1><a href='loginpage.php'> Login </a></h1>";}


    }

    public static function deleteOrder($id){
        self::initialize();
        global $db;
        $sql = "DELETE FROM orders WHERE id=?";
        $stmt = $db->prepare($sql);
        $stmt->bindParam(1,$id,PDO::PARAM_INT);
        $stmt->execute();
    }

    public static function insertOrder($name,$description,$price,$quantity){
        self::initialize();
        global $db;
        $sql = "INSERT INTO orders(name,description,price,quantity) values(?,?,?,?)";
        $stmt = $db->prepare($sql);
        $stmt->bindParam(1,$name,PDO::PARAM_STR);
        $stmt->bindParam(2,$description, PDO::PARAM_STR);
        $stmt->bindParam(3,$price,PDO::PARAM_INT);
        $stmt->bindParam(4,$quantity, PDO::PARAM_STR);
        $stmt->execute();

    }


} 