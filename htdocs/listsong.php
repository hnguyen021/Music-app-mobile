<?php
	require"conn.php";
	class BaiHat{
		function BaiHat($idbaihat,$tenbaihat,$hinhbaihat,$casi,$linkbaihat,$luotthich){
			$this->idBaiHat   = $idbaihat;
			$this->TenBaiHat  = $tenbaihat;
			$this->HinhBaiHat = $hinhbaihat;
			$this->CaSi   	  = $casi;
			$this->LinkBaiHat = $linkbaihat;
			$this->LuotThich  = $luotthich; 
		}
	}
	$arrlistsong = array();
	if(isset($_POST['idplaylist'])){
		$idplaylist    =$_POST['idplaylist'];
		$queryplaylist ="SELECT * FROM `playlist` WHERE idPlayList ='$idplaylist'";
		$dataplaylist  = mysqli_query($conn,$queryplaylist);
		$rowplaylist   =mysqli_fetch_assoc($dataplaylist);
		$tempId   	   = $rowplaylist['idPlayList'];
		$query 		   ="SELECT * FROM `baihat` WHERE idPlayList ='$tempId'";
	}
	if(isset($_POST['idAlbum'])){
		$idalbum    =$_POST['idAlbum'];
		$queryalbum ="SELECT * FROM `album` WHERE idAlbum ='$idalbum'";
		$dataalbum  = mysqli_query($conn,$queryalbum);
		$rowalbum   =mysqli_fetch_assoc($dataalbum);
		$tempId   	   = $rowalbum['idAlbum'];
		$query 		   ="SELECT * FROM `baihat`` WHERE idAlbum ='$tempId'";
	}
	if(isset($_POST['idquangcao'])){
		$idquangcao =$_POST['idquangcao'];
		$query_quangcao="SELECT * FROM `quangcao`WHERE idQuangCao ='$idquangcao'";
		$dataquangcao = mysqli_query($conn,$query_quangcao);
		$rowquangcao =mysqli_fetch_assoc($dataquangcao);
		//echo $rowquangcao;
		$id = $rowquangcao['idQuangCao'];
		//echo $id;
		$query = "SELECT * FROM `baihat` WHERE IdBaiHat ='$id'";
	}
	$data = mysqli_query($conn,$query);
	while($row = mysqli_fetch_assoc($data)){
			array_push($arrlistsong,new BaiHat(  $row["idBaiHat"]
												,$row["TenBaiHat"]
												,$row["HinhBaiHat"]
												,$row["CaSi"]
												,$row["LinkBaiHat"]
												,$row["LuotThich"]));}
	echo json_encode($arrlistsong);										
	
?>