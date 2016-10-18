<?php
    class Connect{
        private $host = 'mysql.hostinger.com.br';
		private $port = 3307;
		private $usuario = 'u153731406_vesti';
		private $senha = 'vesti.0119';
		private $banco = 'u153731406_vesti';
		private $mySqli;

		public function connect(){
			$this->mySqli = new mysqli($this->host, $this->usuario, $this->senha, $this->banco, $this->port);
			if(mysqli_connect_errno()){
				die ("<br>Não foi possivel conectar-se ao banco de dados: ".mysqli_connect_error());
				exit();
			}
		}

		public function getMySqli(){
			return $this->mySqli;
		}

		public function closeConnection(){
			$this->mySqli->close();
		}   
    }
?>