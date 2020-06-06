<?php
session_start();
if (!isset($_SESSION['adminname']) || $_SESSION['adminname'] != true)
{
	header("Location: dangnhapforadmin.php");
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<table cellpadding="10" cellspacing="10" border="0" style="border-collapse: collapse; margin: auto">

    <tr class="control" style="text-align: left; font-weight: bold; font-size: 20px">
        <td colspan="4">
            <a href="addform.php">Thêm sản phẩm</a>
        </td>
		<td><?php
		echo'
			<p align="center">'.$_SESSION['adminname'].'</p>
			<a class="dropdown-item" href="logout.php">LogOut</a>';
		?>
			
		</td>
    </tr>
    <tr class="header">
		<td>Id Bài Hát</td>
        <td>Tên Bài Hát</td>
        <td>Hình Ảnh</td>
        <td>Ca Sĩ</td>
        <td>Link Bai Hat</td>
        
        <td>Thể Loại</td>
        <td>Album</td>       
        <td>PlayList </td>
		
		
    </tr>
	<?php 
	require_once('conn.php');
		  
		 // $sql = "SELECT idphim, tenphim, mota,hinhanh FROM phim";
		 $sql="SELECT idBaiHat,TenBaiHat,HinhBaiHat,CaSi,LinkBaiHat,TenTheLoai,TenAlbum,TenPlayList 
		 FROM baihat,playlist,album,theloai 
		 WHERE baihat.idTheLoai =theloai.idTheLoai and playlist.idPlayList=baihat.idPlayList and album.idAlbum =baihat.idAlbum";
		  
		  $result = $conn->query($sql);
		  if ($result->num_rows > 0) {
			  while ($row = $result->fetch_assoc()) {
	?>
    <tr class="item">
        
        <td><?= $row['idBaiHat']?></td>
        <td><?= $row['TenBaiHat']?> </td>
        <td><img src="<?= $row['HinhBaiHat']?>" style="max-height: 80px"></td>
        <td><?= $row['CaSi']?></td>
        <td><?= $row['LinkBaiHat']?></td>
        <td><?= $row['TenTheLoai']?></td>
        <td><?= $row['TenAlbum']?></td>
		<td><?= $row['TenPlayList']?></td>
		
        <td><a href="updatephim.php?id=<?= $row['idBaiHat']?>">Edit</a> | <a href="delete.php?id=<?= $row['idBaiHat']?>" target="_blank">Delete</a></td>
    </tr>
	<?php }
    } ?>
    <tr class="control" style="text-align: right; font-weight: bold; font-size: 17px">
        <td colspan="5">
            <p>Số lượng Bài Hát: <?= $result->num_rows ?></p>
        </td>
    </tr>
</table>

</body>
</html>