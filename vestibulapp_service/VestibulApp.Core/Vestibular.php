<?php
    include_once '../../VestibulApp.Data/Connect.php';
    include_once '../../VestibulApp.Data/Insert.php';
    include_once '../../VestibulApp.Data/Delete.php';
    include_once '../../VestibulApp.Data/Update.php';
    include_once '../../VestibulApp.Data/SelectAll.php';
    include_once '../../VestibulApp.Data/SelectById.php';
    include_once '../../VestibulApp.Data/SelectBySpecification.php';

    class Vestibular{
        private $id;
        private $id_instituicao;
        private $status;
        private $data_prova;
        private $data_inicio_inscricao;
        private $data_termino_inscricao;
        private $data_resultado_gabarito;
        private $data_resultado_oficial;
        private $edital;
        private $gabarito;
        private $classificacao;

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

        public function getStatus(){
            return $this->status;
        }

        public function setStatus($status){
            $this->status = $status;
        }

        public function getData_prova(){
            return $this->data_prova;
        }

        public function setData_prova($data_prova){
            $this->data_prova = $data_prova;
        }

        public function getData_inicio_inscricao(){
            return $this->data_inicio_inscricao;
        }

        public function setData_inicio_inscricao($data_inicio_inscricao){
            $this->data_inicio_inscricao = $data_inicio_inscricao;
        }

        public function getData_termino_inscricao(){
            return $this->data_termino_inscricao;
        }

        public function setData_termino_inscricao($data_termino_inscricao){
            $this->data_termino_inscricao = $data_termino_inscricao;
        }

        public function getData_resultado_gabarito(){
            return $this->data_resultado_gabarito;
        }

        public function setData_resultado_gabarito($data_resultado_gabarito){
            $this->data_resultado_gabarito = $data_resultado_gabarito;
        }

        public function getData_resultado_oficial(){
            return $this->data_resultado_oficial;
        }

        public function setData_resultado_oficial($data_resultado_oficial){
            $this->data_resultado_oficial = $data_resultado_oficial;
        }

        public function getEdital(){
            return $this->edital;
        }

        public function setEdital($edital){
            $this->edital = $edital;
        }

        public function getGabarito(){
            return $this->gabarito;
        }

        public function setGabarito($gabarito){
            $this->gabarito = $gabarito;
        }

        public function setClassificacao($classificacao){
            $this->classificacao = $classificacao;
        }

        public function getClassificacao(){
            return $this->classificacao;
        }

        public function Insert(){
            try{                
                $insert = new Insert();
                $insert = $insert->Vestibular($this->id_instituicao, $this->status, $this->data_prova, $this->data_inicio_inscricao, $this->data_termino_inscricao, $this->data_resultado_gabarito, $this->data_resultado_oficial, $this->edital, $this->gabarito, $this->classificacao);
                
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
                $update = $update->Vestibular($this->id, $this->gabarito, $this->classificacao);

                return mysqli_query($this->connection->getMySqli(), $update);
            }catch(Exception $ex){
                return $ex;
            }
        }

        public function SelectAll(){
            try{
                $select = new SelectAll();
                $select = $select->Vestibular();

                $resultado = mysqli_query($this->connection->getMySqli(), $select);
                
                if(mysqli_num_rows($resultado) > 0){
                    while($row =  mysqli_fetch_assoc($resultado)) {
                        $data[] = "inicio";
                        $data[] = $row['id_vestibular'];
                        $data[] = $row['status'];
                        $data[] = $row['data_inscricao'];
                        $data[] = $row['data_prova'];
                    }
                    return $data;
                }
            }catch(Exception $ex){
                return $ex;
            }
        }

        public function SelectById(){
            try{
                $select = new SelectById();
                $select = $select->Vestibular($this->id);

                $resultado = mysqli_query($this->connection->getMySqli(), $select);
                
                if(mysqli_num_rows($resultado) > 0){
                    while($row =  mysqli_fetch_assoc($resultado)) {
                        $data[] = $row['id_vestibular'];
                        $data[] = $row['id_instituicao'];
                        $data[] = $row['status'];
                        $data[] = $row['data_prova'];
                        $data[] = $row['data_inscricao'];
                        $data[] = $row['data_encerramento_inscricao'];
                        $data[] = $row['data_resultado_gabarito'];
                        $data[] = $row['data_resultado_oficial'];
                        $data[] = $row['edital'];
                        $data[] = $row['gabarito'];
                        $data[] = $row['resultado_classificacao'];
                    }
                    return $data;
                }
            }catch(Exception $ex){
                return $ex;
            }
        }

        public function SelectBySpecification(){
            
        }

        public function SelectVerify(){
            try{
                $select = new SelectBySpecification();
                $select = $select->Vestibular(" ORDER BY data_prova DESC LIMIT 1");
                
                $resultado = mysqli_query($this->connection->getMySqli(), $select);

                if(mysqli_num_rows($resultado) > 0){
                    while($row =  mysqli_fetch_assoc($resultado)) {
                        return $row['id_vestibular'];
                    }
                }
            }catch(Exception $ex){
                return $ex;
            }
        }
    }
?>