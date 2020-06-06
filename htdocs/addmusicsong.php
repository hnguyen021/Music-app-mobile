<?php
	include('conn.php');
//<ipput ttype name="hihihi">
	$namesong = $_POST['namesong'];
	//echo $name;
	$casi = $_POST['casi'];
	
	//echo $idtheloai;
	$targetimage = "upload/".$_FILES['fileUploadImage']['name'];// lay duong dan 
//	echo $targetimage ;
	move_uploaded_file($_FILES['fileUploadImage']['tmp_name'], $targetimage);
	
	$targetmusic ="upload/".$_FILES['fileUploadMusic']['name'];
	move_uploaded_file($_FILES['fileUploadMusic']['tmp_name'],$targetmusic);
	$idtheloai=$_POST['idtheloai'];
	

	$idplaylist =$_POST['idplaylist'];
	$idalbum =$_POST['idalbum'];
	
	$sql = "INSERT INTO baihat(idAlbum,idTheLoai,idPlayList,TenBaiHat,HinhBaiHat,CaSi,LinkBaiHat) VALUES(?, ?, ?, ?,?,?,?)";
	
	$stmt = $conn->prepare($sql);
	$stmt->bind_param("iiissss", $idalbum,$idtheloai, $idplaylist,$namesong,$targetimage,$casi,$targetmusic);
	
	$isOK = $stmt->execute();
	
	$stmt->close();
	$conn->close();
?>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		<link rel="icon" href="../../../../favicon.ico">

		<title>Add product example</title>

		<!-- Bootstrap core CSS -->
		<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="container">
		  <div class="py-5 text-center">
			<img class="d-block mx-auto mb-4" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
			<?php if ($isOK) { ?>
			<div class="alert alert-success">
				Product added successfully. <br>
				Please <a href="addform.php">click here</a> to add more.
			</div>
			<?php } else {?>
			<div class="alert alert-danger">
				Failed to add product.
			</div>
			<?php } ?>
		  </div>
		</div>
	</body>
</html>