* UnB - Universidade de Brasilia
* FGA - Faculdade do Gama
* OO - Orientação por Objetos
* Prof. André Luiz Peron Martins Lanna
# Trabalho Prático de Orientação por Objetos<H1>

Componetes do Grupo:
* Lucas Monteiro Freitas-231035446

Descrição:
* Este projeto consiste em uma simulação de um sistema de gestão acadêmica desenvolvido para uma faculdade. O sistema é capaz de realizar operações completas de cadastro, pesquisa, atualização e remoção de registros relacionados a alunos, professores, disciplinas e turmas. Além dessas funcionalidades essenciais, o sistema oferece a possibilidade de registrar novos alunos em turmas específicas, garantindo que cada turma seja composta adequadamente conforme os critérios estabelecidos.
**Como o projeto funciona:**
   1. Alunos
      * Aluno: Esta classe representa um aluno na instituição, armazenando informações críticas como o nome completo, CPF, e-mail, número de matrícula e o curso ao qual o aluno está vinculado. Cada aluno é único dentro do sistema, identificado por sua matrícula, e seus dados podem ser consultados e atualizados conforme necessário.
      * Cad alunos: O sistema inclui um módulo dedicado ao armazenamento e gerenciamento dos dados dos alunos. Esse módulo permite adicionar novos alunos, pesquisar registros existentes, atualizar informações e remover registros, garantindo que os dados estejam sempre atualizados e corretos.
   2. Professores
      * Professor: Assim como os alunos, os professores são representados por uma classe específica que armazena informações detalhadas, incluindo nome, CPF, e-mail, área de formação e matrícula FUB. Esses dados são essenciais para associar os professores corretamente às disciplinas e turmas.
      * Cad professor: O sistema oferece um módulo específico para o cadastro e gerenciamento dos dados dos professores. Esse módulo permite operações de inclusão, pesquisa, atualização e remoção de registros de professores, assegurando que as informações sobre o corpo docente.
   3.Disciplina
      * Disciplina:  As disciplinas oferecidas pela instituição são representadas por uma classe que armazena o nome da disciplina e seu código único.
      * Cad disciplina: O sistema possui um módulo dedicado ao cadastro e gerenciamento de disciplinas. Este módulo permite que novas disciplinas sejam adicionadas ao sistema, que as existentes sejam consultadas e atualizadas, e que registros desnecessários sejam removidos.
   4. Turmas
      * Turma: As turmas são uma entidade chave no sistema, representando a associação entre um professor, uma disciplina e um grupo de alunos. A turma é responsável por organizar os alunos, de acordo com a disciplina e o professor designado.
      * cad Turma: Para gerenciar as turmas, o sistema inclui um módulo que permite criar novas turmas, associar alunos, professores e disciplinas às turmas existentes, e manter essas associações atualizadas ao longo do tempo.
   5. Exceções
      * Utilizando exceções específicas como CampoEmBrancoException, DisciplinaNaoAtribuidaException e ProfessorNaoAtribuidoException. Essas exceções garantem que dados incorretos ou incompletos sejam tratados de forma adequada, evitando a inserção de registros inválidos e assegurando a integridade das operações realizadas pelo sistema.
        
 **Tecnologias usadas**
* Java SE: Linguagem de programação principal.
* Swing: Para a interface gráfica, o projeto utiliza Swing, permitindo a criação de uma interface de usuário intuitiva e interativa.
* ArrayList: As operações de armazenamento e manipulação de dados são realizadas com o uso de ArrayList, proporcionando flexibilidade e eficiência no gerenciamento das coleções de dados.
  
