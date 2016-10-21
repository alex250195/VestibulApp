<!DOCTYPE html>
<html>
	<?php include_once 'views/includes/head.php' ?>

	<script type="text/javascript" src="views/js/mascara.js"></script>

	<body>
		<div class="global"> 
			<div class="corpo">
				<?php include_once 'views/includes/topo.php'; ?>
				<div class="conteudo" id="conteudo">
					<div class="login" id="login">
						<h5>Acesse sua Conta</h5>
						<form method="get" action="models/login_verify.php">
							<input type="text" name="login" placeholder='Login' onkeypress="mascara(this, '###.###.###-##')" autocomplete='off' maxlength="14"><br>
							<input type="password" name="senha" placeholder='Senha'><br>
							<input type="submit" value="Acessar"><br>
						</form>
					</div>
				</div>
				<?php include_once 'views/includes/footer.php'; ?>
			</div>
		</div>
	</body>
</html>