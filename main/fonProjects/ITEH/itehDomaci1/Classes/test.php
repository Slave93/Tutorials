<?php
require_once(__DIR__."/TestDAO.php");

/**
 * Created by PhpStorm.
 * User: slavko
 * Date: 23.10.15.
 * Time: 23.01
 */

echo "we are the champions";
$testDAO = new TestDAO();
$testDAO->insertIntoTest();