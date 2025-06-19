<h1 align="center">
  Agenda
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Desafio&color=8257E5&labelColor=000000" alt="Desafio" />
</p>

API para gerenciar Agenda (CRUD), desafio proposto pela [Evo Sistemas Inteligentes](https://evosistemasinteligentes.com.br/) com o objetivo de nivelar o conhecimento em Java e SpringBoot.

<h2 align="left">Tecnologias e Frameworks utilizas no projeto</h2>

* Java
* Spring Boot
* MySql
* Git
* GitHub

###

## Instalação

Pode ser clonado do [repositorio](https://github.com/TharlisSampaio/desafio-agenda-back-end)

```
git clone https://github.com/TharlisSampaio/desafio-agenda-back-end.git
```

Lembrando que após clonar o projeto deve configurar o pom.xml de com sua conexão de banco de dados. Neste projeto foi utlizado o MySql e foi um criado schema agenda:

```
CREATE DATABASE agenda;
```

## Agenda

Modelo que representa a entidade Agenda

```
{
    "nome": "String",
    "sobrenome": "String",
    "telefone": "String"
}
```

## API Endpoint
Os endpoints podem ser consultados através do Swagger
```
/swagger-ui/index.html
```
## Métodos:

### `GET`: Retorna uma agenda ao passar um id válido

```
/api/agenda/{id}
```

```
{
    "id": Long,
    "nome": "String",
    "sobrenome": "String",
    "telefone": "String"
}
```

### `GET`: Retorna uma lista de agendas em ordem alfabetica (pelo nome)
```
/api/agenda
```

```
[
    {
        "id": Long,
        "nome": "String",
        "sobrenome": "String",
        "telefone": "String
    },
    {
        "id": Long,
        "nome": "String",
        "sobrenome": "String",
        "telefone": "String"
    }
]
```

### `POST`: Salva uma agenda, o preenchimento de todos os campos não obrigatório
```
/api/agenda
```

```
{
    "id": Long,
    "nome": "fulano",
    "sobrenome": "da silva",
    "telefone": "6899840021"
}
```

### `PUT`: Atualiza os campos da agenda que foram informados
```
/api/agenda/{id}
```
```
{
{
    "nome": "Fulano",
    "telefone": "81984357951"
}
}
```

### `DELETE`: Deleta uma agenda atreves do id, após deletar retorna status code 204
```
/api/agenda/{id}
