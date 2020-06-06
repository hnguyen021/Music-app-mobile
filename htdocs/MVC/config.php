<?php
    
    /*define('HOST','localhost:8888');
    define('USER','root');
    define('PASS','');
    define('DB','mvc');
    class DB{
        
        private static $conn ;
        public static function GetConnection(){
            if(self::$conn == null){
                self::$conn = new PDO("mysql:host=".HOST.",dbname=".DB,USER,PASS);
                self::$conn->setAttribute(PDO::ATTR_ERRMODE,PDO::ERRMODE_EXCEPTION);
            }
            return self::$conn;
        }
    }
    
   */ 


// Create connection


	
	
	
	
class DB{

    public  function GetConnection(){
      $servername = "localhost";
      $username = "root";
      $password = "";  
      $db = 'db_book';
        $conn = new mysqli($servername, $username, $password, $db);
        mysqli_query($conn,"SET NAMES 'utf8'");
        return $conn;
    }
}
	
	
?>