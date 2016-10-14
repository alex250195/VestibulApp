<?php
	class Curso{
		private $id;
		private $id_instituicao;
		private $nome;
		private $descricao;

		public function setId($id){ $this->id = $id; }
		public function setIdInstituicao($id_instituicao){ $this->id_instituicao = $id_instituicao; }
		public function setNome($nome){ $this->nome = $nome; }
		public function setDescricao($descricao){ $this->descricao = $descricao; }

		public function getId(){ return $this->id; }
		public function getIdInstituicao(){ return $this->id_instituicao; }
		public function getNome(){ return $this->nome; }
		public function getDescricao(){ return $this->descricao; }

		public function Insert(){
			require_once '../utilitarios/lib/nusoap.php';
			include '../utilitarios/configWebService.php';

			$wsdl = $location. 'Curso/Insert.php?wsdl';
			$client = new nusoap_client($wsdl, true);

			$erro = $client->getError();
			if($erro)
				echo "<script>alert ('" .$erro. "');</script>";

			try{
				return $client->call('insertCurso', array(''.$this->id_instituicao.'', ''.$this->nome.'', ''.$this->descricao.''));
			}catch(Exception $e){
				return $e->getMessage();
				exit();
			}
		}

		public function Delete(){
			require_once '../utilitarios/lib/nusoap.php';
			include '../utilitarios/configWebService.php';

			$wsdl = $location. 'Curso/Delete.php?wsdl';
			$client = new nusoap_client($wsdl, true);

			$erro = $client->getError();
			if($erro)
				echo "<script>alert ('" .$erro. "');</script>";

			try{
				return $client->call('deleteCurso', array(''.$this->id.''));	
			}catch(Exception $e){
				return $e->getMessage();
				exit();
			}			
		}

		public function SelectAll(){
			require_once 'utilitarios/lib/nusoap.php';
			include 'utilitarios/configWebService.php';
			
			$wsdl = $location. 'Curso/SelectAll.php?wsdl';
			$client = new nusoap_client($wsdl, true);

			$erro = $client->getError();
			if($erro)
				echo "<script>alert ('" .$erro. "');</script>";

			try{
				return $result = $client->call('selectAllCurso', array());	
			}catch(Exception $e){
				return $e->getMessage();
				exit();
			}
		}

		public function SelectBySpecification(){
			require_once '../utilitarios/lib/nusoap.php';
			include '../utilitarios/configWebService.php';
			
			$wsdl = $location. 'Curso/SelectBySpecification.php?wsdl';
			$client = new nusoap_client($wsdl, true);

			$erro = $client->getError();
			if($erro)
				echo "<script>alert ('" .$erro. "');</script>";

			try{
				return $result = $client->call('selectBySpecificationCurso', array(''.$this->nome.''));	
			}catch(Exception $e){
				return $e->getMessage();
				exit();
			}
		}
	}
?>