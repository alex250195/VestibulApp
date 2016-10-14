<?php
	class VestibularCurso{
		private $id_vestibular;
		private $id_curso;
		private $vaga;

		public function setIdVestibular($id_vestibular){ $this->id_vestibular = $id_vestibular; }
		public function setIdCurso($id_curso){ $this->id_curso = $id_curso; }
		public function setVaga($vaga){ $this->vaga = $vaga; }

		public function getIdVestibular(){ return $this->id_vestibular; }
		public function getIdCurso(){ return $this->id_curso; }
		public function getVaga(){ return $this->vaga; }

		public function Insert(){
			require_once '../utilitarios/lib/nusoap.php';
			include '../utilitarios/configWebService.php';

			$wsdl = $location. 'VestibularCurso/Insert.php?wsdl';
			$client = new nusoap_client($wsdl, true);

			$erro = $client->getError();
			if($erro)
				echo "<script>alert ('" .$erro. "');</script>";
			
			try{
				return $client->call('insertVestibularCurso', array(''.$this->id_vestibular.'', ''.$this->id_curso.'', ''.$this->vaga.'')); 
			}catch(Exception $e){
				return $e->getMessage();
				exit();
			}
		}

		public function delete(){
			/*.....*/
		}

		public function update(){
			/*.....*/
		}

		public function select(){
			/*.....*/
		}
	}
?>