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
						<div class="listCurso" id="listCurso">
							<?php 
							include_once 'models/curso_select.php';

							for ($i=0; $i < count($resp); $i++) {

								if($resp[$i] == 'inicio'){
									$cont = $i;
									continue;
								}
								else if($i == $cont + 1){
									$idCurso = $resp[$i];
								}
								else if($i == $cont + 2){
									$idInstituicao = $resp[$i];
								}
								else if($i == $cont +3){
									$nome = $resp[$i];
								}
								else if($i == $cont + 4){
									$descricao = $resp[$i];
								}

								if($i == $cont + 4){
									echo "
									<table>
										<tr>
											<th>".$nome."</th>
											<th><a href='models/curso_delete.php?id=$idCurso'>X</a></th>
										</tr>
										<tr>
											<td collspan='2'>".$descricao."</td>
										</tr>
									</table>
									";
								}
							}
							?>
						</div>
					</div>
				</div>
				<?php include_once 'views/includes/footer.php'; ?>
			</div>
		</div>
	</body>
</html>