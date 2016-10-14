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
						<div class="cadVestibular" id="cadVestibular">
							<form method="post" action="models/vestibular_insert.php" enctype="multipart/form-data">
								<fieldset id="dados_vestibular">
									<legend>Dados do Vestibular</legend>
										<input type="text" name="dt_prova" onkeypress="mascara(this, '##/##/####')" required placeholder='Data Prova' maxlength="10">
										<input type="text" name="dt_inscricao" onkeypress="mascara(this, '##/##/####')" required placeholder='Data Inscrição' maxlength="10">
										<input type="text" name="dt_encerramento" onkeypress="mascara(this, '##/##/####')" required placeholder='Data Encerramento' maxlength="10">
										<input type="text" name="dt_gabarito" onkeypress="mascara(this, '##/##/####')" required placeholder='Data Gabarito' maxlength="10">
										<input type="text" name="dt_resultado" onkeypress="mascara(this, '##/##/####')" required placeholder='Data Resultado' maxlength="10"><br><br>
										<table>
											<tr>
												<td><p>Edital:</p></td>
												<td><input type="file" name="edital"/><br></td>
											</tr>
										 	<tr>
										 		<td><p>Gabarito:</p></td>
										 		<td><input type="file" name="gabarito" disabled><br></td>
										 	</tr>
										 	<tr>
										 		<td><p>Classificação:</p></td>
										 		<td><input type="file" name="classificacao" disabled><br></td>
										 	</tr>
										</table>
								</fieldset>
								<fieldset id="cursos">
									<legend>Curso</legend>
										<?php 
											include_once 'models/curso_select.php';

											echo "
											<table>
												<tr>
													<th></th>
													<th>Curso</th>
													<th>Vagas</th>
												</tr>
											";
											$cont = 0;
											for ($i=0; $i < count($resp); $i++) {
												if($resp[$i] == 'inicio'){
													$cont = $i;
												}
												if($i == $cont + 3){
													echo "
													<tr>
														<td><input type='checkbox' name='curso[".$i."]' value='".$resp[$i]."'></td>
														<td>".$resp[$i]."</td>
														<td><input type='text' name='vaga[".$i."]' placeholder='Vagas' size=3> </td>
													</tr>
													";
												}
											}
											echo "
												<tr>
													<th></th>
													<th></th>
													<th></th>
												</tr>
											</table>
											";
										?>
										<br>
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