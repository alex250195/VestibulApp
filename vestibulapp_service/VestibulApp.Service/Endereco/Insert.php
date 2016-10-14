<?php
	require_once '../../VestibulApp.Controls/lib/nusoap.php';

	$server = new soap_server;

	$server->configureWSDL('server.insertEndereco', 'urn:server.insertEndereco');
	$server->wsdl->schemaTargetNamespace = 'urn:server.insertEndereco';

	$server->register(
		'insertEndereco',
		array('idInstituicao' => 'xsd:string',
              'idCandidato' => 'xsd:string',
			  'cep' => 'xsd:string',
			  'logradouro' => 'xsd:string',
              'domicilio' => 'xsd:string',
              'numero' => 'xsd:string',
              'complemento' => 'xsd:string',
              'bairro' => 'xsd:string',
              'municipio' => 'xsd:string',
			  'uf' => 'xsd:string'),
		array('return' => 'xsd:string'),
		'urn:server.insertEndereco',
		'urn:server.insertEndereco#insertEndereco',
		'rpc',
		'encoded',
		'Insere os dados do usuario.'
	);

	function insertEndereco($idInstituicao, $idCandidato, $cep, $logradouro, $domicilio, $numero, $complemento, $bairro, $municipio, $uf){        
        include_once '../../VestibulApp.Core/Endereco.php';
		
		$endereco = new Endereco();
		
        $endereco->setId_instituicao($idInstituicao);
		$endereco->setId_candidato($idCandidato);
		$endereco->setCep($cep);
		$endereco->setLogradouro($logradouro);
		$endereco->setEndereco($domicilio);
        $endereco->setNumero($numero);
        $endereco->setComplemento($complemento);
        $endereco->setBairro($bairro);
        $endereco->setCidade($municipio);
        $endereco->setEstado($uf);
        
		$endereco->openConnect();
		
		return $endereco->Insert();
	}

	$HTTP_RAW_POST_DATA = isset($HTTP_RAW_POST_DATA) ? $HTTP_RAW_POST_DATA : '';

	$server->service($HTTP_RAW_POST_DATA);
?>