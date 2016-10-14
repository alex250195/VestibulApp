<?php
	class Formatacao{
		public function cep($cep){
			$cep = split('[/.-]', $cep);
			$cep = $cep[0]."".$cep[1]."".$cep[2];
			return $cep;
		}

		public function cepFormata($cep){
			$cep = $cep[0].$cep[1]. "." .$cep[2].$cep[3].$cep[4]. "-" .$cep[5].$cep[6].$cep[7];
			return $cep;
		}
			
		public function celular($celular){
			$celular = split('[/.-]', $celular);
			$celular = $celular[0]."".$celular[1]."".$celular[2];
			$celular = explode(" ", $celular);
			return $celular;
		}

		public function celularFormata($celular){
			$celular = "(" .$celular[0].$celular[1].$celular[2]. ") " .$celular[3]. "-" .$celular[4].$celular[5].$celular[6].$celular[7]. "-" .$celular[8].$celular[9].$celular[10].$celular[11];
			return $celular;
		}

		public function fixo($telefone){
			$telefone = split('[/.-]', $telefone);
			$telefone = $telefone[0]."".$telefone[1];
			$telefone = explode(" ", $telefone);
			return $telefone;
		}

		public function fixoFormata($telefone){
			$telefone = "(" .$telefone[0].$telefone[1].$telefone[2]. ") " .$telefone[3].$telefone[4].$telefone[5].$telefone[6]. "-" .$telefone[7].$telefone[8].$telefone[9].$telefone[10];
			return $telefone;
		}

		public function data($data){
			$data = split('[/.-]', $data);
			$data = $data[2]."-".$data[1]."-".$data[0];
			return $data;
		}

		public function dataFormata($data){
			$data = $data = split('[/.-]', $data);
			$data = $data[2]. "/" .$data[1]. "/" .$data[0];
			return $data;
		}

		public function cpf($cpf){
			$cpf = split('[/.-]', $cpf);
			$cpf = $cpf[0].$cpf[1].$cpf[2].$cpf[3];
			
			if(!is_numeric($cpf)) throw new Exception("<script>alert ('CPF invalido!'); window.location='../loader.php?status=4';</script>");

			return $cpf;
		}

		public function cnpj($cnpj){
			$cnpj = split('[/.-]', $cnpj);
			$cnpj = $cnpj[0].$cnpj[1].$cnpj[2].$cnpj[3].$cnpj[4];

			if(!is_numeric($cnpj)) throw new ExceptionFormata("<script>alert ('CNPJ invalido!'); window.location='../loader.php?status=3';</script>");

			return $cnpj;
		}

		public function cpfFormata($cpf){
			$cpf = $cpf[0].$cpf[1].$cpf[2]. "." .$cpf[3].$cpf[4].$cpf[5]. "." .$cpf[6].$cpf[7].$cpf[8]. "-" .$cpf[9].$cpf[10];
			return $cpf;
		}

		public function cnpjFormata($cnpj){
			$cnpj = $cnpj[0].$cnpj[1]. "." .$cnpj[2].$cnpj[3].$cnpj[4]. "." .$cnpj[5].$cnpj[6].$cnpj[7]. "/" .$cnpj[8].$cnpj[9].$cnpj[10].$cnpj[11]. "-" .$cnpj[12].$cnpj[13];
			return $cnpj;
		}
	}
?>