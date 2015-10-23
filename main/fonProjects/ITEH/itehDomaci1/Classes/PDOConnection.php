<?php

/**
 * Created by PhpStorm.
 * User: slavko
 * Date: 23.10.15.
 * Time: 22.10
 */
class PDOConnection extends AbstractConnection
{
    public function __construct($hostName,$dbName,$userName,$password) {
        parent::__construct($hostName,$dbName,$userName,$password);
    }

    public function open()    {
        if($this->connection==null){
            $dsn = 'mysql:host='.$this->hostName.';dbname='.$this->dbName;
            $this->connection = new PDO($dsn,$this->userName,$this->password);
        }
    }
    public function close() {
        $this->connection=null;
    }

    public function query($sql) {
        return $this->connection->query($sql);
    }
}