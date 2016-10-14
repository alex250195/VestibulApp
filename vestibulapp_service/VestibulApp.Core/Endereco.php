<?php
    include_once '../../VestibulApp.Data/Connect.php';
    include_once '../../VestibulApp.Data/Insert.php';
    include_once '../../VestibulApp.Data/Delete.php';
    include_once '../../VestibulApp.Data/Update.php';
    include_once '../../VestibulApp.Data/SelectAll.php';
    include_once '../../VestibulApp.Data/SelectById.php';
    include_once '../../VestibulApp.Data/SelectBySpecification.php';
    
    class Endereco{
        private $id_instituicao;
        private $id_candidato;
        private $cep;
        private $logradouro;
        private $numero;
        private $complemento;
        private $endereco;
        private $bairro;
        private $cidade;
        private $estado;

        public function openConnect(){
            $this->connection = new Connect();
            $this->connection->connect();
        }

        public function disconnect(){
            $this->connection->closeConnection();
        }

       	public function getId_instituicao(){
            return $this->id_instituicao;
        }

        public function setId_instituicao($id_instituicao){
            $this->id_instituicao = $id_instituicao;
        }

        public function getId_candidato(){
            return $this->id_candidato;
        }

        public function setId_candidato($id_candidato){
            $this->id_candidato = $id_candidato;
        }

        public function getCep(){
            return $this->cep;
        }

        public function setCep($cep){
            $this->cep = $cep;
        }

        public function getLogradouro(){
            return $this->logradouro;
        }

        public function setLogradouro($logradouro){
            $this->logradouro = $logradouro;
        }

        public function getNumero(){
            return $this->numero;
        }

        public function setNumero($numero){
            $this->numero = $numero;
        }

        public function getComplemento(){
            return $this->complemento;
        }

        public function setComplemento($complemento){
            $this->complemento = $complemento;
        }

        public function getEndereco(){
            return $this->endereco;
        }

        public function setEndereco($endereco){
            $this->endereco = $endereco;
        }

        public function getBairro(){
            return $this->bairro;
        }

        public function setBairro($bairro){
            $this->bairro = $bairro;
        }

        public function getCidade(){
            return $this->cidade;
        }

        public function setCidade($cidade){
            $this->cidade = $cidade;
        }

        public function getEstado(){
            return $this->estado;
        }

        public function setEstado($estado){
            $this->estado = $estado;
        }

        public function Insert(){
            try{      
                $insert = new Insert();
                $insert = $insert->Endereco($this->id_instituicao, $this->id_candidato, $this->cep, $this->logradouro, $this->endereco, $this->numero, $this->complemento, $this->bairro, $this->cidade, $this->estado);
                
                return mysqli_query($this->connection->getMySqli(), $insert);
            }catch(Exception $ex){
                return $ex;
            }          
        } 

        public function Delete(){

        }

        public function Update(){  
            try{
                $update = new Update();
                $update = $update->Endereco($this->id_instituicao, $this->id_candidato, $this->cep, $this->logradouro, $this->endereco, $this->numero, $this->complemento, $this->bairro, $this->cidade, $this->estado);

                return mysqli_query($this->connection->getMySqli(), $update);
            }catch(Exception $ex){
                return $ex;
            }
        }
    }
?>