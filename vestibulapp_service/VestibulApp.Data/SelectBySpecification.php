<?php
    class SelectBySpecification{
        public function AtendimentoEspecial($query){
			return "SELECT * FROM Atendimento_Especial WHERE 1 = 1 " .$query;
		}

		public function AtendimentoEspecifico($query){
			return "SELECT * FROM Atendimento_Especifico WHERE 1 = 1 " .$query;
		}

		public function Candidato($query){
			return "SELECT * FROM Candidato WHERE 1 = 1 " .$query;
		}

		public function Contato($query){
			return "SELECT * FROM Contato WHERE 1 = 1 " .$query;
		}

		public function Curso($query){
			return "SELECT * FROM Curso WHERE 1 = 1 " .$query;
		}

		public function Endereco($query){
			return "SELECT * FROM Endereco WHERE 1 = 1 " .$query;
		}

		public function Inscricao(){
			
		}

		public function Instituicao(){
			return "SELECT *
					FROM Instituicao
					INNER JOIN Endereco ON Endereco.id_instituicao = Instituicao.id_instituicao
					INNER JOIN Contato ON Contato.id_instituicao = Instituicao.id_instituicao";
		}

        public function Usuario($cpf, $senha){
            return "SELECT * FROM Usuario WHERE cpf = '" .$cpf. "' AND senha = '" .$senha. "'";
        }

        public function Vestibular($query){
			return "SELECT * FROM Vestibular WHERE 1 = 1 " .$query;
		}

		public function VestibularCurso($query){
			return "SELECT `Vestibular_has_Curso`.`id_vestibular`,
						   `Vestibular_has_Curso`.`id_curso`,
						   `Vestibular_has_Curso`.`vagas`,
						   `Curso`.`nome`,
						   `Curso`.`descricao`
					FROM `VestibulApp`.`Vestibular_has_Curso`
					INNER JOIN `vestibulapp`.`Curso` ON `Vestibular_has_Curso`.`id_curso` = `Curso`.`id_curso`
					WHERE 1 = 1" .$query;
		}
    }
?>