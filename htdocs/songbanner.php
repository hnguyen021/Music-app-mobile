<?php
	require "conn.php";
	$query ="SELECT quangcao.idQuangCao,quangcao.HinhAnhQC,quangcao.NoiDungQC,quangcao.idBaiHat,baihat.TenBaiHat,baihat.HinhBaiHat 
			 FROM `baihat` ,`quangcao`
			 WHERE quangcao.idQuangCao = baihat.idBaiHat";
	$data = mysqli_query($conn,$query);
	class QuangCao{
		function QuangCao($idquangcao,$hinhanh,$noidung,$idbaihat,$tenbaihat,$hinhbaihat){
			$this->IdQuangCao = $idquangcao;
			$this->HinhAnhQC  = $hinhanh;
			$this->NoiDungQC  = $noidung;
			$this->IdBaiHat   = $idbaihat;
			$this->TenBaiHat  = $tenbaihat;
			$this->HinhBaiHat = $hinhbaihat;
		
		}
	}
		$mangquangcao =array();
		while($row = mysqli_fetch_assoc($data)){
			array_push($mangquangcao,new QuangCao( $row["idQuangCao"]
												  ,$row["HinhAnhQC"]
												  ,$row["NoiDungQC"]
												  ,$row["idBaiHat"]
												  ,$row["TenBaiHat"]
												  ,$row["HinhBaiHat"]));
												  
			}
	echo json_encode($mangquangcao);
	
	
?>