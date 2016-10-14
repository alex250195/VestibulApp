<?php
	class Contato{
		private $id_candidato;
		private $id_instituicao;
		private $tel_celular;
		private $tel_fixo;
		private $email;

		public function setId_candidato($id_candidato){
			$this->id_candidato = $id_candidato;
		}

		public function setId_Instituicao($id_instituicao){
			$this->id_instituicao = $id_instituicao;
		}

		public function setTelCelular($tel){
			$this->tel_celular = $tel;
		}

		public function setTelFixo($tel){
			$this->tel_fixo = $tel;
		}

		public function setEmail($email){
			$this->email = $email;
		}

		public function getId_Instituicao(){
			return $this->id_instituicao;
		}

		public function getId_Candidato(){
			return $this->id_candidato;
		}

		public function getCelular(){ 
			return $this->tel_celular; 
		}
		
		public function getFixo(){ 
			return $this->tel_fixo; 
		}
		
		public function getEmail(){ 
			return $this->email; 
		}

		public function Insert(){
			require_once '../utilitarios/lib/nusoap.php';
			include '../utilitarios/configWebService.php';

			$wsdl = $location. 'Contato/Insert.php?wsdl';
			$client = new nusoap_client($wsdl, true);

			$erro = $client->getError();
			if($erro)
				echo "<script>alert ('" .$erro. "');</script>";

			try{
				return $client->call('insertContato', array(''.$this->id_instituicao.'', ''.$this->id_candidato.'', ''.$this->tel_celular.'', ''.$this->tel_fixo.'', ''.$this->email.'')); 
			}catch(Exception $e){
				return $e->getMessage();
				exit();
			}
		}

		public function Update(){
			require_once '../utilitarios/lib/nusoap.php';
			include '../utilitarios/configWebService.php';

			$wsdl = $location. 'Contato/Update.php?wsdl';
			$client = new nusoap_client($wsdl, true);

			$erro = $client->getError();
			if($erro)
				echo "<script>alert ('" .$erro. "');</script>";

			try{
				return $client->call('updateContato', array(''.$this->id_instituicao.'', ''.$this->id_candidato.'', ''.$this->tel_celular.'', ''.$this->tel_fixo.'', ''.$this->email.'')); 
			}catch(Exception $e){
				return $e->getMessage();
				exit();
			}
		}
	}
?>