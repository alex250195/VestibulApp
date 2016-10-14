<!DOCTYPE html>
<html>
	<?php include_once 'views/includes/head.php'; ?>

	<script type="text/javascript" src="views/js/mascara.js"></script>

	<body>
		<div class="global"> 
			<div class="corpo">
				<?php include_once 'views/includes/topo.php'; ?>
				<div class="conteudo" id="conteudo">
					<?php include_once 'views/includes/menu.php'; ?>
					<div class="content" id="content">
						<div class="listInstituicao" id="listInstituicao">
							<?php 
							include_once 'models/instituicao_select.php';
							echo "
							<form method='get' action='models/instituicao_update.php'>
								<table>
									<tr>
										<th colspan='3'>Dados da Instituição</th>
									</tr>
									<tr>
										<th>Data Fundação</th>
										<td colspan='2'>".$dataFundacao."</td>
									</tr>
									<tr>
										<th>Razão Social</th>
										<td colspan='2'><input type='text' name='razaoSocial' value='".$razaoSocial."' enabled required></td>
									</tr>
									<tr>
										<th>Nome Fantasia</th>
										<td colspan='2'><input type='text' name='nomeFantasia' value='".$nomeFantasia."' enabled required></td>
									</tr>
									<tr>
										<th>CNPJ</th>
										<td colspan='2'>".$cnpj."</td>
									</tr>
									<tr>
										<th>I.M.</th>
										<td colspan='2'>".$inscMunicipal."</td>
									</tr>
									<tr>
										<th>Cursos</th>
										<td colspan='2'><a href='loader.php?status=10'>Visualizar</a></td>
									</tr>
									<tr>
										<th colspan='3'>Contato</th>
									</tr>
									<tr>
										<th>Telefone Celular</th>
										<td colspan='2'><input type='text' name='celular' onkeypress=\"mascara(this, '## #-####-####')\" value='".$celular."' maxlength=\"14\" enabled></td>
									</tr>
									<tr>
										<th>Telefone Fixo</th>
										<td colspan='2'><input type='text' name='fixo' onkeypress=\"mascara(this, '## ####-####')\" value='".$fixo."' enabled></td>
									</tr>
									<tr>
										<th>Email</th>
										<td colspan='2'><input type='text' name='email' value='".$email."' enabled required></td>
									</tr>
									<tr>
										<th colspan='3'>Endereço</th>
									</tr>
									<tr>
										<th>CEP</th>
										<td colspan='2'><input type='text' name='cep' value='".$cep."' enabled required></td>
									</tr>
									<tr>
										<th>Logradouro</th>
										<td colspan='2'><input type'text' name='logradouro' value='".$logradouro."' enabled required></td>
									</tr>
									<tr>
										<th>Endereço</th>
										<td colspan='2'><input type='text' name='endereco' value='".$endereco."' enabled required></td>
									</tr>
									<tr>
										<th>Número</th>
										<td colspan='2'><input type='text' name='numero' value='".$numero."' enabled required></td>
									</tr>
									<tr>
										<th>Complemento</th>
										<td colspan='2'><input type='text' name='complemento' value='".$complemento."' enabled></td>
									</tr>
									<tr>
										<th>Bairro</th>
										<td colspan='2'><input type='text' name='bairro' value='".$bairro."' enabled required></td>
									</tr>
									<tr>
										<th>Município</th>
										<td colspan='2'><input type='text' name='municipio' value='".$municipio."' enabled required></td>
									</tr>
									<tr>
										<th>UF</th>
										<td colspan='2'><input type='text' name='uf' value='".$uf."' enabled required></td>
									</tr>
									<tr>
										<th colspan='2'><input type='submit' value='Atualizar'></th>
									</tr>
								</table>
							</form>
							";
							?>
						</div>
					</div>
				</div>
				<?php include_once 'views/includes/footer.php'; ?>
			</div>
		</div>
	</body>
</html>