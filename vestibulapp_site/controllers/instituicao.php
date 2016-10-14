<?php
	include_once 'endereco.php';
	include_once 'contato.php';

	class Instituicao{
		private $id;
		private $cnpj;
		private $razao_social;
		private $nome_fantasia;
		private $insc_municipal;
		private $data_fundacao;

		public function setId($id){ $this->id = $id; }
		public function setCnpj($cnpj){ $this->cnpj = $cnpj; }
		public function setRazaoSocial($razao_social){ $this->razao_social = $razao_social; }
		public function setNomeFantasia($nome_fantasia){ $this->nome_fantasia = $nome_fantasia; }
		public function setInscMunicipal($insc_municipal){ $this->insc_municipal = $insc_municipal; }
		public function setDataFundacao($data_fundacao){ $this->data_fundacao = $data_fundacao; }

		public function getId(){ return $this->id; }
		public function getCnpj(){ return $this->cnpj; }
		public function getRazaoSocial(){ return $this->razao_social; }
		public function getNomeFantasia(){ return $this->nome_fantasia; }
		public function getInscMunicipal(){ return $this->insc_municipal; }
		public function getDataFundacao(){ return $this->data_fundacao; }

		public function Insert(){
			require_once '../utilitarios/lib/nusoap.php';
			include '../utilitarios/configWebService.php';

			$wsdl = $location. 'Instituicao/Insert.php?wsdl';
			$client = new nusoap_client($wsdl, true);

			$erro = $client->getError();
			if($erro)
				echo "<script>alert ('" .$erro. "');</script>";

			try{
				$result = $client->call('insertInstituicao', array(''.$this->cnpj.'', ''.$this->razao_social.'', ''.$this->nome_fantasia.'', ''.$this->insc_municipal.'', ''.$this->data_fundacao.''));

				return $result;
			}catch(Exception $e){
				return $e->getMessage();
			}
		}

		public function Update(){
			require_once '../utilitarios/lib/nusoap.php';
			include '../utilitarios/configWebService.php';

			$wsdl = $location. 'Instituicao/Update.php?wsdl';
			$client = new nusoap_client($wsdl, true);
			
			$erro = $client->getError();
			if($erro)
				echo "<script>alert ('" .$erro. "');</script>";

			$result = $client->call('updateInstituicao', array(''.$this->id.'', ''.$this->razao_social.'', ''.$this->nome_fantasia.''));

			return $result;
		}

		public function SelectBySpecification(){
			require_once '../utilitarios/lib/nusoap.php';
			include '../utilitarios/configWebService.php';

			$wsdl = $location. 'instituicao_verifica.php?wsdl';
			$client = new nusoap_client($wsdl, true);

			$erro = $client->getError();
			if($erro)
				echo "<script>alert ('" .$erro. "');</script>";

			$result = $client->call('verificaInstituicao', array());

			if($result) throw new Exception("<script>alert ('Instituicao ja cadastrada!'); window.location='../loader.php?status=9';</script>");			
		}

		public function SelectAll(){
			require_once 'utilitarios/lib/nusoap.php';
			include 'utilitarios/configWebService.php';
			
			$wsdl = $location. 'Instituicao/SelectAll.php?wsdl';
			$client = new nusoap_client($wsdl, true);

			$erro = $client->getError();
			if($erro)
				echo "<script>alert ('" .$erro. "');</script>";

			$result = $client->call('selectAllInstituicao', array());

			return $result;

			if(!$result) throw new Exception("<script>alert ('Nenhuma Instituicao Cadastrada!'); window.location='loader.php?status=3';</script>");

			return $result;
		}

		public function SelectVerify(){
			require_once 'utilitarios/lib/nusoap.php';
			include 'utilitarios/configWebService.php';
			
			$wsdl = $location. 'Instituicao/SelectVerify.php?wsdl';
			$client = new nusoap_client($wsdl, true);

			$erro = $client->getError();
			if($erro)
				echo "<script>alert ('" .$erro. "');</script>";

			try{
				return $client->call('selectVerifyInstituicao', array()); 
			}catch(Exception $e){
				return $e->getMessage();
				exit();
			}
		}
	}
?>