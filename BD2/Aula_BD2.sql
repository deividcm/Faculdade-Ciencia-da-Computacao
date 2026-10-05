create or replace type endereco as object (
    Rua varchar(40),
    Num_End varchar(10),
    Bairro varchar(30),
    Cidade varchar(40),
    UF varchar(2),
    CEP numeric(8)
) final;