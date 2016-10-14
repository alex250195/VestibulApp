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
						<div class="listUsuario" id="listUsuario">
							<?php include_once 'models/usuario_select.php'; ?>
							<table>
								<tr>
									<th>NOME</th>
									<th>CPF</th>
									<th>TIPO</th>
								</tr>
								<?php
								$cont = 0;

								$id = "";
								$nome = "";
								$cpf = "";
								$tipo = "";
								for ($i=0; $i < count($resp) -1 ; $i++) {
									if($resp[$i] == 'inicio'){
										$cont = $i;
										continue;
									}
									else if($i == $cont + 1){
										$id = $resp[$i];
									}
									else if($i == $cont + 2){
										$tipo = $resp[$i];
									}
									else if($i == $cont +3){
										$cpf = $resp[$i];
									}
									else if($i == $cont + 4){
										$nome = $resp[$i];
									}

									if($i == $cont + 4){
										echo "
										<tr>
											";
											if($_SESSION['tipo_usuario'] == 'Master'){
												echo"
													<td><a href='loader.php?status=8&id=$id'>".$nome."</a></td>
													<td>".$cpf."</td>
													<td>".$tipo."</td>
													<td><a href='models/usuario_delete.php?id=$id'>X</a></td>
												";
											}
											else if($_SESSION['tipo_usuario'] == 'Administrador'){
												echo"
													<td><a href='loader.php?status=8&id=$id'>".$nome."</a></td>
													<td>".$cpf."</td>
													<td>".$tipo."</td>
													<td><a href='models/usuario_exclui.php?id=$id'>X</a></td>
												";
											}
											else{
												echo"
													<td>".$nome."</td>
													<td>".$cpf."</td>
													<td>".$tipo."</td>
													<td></td>
												";
											}
											echo"
										</tr>
											";
									}
								}
								?>
							</table>
						</div>
					</div>
				</div>
				<?php include_once 'views/includes/footer.php'; ?>
			</div>
		</div>
	</body>
</html>