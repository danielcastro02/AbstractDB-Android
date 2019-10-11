<?php

$conn = new PDO('mysql:host='.$_REQUEST['endereco'].';dbname='.$_REQUEST['nomeDB'], $_REQUEST['user'], $_REQUEST['password']);
$Stmt = $conn->prepare($_REQUEST['sql']);
$Stmt->execute();
$arr = [];
while ($linha = $Stmt->fetch()){
	//$arr[] = json_encode($linha);
	$arr[] = $linha;
}
//var_dump($result);
$teste = json_encode($arr);
header('Content-type: application/json');
echo $teste;