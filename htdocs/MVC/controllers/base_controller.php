<?php
    require_once("models/Categories.php");
    require_once("models/Book.php");
    class BaseController{
        protected $name;
        public function render($view,$data = array(),$template="template"){
            $book = Book::GetLatest(5);
            $hot_book =Book::GetHottest(5);
            $categories = Categories::getAll();  
            ob_start();
            extract($data);
            require_once("views/".$this->name."/".$view.".php");
            $content_main =  ob_get_clean();
            require_once("views/layout/".$template.".php"); 
        }
    }
?>