<!DOCTYPE html>
<html>
	<?php 
		include_once 'views/includes/head.php';
		include_once 'models/instituicao_verify.php';

		if($result)
			echo "<script>alert ('Instituição já cadastrada!'); window.location='loader.php?status=9';</script>"; 
	?>

	<script type="text/javascript" src="views/js/mascara.js"></script>

	<body>
		<div class="global"> 
			<div class="corpo">
				<?php include_once 'views/includes/topo.php'; ?>
				<div class="conteudo" id="conteudo">
					<?php include_once 'views/includes/menu.php'; ?>
					<div class="content" id="content">
						<div class="cadInstituicao" id="cadInstituicao">
							<form method="get" action="models/instituicao_insert.php">
								<fieldset id="dados_empresa">
									<legend>Dados da Instituição</legend>
										<input type="text" name="razaoSocial" required placeholder='* Razão Social'><br>
										<input type="text" name="nomeFantasia"  required placeholder='* Nome Fantasia'><br>
										<input type="text" name="cnpj" onkeypress="mascara(this, '##.###.###/####-##')" required="" placeholder='* CNPJ' maxlength="18">
										<input type="text" name="fundacao" onkeypress="mascara(this, '##/##/####')" required="" placeholder='* Fundação' maxlength="10">
										<input type="text" name="inscMunicipal" required placeholder='* Inscrição Municipal' maxlength="15"><br>
								</fieldset>
								<fieldset id="contato_empresa">
									<legend>Contato</legend>
										<input type="text" name="tel_celular" onkeypress="mascara(this, '## #-####-####')" required placeholder='* Telefone Celular' maxlength="14">
										<input type="text" name="tel_fixo" onkeypress="mascara(this, '## ####-####')" required placeholder='* Telefone Fixo' maxlength="12">
										<input type="text" name="email" required placeholder='* E-mail' maxlength="100">
								</fieldset>
								<fieldset id="endereco_empresa">
									<legend>Endereço</legend>
										<input type="text" name="cep" onkeypress="mascara(this, '##.###-###')" required placeholder='* CEP' maxlength="10">
										<input type="text" name="logradouro" required placeholder='* Logradouro' maxlength="30">
										<input type="text" name="endereco" required placeholder='* Endereço' maxlength="100">
										<input type="text" name="numero" required placeholder='* N⁰' maxlength="5">
										<input type="text" name="complemento" placeholder='* Complemento' maxlength="30">
										<input type="text" name="bairro" required placeholder='* Bairro' maxlength="30">
										<input type="text" name="municipio" required placeholder='* Município' maxlength="30">
										<select name="uf">
											<option>* UF</option>
											<option value="AC">AC</option>
											<option value="AL">AL</option>
											<option value="AP">AP</option>
											<option value="AM">AM</option>
											<option value="BA">BA</option>
											<option value="CE">CE</option>
											<option value="DF">DF</option>
											<option value="ES">ES</option>
											<option value="GO">GO</option>
											<option value="MA">MA</option>
											<option value="MT">MT</option>
											<option value="MS">MS</option>
											<option value="MG">MG</option>
											<option value="PA">PA</option>
											<option value="PB">PB</option>
											<option value="PR">PR</option>
											<option value="PE">PE</option>
											<option value="PI">PI</option>
											<option value="RJ">RJ</option>
											<option value="RN">RN</option>
											<option value="RS">RS</option>
											<option value="RO">RO</option>
											<option value="RR">RR</option>
											<option value="SC">SC</option>
											<option value="SP">SP</option>
											<option value="SE">SE</option>
											<option value="TO">TO</option>
										</select>
								</fieldset>
								<input type="submit" value="Cadastrar">
							</form>
						</div>
					</div>
				</div>
				<?php include_once 'views/includes/footer.php'; ?>
			</div>
		</div>
	</body>
</html>