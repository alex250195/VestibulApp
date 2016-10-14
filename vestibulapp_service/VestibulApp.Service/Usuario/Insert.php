<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.insertUsuario', 'urn:server.insertUsuario');
	$server->wsdl->schemaTargetNamespace = 'urn:server.insertUsuario';

	$server->register(
		'insertUsuario',
		array('instituicao' => 'xsd:string',
              'tipo' => 'xsd:string',
			  'cpf' => 'xsd:string',
			  'senha' => 'xsd:string',
			  'nome' => 'xsd:string'),
		array('return' => 'xsd:string'),
		'urn:server.insertUsuario',
		'urn:server.insertUsuario#insertUsuario',
		'rpc',
		'encoded',
		'Insere os dados do usuario.'
	);

	function insertUsuario($instituicao, $tipo, $cpf, $senha, $nome){
		include_once '../../VestibulApp.Core/Usuario.php';
		
		$usuario = new Usuario();

        $usuario->setInstituicao($instituicao);
		$usuario->setTipo($tipo);
		$usuario->setCpf($cpf);
		$usuario->setSenha($senha);
		$usuario->setNome($nome);

		$usuario->openConnect();

		return $usuario->Insert();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>