<?php
session_start();
session_destroy();
header('location: dangnhapforadmin.php');
?>