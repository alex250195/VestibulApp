<?php
    include_once '../../VestibulApp.Data/Connect.php';
    include_once '../../VestibulApp.Data/Insert.php';
    include_once '../../VestibulApp.Data/Delete.php';
    include_once '../../VestibulApp.Data/Update.php';
    include_once '../../VestibulApp.Data/SelectAll.php';
    include_once '../../VestibulApp.Data/SelectById.php';
    include_once '../../VestibulApp.Data/SelectBySpecification.php';
    
    class AtendimentoEspecial{
        private $descricao;
        private $inscricao;

        private $connection;

        public function openConnect(){
            $this->connection = new Connect();
            $this->connection->connect();
        }

        public function disconnect(){
            $this->connection->closeConnection();
        }

        public function setDescricao($descricao){ 
            $this->descricao = $descricao; 
        }
        
        public function getDescricao(){ 
            return $this->descricao; 
        }

        public function setInscricao($inscricao){ 
            $this->inscricao = $inscricao; 
        }
        
        public function getInscricao(){ 
            return $this->inscricao; 
        }

        public function Insert(){
            try{
                $insert = new Insert();
                $insert = $insert->AtendimentoEspecial($this->descricao, $this->inscricao);

                return mysqli_query($this->connection->getMySqli(), $insert);
            }catch(Exception $ex){
                return $ex;
            }
        }

        public function SelectBySpecification(){
            try{
                $selectBySpecification = new SelectBySpecification();
                $selectBySpecification = $selectBySpecification->AtendimentoEspecial(" AND Inscricao_id_inscricao = " .$this->inscricao);

                $resultado = mysqli_query($this->connection->getMySqli(), $selectBySpecification);

                if(mysqli_num_rows($resultado) > 0){
                    while($row =  mysqli_fetch_assoc($resultado)) {
                        $select[] = $row['id_especial'];
                        $select[] = $row['descricao'];
                        $select[] = $row['Inscricao_id_inscricao'];
                        return $select;
                    }
                }
                else{
                    return false;
                }
            }catch(Exception $ex){
                return $ex;
            }
        }
    }
?>