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
			  'senha' => 'xsd:string',),
		array('return' => 'xsd:string'),
		'urn:server.insertCandidato',
		'urn:server.insertCandidato#insertCandidato',
		'rpc',
		'encoded',
		'Insere os dados do usuario.'
	);

	function insertCandidato($etnia, $estadoCivil, $sexo, $cpf, $identidade, $orgaoExpedidor, $ufIdentidade, $nome, $nomeMae, $nascimento, $nascionalidade, $ufNascimento, $municipioNascimento, $escolaridade, $senha){
		include_once '../../VestibulApp.Core/Candidato.php';

		$candidato = new Candidato();

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

		return $candidato->Insert();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>