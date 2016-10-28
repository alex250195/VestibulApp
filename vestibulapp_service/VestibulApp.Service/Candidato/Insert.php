<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.insertCandidato', 'urn:server.insertCandidato');
	$server->wsdl->schemaTargetNamespace = 'urn:server.insertCandidato';

	$server->register(
		'insertCandidato',
		array('etnia' => 'xsd:string',
              'estadoCivil' => 'xsd:string',
			  'sexo' => 'xsd:string',
			  'cpf' => 'xsd:string',
			  'identidade' => 'xsd:string',
			  'orgaoExpedidor' => 'xsd:string',
			  'ufIdentidade' => 'xsd:string',
			  'nome' => 'xsd:string',
			  'nomeMae' => 'xsd:string',
			  'nascimento' => 'xsd:string',
			  'nascionalidade' => 'xsd:string',
			  'ufNasicmento' => 'xsd:string',
			  'municipioNascimento' => 'xsd:string',
			  'escolaridade' => 'xsd:string',
			  'senha' => 'xsd:string',
			  'curso' => 'xsd:string',),
		array('return' => 'xsd:string'),
		'urn:server.insertCandidato',
		'urn:server.insertCandidato#insertCandidato',
		'rpc',
		'encoded',
		'Insere os dados do usuario.'
	);

	function insertCandidato($etnia, $estadoCivil, $sexo, $cpf, $identidade, $orgaoExpedidor, $ufIdentidade, $nome, $nomeMae, $nascimento, $nascionalidade, $ufNascimento, $municipioNascimento, $escolaridade, $senha, $curso){
		include_once '../../VestibulApp.Core/Candidato.php';
		include_once '../../VestibulApp.Core/Contato.php';
		include_once '../../VestibulApp.Core/Endereco.php';
		include_once '../../VestibulApp.Core/AtendimentoEspecial.php';
		include_once '../../VestibulApp.Core/AtendimentoEspecifico.php';
		include_once '../../VestibulApp.Core/Inscricao.php';
		include_once '../../VestibulApp.Core/Curso.php';
		include_once '../../VestibulApp.Core/Vestibular.php';

		$candidato = new Candidato();
		$contato = new Contato();
		$endereco = new Endereco();
		$atendimentoEspecial = new AtendimentoEspecial();
		$atendimentoEspecifico = new AtendimentoEspecifico();
		$inscricao = new Inscricao();
		$curso = new Curso();
		$vestibular = new Vestibular();

        $candidato->setEtnia($etnia);
		$candidato->setEstado_civil($estadoCivil);
		$candidato->setSexo($sexo);
		$candidato->setCpf($cpf);
		$candidato->setIdentidade($identidade);
        $candidato->setOrgao_expedidor($orgaoExpedidor);
        $candidato->setUf_identidade($ufIdentidade);
        $candidato->setNome($nome);
        $candidato->setNome_mae($nomeMae);
        $candidato->setNascimento($nascimento);
        $candidato->setNascionalidade($nascionalidade);
        $candidato->setUf_nascimento($ufNascimento);
        $candidato->setMunicipio_nascimento($municipioNascimento);
        $candidato->setEscolaridade($escolaridade);
        $candidato->setSenha($senha);

		$candidato->openConnect();
		$candidato->Insert();
		$idCandidato = $candidato->SelectBySpecification(" AND cpf =  " .$cpf)['id_candidato'];
		$candidato->disconnect();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>