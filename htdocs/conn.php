<?php
	$servername = 'localhost';
	$username = 'root';
	$password = '';
	$db = 'bd_music';
	
	$conn = new mysqli($servername, $username, $password, $db);
	mysqli_query($conn,"SET NAMES 'utf8'");
	
?>