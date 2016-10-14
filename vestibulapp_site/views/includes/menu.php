<div id='cssmenu'>
<ul>
   <li><a href='loader.php?status=2'><span>Home</span></a></li>
   <li class='active has-sub'><a href='#'><span>Novo</span></a>
      <ul>
         <?php
            if($_SESSION['tipo_usuario'] == 'Master'){
               echo "
                  <li><a href='loader.php?status=3'><span>Instituição</span></a></li>
                  <li><a href='loader.php?status=6'><span>Cursos</span></a></li>
                  <li><a href='loader.php?status=5'><span>Vestibular</span></a></li>
                  <li><a href='loader.php?status=4'><span>Usuário</span></a></li>
               ";
            }
            else if($_SESSION['tipo_usuario'] == 'Administrador'){
               echo "
                  <li><a href='loader.php?status=6'><span>Cursos</span></a></li>
                  <li><a href='loader.php?status=4'><span>Usuário</span></a></li>
                  <li><a href='loader.php?status=5'><span>Vestibular</span></a></li>
               ";
            }
            else{
               echo "
                  <li><a href='loader.php?status=5'><span>Vestibular</span></a></li>
               ";
            }
         ?>
      </ul>
   </li>
   <li class='active has-sub'><a href='#'><span>Exibir</span></a>
      <ul>
         <?php
            if($_SESSION['tipo_usuario'] == 'Master'){
               echo "
                  <li><a href='loader.php?status=9'><span>Instituição</span></a></li>
                  <li><a href='loader.php?status=7'><span>Usuário</span></a></li>
                  <li><a href='loader.php?status=11'><span>Vestibular</span></a></li>
               ";
            }
            else if($_SESSION['tipo_usuario'] == 'Administrador'){
               echo "
                  <li><a href='loader.php?status=7'><span>Usuário</span></a></li>
                  <li><a href='loader.php?status=11''><span>Vestibular</span></a></li>
               ";
            }
            else{
               echo "
                  <li><a href='loader.php?status=11''><span>Vestibular</span></a></li>
               ";
            }
         ?>
      </ul>
   </li>
   <li class='last'><a href='models/logoff.php'><span>Sair</span></a></li>
   <li class='last'><span id='boas_vindas'><?php echo "Bem vindo(a) " .$_SESSION['nome']. " !"; ?></span></li>
</ul>
</div>