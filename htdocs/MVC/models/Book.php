<?php
 require_once("C:/xampp/htdocs/MVC/config.php");
    class Book{

        public $idsach;
        public $tensach;
        public $hinhsach;
        public $motasach;
        public $tacgiasach;
        public $idtheloai;
        public $namxuatban;
        public $idquocgia;
        public $luotmua;
        public $giasach;
        public function __construct($idsach,$tensach,$hinhsach,$motasach,$tacgiasach,$idtheloai,$namxuatban,$idquocgia,$luotmua,$giasach){            
            $this->idsach     =$idsach;
            $this->tensach    =$tensach ;
            $this->hinhsach   =$hinhsach;
            $this->motasach   =$motasach;
            $this->tacgiasach =$tacgiasach;
            $this->idtheloai  =$idtheloai;
            $this->namxuatban =$namxuatban;
            $this->idquocgia  =$idquocgia;
            $this->luotmua    =$luotmua;
            $this->giasach    =$giasach;
        }
        public static function GetAll(){
            $sql ="select * from book";
            $conn =DB::GetConnection();
           // $stms=$conn->query($sql);
           $stms = mysqli_query($conn,$sql);  
            $data = array();
           // $row = mysqli_fetch_assoc($data)
            
            while($row = mysqli_fetch_assoc($stms)){
                array_push($data, new Book(       $row['idsach']
                                                 ,$row['tensach']
                                                 ,$row['hinhsach']
                                                 ,$row['motasach']
                                                 ,$row['tacgiasach']
                                                 ,$row['idtheloai']
                                                 ,$row['namxuatban']
                                                 ,$row['idquocgia']
                                                 ,$row['luotmua']
                                                 ,$row['giasach']));
                                                      
                }
            return $data;

        }
        public static function GetLatest($num){
            $sql ="SELECT * FROM book ORDER BY idsach DESC LIMIT $num";
            $conn =DB::GetConnection();
           // $stms=$conn->query($sql);
           $stms = mysqli_query($conn,$sql);  
            $data = array();
           // $row = mysqli_fetch_assoc($data)
            
            while($row = mysqli_fetch_assoc($stms)){
                array_push($data, new Book(       $row['idsach']
                                                 ,$row['tensach']
                                                 ,$row['hinhsach']
                                                 ,$row['motasach']
                                                 ,$row['tacgiasach']
                                                 ,$row['idtheloai']
                                                 ,$row['namxuatban']
                                                 ,$row['idquocgia']
                                                 ,$row['luotmua']
                                                 ,$row['giasach']));
                                                      
                }
            return $data;

        }
        public static function GetHottest($num){
            $sql ="SELECT * FROM book ORDER BY luotmua DESC LIMIT $num";
            $conn =DB::GetConnection();
           // $stms=$conn->query($sql);
           $stms = mysqli_query($conn,$sql);  
            $data = array();
           // $row = mysqli_fetch_assoc($data)
            
            while($row = mysqli_fetch_assoc($stms)){
                array_push($data, new Book(       $row['idsach']
                                                 ,$row['tensach']
                                                 ,$row['hinhsach']
                                                 ,$row['motasach']
                                                 ,$row['tacgiasach']
                                                 ,$row['idtheloai']
                                                 ,$row['namxuatban']
                                                 ,$row['idquocgia']
                                                 ,$row['luotmua']
                                                 ,$row['giasach']));
                                                      
                }
            return $data;

        }
        public static function GetByCategory($id,$limit=''){
            $sql ="SELECT * FROM book where idtheloai = $id LIMIT $limit";
            $conn =DB::GetConnection();
           // $stms=$conn->query($sql);
           $stms = mysqli_query($conn,$sql);  
            $data = array();
           // $row = mysqli_fetch_assoc($data)
            
            while($row = mysqli_fetch_assoc($stms)){
                array_push($data, new Book(       $row['idsach']
                                                 ,$row['tensach']
                                                 ,$row['hinhsach']
                                                 ,$row['motasach']
                                                 ,$row['tacgiasach']
                                                 ,$row['idtheloai']
                                                 ,$row['namxuatban']
                                                 ,$row['idquocgia']
                                                 ,$row['luotmua']
                                                 ,$row['giasach']));
                                                      
                }
            return $data;

        }
    }
?>