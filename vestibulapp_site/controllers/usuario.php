<?php
	class Usuario{
		private $id;
		private $id_instituicao;
		private $tipo_usuario;		
		private $cpf;
		private $senha;
		private $nome;

		public function getId(){
			return $this->id;
		}

		public function setId($id){
			$this->id = $id;
		}

		public function getId_instituicao(){
			return $this->id_instituicao;
		}

		public function setId_instituicao($id_instituicao){
			$this->id_instituicao = $id_instituicao;
		}

		public function getTipo_usuario(){
			return $this->tipo_usuario;
		}

		public function setTipo_usuario($tipo_usuario){
			$this->tipo_usuario = $tipo_usuario;
		}

		public function getCpf(){
			return $this->cpf;
		}

		public function setCpf($cpf){
			$this->cpf = $cpf;
		}

		public function getSenha(){
			return $this->senha;
		}

		public function setSenha($senha){
			$this->senha = $senha;
		}

		public function getNome(){
			return $this->nome;
		}

		public function setNome($nome){
			$this->nome = $nome;
		}

		public function Insert(){
			require_once '../utilitarios/lib/nusoap.php';
			include '../utilitarios/configWebService.php';

			$wsdl = $location. 'Usuario/Insert.php?wsdl';
			$client = new nusoap_client($wsdl, true);

			$erro = $client->getError();
			if($erro)
				echo "<script>alert ('" .$erro. "');</script>";

			try{
				return $client->call('insertUsuario', array(''.$this->id_instituicao.'', ''.$this->tipo_usuario.'', ''.$this->cpf.'', ''.$this->senha.'', ''.$this->nome.'')); 
			}catch(Exception $e){
				return $e->getMessage();
				exit();
			}
		}

		public function Delete(){			
			require_once '../utilitarios/lib/nusoap.php';
			include '../utilitarios/configWebService.php';

			$wsdl = $location. 'Usuario/Delete.php?wsdl';
			$client = new nusoap_client($wsdl, true);

			$erro = $client->getError();
			if($erro)
				echo "<script>alert ('" .$erro. "');</script>";

			try{
				return $client->call('deleteUsuario', array(''.$this->id.'')); 
			}catch(Exception $e){
				return $e->getMessage();
				exit();
			}
		}

		public function Update(){
			require_once '../utilitarios/lib/nusoap.php';
			include '../utilitarios/configWebService.php';

			$wsdl = $location. 'Usuario/Update.php?wsdl';
			$client = new nusoap_client($wsdl, true);

			$erro = $client->getError();
			if($erro)
				echo "<script>alert ('" .$erro. "');</script>";

			try{
				return $client->call('updateUsuario', array(''.$this->id.'', ''.$this->senha.'')); 
			}catch(Exception $e){
				return $e->getMessage();
				exit();
			}
		}

		public function SelectAll(){
			require_once 'utilitarios/lib/nusoap.php';
			include 'utilitarios/configWebService.php';
			
			$wsdl = $location. 'Usuario/SelectAll.php?wsdl';
			$client = new nusoap_client($wsdl, true);
			
			$erro = $client->getError();
			if($erro)
				echo "<script>alert ('" .$erro. "');</script>";

			try{
				return $client->call('selectAllUsuario', array()); 
			}catch(Exception $e){
				return $e->getMessage();
				exit();
			}
		}

		public function SelectVerify(){
			require_once '../utilitarios/lib/nusoap.php';
			include '../utilitarios/configWebService.php';

			$wsdl = $location. 'Usuario/SelectVerify.php?wsdl';
			$client = new nusoap_client($wsdl, true);

			$erro = $client->getError();
			if($erro)
				echo "<script>alert ('" .$erro. "');</script>";

			try{
				return $client->call('selectVerify', array()); 
			}catch(Exception $e){
				return $e->getMessage();
				exit();
			}
		}

		public function SelectBySpecification(){
			require_once '../utilitarios/lib/nusoap.php';
			include '../utilitarios/configWebService.php';

			$wsdl = $location. 'Usuario/SelectBySpecification.php?wsdl';
			$client = new nusoap_client($wsdl, true);

			$erro = $client->getError();
			if($erro)
				echo "<script>alert ('" .$erro. "');</script>";

			$result = $client->call('selectBySpecificationUsuario', array(''.$this->cpf.'', ''.$this->senha.''));

			if (!isset($_SESSION)) session_start();
			$_SESSION['id_usuario'] = $result[1];
			$_SESSION['tipo_usuario']  = $result[2];			
			$_SESSION['cpf'] = $result[3];
			$_SESSION['nome'] = $result[4];

			return $result;
		}
	}
?>