# API do TFC OnTrack

- Desenvolvida por: [Telmo Panaças](https://github.com/telmo-a22001972) e por [Rafael Paulo](https://github.com/rafaelpaulo22001810)

## Endpoints:

### Miscellaneous

- `GET` `api/v1/alive` - Verificar se a API está a funcionar 

### Aluno

- `GET` `api/v1/aluno/list` - Obter todos os alunos
- `GET` `api/v1/aluno/{aluno_id}` - Obter aluno através do seu id
- `POST` `api/v1/aluno/new` - Criar um novo aluno
- `DELETE` `api/v1/aluno/delete/{aluno_id}` - Remover aluno através do seu id
- `GET` `api/v1/aluno/{aluno_id}/unidades-curriculares/list` - Obter todas as unidades curriculares que pertencem ao aluno
- `GET` `api/v1/aluno/{aluno_id}/avaliacoes/list` - Obter todas as avaliações que pertencem ao aluno
- `POST` `api/v1/aluno/{alunoId}/unidades-curriculares/add/{unidadeCurricularId}` - Adicionar uma unidade curricular ao aluno

### Professor

- `GET` `api/v1/professor/list` - Obter todos os professores
- `GET` `api/v1/professor/{professor_id}` - Obter professor através do seu id
- `POST` `api/v1/professor/new` - Criar um novo professor
- `DELETE` `api/v1/professor/delete/{professor_id}` - Remover professor através do seu id
- `GET` `api/v1/professor/{professor_id}/unidades-curriculares/list` - Obter todas as unidades curriculares que pertencem ao professor
- `POST` `api/v1/professor/{professorId}/unidades-curriculares/add/{unidadeCurricularId}` - Adicionar uma unidade curricular ao professor

### Unidade Curricular

- `GET` `api/v1/unidade_curricular/list` - Obter todas as unidades curriculares
- `GET` `api/v1/unidade_curricular/{unidade_curricular_id}` - Obter unidade curricular através do seu id
- `POST` `api/v1/unidade_curricular/new` - Criar uma nova unidade curricular
- `DELETE` `api/v1/unidade_curricular/delete/{unidade_curricular_id}` - Remover unidade curricular através do seu id
- `GET` `api/v1/unidade_curricular/{unidade_curricular_id}/professores/list` - Obter todos os professores que pertencem à unidade curricular
- `GET` `api/v1/unidade_curricular/{unidade_curricular_id}/alunos/list` - Obter todos os alunos que pertencem à unidade curricular
- `GET` `api/v1/unidade_curricular/{unidade_curricular_id}/avaliacoes/list` - Obter todas as avaliações que pertencem à unidade curricular
- `POST` `api/v1/unidade_curricular/{unidadeCurricularId}/avaliacoes/add/{avaliacaoId}` - Adicionar uma avaliação à unidade curricular

### Avaliação

- `GET` `api/v1/avaliacao/list` - Obter todas as avaliações
- `GET` `api/v1/avaliacao/{avaliacao_id}` - Obter avaliação através do seu id
- `POST` `api/v1/avaliacao/new` - Criar uma nova avaliação
- `DELETE` `api/v1/avaliacao/delete/{avaliacao_id}` - Remover avaliação através do seu id
- `PUT` `api/v1/avaliacao/{avaliacao_id}` - Atualizar avaliação através do seu id

### Ano Letivo

- `GET` `api/v1/ano_letivo/list` - Obter todos os anos letivos
- `GET` `api/v1/ano_letivo/{ano_letivo_id}` - Obter ano letivo através do seu id
- `POST` `api/v1/ano_letivo/new` - Criar um novo ano letivo
- `DELETE` `api/v1/ano_letivo/delete/{ano_letivo_id}` - Remover ano letivo através do seu id
- `GET` `api/v1/ano_letivo/{ano_letivo_id}/unidades-curriculares/list` - Obter todas as unidades curriculares que pertencem ao ano letivo

### Curso

- `GET` `api/v1/curso/list` - Obter todos os cursos
- `GET` `api/v1/curso/{curso_id}` - Obter curso através do seu id
- `POST` `api/v1/curso/new` - Criar um novo curso
- `DELETE` `api/v1/curso/delete/{curso_id}` - Remover curso através do seu id
- `GET` `api/v1/curso/{curso_id}/unidades-curriculares/list` - Obter todas as unidades curriculares que pertencem ao curso
- `GET` `api/v1/curso/{curso_id}/alunos/list` - Obter todos os alunos que pertencem ao curso

### Login

- `POST` `api/v1/login` - Login

## Alterações necessárias para o funcionamento da API (sem Docker)

### Step 1
No ficheiro `application.properties` é necessário alterar as seguintes propriedades:

- `spring.datasource.url` - URL da base de dados
- `spring.datasource.username` - Username da base de dados
- `spring.datasource.password` - Password da base de dados

De modo a que fiquei algo como:

```
spring.datasource.url=jdbc:mysql://localhost:3306/teste_db
spring.datasource.password=teste
spring.datasource.username=12345
```

### Step 2

Ter o mysql instalado e através de uma ferramenta como o [MySQL Workbench](https://dev.mysql.com/downloads/workbench/) executar o script `db_creation.sql` que se encontra na pasta `db_scripts` para criar a base de dados e as tabelas necessárias.


## Utilização da API com Docker

### Step 1

Ter o `docker` e o `docker-compose` instalado na máquina.
- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)

### Step 2

#### Na primeira execução: 

Na pasta raiz do projeto executar o seguinte comando:

`docker-compose up --build` ou `docker-compose up -d --build` para correr em background.

#### Nas restantes execuções:

Na pasta raiz do projeto executar o seguinte comando:

`docker-compose up` ou `docker-compose up -d` para correr em background.

# To Do:
- [ ] Alterar a base de dados para uma H2 Database


# Change Log
Instruições para o formato do Change Log

`Added` for new features.

`Changed` for changes in existing functionality.

`Deprecated` for soon-to-be removed features.

`Removed` for now removed features.

`Fixed`  for any bug fixes.


## 2023-06-25

### Added
- Adição do campo `ects` à classe `UnidadeCurricular`.


- Criação do ficheiro `SetupConfiguration` que vai criar os dados iniciais na base de dados.



### Changed


### Deprecated


### Removed


### Fixed


## 2023-06-17

### Added
- Criação da classe `CredenciaisUser` a ser usada no endpoint `api/v1/login` para fazer o login na aplicação.


- Criação do ficheiro `MisceallenousController` que contém o endpoint `api/v1/alive` para verificar se a API está a correr.


### Changed
- Alteração do endpoint `api/v1/login` para `POST` e  para receber um objeto do tipo `CredenciaisUser` em vez de um `email`.


- Alteração do ficheiro `LoginService` para receber um objeto do tipo `CredenciaisUser` em vez de um `email`.


- Alteração do ficheiro `Dockerfile` para automatizar o processo de buildar o ficheiro `.jar` da API.


- Alteração do ficheiro `docker-compose.yml` para remover definições que não são necessárias.


### Deprecated


### Removed


### Fixed


## 2023-06-01

###  Added
- Criação do ficheiro `Dockerfile` para a criação de uma imagem docker da API.

### Changed
- Alteração do endpoint `api/v1/aluno/new` para não permitir a criação de um aluno com um email que já exista na base de dados.


- Alteração do endpoint `api/v1/professor/new` para não permitir a criação de um professor com um email que já exista na base de dados.


### Deprecated


### Removed


### Fixed

## 2023-05-29

###  Added
- Endpoint `api/v1/login` que temporariamente recebe como parâmetro o `email` do utilizadore devolve o `Id` associado a esse
email, para que seja possível fazer o login na aplicação. 


- Campos `tipoDeAvaliacao`, `metodoDeEntrega` e `descricao` à entidade `Avaliacao`.


- Endpoint `api/v1/avaliacao/{avaliacao_id}` com método `PUT` para a entidade `Avaliacao` onde é possível atualizar 
os campos `nome`,`tipoDeAvaliacao`, `metodoDeEntrega`, `data`, `descricao` e `unidadeCurricular` da avaliação pretendida 
através do seu id.


### Changed
- Alteração da nomenclatura de métodos e variáveis utilizados nos ficheiros `AvaliacaoService` e `AvaliacaoController` 
para manter a consistência nos termos utilizados. 


- Alteração da lista To Do no ficheiro `README.md`.


- Adicionado exemplo de um pedido `PUT` para o endpoint `api/v1/avaliacao/{avaliacao_id}` no ficheiro 
`rest api(ontrack).http`.
### Deprecated


### Removed


### Fixed

## 2023-05-26

###  Added
- Foram criados os ficheiros dao, controller, service, repository para a entidade `Curso`.


- Endpoint `api/v1/curso/list` para a entidade `Curso` onde é possível obter todos os cursos.


- Endpoint `api/v1/curso/{curso_id}` para a entidade `Curso` onde é possível obter o curso pretendido através do seu id.


- Endpoint `api/v1/curso/new` para a entidade `Curso` onde é possível criar um novo curso.


- Endpoint `api/v1/curso/delete/{curso_id}` para a entidade `Curso` onde é possível remover o curso pretendido através do
  seu id.


- Endpoint `api/v1/curso/{curso_id}/unidades-curriculares/list` para a entidade `Curso` onde é possível obter todas as
  unidades curriculares que pertencem ao curso pretendido.


- Endpoint `api/v1/curso/{curso_id}/alunos/list` para a entidade `Curso` onde é possível obter todos os alunos que
  pertencem ao curso pretendido.

### Changed
- No ficheiro `db_creation.sql` foi adicionada a entidade Curso.

### Deprecated


### Removed


### Fixed


## 2023-05-25

###  Added
- Foram criados os ficheiros dao, controller, service, repository para a entidade `Avaliacao`.


- Endpoint `api/v1/avaliacao/list` para a entidade `Avaliacao` onde é possível obter todos os eventos.


- Endpoint `api/v1/avaliacao/{evento_id}` para a entidade `Avaliacao` onde é possível obter o evento pretendido através do seu id.


- Endpoint `api/v1/avaliacao/new` para a entidade `Avaliacao` onde é possível criar um novo eventos.


- Endpoint `api/v1/avaliacao/delete/{evento_id}` para a entidade `Avaliacao` onde é possível remover o eventos pretendido através do
  seu id.


- Endpoint `api/v1/unidade_curricular/{unidadeCurricularId}/avaliacoes/add/{avaliacaoId}` para a entidade `Unidade Curricular` onde é
possível adicionar uma avaliação à unidade curricular.

  
- Endpoint `api/v1/unidade_curricular/{unidadeCurricularId}/avaliacoes/list` para a entidade `Unidade Curricular` onde é 
possível obter todas as avaliações da unidade curricular pretendida.


- Criada a relação 1:N entre a entidade `Ano Letivo` e a entidade `Unidade Curricular`.


- Endpoint `api/v1/ano_letivo/{ano_letivo_id}/unidades-curriculares/list` para a entidade `Ano Letivo` onde é possível 
obter asunidades curriculares que pertencem ao ano letivo pretendido.

  
  
### Changed
- No ficheiro `db_creation.sql` foi adicionada a entidade Avaliacao.


- Nomeclatura dos endpoints da entidade `Ano Letivo` para serem mais intuitivos.


- No ficheiro `rest api(ontrack).htpp` foram adicionados os endpoints de pedidos da entidade `Ano Letivo`.


### Deprecated


### Removed


### Fixed


## 2023-05-24

###  Added
- Foram criados os ficheiros dao, controller, service e repository para a entidade `Aluno`.


- Endpoint `api/v1/aluno/list` para a entidade `Aluno` onde é possível obter todos os alunos.


- Endpoint `api/v1/aluno/{aluno_id}` para a entidade `Aluno` onde é possível obter o aluno pretendido através do seu id.


- Endpoint `api/v1/aluno/new` para a entidade `Aluno` onde é possível criar um novo aluno.


- Endpoint `api/v1/aluno/delete/{aluno_id}` para a entidade `Aluno` onde é possível remover o aluno pretendido através do
seu id.


- Endpoint `api/v1/aluno/{aluno_id}/unidades-curriculares/list` para a entidade `Aluno` onde é possível obter todas as
unidades curriculares que o aluno está inscrito.


- Endpoint `api/v1/aluno/{aluno_id}/unidades-curriculares/add/{unidadeCurricularId}` para a entidade `Aluno` onde é 
possível adicionar uma unidade curricular ao aluno.


- Endpoint `api/v1/unidade_curricular/{unidadeCurricularId}/alunos/list` para a entidade `Unidade Curricular` onde é
possível obter todos os alunos inscritos na unidade curricular pretendida.


### Changed
- Nomenclatura dos endpoints das entidades `Professor` e `Unidade Curricular` para serem mais intuitivos.


- No ficheiro `db_creation.sql` foi adicionada a entidade Aluno.


- No ficheiro `rest api(ontrack).htpp` foram adicionados os endpoints da entidade `Aluno` e alterados os endpoints da
entidade `Unidade Curricular`.


- Foram adicionadas as linhas `server.servlet.encoding.charset=UTF-8` `server.servlet.encoding.force=true` ao ficheiro
`application.properties`.

### Deprecated


### Removed


### Fixed
- Resolvido o erro `"error": "Unsupported Media Type",
  "message": "Content-Type 'application/json;charset=UTF-8' is not supported.",` nos pedidos POST ao adicionar
`@JsonIgnore` nas classes que têm relações com outras classes.

## 2023-05-23

###  Added
- Foram criados os ficheiros dao, controller, service e repository para a entidade `Unidade Curricular`.


- Endpoint `api/v1/unidade_curricular` para a entidade `Unidade Curricular` onde é possível obter, criar e remover os
  mesmos.


- Endpoint `api/v1/professor/{professor_id}` para a entidade `Professor` onde é possível obter o professor pretendido 
através do seu id.


- Criou-se a relação N:N entre a entidade `Professor` e a entidade `Unidade Curricular`.


- Endpoint`api/v1/professor/{professor_id}/unidades-curriculares` para a entidade `Professor` onde é possível obter as
unidades curriculares que o professor leciona.


- Endpoint `api/v1/professor/{professor_id}/unidades-curriculares/new` para a entidade `Professor` onde é possível
adicionar uma unidade curricular ao professor.


### Changed
- No ficheiro `db_creation.sql` foi apagado o código de criação das tabelas que ainda não têm os seus ficheiros dao, 
controller, service e repository criados de modo a simplificar o código. 

### Deprecated

### Removed

### Fixed



## 2023-05-22

###  Added
- Adicionei o ficheiro `db_creation.sql` que contém o script para criar a base de dados e as tabelas necessárias.
Mas ainda é preciso fazer alterações no mesmo, pois ainda não está completo.


- Foram criados os ficheiros dao, controller, service e repository para as entidades `Professor` e `Ano Letivo`.
Mas no ficheiro `db_creation.sql` a entidade `Professor` já tem uma relação N:N com a `Unidade Curricular` e 
no ficheiro `Professor.java` ainda não.


- Endpoints `api/v1/professor` para a entidade `Professor` onde é possível obter, criar e remover os mesmos. 


- Endpoints `api/v1/anoletivo` para a entidade `Ano Letivo` onde é possível obter, criar e remover os mesmos.
### Changed

### Deprecated

### Removed

### Fixed