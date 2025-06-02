<?php
$connect=mysqli_connect("localhost","root","","qlxe");
mysqli_query($connect,"SET NAMES 'utf8'");
$query="SELECT * FROM loaixe";
$data=mysqli_query($connect,$query);
$mangloaixe=array();
while ($row=mysqli_fetch_assoc($data))
{
    $mangloaixe[]=$row;
}
echo json_encode($mangloaixe);
class Loaixe
{
    function Loaixe($maloai, $tenloai)
    {
        $this->maloai=$maloai;
        $this->tenloai=$tenloai;
    }
}
?>
