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
							<form method="post" action="models/vestibular_update.php" enctype="multipart/form-data">
								<?php
									$vest = $_GET['id'];
								?>
								<table>
									<tr>
										<th colspan="3">Atualizar Vestibular</th>
									</tr>
									<tr>
										<th>Vestibular</th>
										<td colspan="2"><input type="text" name="vestibular" value=<?php echo $vest ?> size='1' style='text-align: center;'></td>
									</tr>
									<tr>
										<th>Gabarito</th>
										<td><input type="file" name="gabarito"></td>
										<td></td>
									</tr>
									<tr>
										<th>Resultado</th>
										<td><input type="file" name="resultado"></td>
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