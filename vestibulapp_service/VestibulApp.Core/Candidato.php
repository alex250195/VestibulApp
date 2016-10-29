<?php
    include_once '../../VestibulApp.Data/Connect.php';
    include_once '../../VestibulApp.Data/Insert.php';
    include_once '../../VestibulApp.Data/Delete.php';
    include_once '../../VestibulApp.Data/Update.php';
    include_once '../../VestibulApp.Data/SelectAll.php';
    include_once '../../VestibulApp.Data/SelectById.php';
    include_once '../../VestibulApp.Data/SelectBySpecification.php';
    
    class Candidato{
        private $etnia;
        private $estado_civil;
        private $sexo;
        private $cpf;
        private $identidade;
        private $orgao_expedidor;
        private $uf_identidade;
        private $nome;
        private $nome_mae;
        private $nascimento;
        private $nascionalidade;
        private $uf_nascimento;
        private $municipio_nascimento;
        private $escolaridade;
        private $senha;

        private $connection;

        public function openConnect(){
            $this->connection = new Connect();
            $this->connection->connect();
        }

        public function disconnect(){
            $this->connection->closeConnection();
        }

        public function getEtnia(){
            return $this->etnia;
        }

        public function setEtnia($etnia){
            $this->etnia = $etnia;
        }

        public function getEstado_civil(){
            return $this->estado_civil;
        }

        public function setEstado_civil($estado_civil){
            $this->estado_civil = $estado_civil;
        }

        public function getSexo(){
            return $this->sexo;
        }

        public function setSexo($sexo){
            $this->sexo = $sexo;
        }

        public function getCpf(){
            return $this->cpf;
        }

        public function setCpf($cpf){
            $this->cpf = $cpf;
        }

        public function getIdentidade(){
            return $this->identidade;
        }

        public function setIdentidade($identidade){
            $this->identidade = $identidade;
        }

        public function getOrgao_expedidor(){
            return $this->orgao_expedidor;
        }

        public function setOrgao_expedidor($orgao_expedidor){
            $this->orgao_expedidor = $orgao_expedidor;
        }

        public function getUf_identidade(){
            return $this->uf_identidade;
        }

        public function setUf_identidade($uf_identidade){
            $this->uf_identidade = $uf_identidade;
        }

        public function getNome(){
            return $this->nome;
        }

        public function setNome($nome){
            $this->nome = $nome;
        }

        public function getNome_mae(){
            return $this->nome_mae;
        }

        public function setNome_mae($nome_mae){
            $this->nome_mae = $nome_mae;
        }

        public function getNascimento(){
            return $this->nascimento;
        }

        public function setNascimento($nascimento){
            $this->nascimento = $nascimento;
        }

        public function getNascionalidade(){
            return $this->nascionalidade;
        }

        public function setNascionalidade($nascionalidade){
            $this->nascionalidade = $nascionalidade;
        }

        public function getUf_nascimento(){
            return $this->uf_nascimento;
        }

        public function setUf_nascimento($uf_nascimento){
            $this->uf_nascimento = $uf_nascimento;
        }

        public function getMunicipio_nascimento(){
            return $this->municipio_nascimento;
        }

        public function setMunicipio_nascimento($municipio_nascimento){
            $this->municipio_nascimento = $municipio_nascimento;
        }

        public function getEscolaridade(){
            return $this->escolaridade;
        }

        public function setEscolaridade($escolaridade){
            $this->escolaridade = $escolaridade;
        }

        public function getSenha(){
            return $this->senha;
        }

        public function setSenha($senha){
            $this->senha = $senha;
        }

        public function Insert(){
            try{               
                $insert = new Insert();
                $insert = $insert->Candidato($this->etnia, $this->estado_civil, $this->sexo, $this->cpf, $this->identidade, $this->orgao_expedidor, $this->uf_identidade, $this->nome, $this->nome_mae, $this->nascimento, $this->nascionalidade, $this->uf_nascimento, $this->municipio_nascimento, $this->escolaridade, $this->senha);

                return mysqli_query($this->connection->getMySqli(), $insert);
            }catch(Exception $ex){
                return $ex;
            }
        }

        public function Update(){
            try{
                $update = new Update();
                $update = $update->Candidato($this->cpf, $this->senha);
                
                return mysqli_query($this->connection->getMySqli(), $update);
            }catch(Exception $ex){
                return $ex;
            }
        }

        public function SelectBySpecification2($query){
            try{
                $selectBySpecification = new SelectBySpecification();
                $selectBySpecification = $selectBySpecification->Candidato($query);

                $resultado = mysqli_query($this->connection->getMySqli(), $selectBySpecification);

                if(mysqli_num_rows($resultado) > 0){
                    while($row =  mysqli_fetch_assoc($resultado)) {
                        $select[] = $row['id_candidato'];
                        $select[] = $row['nome'];
                        $select[] = $row['cpf'];
                        $select[] = $row['sexo'];
                        $select[] = $row['identidade'];
                        $select[] = $row['nascimento'];
                        $select[] = $row['nascionalidade'];
                        $select[] = $row['municipio_nascimento'];
                        $select[] = $row['uf_nascimento'];
                        $select[] = $row['escolaridade'];
                        $select[] = $row['senha'];
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

        public function SelectBySpecification($query){
            try{
                $selectBySpecification = new SelectBySpecification();
                $selectBySpecification = $selectBySpecification->Candidato($query);

                $resultado = mysqli_query($this->connection->getMySqli(), $selectBySpecification);

                if(mysqli_num_rows($resultado) > 0){

                    $result = array();

                    while($row =  mysqli_fetch_assoc($resultado)) {

                        $booking = array(
                            'id_candidato' => $row['id_candidato'],
                            'nome' => $row['nome'],
                            'cpf' => $row['cpf'],
                            'sexo' => $row['sexo'],
                            'identidade' => $row['identidade'],
                            'nascimento' => $row['nascimento'],
                            'nascionalidade' => $row['nascionalidade'],
                            'municipio_nascimento' => $row['municipio_nascimento'],
                            'uf_nascimento' => $row['uf_nascimento'],
                            'escolaridade' => $row['escolaridade'],
                            'senha' => $row['senha']
                        );

                        $result[] = new soapval('curso', 'tns:candidatoDateType', $booking);
                    }

                    return $result;
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