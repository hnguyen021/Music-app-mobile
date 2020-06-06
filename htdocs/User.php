<?php
	require"conn.php";
	$query ="SELECT * FROM  `user`";
	$data = mysqli_query($conn,$query);
	class User{
		function User($idUser,$TenUser,$PassWord,$idBaiHat,$idComMent){
			$this->idUser 	= $idUser;
			$this->TenUser 	= $TenUser;
			$this->PassWord = $PassWord;
			$this->idBaiHat = $idBaiHat;
			$this->idComMent = $idComMent;
					
		}
	}
		$arruser =array();
		while($row = mysqli_fetch_assoc($data)){
			array_push($arruser,new User( 	$row["idUser"]
											 ,$row["TenUser"]
											 ,$row["PassWord"]
											 ,$row["idBaiHat"]	
											 ,$row["idComMent"]));
											 	  
			}
	echo json_encode($arruser);
?>	