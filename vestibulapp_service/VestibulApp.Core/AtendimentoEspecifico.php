<?php
    include_once '../../VestibulApp.Data/Connect.php';
    include_once '../../VestibulApp.Data/Insert.php';
    include_once '../../VestibulApp.Data/Delete.php';
    include_once '../../VestibulApp.Data/Update.php';
    include_once '../../VestibulApp.Data/SelectAll.php';
    include_once '../../VestibulApp.Data/SelectById.php';
    include_once '../../VestibulApp.Data/SelectBySpecification.php';
    
    class AtendimentoEspecifico{
        private $descricao;
        private $inscricao;

        public function setDescricao($descricao){ 
            $this->descricao = $descricao; 
        }
        
        public function getDescricao(){ 
            return $this->descricao; 
        }

        public function setInscricao($tipo){ 
            $this->inscricao = $inscricao; 
        }
        
        public function getInscricao(){ 
            return $this->inscricao; 
        }

        public function Insert(){
            try{
                $insert = new Insert();
                $insert = $insert->AtendimentoEspecifico($this->descricao, $this->inscricao);

                return mysqli_query($this->connection->getMySqli(), $insert);
            }catch(Exception $ex){
                return $ex;
            }
        }
    }
?>