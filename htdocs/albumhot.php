<?php
	require"conn.php";
	$query ="SELECT * FROM  `album` LIMIT 4";
	$data = mysqli_query($conn,$query);
	class Album{
		function Album($idalbum,$tenalbum,$tencasialbum,$hinhalbum){
			$this->idAlbum 		= $idalbum;
			$this->TenAlbum  	= $tenalbum;
			$this->TenCaSiAlbum = $tencasialbum;
			$this->HinhAlbum 	= $hinhalbum;		
		}
	}
		$albumhot =array();
		while($row = mysqli_fetch_assoc($data)){
			array_push($albumhot,new Album( $row["idAlbum"]
											 ,$row["TenAlbum"]
											 ,$row["TenCaSiAlbum"]
											 ,$row["HinhAlbum"]));
												  
			}
	echo json_encode($albumhot);
?>