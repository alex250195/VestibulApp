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
						<div class="listVestibular" id="listVestibular">
							<table>
								<tr>
									<th></th>
									<th>Status</th>
									<th>Data da Inscrição</th>
									<th>Data da Prova</th>
									<th></th>
								</tr>
								<?php 
									include_once 'models/vestibular_selectAll.php';
									include_once 'utilitarios/formatacao.php'; 

									$cont = 0;

									$id = "";
									$status = "";
									$dtInscricao = "";
									$dtProva = "";

									$formata = new Formatacao();

									for ($i=0; $i < count($resp) ; $i++) {
										if($resp[$i] == 'inicio'){
											$cont = $i;
											continue;
										}
										else if($i == $cont + 1){
											$id = $resp[$i];
										}
										else if($i == $cont + 2){
											$status = $resp[$i];
										}
										else if($i == $cont +3){
											$dtInscricao = $formata->dataFormata($resp[$i]);
										}
										else if($i == $cont + 4){
											$dtProva = $formata->dataFormata($resp[$i]);
										}

										if($i == $cont + 4){
											echo "
											<tr>
												<td>$id</td>
												<td>$status</td>
												<td>$dtInscricao</td>
												<td>$dtProva</td>
												<td><a href='loader.php?status=12&id=$id'>Visualizar</a></td>
											</tr>
											";
										}
									}
								?>
							</table>
							<br>
						</div>
					</div>
				</div>
				<?php include_once 'views/includes/footer.php'; ?>
			</div>
		</div>
	</body>
</html>