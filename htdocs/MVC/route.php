<?php
    $supported_controller = array(
        "home"=>array("index","error","login","logined","logout"),
        "cart"=>array("index"),
        "book"=>array("category","country")
        
        
    );
    if(!array_key_exists($controller,$supported_controller)||!in_array($action,$supported_controller[$controller])){
        $controller ="home";
        $action ="error";
    }
    require_once("controllers/".$controller."_controller.php");
    $className = ucfirst($controller)."Controller";
    

    $obj= new $className();
    $obj->$action();


?>
