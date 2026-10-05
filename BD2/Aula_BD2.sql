create or replace type endereco_udt as object (
    Rua varchar(40),
    Num_End varchar(10),
    Bairro varchar(30),
    Cidade varchar(40),
    UF varchar(2),
    CEP numeric(8)
) final;

create or replace type pessoa_udt as object(
    CPF numeric(11),
    Nome varchar (40),
    Endereco endereco_udt,
    Estado_civil varchar(15)
)not final;

create or replace type aluno under pessoa_udt(
    Matricula integer
)not final;

create or replace type professor under pessoa_udt(
    titulacao varchar(10)
) final;


create table tb_aluno of aluno(
    matricula primary key
);

create table tb_professor of professor(
    CPF primary key
);
