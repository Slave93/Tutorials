<?php

/**
 * Created by PhpStorm.
 * User: slavko
 * Date: 23.10.15.
 * Time: 22.43
 */
abstract class AbstractConnection
{
    protected $hostName,$dbName,$userName,$password;
    protected $connection = null;

    public function __construct($hostName,$dbName,$userName,$password) {
        $this->hostName = $hostName;
        $this->dbName = $dbName;
        $this->userName = $userName;
        $this->password = $password;
    }

    abstract public function open();
    abstract  public function close();
    abstract public function query($sql);
}