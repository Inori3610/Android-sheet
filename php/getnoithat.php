<?php
$connect = mysqli_connect("localhost", "root", "", "qlnoithat");
mysqli_query($connect, "SET NAMES 'utf8'");

class Noithat
{
    function __construct($manoithat, $tennoithat, $donvitinh, $soluong, $dongia,$maloaiNT,$hinhanh)
    {
        $this->manoithat = $manoithat;
        $this->tennoithat = $tennoithat;
        $this->donvitinh = $donvitinh;
        $this->soluong = $soluong;
        $this->dongia = $dongia;
        $this->maloaiNT = $maloaiNT;
        $this->hinhanh = $hinhanh;
    }
}

// Get maloai from the URL parameters
$maloaiNT = $_GET['maloaiNT'];

$query = "SELECT * FROM noithat WHERE maloaiNT = '$maloaiNT'";
$data = mysqli_query($connect, $query);

$mangnoithat = array();
while ($row = mysqli_fetch_assoc($data)) {
    $mangnoithat[] = new Noithat($row['manoithat'], $row['tennoithat'], $row['donvitinh'], $row['soluong'], $row['dongia'],$row['maloaiNT'],$row['hinhanh']);

}

// Return JSON response
echo json_encode($mangnoithat);
?>
