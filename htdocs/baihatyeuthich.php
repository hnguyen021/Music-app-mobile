<?php
	require"conn.php";
	$query ="SELECT * FROM baihat ORDER BY RAND() LIMIT 5";
	$data = mysqli_query($conn,$query);
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
		$mangbaihatyeuthich =array();
		while($row = mysqli_fetch_assoc($data)){
			array_push($mangbaihatyeuthich,new BaiHat(   $row["idBaiHat"]
														,$row["TenBaiHat"]
														,$row["HinhBaiHat"]
														,$row["CaSi"]
														,$row["LinkBaiHat"]
														,$row["LuotThich"]));
												  
			}
	echo json_encode($mangbaihatyeuthich);
?>
