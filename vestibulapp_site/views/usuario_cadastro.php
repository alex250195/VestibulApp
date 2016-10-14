<!DOCTYPE html>
<html>
	<?php 
		include_once 'views/includes/head.php'; 
		include_once 'models/instituicao_verify.php';

		if(!$result)
			echo "<script>alert ('Favor cadastrar a Instituição!'); window.location='loader.php?status=3';</script>";
	?>

	<script type="text/javascript" src="views/js/mascara.js"></script>

	<body>
		<div class="global"> 
			<div class="corpo">
				<?php include_once 'views/includes/topo.php'; ?>
				<div class="conteudo" id="conteudo">
					<?php include_once 'views/includes/menu.php'; ?>
					<div class="content" id="content">
						<div class="cadUsuario" id="cadUsuario">
							<form method="get" action="models/usuario_insert.php">
								<fieldset id="dados_usuario">
									<legend>Dados do Usuário</legend>
										<input type="text" name="nome" required placeholder='Nome' maxlength="100"/>
										<input type="text" name="cpf" onkeypress="mascara(this, '###.###.###-##')" required placeholder='CPF' maxlength="14" value=" "/>
										<input type="password" name="senha" required placeholder='Senha' maxlength="10"/>
										<select name="tipo">
											<option></option>
											<option value="Master">Master</option>
											<option value="Administrador">Administrador</option>
											<option value="Coordenador">Coordenador</option>
										</select>
										<input type="submit" value="Cadastrar">
								</fieldset>
							</form>
						</div>
					</div>
				</div>
				<?php include_once 'views/includes/footer.php'; ?>
			</div>
		</div>
	</body>
</html>