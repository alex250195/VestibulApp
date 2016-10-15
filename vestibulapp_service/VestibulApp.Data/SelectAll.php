<?php
    class SelectAll{
        	public function AtendimentoEspecial(){
            	return "SELECT * FROM Atendimento_Especial";
		}

		public function AtendimentoEspecifico(){
            	return "SELECT * FROM Atendimento_Especifico";
		}

		public function Candidato(){
            	return "SELECT * FROM Candidato";
		}

		public function Contato(){
            	return "SELECT * FROM Candidato";
		}

		public function Curso(){
            	return "SELECT * FROM Curso";
		}

		public function Endereco(){
            	return "SELECT * FROM Endereco";
		}

		public function Inscricao(){
            	return "SELECT * FROM Inscricao";
		}

		public function Instituicao(){
            	return "SELECT * FROM Instituicao";
		}

		public function Usuario(){
			return "SELECT * FROM Usuario";
		}

        	public function Vestibular(){
			return "SELECT * FROM Vestibular";
		}

		public function VestibularCurso(){
			return "SELECT * FROM Vestibular_has_curso";
		}
	}
?>