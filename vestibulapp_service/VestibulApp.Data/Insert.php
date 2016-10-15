<?php
    class Insert{
		public function AtendimentoEspecial($descricao, $id_inscricao){
			return "INSERT INTO Atendimento_Especial(descricao, Inscricao_id_inscricao)
					VALUES('".$descricao."',
						   ".$id_inscricao.")";
		}

		public function AtendimentoEspecifico($descricao, $id_inscricao){
			return "INSERT INTO Atendimento_Especifico(descricao, Inscricao_id_inscricao)
					VALUES('".$descricao."',
						   ".$id_inscricao.")";
		}

		public function Candidato($etnia, $estado_civil, $sexo, $cpf, $identidade, $orgao_expedidor, $uf_identidade, $nome, $nome_mae, $nascimento, $nascionalidade, $uf_nascimento, $municipio_nascimento, $escolaridade){
			return "INSERT INTO Candidato(etnia, estado_civil, sexo, cpf, identidade, orgao_expedidor, uf_identidade, nome, nome_mae, nascimento, nascionalidade, uf_nascimento, municipio_nascimento, escolaridade)
					VALUES('".$etnia."',
						   '".$estado_civil."',
						   '".$sexo."',
						   '".$cpf."',
						   '".$identidade."',
						   '".$orgao_expedidor."',
						   '".$uf_identidade."',
						   '".$nome."',
						   '".$nome_mae."',
						   '".$nascimento."',
						   '".$nascionalidade."',
						   '".$uf_nascimento."',
						   '".$municipio_nascimento."',
						   '".$escolaridade."')";
		}

		public function Contato($id_instituicao, $id_candidato, $telefone_fixo, $telefone_celular, $email){
			return "INSERT INTO Contato(id_instituicao, id_candidato, telefone_fixo, telefone_celular, email)
					VALUES(".$id_instituicao.",
						   ".$id_candidato.",
						   '".$telefone_fixo."',
						   '".$telefone_celular."',
						   '".$email."')";
		}

		public function Curso($id_instituicao, $nome, $descricao){
			return "INSERT INTO Curso(id_instituicao, nome, descricao)
					VALUES(".$id_instituicao.",
						   '".$nome."',
						   '".$descricao."')";
		}

		public function Endereco($id_instituicao, $id_candidato, $cep, $logradouro, $endereco, $numero, $complemento, $bairro, $cidade, $estado){
			return "INSERT INTO Endereco(id_instituicao, id_candidato, cep, logradouro, numero, complemento, endereco, bairro, municipio, uf)
					VALUES(".$id_instituicao.",
						   ".$id_candidato.",
						   '".$cep."',
						   '".$logradouro."',
						   '".$numero."',
						   '".$complemento."',
						   '".$endereco."',
						   '".$bairro."',
						   '".$cidade."',
						   '".$estado."')";
		}

		public function Inscricao($id_curso, $id_vestibular, $id_candidato, $lingua){
			return "INSERT INTO Inscricao(id_curso, id_vestibular, id_candidato, lingua)
					VALUES(".$id_curso.",
						   ".$id_vestibular.",
						   ".$id_candidato.",
						   '".$lingua."')";
		}

		public function Instituicao($cnpj, $razao_social, $nome_fantasia, $inscricao_municipal, $data_funcadao){
			return "INSERT INTO Instituicao(cnpj, razao_social, nome_fantasia, data_fundacao, insc_municipal)
					VALUES('".$cnpj."',
						   '".$razao_social."',
						   '".$nome_fantasia."',
						   '".$data_funcadao."',
						   '".$inscricao_municipal."')";
		}

        public function Usuario($id_instituicao, $tipo, $cpf, $senha, $nome){
            return "INSERT INTO Usuario (id_instituicao, tipo_usuario, cpf, senha, nome)
					VALUES (".$id_instituicao.",
						    '".$tipo."',
						    '".$cpf."',
						    '".$senha."',
						    '".$nome."')";
        }

		public function Vestibular($id_instituicao, $status, $data_prova, $data_inicio_inscricao, $data_termino_inscricao, $data_resultado_gabarito, $data_resultado_oficial, $edital, $gabarito, $classificacao){
			return "INSERT INTO Vestibular (id_instituicao, status, data_prova, data_inscricao, data_encerramento_inscricao, data_resultado_gabarito, data_resultado_oficial, edital, gabarito, resultado_classificacao)
					VALUES(".$id_instituicao.",
						   '".$status."',
						   '".$data_prova."',
						   '".$data_inicio_inscricao."',
						   '".$data_termino_inscricao."',
						   '".$data_resultado_gabarito."',
						   '".$data_resultado_oficial."',
						   '".$edital."',
						   '".$gabarito."',
						   '".$classificacao."')";
		}

		public function VestibularCurso($id_vestibular, $id_curso, $vagas){
			return "INSERT INTO Vestibular_has_Curso(id_vestibular, id_curso, vagas)
					VALUES(".$id_vestibular.",
						   ".$id_curso.",
						   ".$vagas.")";
		}
    }
?>