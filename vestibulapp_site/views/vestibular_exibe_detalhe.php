<!DOCTYPE html>
<html>
	<?php include_once 'views/includes/head.php'; ?>

	<script type="text/javascript" src="views/js/mascara.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

	<script>
	$(document).ready(function(){
		$("#visualiza_candidato").hide();
		$("#candidato").click(function(){
			$("#visualiza_candidato").toggle(1000);
		});
	});
	</script>

	<body>
		<div class="global"> 
			<div class="corpo">
				<?php include_once 'views/includes/topo.php'; ?>
				<div class="conteudo" id="conteudo">
					<?php include_once 'views/includes/menu.php'; ?>
					<div class="content" id="content">
						<div class="listVestibularDetalhe" id="listVestibularDetalhe">
							<?php
							 	include_once 'models/vestibular_selectById.php';
								include_once 'utilitarios/formatacao.php';

								$formata = new Formatacao();
								
								if($resp[2] == 'P') $status = 'Previsto';
								else if($resp[2] == 'E') $status = 'Em Andamento'; 
							 	else $status = 'Encerrado';

							 	$vestibular = $resp[0];
							 	$dt_prova = $formata->dataFormata($resp[3]);
							 	$dt_insc = $formata->dataFormata($resp[4]);
							 	$dt_encerramento = $formata->dataFormata($resp[5]);
							 	$dt_gabarito = $formata->dataFormata($resp[6]);
							 	$dt_resultado = $formata->dataFormata($resp[7]);
								$edital = $resp[8];
								$gabarito = $resp[9];
								$resultado = $resp[10];

								if($edital == 'null') $edital = "";
								else $edital = "<a class='pdf' href=\"loader.php?status=13&id=$edital\">Edital</a>";
								if($gabarito == 'null') $gabarito = "";
								else $gabarito = "<a class='pdf' href=\"loader.php?status=13&id=$gabarito\">Gabarito</a>";
								if($resultado == 'null') $resultado = "";
								else $resultado = "<a class='pdf' href=\"loader.php?status=13&id=$resultado\">Resultado</a>";

							 	echo "	
							<div class=\"part1\">							 								 	
								<table>
									<tr>
										<th colspan=\"2\">Dados do Vestibular</th>
									</tr>
									<tr>
										<th>Status</th>
										<td>$status</td>
									</tr>
									<tr>
										<th>Data Prova</th>
										<td>$dt_prova</td>
									</tr>
									<tr>
										<th>Data Inscrição</th>
										<td>$dt_insc</td>
									</tr>
									<tr>
										<th>Data Encerramento Inscrição</th>
										<td>$dt_encerramento</td>
									</tr>
									<tr>
										<th>Data Gabarito</th>
										<td>$dt_gabarito</td>
									</tr>
									<tr>
										<th>Data Resultado</th>
										<td>$dt_resultado</td>
									</tr>
									<tr>
										<th>Edital</th>
										<td>$edital</td>
									</tr>
									<tr>
										<th>Gabarito</th>
										<td>$gabarito</td>
									</tr>
									<tr>
										<th>Classificação</th>
										<td>$resultado</td>
									</tr>
									<tr>
										<th colspan=\"2\"></th>
									</tr>
								</table>
							</div>
							<div class=\"part2\">
									<table>
										<tr>
											<th>Curso</th>
											<th>Vaga</th>
										</tr>
							";
							
							$cont = 0;
							for ($i=0; $i < count($curso) ; $i++) {
								if($curso[$i] == 'inicio'){
									$cont = $i;
									continue;
								}
								else if($i == $cont + 2){
									$faculdade = $curso[$i];
								}
								else if($i == $cont + 1){
									$vaga = $curso[$i];
								}

								if($i == $cont + 2){
									echo "
										<tr>
							 				<td>$faculdade</td>
							 				<td>$vaga</td>
							 			</tr>
									";
								}
							}
							echo "
									</table>
								</div>
								<a class=\"editarPdf\" href=\"loader.php?status=14&id=$vestibular\">Editar</a>
							";
							?>
						</div>
						<div class="content" id="content">
							<button id='candidato'>Visualizar Candidatos</button>
							<div class="listVestibular" id="listVestibular">
								<table id='visualiza_candidato'>
									<tr>
										<th>Nome</th>
										<th>CPF</th>
										<th>Sexo</th>
										<th>Data Nascimento</th>
										<th>Curso</th>
									</tr>
									<tr>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</div>
				<?php include_once 'views/includes/footer.php'; ?>
			</div>
		</div>
	</body>
</html>