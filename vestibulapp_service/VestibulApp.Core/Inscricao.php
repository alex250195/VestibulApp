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
            parent::Insert();
        } 

        public function Delete(){
            parent::Delete();
        }

        public function Update(){  
            parent::Update();
        }

        public function SelectAll(){
            parent::SelectAll();
        }

        public function SelectById(){
            parent::SelectById();
        }

        public function SelectBySpecification(){
            parent::SelectBySpecification();
        }
    }
?>