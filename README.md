# API do TFC OnTrack

- Desenvolvida por: [Telmo Panaças](https://github.com/telmo-a22001972) e por [Rafael Paulo](https://github.com/rafaelpaulo22001810)

## Alterações necessárias para o funcionamento da API

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

# To Do:

- [ ] Implementar a entidade `Ano Letivo` (em progresso)


- [x] ~~Implementar a entidade `Professor`~~


- [ ] Implementar a entidade `Unidade Curricular` (em progresso)


- [ ] Implementar a entidade `Aluno` (em progresso)


- [ ] Implementar a entidade `Avaliacao`


- [ ] Implementar a entidade `Curso`


# Change Log
Instruições para o formato do Change Log

`Added` for new features.

`Changed` for changes in existing functionality.

`Deprecated` for soon-to-be removed features.

`Removed` for now removed features.

`Fixed`  for any bug fixes.

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

### Deprecated


### Removed


### Fixed

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