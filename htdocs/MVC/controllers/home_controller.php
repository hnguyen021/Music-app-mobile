<?php
require_once("controllers/base_controller.php");
require_once("models/User.php");
class HomeController extends BaseController{
    function __construct(){
        $this->name ="home";
    }
    public function index(){
       // ob_start();       
       // require_once("views/".$this->name."/slider.php");
      //  $content_slider =  ob_get_clean();
      //  $categories = Categories::getAll();  
      //  $book = Book::getAll();
        BaseController::render("content",array());
        //ob_start();
      //  require_once("views/".$this->name."/content.php");
       // $content_main = ob_get_clean(); 
        //require_once("views/layout/template.php"); 
    }
    public function login(){
        if(isLoggedIn()){
            redirect('?controller=home&action=index');
        }
        else{
            BaseController::render("login",array(),"template_2");
        }
         
            
    }
    public function logout(){
        unset($_SESSION['user']);
        redirect('?controller=home&action=login');
    }
    public function logined(){
       
            $user = filter_input(INPUT_POST,'username',FILTER_SANITIZE_STRING);
            $pass = filter_input(INPUT_POST,'password',FILTER_SANITIZE_STRING);
            if(empty($user)||empty($pass)){
                redirect('?controller=home&action=login',"Your PassWord or UserName is not Valid");
            }else{
                $acount=User::login($user,$pass);
                
                if($acount != null){
                    $_SESSION['user'] =$acount;
                    redirect('?controller=home&action=index');
                }
                else{
                    redirect('?controller=home&action=login',"Your PassWord or UserName is not Valid");
                }
            
        } 
        
        

    }
    public function error(){
        ob_start();
        require_once("views/layout/error.php");

        $content_main =ob_get_clean();

        require_once("views/layout/template.php");
    }

    
}
?>