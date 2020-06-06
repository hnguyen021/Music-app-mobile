<?php
require "conn.php";
//$query ="SELECT DISTINCT * FROM playlist ORDER BY rand(" . date("Ymd") . ")LIMIT 3";
	$query ="SELECT * FROM `playlist`";
	$data = mysqli_query($conn,$query);
	class PlayListToDay{
		function PlayListToDay($idplaylist,$tenplaylist,$hinhnen,$iconplaylist){
			$this->idPlayList 	= $idplaylist;
			$this->TenPlayList  = $tenplaylist;
			$this->HinhNen  	= $hinhnen;
			$this->IconPlayList = $iconplaylist;		
		}
	}
		$playlistfortoday =array();
		while($row = mysqli_fetch_assoc($data)){
			array_push($playlistfortoday,new PlayListToDay( $row["idPlayList"]
														   ,$row["TenPlayList"]
														   ,$row["HinhNen"]
														   ,$row["IconPlayList"]));
												  
			}
	echo json_encode($playlistfortoday);
?>