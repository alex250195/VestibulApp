<?php
    class Connect{
        private $host = 'tcc.cfxuwdrgkqt2.us-west-2.rds.amazonaws.com';
		private $port = 3307;
		private $usuario = 'DBUserAlex';
		private $senha = 'Loucos129613';
		private $banco = 'VestibulApp';
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