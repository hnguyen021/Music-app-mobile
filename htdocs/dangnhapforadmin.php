
<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style>
		form {
  border: 3px solid #f1f1f1;
}

/* Full-width inputs */
input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

/* Set a style for all buttons */
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

/* Add a hover effect for buttons */
button:hover {
  opacity: 0.8;
}

/* Extra style for the cancel button (red) */
.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

/* Center the avatar image inside this container */
.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

/* Avatar image */
img.avatar {
  width: 40%;
  border-radius: 50%;
}

/* Add padding to containers */
.container {
  padding: 16px;
}

/* The "Forgot password" text */
span.psw {
  float: right;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
    display: block;
    float: none;
  }
  .cancelbtn {
    width: 100%;
  }
}
		</style>
    </head>
    <body>

	<form  method='POST'>
  <div class="imgcontainer">
    <img src="img_avatar2.png" alt="Avatar" class="avatar">
  </div>

  <div class="container">
    <label for="AdminName"><b>AdminName</b></label>
    <input type="text" placeholder="Enter AdminName" name="AdminName" required>
						

    <label for="Password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="Password" required>
		
    <button type="submit" name="dangnhap">Login</button>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
  </div>

  <div class="container" style="background-color:#f1f1f1">
    <button type="button" class="cancelbtn">Cancel</button>
    <span class="psw">Forgot <a href="#">password?</a></span>
  </div>
</form>
	<?php
//Khai báo sử dụng session
session_start();
 
//Khai báo utf-8 để hiển thị được tiếng việt
header('Content-Type: text/html; charset=UTF-8');
 
//Xử lý đăng nhập
if (isset($_POST['dangnhap'])) 
{	
	//$errors=array(); ///tạo mảng check lỗi
    //Kết nối tới database
    include('conn.php');
     
    //Lấy dữ liệu nhập vào
    $AdminName = $_POST['AdminName'];
    $password = $_POST['Password'];
	$AdminName=strtolower($AdminName );
	//echo $AdminName;
     
    //Kiểm tra đã nhập đủ tên đăng nhập với mật khẩu chưa
   // if (!$AdminName) {
     //   $errors[]='taikhoan';
   // }
	//if(!$password)
	//{
	//	$errors[]='matkhau';
	
	//}
     
    // mã hóa pasword
   //$password = md5($password);
     
    //Kiểm tra tên đăng nhập có tồn tại không
    $query = $conn->query("SELECT adminname, password FROM admin WHERE adminname='$AdminName'");
    if (mysqli_num_rows($query) == 0) {
		echo '<script language="javascript">';
		echo 'alert("Tài Khoản Của Bạn Chưa Chính Xác")';  //not showing an alert box.
		echo '</script>';						
								
								//end;
		
		
		
    }
     
    //Lấy mật khẩu trong database ra
    $row = mysqli_fetch_array($query);
     
    //So sánh 2 mật khẩu có trùng khớp hay không
    if ($password != $row['password']) {
        echo '<script language="javascript">';
		echo 'alert("Mật Khẩu Của Bạn Chưa Chính Xác")';  //not showing an alert box.
		echo '</script>';
							//end;
    }
     
    //Lưu tên đăng nhập
	if($password == $row['password'] && $AdminName== $row['adminname'] ){
    $_SESSION['adminname'] = $AdminName;
	//echo'jihi';
	header('location: list.php');
	//echo "Xin chào " . $AdminName . ". Bạn đã đăng nhập thành công. <a href='/'>Về trang chủ</a>";
	}
   // echo "Xin chào " . $AdminName . ". Bạn đã đăng nhập thành công. <a href='/'>Về trang chủ</a>";
    //die();
	
}
?>


    </body>
</html>
