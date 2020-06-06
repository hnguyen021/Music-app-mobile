<!doctype html>
<?php
session_start();
if (!isset($_SESSION['adminname']) || $_SESSION['adminname'] != true)
{
	header("Location: dangnhapforadmin.php");
}
?>
<html lang="en">
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

  <body class="bg-light">

    <div class="container">
      <div class="py-5 text-center">
        <img class="d-block mx-auto mb-4" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72">
        <h2>Add Music</h2>
      </div>

      <div class="row">
        <div class="col-md order-md-1">
          <form action="addmusicsong.php" method="POST" enctype="multipart/form-data">

            <div class="mb-3">
              <label for="namesong">Tên Bài Hát</label>
              <div class="input-group">
                <input type="text" class="form-control" id="namesong" name="namesong" required>
              </div>
            </div>
			
			<div class="mb-3">
              <label for="casi">Ca Sĩ</label>
              <div class="input-group">
                <input type="text" class="form-control"  name="casi" required>
              </div>
            </div>
			
			
			
			
			<div class="mb-3">
              <label for="fileUploadImage">Image</label>
              <div class="input-group">
                <input type="file" id="fileUploadImage" name="fileUploadImage" required>
              </div>
            </div>
			<div class="mb-3">
              <label for="fileUploadMusic">Link Music</label>
              <div class="input-group">
                <input type="file" id="fileUploadMusic" name="fileUploadMusic" required>
              </div>
            </div>
			
				
			
			
			
			
	<div class="dropdown">
		<select name="idtheloai" id="idtheloai">
		<option value="1">V-POP: Những Bản Hits Quốc Dân</option>
		<option value="2">EDM</option>
		<option value="3">Acoustic Hàn Quốc</option>
		<option value="4">Acoustic Nước Ngoài</option>	
		<option value="5">Acoustic Việt Nam</option>	
		<option value="6">Nhạc Không Lời EDM</option>	

		</select>
	</div>
	<div></br></div>
	<div class="dropdown">
		<select name="idplaylist" id="idplaylist">
		<option value="1">Top 100 Việt Nam</option>
		<option value="2">Top 100 Nhạc V-Pop Hay Nhất</option>
		<option value="3">Top 100 Nhạc Rock Âu Mỹ Hay Nhất</option>
		<option value="4">Top 100 Nhạc Trữ Tình Hay Nhất</option>
		</select>
	</div>
	<div></br></div>
	<div class="dropdown">
		<select name="idalbum" id="idalbum">
		<option value="1">Lá Xa Lìa Cành (Single)</option>
		<option value="2">Cõi Nhớ</option>
		<option value="3">Hồng Nhan Bạc Phận</option>
		<option value="4">Em Ơi Lên Phố</option>
		</select>
	</div>
	
			
			
            <hr class="mb-4"><br>
            <button class="btn btn-primary btn-lg btn-block" type="submit" name="submit">Add</button>
          </form>
        </div>
      </div>

      <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2017-2018 Company Name</p>
        <ul class="list-inline">
          <li class="list-inline-item"><a href="#">Privacy</a></li>
          <li class="list-inline-item"><a href="#">Terms</a></li>
          <li class="list-inline-item"><a href="#">Support</a></li>
        </ul>
      </footer>
    </div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>