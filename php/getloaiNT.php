<?php
$connect=mysqli_connect("localhost","root","","qlnoithat");
mysqli_query($connect,"SET NAMES 'utf8'");
$query="SELECT * FROM loainoithat";
$data=mysqli_query($connect,$query);
$mangloai=array();
while ($row=mysqli_fetch_assoc($data))
{
    $mangloai[]=$row;
}
echo json_encode($mangloai);
class Loai
{
    function Loai($maloai, $tenloai)
    {
        $this->maloai=$maloai;
        $this->tenloai=$tenloai;
    }
}
?>
