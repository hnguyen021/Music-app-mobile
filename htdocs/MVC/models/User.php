<?php
 require_once("C:/xampp/htdocs/MVC/config.php");
    class User{

        public $iduser;
        public $tenuser;
        public $taikhoanuser;
        public $password;       
        public function __construct($iduser,$tenuser,$taikhoanuser,$password){            
            $this->iduser     =$iduser;
            $this->tenuser     =$tenuser;
            $this->taikhoanuser  =$taikhoanuser ;
            $this->password   =$password;
            
        }
        public static function GetAll(){
            $sql ="select * from user";
            $conn =DB::GetConnection();
           // $stms=$conn->query($sql);
           $stms = mysqli_query($conn,$sql);  
            $data = array();
           // $row = mysqli_fetch_assoc($data)
            
            while($row = mysqli_fetch_assoc($stms)){
                array_push($data, new User(       $row['iduser']
                                                 ,$row['tenuser']
                                                 ,$row['taikhoanuser']
                                                 ,$row['password'] ));
                                                      
                }
            return $data;

        }
        public static function login($username,$password){
            $sql ="select * from user where taikhoanuser ='$username' and password ='$password'";
            $conn =DB::GetConnection();
            $stms = mysqli_query($conn,$sql);
           // $r =mysqli_num_rows($stms); 
             
            if ( mysqli_num_rows($stms) == 0) {
                return null;
            }
            else{
                $acount = array();
                while($row = mysqli_fetch_assoc($stms)){
                    array_push($acount, new User(     $row['iduser']
                                                     ,$row['tenuser']
                                                     ,$row['taikhoanuser']
                                                     ,$row['password'] ));
                                                          
                    }
                    
                return $acount;
                
            }
        }
    }
        
  ?>  
