<?php
    include_once '../../VestibulApp.Data/Connect.php';
    include_once '../../VestibulApp.Data/Insert.php';
    include_once '../../VestibulApp.Data/Delete.php';
    include_once '../../VestibulApp.Data/Update.php';
    include_once '../../VestibulApp.Data/SelectAll.php';
    include_once '../../VestibulApp.Data/SelectById.php';
    include_once '../../VestibulApp.Data/SelectBySpecification.php';
    
    class Instituicao{
        private $id;
        private $cnpj;
        private $razao_social;
        private $nome_fantasia;
        private $data_fundacao;
        private $inscricao_municipal;

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

       	public function getCnpj(){
            return $this->cnpj;
        }

        public function setCnpj($cnpj){
            $this->cnpj = $cnpj;
        }

        public function getRazao_social(){
            return $this->razao_social;
        }

        public function setRazao_social($razao_social){
            $this->razao_social = $razao_social;
        }

        public function getNome_fantasia(){
            return $this->nome_fantasia;
        }

        public function setNome_fantasia($nome_fantasia){
            $this->nome_fantasia = $nome_fantasia;
        }

        public function getData_fundacao(){
            return $this->data_fundacao;
        }

        public function setData_fundacao($data_fundacao){
            $this->data_fundacao = $data_fundacao;
        }

        public function getInscricao_municipal(){
            return $this->inscricao_municipal;
        }

        public function setInscricao_municipal($inscricao_municipal){
            $this->inscricao_municipal = $inscricao_municipal;
        }

        public function Insert(){
            try{      
                $insert = new Insert();
                $insert = $insert->Instituicao($this->cnpj, $this->razao_social, $this->nome_fantasia, $this->inscricao_municipal, $this->data_fundacao);

                return mysqli_query($this->connection->getMySqli(), $insert);
            }catch(Exception $ex){
                return $ex;
            }
        } 

        public function Update(){  
            try{
                $update = new Update();
                $update = $update->Instituicao($this->id, $this->razao_social, $this->nome_fantasia);

                return mysqli_query($this->connection->getMySqli(), $update);
            }catch(Exception $ex){
                return $ex;
            }
        }

        public function SelectAll(){
            try{
                $selectAll = new SelectBySpecification();
                $selectAll = $selectAll->Instituicao();

                $resultado = mysqli_query($this->connection->getMySqli(), $selectAll);

                if(mysqli_num_rows($resultado) > 0){

                    $result = array();

                    while($row =  mysqli_fetch_assoc($resultado)) {

                        $booking = array(
                            'id_instituicao' => $row['id_instituicao'],
                            'cnpj' => $row['cnpj'],
                            'razao_social' => $row['razao_social'],
                            'nome_fantasia' => $row['nome_fantasia'],
                            'data_fundacao' => $row['data_fundacao'],
                            'insc_municipal' => $row['insc_municipal'],
                            'id_endereco' => $row['id_endereco'],
                            'cep' => $row['cep'],
                            'logradouro' => $row['logradouro'],
                            'endereco' => $row['endereco'],
                            'numero' => $row['numero'],
                            'complemento' => $row['complemento'],
                            'bairro' => $row['bairro'],
                            'municipio' => $row['municipio'],
                            'uf' => $row['uf'],
                            'id_contato' => $row['id_contato'],
                            'telefone_celular' => $row['telefone_celular'],
                            'telefone_fixo' => $row['telefone_fixo'],
                            'email' => $row['email'],
                        );

                        $result[] = new soapval('curso', 'tns:cursoDateType', $booking);
                    }

                    return $result;

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

        public function SelectAll2(){
            try{
                $selectAll = new SelectBySpecification();
                $selectAll = $selectAll->Instituicao();

                $resultado = mysqli_query($this->connection->getMySqli(), $selectAll);

                if(mysqli_num_rows($resultado) > 0){
                    while($row =  mysqli_fetch_assoc($resultado)) {
                        $select[] = $row['id_instituicao'];
                        $select[] = $row['cnpj'];
                        $select[] = $row['razao_social'];
                        $select[] = $row['nome_fantasia'];
                        $select[] = $row['data_fundacao'];
                        $select[] = $row['insc_municipal'];
                        $select[] = $row['id_endereco'];
                        $select[] = $row['cep'];
                        $select[] = $row['logradouro'];
                        $select[] = $row['endereco'];
                        $select[] = $row['numero'];
                        $select[] = $row['complemento'];
                        $select[] = $row['bairro'];
                        $select[] = $row['municipio'];
                        $select[] = $row['uf'];
                        $select[] = $row['id_contato'];
                        $select[] = $row['telefone_celular'];
                        $select[] = $row['telefone_fixo'];
                        $select[] = $row['email'];

                        return $select;
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

        public function SelectVerify(){
            try{
                $selectVerify = new SelectAll();
                $selectVerify = $selectVerify->Instituicao();
                
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
    }
?>