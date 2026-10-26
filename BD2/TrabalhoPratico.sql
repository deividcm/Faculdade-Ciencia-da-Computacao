CREATE OR REPLACE TYPE person_udt;
/
CREATE OR REPLACE TYPE agent_udt;
/
CREATE OR REPLACE TYPE modeling_project_udt;
/
CREATE OR REPLACE TYPE model_udt;
/
CREATE OR REPLACE TYPE movie_star_udt;
/
CREATE OR REPLACE TYPE film_project_udt;
/


create or replace type address_udt as object (
    Rua varchar(40),
    Num_End varchar(10),
    Bairro varchar(30),
    Cidade varchar(40),
    UF varchar(2),
    CEP numeric(8)
) final;
/

create or replace type phone_NT as TABLE of NUMERIC(11);
/

create or replace type company_udt as object(
    CompanyID int,
    Nome varchar(50)
);
/

create or replace type person_udt as object (
    PersonID int,
    Nome varchar(50),
    Endereco address_udt,
    Genero char,
    Conjuge ref person_udt,
    Telefone phone_NT
) not final;
/

create or replace type movie_professional_udt under person_udt (
    Company company_udt
)not final;
/

create or replace type critic_udt under movie_professional_udt (
    Popularidade NUMERIC(2,2)
) final;
/

create or replace type agent_udt under movie_professional_udt (
    TaxaDeAgencia NUMERIC(2,2)
) final;
/

create or replace type celebrity_udt under person_udt (
    Agente ref agent_udt,
    Aniversario DATE
) not final;
/

create or replace type model_udt under celebrity_udt (
    Preferencias VARCHAR(40)
) final;
/

create or replace type movie_star_array as VARRAY(50) of ref movie_star_udt;
/

create or replace type project_udt as object(
     ProjectID int,
     ProjectType char,
     Location address_udt
) not final;
/

create or replace type film_project_udt under project_udt(
    Titulo VARCHAR(40),
    EstrelasDeCinema movie_star_array
);
/

create or replace type film_project_array as VARRAY(50) of ref film_project_udt;
/

create or replace type movie_star_udt under celebrity_udt (
    TipoDeFilmes VARCHAR(40),
    Filmes film_project_array
) final;
/


create or replace type sponsor_udt as object(
    PersonSponsor ref person_udt,
    CompanySponsor ref company_udt
);
/

create or replace type modeling_project_udt under project_udt (
    Descricao VARCHAR(50),
    Patrocinador ref sponsor_udt
);
/

create or replace type model_in_project as object(
    Modelo ref model_udt,
    Projeto ref modeling_project_udt,
    Pago bool
)final;
/








