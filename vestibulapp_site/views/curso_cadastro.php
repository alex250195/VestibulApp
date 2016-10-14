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
						<div class="cadCurso" id="cadCurso">
							<form method="get" action="models/curso_insert.php">
								<fieldset id="dados_curso">
									<legend>Dados do Curso</legend>
										<input type="text" name="curso" required placeholder='Curso' maxlength="100"><br>
										<textarea name="descricao"></textarea><br>
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