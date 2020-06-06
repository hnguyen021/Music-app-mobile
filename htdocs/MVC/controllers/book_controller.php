<?php
require_once("controllers/base_controller.php");
require_once("models/User.php");
class BookController extends BaseController{
    function __construct(){
        $this->name ="book";
    }
    
    public function category(){
        $id = filter_input(INPUT_GET,'id',FILTER_SANITIZE_STRING);
        if(empty($id)|| !is_numeric($id)){
           // echo "id k hop le";
            exit();
        }

            $books = Book::GetByCategory($id,'8');
            BaseController::render("category",array('books'=>$books),"template");
        
         
            
    }
   

}   

?>