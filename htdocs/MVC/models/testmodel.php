<?php
require_once("Book.php");
$list = Book::GetByCategory(1,'3');
print_r($list);
?>