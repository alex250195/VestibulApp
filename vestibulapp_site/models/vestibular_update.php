<?php
	include_once '../controllers/vestibular.php';

	$vestibular = new Vestibular();

	if($_FILES){
		if($_FILES['gabarito']['size'] != 0){
			$_FILES['gabarito']['name'] = date('d-m-y')."_gabarito.pdf"; //Renomeando o nome do arquivo
			$name = $_FILES['gabarito']['name']; //Gravando o nome do arquivo em uma variável
			$tmpName = $_FILES['gabarito']['tmp_name']; //Gravando o nome temporário do arquivo em uma vairável
			$dir = '../utilitarios/gabarito/'; //Gravando o diretório que será salvo o arquivo
			$gabarito_path = 'gabarito/' . $name;
			move_uploaded_file( $tmpName, $dir . $name ); //Upload do arquivo e armazenamento do mesmo

			$vestibular->setGabarito($gabarito_path);
		}
		else{
			$vestibular->setGabarito("null");
		}
		if($_FILES['resultado']['size'] != 0){
			$_FILES['resultado']['name'] = date('d-m-y')."_resultado.pdf"; //Renomeando o nome do arquivo
			$name = $_FILES['resultado']['name']; //Gravando o nome do arquivo em uma variável
			$tmpName = $_FILES['resultado']['tmp_name']; //Gravando o nome temporário do arquivo em uma vairável
			$dir = '../utilitarios/resultado/'; //Gravando o diretório que será salvo o arquivo
			$resultado_path = 'resultado/' . $name;
			move_uploaded_file( $tmpName, $dir . $name ); //Upload do arquivo e armazenamento do mesmo

			$vestibular->setResultadoClassificacao($resultado_path);
		}
        else{
            $vestibular->setResultadoClassificacao("null");
        }

        $vestibular->setId($_POST['vestibular']);
	}

	try{
		$vestibular->Update();
	}catch(Exception $e){
		echo "<script>alert ('" .$e->getMessage(). "');</script>";
        exit();
	}finally{
		echo "<script>alert ('Vestibular Atualizado com Sucesso!'); window.location='../loader.php?status=11';</script>";
	}
?>