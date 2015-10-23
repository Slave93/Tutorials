<?php
require_once(__DIR__."/ConnectionManager.php");
/**
 * Created by PhpStorm.
 * User: slavko
 * Date: 23.10.15.
 * Time: 22.52
 */


class TestDAO{

    public function insertIntoTest(){
        $connection = ConnectionManager::getConnection('localhost','itehDomaci','sourcecode'.'root');
        $connection->query("insert into test values(3,'PHP insert works'')");
        $connection->close();
    }
}