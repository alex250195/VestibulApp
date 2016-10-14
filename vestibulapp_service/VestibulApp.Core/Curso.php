<?php
    include_once '../../VestibulApp.Data/Connect.php';
    include_once '../../VestibulApp.Data/Insert.php';
    include_once '../../VestibulApp.Data/Delete.php';
    include_once '../../VestibulApp.Data/Update.php';
    include_once '../../VestibulApp.Data/SelectAll.php';
    include_once '../../VestibulApp.Data/SelectById.php';
    include_once '../../VestibulApp.Data/SelectBySpecification.php';
    
    class Curso{
        private $id;
        private $id_instituicao;
        private $nome;
        private $descricao;

        public function openConnect(){
            $this->connection = new Connect();
            $this->connection->connect();
        }

        public function disconnect(){
            $this->connection->closeConnection();
        }

        public function setId($id){
            $this->id = $id;
        }

        public function getId(){
            return $this->id;
        }

       	public function getId_instituicao(){
            return $this->id_instituicao;
        }

        public function setId_instituicao($id_instituicao){
            $this->id_instituicao = $id_instituicao;
        }

        public function getNome(){
            return $this->nome;
        }

        public function setNome($nome){
            $this->nome = $nome;
        }

        public function getDescricao(){
            return $this->descricao;
        }

        public function setDescricao($descricao){
            $this->descricao = $descricao;
        }

        public function Insert(){
            try{                
                $insert = new Insert();
                $insert = $insert->Curso($this->id_instituicao, $this->nome, $this->descricao);

                return mysqli_query($this->connection->getMySqli(), $insert);
            }catch(Exception $ex){
                return $ex;
            }
        } 

        public function Delete(){
            try{
                $delete = new Delete();
                $delete = $delete->Curso($this->id);
                
                return mysqli_query($this->connection->getMySqli(), $delete);
            }catch(Exception $ex){
                return $ex;
            }
        }

        public function SelectAll(){
            try{
                $selectAll = new SelectAll();
                $selectAll = $selectAll->Curso();

                $resultado = mysqli_query($this->connection->getMySqli(), $selectAll);

                if(mysqli_num_rows($resultado) > 0){
                    while($row =  mysqli_fetch_assoc($resultado)) {
                        $select[] = 'inicio';
                        $select[] = $row['id_curso'];
                        $select[] = $row['id_instituicao'];
                        $select[] = $row['nome'];
                        $select[] = $row['descricao'];
                    }
                    return $select;
                }
                else if(!$resultado){
                    return false;
                }
                else{
                    return true;
                }
            }catch(Exception $ex){
                return $ex;
            }
        }

        public function SelectBySpecification(){
            try{
                $selectBySpecification = new SelectBySpecification();
                $selectBySpecification = $selectBySpecification->Curso(" AND nome = '".$this->nome."'");

                $resultado = mysqli_query($this->connection->getMySqli(), $selectBySpecification);

                if(mysqli_num_rows($resultado) > 0){
                    while($row =  mysqli_fetch_assoc($resultado)) {
                        return $row['id_curso'];
                    }
                }
                else if(!$resultado){
                    return false;
                }
                else{
                    return true;
                }
            }catch(Exception $ex){
                return $ex;
            }
        }
    }
?>