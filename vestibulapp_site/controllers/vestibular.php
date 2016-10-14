<?php
	class Vestibular{
		private $id;
		private $id_instituicao;
		private $status;
		private $data_prova;
		private $data_inscricao;
		private $data_encerramento_inscricao;
		private $data_resultado_gabarito;
		private $data_resultado_oficial;
		private $edital;
		private $gabarito;
		private $resultado_classificacao;

		public function setId($id){ $this->id = $id; }
		public function setIdInstituicao($id_instituicao){ $this->id_instituicao = $id_instituicao; }
		public function setStatus($status){ $this->status = $status; }
		public function setDataProva($data_prova){ $this->data_prova = $data_prova; }
		public function setDataInscricao($data_inscricao){ $this->data_inscricao = $data_inscricao; }
		public function setDataEncerramentoInscricao($data_encerramento_inscricao){ $this->data_encerramento_inscricao = $data_encerramento_inscricao; }
		public function setDataResultadoGabarito($data_resultado_gabarito){ $this->data_resultado_gabarito = $data_resultado_gabarito; }
		public function setDataResultadoOficial($data_resultado_oficial){ $this->data_resultado_oficial = $data_resultado_oficial; }
		public function setEdital($edital){ $this->edital = $edital; }
		public function setGabarito($gabarito){ $this->gabarito = $gabarito; }
		public function setResultadoClassificacao($resultado_classificacao){ $this->resultado_classificacao = $resultado_classificacao; }

		public function getId(){ return $this->id; }
		public function getIdInstituicao(){ return $this->id_instituicao; }
		public function getStatus(){ return $this->status; }
		public function getDataProva(){ return $this->data_prova; }
		public function getDataInscricao(){ return $this->data_inscricao; }
		public function getDataEncerramentoInscricao(){ return $this->data_encerramento_inscricao; }
		public function getDataResultadoGabarito(){ return $this->data_resultado_gabarito; }
		public function getDataResultadoOficial(){ return $this->data_resultado_oficial; }
		public function getEdital(){ return $this->edital; }
		public function getGabarito(){ return $this->gabarito; }
		public function getResultadoClassificacao(){ return $this->resultado_classificacao; }

		public function Insert(){
			require_once '../utilitarios/lib/nusoap.php';
			include '../utilitarios/configWebService.php';

			$wsdl = $location. 'Vestibular/Insert.php?wsdl';
			$client = new nusoap_client($wsdl, true);

			$erro = $client->getError();
			if($erro)
				echo "<script>alert ('" .$erro. "');</script>";
			
			$result = $client->call('insertVestibular', array(''.$this->id_instituicao.'', ''.$this->status.'', ''.$this->data_prova.'', ''.$this->data_inscricao.'', ''.$this->data_encerramento_inscricao.'', ''.$this->data_resultado_gabarito.'', ''.$this->data_resultado_oficial.'', ''.$this->edital.'', ''.$this->gabarito.'', ''.$this->resultado_classificacao.''));

			return $result;
		}

		public function delete(){
			/*.....*/
		}

		public function update(){
			require_once '../utilitarios/lib/nusoap.php';
			include '../utilitarios/configWebService.php';

			$wsdl = $location. 'Vestibular/Update.php?wsdl';
			$client = new nusoap_client($wsdl, true);

			$erro = $client->getError();
			if($erro)
				echo "<script>alert ('" .$erro. "');</script>";

			try{
				return $client->call('updateVestibular', array(''.$this->id.'', ''.$this->gabarito.'', ''.$this->resultado_classificacao.'')); 
			}catch(Exception $e){
				return $e->getMessage();
				exit();
			}
		}

		public function SelectVerify(){
			require_once '../utilitarios/lib/nusoap.php';
			include '../utilitarios/configWebService.php';

			$wsdl = $location. 'Vestibular/SelectVerify.php?wsdl';
			$client = new nusoap_client($wsdl, true);

			$erro = $client->getError();
			if($erro)
				echo "<script>alert ('" .$erro. "');</script>";

			try{
				return $client->call('selectVerifyVestibular', array()); 
			}catch(Exception $e){
				return $e->getMessage();
				exit();
			}
		}

		public function SelectById(){
			require_once 'utilitarios/lib/nusoap.php';
			include 'utilitarios/configWebService.php';

			$wsdl = $location. 'Vestibular/SelectById.php?wsdl';
			$client = new nusoap_client($wsdl, true);

			$erro = $client->getError();
			if($erro)
				echo "<script>alert ('" .$erro. "');</script>";
			
			try{
				return $client->call('selectByIdVestibular', array(''.$this->id.'')); 
			}catch(Exception $e){
				return $e->getMessage();
				exit();
			}
		}

		public function SelectByCurso(){
			require_once 'utilitarios/lib/nusoap.php';
			include 'utilitarios/configWebService.php';

			$wsdl = $location. 'VestibularCurso/SelectByCurso.php?wsdl';
			$client = new nusoap_client($wsdl, true);

			$erro = $client->getError();
			if($erro)
				echo "<script>alert ('" .$erro. "');</script>";
			
			try{
				return $client->call('selectByCurso', array(''.$this->id.'')); 
			}catch(Exception $e){
				return $e->getMessage();
				exit();
			}
		}

		public function SelectAll(){
			require_once 'utilitarios/lib/nusoap.php';
			include 'utilitarios/configWebService.php';

			$wsdl = $location. 'Vestibular/SelectAll.php?wsdl';
			$client = new nusoap_client($wsdl, true);

			$erro = $client->getError();
			if($erro)
				echo "<script>alert ('" .$erro. "');</script>";
				
			try{
				return $client->call('selectAll', array()); 
			}catch(Exception $e){
				return $e->getMessage();
				exit();
			}
		}
	}
?>