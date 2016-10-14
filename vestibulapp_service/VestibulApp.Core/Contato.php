<?php
    include_once '../../VestibulApp.Data/Connect.php';
    include_once '../../VestibulApp.Data/Insert.php';
    include_once '../../VestibulApp.Data/Delete.php';
    include_once '../../VestibulApp.Data/Update.php';
    include_once '../../VestibulApp.Data/SelectAll.php';
    include_once '../../VestibulApp.Data/SelectById.php';
    include_once '../../VestibulApp.Data/SelectBySpecification.php';
    
    class Contato{
        private $id_instituicao;
        private $id_candidato;
        private $telefone_fixo;
        private $telefone_celular;
        private $email;

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

        public function getTelefone_fixo(){
            return $this->telefone_fixo;
        }

        public function setTelefone_fixo($telefone_fixo){
            $this->telefone_fixo = $telefone_fixo;
        }

        public function getTelefone_celular(){
            return $this->telefone_celular;
        }

        public function setTelefone_celular($telefone_celular){
            $this->telefone_celular = $telefone_celular;
        }

        public function getEmail(){
            return $this->email;
        }

        public function setEmail($email){
            $this->email = $email;
        }

        public function Insert(){
            try{                
                $insert = new Insert();
                $insert = $insert->Contato($this->id_instituicao, $this->id_candidato, $this->telefone_fixo, $this->telefone_celular, $this->email);

                return mysqli_query($this->connection->getMySqli(), $insert);
            }catch(Exception $ex){
                return $ex;
            }
        } 

        public function Delete(){
            try{
                $delete = new Delete();

                if(empty($this->id_candidato)){
                    $delete = $delete->ContatoInstituicao($this->id_instituicao);
                }
                else{
                    $delete = $delete->ContatoCandidato($this->id_candidato);
                }

                return mysqli_query($this->connection->getMySqli(), $delete);
            }catch(Exception $ex){
                return $ex;
            }
        }

        public function Update(){  
            try{
                $update = new Update();
                $update = $update->Contato($this->id_instituicao, $this->id_candidato, $this->telefone_fixo, $this->telefone_celular, $this->email);
                
                return mysqli_query($this->connection->getMySqli(), $update);
            }catch(Exception $ex){
                return $ex;
            }
        }
    }
?>