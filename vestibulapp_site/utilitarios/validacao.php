<?php
	class Validacao{
		public function cnpj($cnpj){
			if($cnpj == '' OR $cnpj == null) throw new ExceptionValidacao("<script>alert ('CNPJ invalido!'); window.location='../loader.php?status=3';</script>");

			if ($cnpj == 00000000000000 || 
	            $cnpj == 11111111111111 || 
	            $cnpj == 22222222222222 || 
	            $cnpj == 33333333333333 || 
	            $cnpj == 44444444444444 || 
	            $cnpj == 55555555555555 || 
	            $cnpj == 66666666666666 || 
	            $cnpj == 77777777777777 || 
	            $cnpj == 88888888888888 || 
	            $cnpj == 99999999999999) throw new Exception("<script>alert ('CNPJ invalido!'); window.location='../loader.php?status=3';</script>");

			$resultado = ($cnpj[0] * 5) + ($cnpj[1] * 4) + ($cnpj[2] * 3) + ($cnpj[3] * 2) + ($cnpj[4] * 9) + ($cnpj[5] * 8) + ($cnpj[6] * 7) + ($cnpj[7] * 6) + ($cnpj[8] * 5) + ($cnpj[9] * 4) + ($cnpj[10] * 3) + ($cnpj[11] * 2);

	        $resultado = $resultado % 11;

	        if($resultado < 2)
	        	if($cnpj[12] != 0) throw new Exception("<script>alert ('CNPJ invalido!'); window.location='../loader.php?status=3';</script>");
	        else
	        	if($cnpj[12] != (11 - $resultado)) throw new Exception("<script>alert ('CNPJ invalido!'); window.location='../loader.php?status=3';</script>");

	        $resultado = ($cnpj[0] * 6) + ($cnpj[1] * 5) + ($cnpj[2] * 4) + ($cnpj[3] * 3) + ($cnpj[4] * 2) + ($cnpj[5] * 9) + ($cnpj[6] * 8) + ($cnpj[7] * 7) + ($cnpj[8] * 6) + ($cnpj[9] * 5) + ($cnpj[10] * 4) + ($cnpj[11] * 3) + ($cnpj[12] * 2);

			$resultado = $resultado % 11;

			if($resultado < 2)
	        	if($cnpj[13] != 0) throw new ExceptionValidacao("<script>alert ('CNPJ invalido!'); window.location='../loader.php?status=3';</script>");
	        else
	        	if($cnpj[13] != (11 - $resultado)) throw new ExceptionValidacao("<script>alert ('CNPJ invalido!'); window.location='../loader.php?status=3';</script>");

	        return $cnpj;
		}

		public function cpf($cpf){
			if ($cpf == 00000000000 || 
	            $cpf == 11111111111 || 
	            $cpf == 22222222222 || 
	            $cpf == 33333333333 || 
	            $cpf == 44444444444 || 
	            $cpf == 55555555555 || 
	            $cpf == 66666666666 || 
	            $cpf == 77777777777 || 
	            $cpf == 88888888888 || 
	            $cpf == 99999999999) throw new Exception("<script>alert ('CPF invalido!'); window.location='../loader.php?status=4';</script>");

			$first = ($cpf[0]*10) + ($cpf[1]*9) + ($cpf[2]*8) + ($cpf[3]*7) + ($cpf[4]*6) + ($cpf[5]*5) + ($cpf[6]*4) + ($cpf[7]*3) + ($cpf[8]*2);
			$first = $first*10;
			$first = $first%11;
			if($first == 10) $first = 0;

			if($first != $cpf[9]) throw new Exception("<script>alert ('CPF invalido!'); window.location='../loader.php?status=4';</script>");

			$second = ($cpf[0]*11) + ($cpf[1]*10) + ($cpf[2]*9) + ($cpf[3]*8) + ($cpf[4]*7) + ($cpf[5]*6) + ($cpf[6]*5) + ($cpf[7]*4) + ($cpf[8]*3) + ($cpf[9]*2);
			$second = $second*10;
			$second = $second%11;

			if($second != $cpf[10]) throw new Exception("<script>alert ('CPF invalido!'); window.location='../loader.php?status=4';</script>");

			return true;
		}
	}
?>