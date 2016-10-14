<!DOCTYPE html>
<html>
	<?php include_once 'views/includes/head.php' ?>
	<body>
		<div class="global"> 
			<div class="corpo">
				<?php include_once 'views/includes/topo.php'; ?>
				<div class="conteudo" id="conteudo">
					<?php include_once 'views/includes/menu.php'; ?>
					<div class="content" id="content">
						<?php
							$edital = $_GET['id'];
							echo "<center><iframe src=\"utilitarios/$edital\" width=\"100%\" height=\"780\" style=\"border: none;\"></iframe></center>";
						?>
					</div>
				</div>
				<?php include_once 'views/includes/footer.php'; ?>
			</div>
		</div>
	</body>
</html>