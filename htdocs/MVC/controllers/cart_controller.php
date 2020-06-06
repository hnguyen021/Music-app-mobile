<?php
require_once("controllers/base_controller.php");
class CartController extends BaseController{
    function __construct(){
        $this->name ="cart";
    }
    public function index(){
        echo "index page for Cart";
    }
    
}
?>