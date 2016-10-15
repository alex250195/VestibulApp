<?php
    class Update{
        /*public function AtendimentoEspecial($id, $descricao, $inscricao){
			return "UPDATE Atendimento_Especial 
					SET descricao = '" .$descricao."',
						id_inscricao = ".$id_inscricao." 
					WHERE id = '".$id."'";
		}

		public function AtendimentoEspecifico($id, $descricao, $inscricao){
			return "UPDATE Atendimento_Especifico 
					SET descricao = '" .$descricao."',
						id_inscricao = ".$id_inscricao." 
					WHERE id = '".$id."'";
		}*/

		public function Candidato($cpf, $senha){
			return "UPDATE Candidato 
					SET senha = '".$senha."'						
					WHERE cpf = '".$cpf."'";
		}

		public function Contato($id_instituicao, $id_candidato, $telefone_fixo, $telefone_celular, $email){
			if($id_instituicao != "null"){
				return "UPDATE Contato
					SET  telefone_fixo = '".$telefone_fixo."',
						 telefone_celular = '".$telefone_celular."',
						 email = '".$email."'
					WHERE id_instituicao = '".$id_instituicao."'";
			}
			else{
				return "UPDATE Contato
					SET  telefone_fixo = '".$telefone_fixo."',
						 telefone_celular = '".$telefone_celular."',
						 email = '".$email."'
					WHERE id_candidato = '".$id_candidato."'";
			}
		}

		/*public function Curso($id, $id_instituicao, $nome, $descricao){
			return "UPDATE Curso
					SET id_instituicao = ".$id_instituicao.",
						descricao = '".$descricao."' 
					WHERE id = '".$id."'";
		}*/

		public function Endereco($id_instituicao, $id_candidato, $cep, $logradouro, $numero, $endereco, $bairro, $cidade, $estado){
			if($id_instituicao != "null"){
				return "UPDATE Endereco
					SET cep = '".$cep."',
					    logradouro = '".$logradouro."',
					    numero = '".$numero."',
					    endereco = '".$endereco."',
					    bairro = '".$bairro."',
					    municipio = '".$cidade."',
					    uf = '".$estado."'
					WHERE id_instituicao = '".$id_instituicao."'";
			}
			else{
				return "UPDATE Endereco
					SET cep = '".$cep."',
					    logradouro = '".$logradouro."',
					    numero = '".$numero."',
					    endereco = '".$endereco."',
					    bairro = '".$bairro."',
					    municipio = '".$cidade."',
					    uf = '".$estado."'
					WHERE id_candidato = '".$id_candidato."'";
			}
		}

		/*public function Inscricao($id, $id_curso, $id_vestibular, $id_candidato, $lingua){
			return "UPDATE Inscricao 
					SET id_curso = ".$id_curso.",
					    id_vestibular = ".$id_vestibular.",
					    id_candidato = ".$id_candidato.",
					    linguagem = '".$lingua."'
					WHERE id = '".$id."'";
		}*/

		public function Instituicao($id, $razao_social, $nome_fantasia){
			return "UPDATE Instituicao 
					SET razao_social = '".$razao_social."',
					    nome_fantasia = '".$nome_fantasia."'
					WHERE id_instituicao = '".$id."'";
		}

        public function Usuario($id, $senha){
            return "UPDATE Usuario 
            		SET senha = '".$senha."'
            		WHERE id_usuario = '".$id."'";
        }

        public function Vestibular($id, $gabarito, $classificacao){
			return "UPDATE Vestibular 
					SET gabarito = '".$gabarito."',
						resultado_classificacao = '".$classificacao."'
					WHERE id_vestibular = '".$id."'";
		}

		/*public function VestibularCurso($id_curso, $id_vestibular){
			return "UPDATE Vestibular_has_Curso 
					SET id_vestibular = ".$id_vestibular.",
						id_curso = ".$id_curso"
					WHERE id = '".$id."'";
		}*/
    }
?>