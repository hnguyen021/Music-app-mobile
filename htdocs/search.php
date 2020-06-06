<?php
	require "conn.php";
	
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
	$arrsongsearch =array();
	if(isset($_POST['keyword'])){
		$keyword = $_POST['keyword'];
		$query ="SELECT *FROM `baihat` WHERE lower(TenBaiHat) LIKE '%$keyword%'";
		$data = mysqli_query($conn,$query);
		
		while($row = mysqli_fetch_assoc($data)){
			array_push($arrsongsearch,new BaiHat(  	 $row["idBaiHat"]
													,$row["TenBaiHat"]
													,$row["HinhBaiHat"]
													,$row["CaSi"]
													,$row["LinkBaiHat"]
													,$row["LuotThich"]));
		}
		echo json_encode($arrsongsearch);
	}
		
												  
			
	
?>