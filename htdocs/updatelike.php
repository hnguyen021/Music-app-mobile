<?php
	require"conn.php";
	$idbaihat = $_POST['idbaihat'];
	$luotthich =$_POST['luotthich'];
	$query ="SELECT LuotThich FROM `baihat` WHERE IdBaiHat ='$idbaihat'";
	$dataluotthich = mysqli_query($conn,$query);
	$row = mysqli_fetch_assoc($dataluotthich);
	$sumLuotThich =$row['LuotThich'];
	if(isset($luotthich)){
		$sumLuotThich = $sumLuotThich + $luotthich;
		$queryUpdate ="UPDATE `baihat` SET LuotThich ='$sumLuotThich' WHERE idBaiHat ='$idbaihat'";
		$result=mysqli_query($conn,$queryUpdate);
		if($result){
			echo "Update Success";
		}
		else{
			echo "Update Fail";
		}
		
	}
?>