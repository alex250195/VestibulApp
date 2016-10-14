<?php
	include_once '../controllers/vestibular.php';
	include_once '../controllers/vestibular_curso.php';
	include_once '../controllers/curso.php';
	include_once '../utilitarios/formatacao.php';

	$vestibular = new Vestibular();
	$vestCur = new VestibularCurso();
	$formata = new Formatacao();
	$curso = new Curso();

	$vestibular->setIdInstituicao(1);	
	$vestibular->setStatus('Previsto');
	$vestibular->setDataProva($formata->data($_REQUEST['dt_prova']));
	$vestibular->setDataInscricao($formata->data($_REQUEST['dt_inscricao']));
	$vestibular->setDataEncerramentoInscricao($formata->data($_REQUEST['dt_encerramento']));
	$vestibular->setDataResultadoGabarito($formata->data($_REQUEST['dt_gabarito']));
	$vestibular->setDataResultadoOficial($formata->data($_REQUEST['dt_resultado']));

	if($_FILES){
		if($_FILES['edital']){
			$_FILES['edital']['name'] = date('d-m-y')."_edital.pdf"; //Renomeando o nome do arquivo
			$name = $_FILES['edital']['name']; //Gravando o nome do arquivo em uma variável
			$tmpName = $_FILES['edital']['tmp_name']; //Gravando o nome temporário do arquivo em uma vairável
			$dir = '../utilitarios/edital/'; //Gravando o diretório que será salvo o arquivo
			$edital_path = 'edital/' . $name;
			move_uploaded_file( $tmpName, $dir . $name ); //Upload do arquivo e armazenamento do mesmo

			$vestibular->setEdital($edital_path);
		}
	}
	else{
        $vestibular->setEdital('null');
    }
	
    $vestibular->setGabarito('null');
	$vestibular->setResultadoClassificacao('null');

	try{
		if($vestibular->insert()){
			$array = array('curso' => array(), 'vaga' => array());

			foreach ($_REQUEST['curso'] as $item) {
				array_push($array['curso'], $item);
			}
			
			foreach ($_REQUEST['vaga']  as $item) {
				if($item != null )
					array_push($array['vaga'], $item);
			}

			$vestibularCadastro = $vestibular->SelectVerify();

			for ($i=0; $i < count($array['curso']); $i++) {
				$curso->setNome($array['curso'][$i]);

				$vestCur->setIdVestibular($vestibularCadastro);
				$vestCur->setIdCurso($curso->SelectBySpecification());
				$vestCur->setVaga($array['vaga'][$i]);
						
				if($vestCur->Insert())
					echo "<script>alert ('Cadastro Efetuado com Sucesso!'); window.location='../loader.php?status=11';</script>";		
				else
					echo "<script>alert ('Erro ao cadastrar vestibular!'); window.location='../loader.php?status=5';</script>";
			}
		}
	}catch(Exception $e){
		echo "<script>alert ('" .$e->getMessage(). "');</script>";
        exit();
	}
?>