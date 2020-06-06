<?php
    
    function redirect($url,$message=""){
        if($message){
            set_message($message);
        }
        header("Location:$url");

    }
    function set_message($message){
        $_SESSION['one-time-message'] =$message;
    }
    function get_message(){
       if($_SESSION['one-time-message']){
           $value = $_SESSION['one-time-message'];
           unset($_SESSION['one-time-message']);
           return $value;
       }
       else{
           return null;
       }
    }
     function isLoggedIn(){
       return isset($_SESSION['user']);
    }

?>