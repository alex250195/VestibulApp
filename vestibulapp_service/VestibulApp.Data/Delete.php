<?php
    class Delete{
        /*public function AtendimentoEspecial($id){
            return "DELETE FROM atendimento_especial WHERE id = " .$id;
            
        }

        public function AtendimentoEspecifico($id){
            return "DELETE FROM atendimento_especifico WHERE id = " .$id;
        }

        public function Candidato($id){
            return "DELETE FROM candidato WHERE id = " .$id;
        }

        public function Contato($id){
            return "DELETE FROM contato WHERE id = " .$id;
        }*/

        public function Curso($id){
            return "DELETE FROM Curso WHERE id_curso = " .$id;
        }

        /*public function Endereco($id){
            return "DELETE FROM endereco WHERE id = " .$id;
        }

        public function Inscricao($id){
            return "DELETE FROM inscricao WHERE id = " .$id;
        }

        public function Instituicao($id){
            return "DELETE FROM instituicao WHERE id = " .$id;
        }*/

        public function Usuario($id){
            return "DELETE FROM Usuario WHERE id_usuario=" .$id. "";
        }

        /*public function Vestibular($id){
            return "DELETE FROM vestibular WHERE id = " .$id;
        }

        public function VestibularCurso($idVestibular, $idCurso){
            return "DELETE 
                    FROM vestibular_has_curso 
                    WHERE id_vestibular = " .$idVestibular. " AND id_curso = " .$idCurso;
        }*/
    }
?>