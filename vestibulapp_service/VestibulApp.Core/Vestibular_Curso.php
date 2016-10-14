<?php
    include_once '../../VestibulApp.Data/Connect.php';
	include_once '../../VestibulApp.Data/Insert.php';
    include_once '../../VestibulApp.Data/Delete.php';
    include_once '../../VestibulApp.Data/Update.php';
    include_once '../../VestibulApp.Data/SelectAll.php';
    include_once '../../VestibulApp.Data/SelectById.php';
    include_once '../../VestibulApp.Data/SelectBySpecification.php';

    class VestibularCurso{
        private $id_vestibular;
        private $id_curso;
        private $vaga;

        private $connection;

        public function openConnect(){
            $this->connection = new Connect();
            $this->connection->connect();
        }

        public function disconnect(){
            $this->connection->closeConnection();
        }

       	public function getId_vestibular(){
            return $this->id_vestibular;
        }

        public function setId_vestibular($id_vestibular){
            $this->id_vestibular = $id_vestibular;
        }

        public function getId_curso(){
            return $this->id_curso;
        }

        public function setId_curso($id_curso){
            $this->id_curso = $id_curso;
        }

        public function getVaga(){
            return $this->vaga;
        }

        public function setVaga($vaga){
            $this->vaga = $vaga;
        }

        public function Insert(){
            try{                
                $insert = new Insert();
                $insert = $insert->VestibularCurso($this->id_vestibular, $this->id_curso, $this->vaga);
                
                return mysqli_query($this->connection->getMySqli(), $insert);
            }catch(Exception $ex){
                return $ex;
            }
        } 

        public function Delete(){
            
        }

        public function Update(){  
            
        }

        public function SelectAll(){
            
        }

        public function SelectById(){
            
        }

        public function SelectBySpecification(){
            
        }

        public function SelectByCurso(){
            try{
                $select = new SelectBySpecification();
                $select = $select->VestibularCurso(" AND `vestibular_has_curso`.`id_vestibular` = " .$this->id_vestibular. " ");
            
                $resultado = mysqli_query($this->connection->getMySqli(), $select);

                if(mysqli_num_rows($resultado) > 0){
                    while($row =  mysqli_fetch_assoc($resultado)) {
                        $data[] = "inicio";
                        $data[] = $row['vagas'];
                        $data[] = $row['nome'];
                    }
                    return $data;
                }
            }catch(Exception $e){
                return $e->getMessage();
            }
        }
    }
?>