
<?php
    require_once("C:/xampp/htdocs/MVC/config.php");
    class Categories{
        public $idtheloai;
        public $tentheloai;
        
        public function __construct($id,$name){
            $this->idtheloai =$id;
            $this->tentheloai =$name;
        }
        public static function GetAll(){
            $sql ="select * from theloai";
            $conn =DB::GetConnection();
           // $stms=$conn->query($sql);
           $stms = mysqli_query($conn,$sql);  
            $data = array();
           // $row = mysqli_fetch_assoc($data)
            
            while($row = mysqli_fetch_assoc($stms)){
                array_push($data, new Categories($row['idtheloai'],$row['tentheloai']));
                                                      
                }
            return $data;

        }
    }
?>