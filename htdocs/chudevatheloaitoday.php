<?php
	require"conn.php";
	class TheLoai{
		function TheLoai($idtheloai,$idchude,$tentheloai,$hinhtheloai){
			$this->idTheLoai 	= $idtheloai;
			$this->idChuDe  	= $idchude;
			$this->TenTheLoai  	= $tentheloai;
			$this->HinhTheLoai 	= $hinhtheloai;	
			
		}
	}
	class ChuDe{
		function ChuDe($idchude,$tenchude,$hinhchude){
			$this->idChuDe  	= $idchude;
			$this->TenChuDe	  	= $tenchude;
			$this->HinhChuDe 	= $hinhchude;	
			
		}
	}
	$arraytheloai = array();
	$arraychude   = array();
	$querytheloai ="SELECT * FROM  `theloai` LIMIT 4";
	$datatheloai = mysqli_query($conn,$querytheloai);
	while($row = mysqli_fetch_assoc($datatheloai)){
			array_push($arraytheloai,new TheLoai( $row["idTheLoai"]
												 ,$row["idChuDe"]
												 ,$row["TenTheLoai"]
												 ,$row["HinhTheLoai"]));
												  
			}
	
	$querychude ="SELECT * FROM  `chude` LIMIT 4";
	$datachude = mysqli_query($conn,$querychude);
	
	while($row = mysqli_fetch_assoc($datachude)){
			array_push($arraychude,new ChuDe( $row["idChuDe"]
											 ,$row["TenChuDe"]
											 ,$row["HinhChuDe"]));																						  
			}
	$arraychude_theloai =array('TheLoai'=>$arraytheloai,'ChuDe'=>$arraychude);
	echo json_encode($arraychude_theloai);
	
?>