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


# Change Log
Instruições para o formato do Change Log

`Added` for new features.

`Changed` for changes in existing functionality.

`Deprecated` for soon-to-be removed features.

`Removed` for now removed features.

`Fixed`  for any bug fixes.

## 2023-05-22 - Telmo

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