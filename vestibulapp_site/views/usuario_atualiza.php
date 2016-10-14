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
						<div class="updateUsuario" id="updateUsuario">
							<form method="get" action="models/usuario_update.php">
								<table>
									<tr>
										<th colspan="3">Nova Senha</th>
									</tr>
									<tr>
										<th>ID</th>
										<?php 
											$id = $_GET['id'];
										?>
										<td><input type="text" name="id" value=<?php echo "$id"; ?>></td>
										<td></td>
									</tr>
									<tr>
										<th>Senha</th>
										<td><input type="password" name="senha"></td>
										<td><input type="submit" value="Alterar"></td>
									</tr>
									<tr>
										<th colspan="3"></th>
									</tr>
								</table>
							</form>
						</div>
					</div>
				</div>
				<?php include_once 'views/includes/footer.php'; ?>
			</div>
		</div>
	</body>
</html>