<?php
	class Endereco{
		private $id_instituicao;
		private $id_candidato;
		private $cep;
		private $logradouro;
		private $endereco;
		private $numero;
		private $complemento;
		private $bairro;
		private $municipio;
		private $uf;

		public function getId_instituicao(){
			return $this->id_instituicao;
		}

		public function setId_instituicao($id_instituicao){
			$this->id_instituicao = $id_instituicao;
		}

		public function getId_candidato(){
			return $this->id_candidato;
		}

		public function setId_candidato($id_candidato){
			$this->id_candidato = $id_candidato;
		}

		public function getCep(){
			return $this->cep;
		}

		public function setCep($cep){
			$this->cep = $cep;
		}

		public function getLogradouro(){
			return $this->logradouro;
		}

		public function setLogradouro($logradouro){
			$this->logradouro = $logradouro;
		}

		public function getEndereco(){
			return $this->endereco;
		}

		public function setEndereco($endereco){
			$this->endereco = $endereco;
		}

		public function getNumero(){
			return $this->numero;
		}

		public function setNumero($numero){
			$this->numero = $numero;
		}

		public function getComplemento(){
			return $this->complemento;
		}

		public function setComplemento($complemento){
			$this->complemento = $complemento;
		}

		public function getBairro(){
			return $this->bairro;
		}

		public function setBairro($bairro){
			$this->bairro = $bairro;
		}

		public function getMunicipio(){
			return $this->municipio;
		}

		public function setMunicipio($municipio){
			$this->municipio = $municipio;
		}

		public function getUf(){
			return $this->uf;
		}

		public function setUf($uf){
			$this->uf = $uf;
		}	

		public function Insert(){
			require_once '../utilitarios/lib/nusoap.php';
			include '../utilitarios/configWebService.php';

			$wsdl = $location. 'Endereco/Insert.php?wsdl';
			$client = new nusoap_client($wsdl, true);

			$erro = $client->getError();
			if($erro)
				echo "<script>alert ('" .$erro. "');</script>";
			
			try{
				return $client->call('insertEndereco', array(''.$this->id_instituicao.'', ''.$this->id_candidato.'', ''.$this->cep.'', ''.$this->logradouro.'', ''.$this->endereco.'', ''.$this->numero.'', ''.$this->complemento.'', ''.$this->bairro.'', ''.$this->municipio.'', ''.$this->uf.'')); 
			}catch(Exception $e){
				return $e->getMessage();
				exit();
			}
		}	

		public function Update(){
			require_once '../utilitarios/lib/nusoap.php';
			include '../utilitarios/configWebService.php';

			$wsdl = $location. 'Endereco/Update.php?wsdl';
			$client = new nusoap_client($wsdl, true);

			$erro = $client->getError();
			if($erro)
				echo "<script>alert ('" .$erro. "');</script>";

			try{
				return $client->call('updateEndereco', array(''.$this->id_instituicao.'', ''.$this->id_candidato.'', ''.$this->cep.'', ''.$this->logradouro.'', ''.$this->endereco.'', ''.$this->numero.'', ''.$this->complemento.'', ''.$this->bairro.'', ''.$this->municipio.'', ''.$this->uf.'')); 
			}catch(Exception $e){
				return $e->getMessage();
				exit();
			}
		}
	}
?>