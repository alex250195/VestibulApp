<?php
    include_once '../../VestibulApp.Data/Connect.php';
    include_once '../../VestibulApp.Data/Insert.php';
    include_once '../../VestibulApp.Data/Delete.php';
    include_once '../../VestibulApp.Data/Update.php';
    include_once '../../VestibulApp.Data/SelectAll.php';
    include_once '../../VestibulApp.Data/SelectById.php';
    include_once '../../VestibulApp.Data/SelectBySpecification.php';

    class Usuario{
        private $id;
        private $instituicao;
        private $tipo;
        private $cpf;
        private $senha;
        private $nome;

        private $connection;

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

        public function setInstituicao($instituicao){ 
            $this->instituicao = $instituicao; 
        }
        
        public function getInstituicao(){ 
            return $this->instituicao; 
        }

        public function setTipo($tipo){ 
            $this->tipo = $tipo; 
        }
        
        public function getTipo(){ 
            return $this->tipo; 
        }

        public function setCpf($cpf){ 
            $this->cpf = $cpf; 
        }
        
        public function getCpf(){ 
            return $this->cpf; 
        }

        public function setSenha($senha){ 
            $this->senha = $senha; 
        }
        
        public function getSenha(){ 
            return $this->senha; 
        }

        public function setNome($nome){ 
            $this->nome = $nome; 
        }

        public function getNome(){ 
            return $this->nome; 
        }

        public function Insert(){			
            try{               
                $insert = new Insert();
                $insert = $insert->Usuario($this->instituicao, $this->tipo, $this->cpf, $this->senha, $this->nome);

                return mysqli_query($this->connection->getMySqli(), $insert);
            }catch(Exception $ex){
                return $ex;
            }
        } 

        public function Delete(){
            try{
                $delete = new Delete();
                $delete = $delete->Usuario($this->id);

                return mysqli_query($this->connection->getMySqli(), $delete);
            }catch(Exception $ex){
                return $ex;
            }
        }

        public function Update(){              
            try{
                $update = new Update();
                $update = $update->Usuario($this->id, $this->senha);
                
                return mysqli_query($this->connection->getMySqli(), $update);
            }catch(Exception $ex){
                return $ex;
            }
        }

        public function SelectAll(){  
            try{
                $selectAll = new SelectAll();
                $selectAll = $selectAll->Usuario();

                $resultado = mysqli_query($this->connection->getMySqli(), $selectAll);

                if(mysqli_num_rows($resultado) > 0){
                    while($row =  mysqli_fetch_assoc($resultado)) {
                        $select[] = 'inicio';
                        $select[] = $row['id_usuario'];
                        $select[] = $row['tipo_usuario'];
                        $select[] = $row['cpf'];
                        $select[] = $row['nome'];
                        $select[] = $row['senha'];
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

        public function SelectVerify(){
            try{
                $selectVerify = new SelectAll();
                $selectVerify = $selectVerify->Usuario();

                $resultado = mysqli_query($this->connection->getMySqli(), $selectVerify);

                if(mysqli_num_rows($resultado) > 0){
                    return true;
                }
                else{
                    return false;
                }
            }catch(Exception $ex){
                return $ex;
            }
        }

        public function SelectBySpecification(){  
            try{
                $selectBySpecification = new SelectBySpecification();
                $selectBySpecification = $selectBySpecification->Usuario($this->cpf, $this->senha);

                $resultado = mysqli_query($this->connection->getMySqli(), $selectBySpecification);

                if(mysqli_num_rows($resultado) > 0){
                    while($row =  mysqli_fetch_assoc($resultado)) {
                        $select[] = 'inicio';
                        $select[] = $row['id_usuario'];
                        $select[] = $row['tipo_usuario'];
                        $select[] = $row['cpf'];
                        $select[] = $row['nome'];
                    }
                    return $select;
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