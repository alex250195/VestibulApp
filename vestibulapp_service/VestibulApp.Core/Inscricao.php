<?php
    include_once '../../VestibulApp.Data/Connect.php';
    include_once '../../VestibulApp.Data/Insert.php';
    include_once '../../VestibulApp.Data/Delete.php';
    include_once '../../VestibulApp.Data/Update.php';
    include_once '../../VestibulApp.Data/SelectAll.php';
    include_once '../../VestibulApp.Data/SelectById.php';
    include_once '../../VestibulApp.Data/SelectBySpecification.php';
    
    class Inscricao{
        private $id_curso;
        private $id_vestibular;
        private $id_candidato;
        private $lingua; 

        private $connection;

        public function openConnect(){
            $this->connection = new Connect();
            $this->connection->connect();
        }

        public function disconnect(){
            $this->connection->closeConnection();
        }

       	public function getId_curso(){
            return $this->id_curso;
        }

        public function setId_curso($id_curso){
            $this->id_curso = $id_curso;
        }

        public function getId_vestibular(){
            return $this->id_vestibular;
        }

        public function setId_vestibular($id_vestibular){
            $this->id_vestibular = $id_vestibular;
        }

        public function getId_candidato(){
            return $this->id_candidato;
        }

        public function setId_candidato($id_candidato){
            $this->id_candidato = $id_candidato;
        }

        public function getLingua(){
            return $this->lingua;
        }

        public function setLingua($lingua){
            $this->lingua = $lingua;
        }

        public function Insert(){
            try{               
                $insert = new Insert();
                $insert = $insert->Inscricao($this->id_curso, $this->id_vestibular, $this->id_candidato, $this->lingua);

                return mysqli_query($this->connection->getMySqli(), $insert);
            }catch(Exception $ex){
                return $ex;
            }
        } 

        public function SelectBySpecification(){
            try{
                $selectBySpecification = new SelectBySpecification();
                $selectBySpecification = $selectBySpecification->Inscricao(" AND id_vestibular = " .$this->id_vestibular);

                $resultado = mysqli_query($this->connection->getMySqli(), $selectBySpecification);

                if(mysqli_num_rows($resultado) > 0){
                    while($row =  mysqli_fetch_assoc($resultado)) {
                        $select[] = $row['id_inscricao'];
                        $select[] = $row['id_curso'];
                        $select[] = $row['id_vestibular'];
                        $select[] = $row['id_candidato'];
                        $select[] = $row['lingua'];
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