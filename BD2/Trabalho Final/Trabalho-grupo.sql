/*Tipos independentes*/
create or replace type acomodacao_udt as object(
    id_aco int,
    nome_aco varchar2(40),
    qtd_camas numeric(2),
    valor_base numeric(6,2)
)not final;
/
create or replace type pessoa_udt as object(
    id_pessoa int,
    nome_pessoa Varchar2(40)
)not final;
/
CREATE OR REPLACE TYPE grupo_familiar_udt AS OBJECT (
  id_grupo int
) final;
/
create or replace type pacote_udt as object(
    id_pacote int,
    nome_pacote varchar2(40)
)final;
/
create or replace type produto_udt as object(
    id_produto int,
    nome_produto varchar2(40),
    tipo_produto char
)final;
/
create or replace type atividade_udt as object(
    id_atividade int,
    nome_atividade varchar2(40)
)final;
/
create or replace type turma_udt as object(
    id_turma int,
    atividade ref atividade_udt,
    horario varchar2(5)
)final;
/
/*Tipos herdados*/
create or replace type hospede_udt under pessoa_udt(
    idade numeric(3)
)final;
/
create or replace type monitor_udt under pessoa_udt(
    hora_entrada varchar2(5),
    hora_saida varchar2(5)
)final;
/

create or replace type quarto_udt under acomodacao_udt(
    tipo_quarto char
)final;
/
create or replace type apartamento_udt under acomodacao_udt(
    
)not final;
/
create or replace type chale_udt under acomodocao_udt(
    qtd_quartos numeric(2)
)final;
/

create or replace type apartamento_duplo_udt under apartamento_udt(
    
)final;
/
create or replace type apartamento_triplo_udt under apartamento_udt(

)final;
/
/*Criando tipos derivados de relações*/

create or replace type produto_consumido_udt as object (
    id_consumo int,
    produto ref produto_udt,
    hospede ref hospede_udt
)final;
/
create or replace type pacote_apartamento_duplo as object(
    pacote ref pacote_udt,
    apartamento ref apartamento_duplo_udt
)final;
/

create or replace type reserva_acomodacao_udt as object(
    id_reserva int,
    acomodacao ref acomodacao_udt, /*nao pode ser chale*/
    pessoa ref pessoa_udt
)final;
/
create or replace type reserva_chale_udt as object(
    id_reserva int,
    chale ref chale_udt,
    grupo_familiar ref grupo_familiar_udt
)final;
/

create or replace type pertencente_grupo_udt as object(
    pessoa ref pessoa_udt,
    grupo_familiar ref grupo_familiar_udt
)final;
/

create or replace type reserva_turma_udt as object( /*Acredito que não precise de id proprio*/
    turma ref turma_udt,
    pessoa ref pessoa_udt
)final;
/
create or replace type coordenacao_atividade_udt as object( /*Acredito que não seria inserido o mesmo monitor na mesma atividade duas vezes*/
    monitor ref monitor_udt,
    atividade ref atividade_udt
)final;
/

/*tabelas*/



