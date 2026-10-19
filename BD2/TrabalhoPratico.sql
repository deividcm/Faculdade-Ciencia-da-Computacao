create or replace type address_udt as object (
    Rua varchar(40),
    Num_End varchar(10),
    Bairro varchar(30),
    Cidade varchar(40),
    UF varchar(2),
    CEP numeric(8)
) final;

create or replace type person_udt as object (
    PersonID int,
    Name varchar(50),
    Address address_udt,
    Gender char
) not final;

create or replace type movie_professional_udt under person_udt (
    Company company_udt
)not final;

create or replace type critic_udt under movie_professional_udt (

) final;

create or replace type agent_udt under movie_professional_udt (

) final;

create or replace type celebrity_udt under person_udt (

) not final;

create or replace type movie_star_udt under celebrity_udt (

) final;

create or replace type model_udt under celebrity_udt (

) final;

create or replace type company_udt as object(
    CompanyID int,
    Name varchar(50)
);

create or replace type sponsor_udt as object(
    PersonSponsor ref(person_udt),
    CompanySponsor ref(company_udt)
);

create or replace type project_udt as object(
     ProjectID int,
     ProjectType char,
     Location addres_udt
);
/*ProjectType = "F"*/
create or replace type film_project_udt under project_udt(

);
/*ProjecType = "M"*/
create or replace type modeling_project_udt under project_udt (

);
