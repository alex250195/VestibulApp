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
            	return "SELECT * FROM curso";
		}

		public function Endereco(){
            	return "SELECT * FROM endereco";
		}

		public function Inscricao(){
            	return "SELECT * FROM inscricao";
		}

		public function Instituicao(){
            	return "SELECT * FROM instituicao";
		}

		public function Usuario(){
			return "SELECT * FROM usuario";
		}

        	public function Vestibular(){
			return "SELECT * FROM vestibular";
		}

		public function VestibularCurso(){
			return "SELECT * FROM vestibular_has_curso";
		}
	}
?>