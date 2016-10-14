<?php
    class SelectById{
        public function AtendimentoEspecial($id){
			return "SELECT * FROM Atendimento_Especial WHERE id = " .$id;
		}

		public function AtendimentoEspecifico($id){
			return "SELECT * FROM Atendimento_Especifico WHERE id = " .$id;
		}

		public function Candidato($id){
			return "SELECT * FROM Candidato WHERE id = " .$id;
		}

		public function Contato($id){
			return "SELECT * FROM Contato WHERE id = " .$id;
		}

		public function Curso($id){
			return "SELECT * FROM Curso WHERE id = " .$id;
		}

		public function Endereco($id){
			return "SELECT * FROM Endereco WHERE id = " .$id;
		}

		public function Inscricao($id){
			return "SELECT * FROM Inscricao WHERE id = " .$id;
		}

		public function Instituicao($id){
			return "SELECT * FROM Instituicao WHERE id = " .$id;
		}

        public function Usuario($id){
            return "SELECT * FROM Usuario WHERE id = " .$id;
        }

        public function Vestibular($id){
			return "SELECT * FROM Vestibular WHERE id_vestibular = " .$id;
		}

		public function VestibularCurso($id){
			return "SELECT * FROM Vestibular_has_Curso WHERE id = " .$id;
		}
    }
?>