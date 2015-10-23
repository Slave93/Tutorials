<?php
require_once(__DIR__."/PDOConnection.php");
/**
 * Created by PhpStorm.
 * User: slavko
 * Date: 23.10.15.
 * Time: 22.00
 */

class ConnectionManager
{
    static function getConnection($hostName,$dbName,$userName,$password){
        return new PDOConnection($hostName,$dbName,$userName,$password);
    }
}