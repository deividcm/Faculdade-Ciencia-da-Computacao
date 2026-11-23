/*Tipos independentes*/
create or replace type acomodacao_udt as object(
    id_aco int,
    nome_aco varchar2(40),
    qtd_camas numeric(2),
    valor_base numeric(6,2)
) not final;
/
create or replace type pessoa_udt as object(
    id_pessoa int,
    nome_pessoa varchar2(40)
) not final;
/
CREATE OR REPLACE TYPE grupo_familiar_udt AS OBJECT (
  id_grupo int
) final;
/
create or replace type pacote_udt as object(
    id_pacote int,
    nome_pacote varchar2(40)
) final;
/
create or replace type produto_udt as object(
    id_produto int,
    nome_produto varchar2(40),
    tipo_produto char(1)
) final;
/
create or replace type atividade_udt as object(
    id_atividade int,
    nome_atividade varchar2(40)
) final;
/
create or replace type turma_udt as object(
    id_turma int,
    atividade ref atividade_udt,
    horario varchar2(5)
) final;
/
/*Tipos herdados*/
create or replace type hospede_udt under pessoa_udt(
    idade numeric(3)
) final;
/
create or replace type monitor_udt under pessoa_udt(
    hora_entrada varchar2(5),
    hora_saida varchar2(5)
) final;
/

create or replace type quarto_udt under acomodacao_udt(
    tipo_quarto char(1)
) final;
/
create or replace type apartamento_udt under acomodacao_udt not final;
/
create or replace type chale_udt under acomodacao_udt(
    qtd_quartos numeric(2)
) final;
/

create or replace type apartamento_duplo_udt under apartamento_udt final;
/
create or replace type apartamento_triplo_udt under apartamento_udt final;
/
/*Criando tipos derivados de relações*/

create or replace type produto_consumido_udt as object (
    id_consumo int,
    produto ref produto_udt,
    hospede ref hospede_udt
) final;
/
create or replace type pacote_apartamento_duplo as object(
    pacote ref pacote_udt,
    apartamento ref apartamento_duplo_udt
) final;
/

create or replace type reserva_acomodacao_udt as object(
    id_reserva int,
    acomodacao ref acomodacao_udt, /*nao pode ser chale*/
    pessoa ref pessoa_udt
) final;
/
create or replace type reserva_chale_udt as object(
    id_reserva int,
    chale ref chale_udt,
    grupo_familiar ref grupo_familiar_udt
) final;
/

create or replace type pertencente_grupo_udt as object(
    pessoa ref pessoa_udt,
    grupo_familiar ref grupo_familiar_udt
) final;
/

create or replace type reserva_turma_udt as object( /*Acredito que não precise de id proprio*/
    turma ref turma_udt,
    pessoa ref pessoa_udt
) final;
/
create or replace type coordenacao_atividade_udt as object( /*Acredito que não seria inserido o mesmo monitor na mesma atividade duas vezes*/
    monitor ref monitor_udt,
    atividade ref atividade_udt
) final;
/

/*Tabelas de entidades independentes*/

CREATE TABLE grupo_familiar OF grupo_familiar_udt (
    id_grupo PRIMARY KEY
);
/

CREATE TABLE pacote OF pacote_udt (
    id_pacote PRIMARY KEY
);
/

CREATE TABLE produto OF produto_udt (
    id_produto PRIMARY KEY
);
/

CREATE TABLE atividade OF atividade_udt (
    id_atividade PRIMARY KEY
);
/

CREATE TABLE turma OF turma_udt (
    id_turma PRIMARY KEY,
    atividade SCOPE IS atividade
);
/

/*Tabelas de entidades especializadas (folhas da herança)*/

CREATE TABLE hospede OF hospede_udt (
    id_pessoa PRIMARY KEY
);
/

CREATE TABLE monitor OF monitor_udt (
    id_pessoa PRIMARY KEY
);
/

CREATE TABLE quarto OF quarto_udt (
    id_aco PRIMARY KEY
);
/

CREATE TABLE chale OF chale_udt (
    id_aco PRIMARY KEY
);
/

CREATE TABLE apartamento_duplo OF apartamento_duplo_udt (
    id_aco PRIMARY KEY
);
/

CREATE TABLE apartamento_triplo OF apartamento_triplo_udt (
    id_aco PRIMARY KEY
);
/

/*Tabelas derivadas de relações*/

CREATE TABLE produto_consumido OF produto_consumido_udt (
    id_consumo PRIMARY KEY,
    produto SCOPE IS produto,
    hospede SCOPE IS hospede
);
/

CREATE TABLE pacote_apartamento_duplo_tab OF pacote_apartamento_duplo (
    pacote SCOPE IS pacote,
    apartamento SCOPE IS apartamento_duplo
);
/

CREATE TABLE reserva_acomodacao OF reserva_acomodacao_udt (
    id_reserva PRIMARY KEY
);
/

CREATE TABLE reserva_chale OF reserva_chale_udt (
    id_reserva PRIMARY KEY,
    chale SCOPE IS chale,
    grupo_familiar SCOPE IS grupo_familiar
);
/

CREATE TABLE pertencente_grupo OF pertencente_grupo_udt (
    grupo_familiar SCOPE IS grupo_familiar
);
/

CREATE TABLE reserva_turma OF reserva_turma_udt (
    turma SCOPE IS turma
);
/

CREATE TABLE coordenacao_atividade OF coordenacao_atividade_udt (
    monitor SCOPE IS monitor,
    atividade SCOPE IS atividade
);
/

/* 1. TABELAS DE ENTIDADES INDEPENDENTES */

/* grupo_familiar */
INSERT INTO grupo_familiar VALUES (grupo_familiar_udt(1));
INSERT INTO grupo_familiar VALUES (grupo_familiar_udt(2));
INSERT INTO grupo_familiar VALUES (grupo_familiar_udt(3));
INSERT INTO grupo_familiar VALUES (grupo_familiar_udt(4));
INSERT INTO grupo_familiar VALUES (grupo_familiar_udt(5));

/* pacote */
INSERT INTO pacote VALUES (pacote_udt(1, 'Pacote Fim de Semana'));
INSERT INTO pacote VALUES (pacote_udt(2, 'Pacote Feriado Prolongado'));
INSERT INTO pacote VALUES (pacote_udt(3, 'Pacote Lua de Mel'));
INSERT INTO pacote VALUES (pacote_udt(4, 'Pacote Férias em Família'));
INSERT INTO pacote VALUES (pacote_udt(5, 'Pacote Corporativo'));

/* produto */
INSERT INTO produto VALUES (produto_udt(1, 'Água Mineral', 'B'));
INSERT INTO produto VALUES (produto_udt(2, 'Refrigerante Lata', 'B'));
INSERT INTO produto VALUES (produto_udt(3, 'Porção de Batata Frita', 'A'));
INSERT INTO produto VALUES (produto_udt(4, 'Sanduíche Natural', 'A'));
INSERT INTO produto VALUES (produto_udt(5, 'Suco de Laranja', 'B'));

/* atividade */
INSERT INTO atividade VALUES (atividade_udt(1, 'Trilha Ecológica'));
INSERT INTO atividade VALUES (atividade_udt(2, 'Hidroginástica'));
INSERT INTO atividade VALUES (atividade_udt(3, 'Passeio a Cavalo'));
INSERT INTO atividade VALUES (atividade_udt(4, 'Arco e Flecha'));
INSERT INTO atividade VALUES (atividade_udt(5, 'Canoagem'));

/* turma (referencia atividade) */
INSERT INTO turma VALUES (turma_udt(1, (SELECT REF(a) FROM atividade a WHERE a.id_atividade = 1), '08:00'));
INSERT INTO turma VALUES (turma_udt(2, (SELECT REF(a) FROM atividade a WHERE a.id_atividade = 2), '10:00'));
INSERT INTO turma VALUES (turma_udt(3, (SELECT REF(a) FROM atividade a WHERE a.id_atividade = 3), '14:00'));
INSERT INTO turma VALUES (turma_udt(4, (SELECT REF(a) FROM atividade a WHERE a.id_atividade = 4), '16:00'));
INSERT INTO turma VALUES (turma_udt(5, (SELECT REF(a) FROM atividade a WHERE a.id_atividade = 5), '17:30'));


/* 2. TABELAS DE ENTIDADES ESPECIALIZADAS */

/* hospede (herda id_pessoa, nome_pessoa de pessoa_udt) */
INSERT INTO hospede VALUES (hospede_udt(1, 'Carlos Silva', 34));
INSERT INTO hospede VALUES (hospede_udt(2, 'Mariana Souza', 28));
INSERT INTO hospede VALUES (hospede_udt(3, 'João Pedro', 12));
INSERT INTO hospede VALUES (hospede_udt(4, 'Fernanda Lima', 45));
INSERT INTO hospede VALUES (hospede_udt(5, 'Lucas Oliveira', 19));

/* monitor (herda id_pessoa, nome_pessoa de pessoa_udt) */
INSERT INTO monitor VALUES (monitor_udt(6, 'Rafael Costa', '07:00', '15:00'));
INSERT INTO monitor VALUES (monitor_udt(7, 'Camila Rocha', '08:00', '16:00'));
INSERT INTO monitor VALUES (monitor_udt(8, 'Bruno Alves', '09:00', '17:00'));
INSERT INTO monitor VALUES (monitor_udt(9, 'Juliana Mendes', '10:00', '18:00'));
INSERT INTO monitor VALUES (monitor_udt(10, 'Diego Martins', '12:00', '20:00'));

/* quarto (herda id_aco, nome_aco, qtd_camas, valor_base de acomodacao_udt) */
INSERT INTO quarto VALUES (quarto_udt(1, 'Quarto Standard 101', 1, 150.00, 'S'));
INSERT INTO quarto VALUES (quarto_udt(2, 'Quarto Standard 102', 2, 180.00, 'S'));
INSERT INTO quarto VALUES (quarto_udt(3, 'Quarto Luxo 103', 1, 250.00, 'L'));
INSERT INTO quarto VALUES (quarto_udt(4, 'Quarto Luxo 104', 2, 280.00, 'L'));
INSERT INTO quarto VALUES (quarto_udt(5, 'Quarto Master 105', 1, 350.00, 'M'));

/* chale (herda de acomodacao_udt) */
INSERT INTO chale VALUES (chale_udt(6, 'Chalé das Araucárias', 4, 450.00, 2));
INSERT INTO chale VALUES (chale_udt(7, 'Chalé do Lago', 6, 600.00, 3));
INSERT INTO chale VALUES (chale_udt(8, 'Chalé da Serra', 4, 480.00, 2));
INSERT INTO chale VALUES (chale_udt(9, 'Chalé Ipê Amarelo', 5, 520.00, 2));
INSERT INTO chale VALUES (chale_udt(10, 'Chalé Bosque', 6, 650.00, 3));

/* apartamento_duplo (herda de apartamento_udt -> acomodacao_udt) */
INSERT INTO apartamento_duplo VALUES (apartamento_duplo_udt(11, 'Apto Duplo 201', 2, 220.00));
INSERT INTO apartamento_duplo VALUES (apartamento_duplo_udt(12, 'Apto Duplo 202', 2, 220.00));
INSERT INTO apartamento_duplo VALUES (apartamento_duplo_udt(13, 'Apto Duplo 203', 2, 240.00));
INSERT INTO apartamento_duplo VALUES (apartamento_duplo_udt(14, 'Apto Duplo 204', 2, 240.00));
INSERT INTO apartamento_duplo VALUES (apartamento_duplo_udt(15, 'Apto Duplo 205', 2, 260.00));

/* apartamento_triplo (herda de apartamento_udt -> acomodacao_udt) */
INSERT INTO apartamento_triplo VALUES (apartamento_triplo_udt(16, 'Apto Triplo 301', 3, 300.00));
INSERT INTO apartamento_triplo VALUES (apartamento_triplo_udt(17, 'Apto Triplo 302', 3, 300.00));
INSERT INTO apartamento_triplo VALUES (apartamento_triplo_udt(18, 'Apto Triplo 303', 3, 320.00));
INSERT INTO apartamento_triplo VALUES (apartamento_triplo_udt(19, 'Apto Triplo 304', 3, 320.00));
INSERT INTO apartamento_triplo VALUES (apartamento_triplo_udt(20, 'Apto Triplo 305', 3, 340.00));


/* 3. TABELAS DERIVADAS DE RELAÇÕES */

/* produto_consumido */
INSERT INTO produto_consumido VALUES (produto_consumido_udt(1, (SELECT REF(p) FROM produto p WHERE p.id_produto = 1), (SELECT REF(h) FROM hospede h WHERE h.id_pessoa = 1)));
INSERT INTO produto_consumido VALUES (produto_consumido_udt(2, (SELECT REF(p) FROM produto p WHERE p.id_produto = 2), (SELECT REF(h) FROM hospede h WHERE h.id_pessoa = 2)));
INSERT INTO produto_consumido VALUES (produto_consumido_udt(3, (SELECT REF(p) FROM produto p WHERE p.id_produto = 3), (SELECT REF(h) FROM hospede h WHERE h.id_pessoa = 1)));
INSERT INTO produto_consumido VALUES (produto_consumido_udt(4, (SELECT REF(p) FROM produto p WHERE p.id_produto = 4), (SELECT REF(h) FROM hospede h WHERE h.id_pessoa = 4)));
INSERT INTO produto_consumido VALUES (produto_consumido_udt(5, (SELECT REF(p) FROM produto p WHERE p.id_produto = 5), (SELECT REF(h) FROM hospede h WHERE h.id_pessoa = 5)));

/* pacote_apartamento_duplo_tab */
INSERT INTO pacote_apartamento_duplo_tab VALUES (pacote_apartamento_duplo((SELECT REF(p) FROM pacote p WHERE p.id_pacote = 1), (SELECT REF(a) FROM apartamento_duplo a WHERE a.id_aco = 11)));
INSERT INTO pacote_apartamento_duplo_tab VALUES (pacote_apartamento_duplo((SELECT REF(p) FROM pacote p WHERE p.id_pacote = 2), (SELECT REF(a) FROM apartamento_duplo a WHERE a.id_aco = 12)));
INSERT INTO pacote_apartamento_duplo_tab VALUES (pacote_apartamento_duplo((SELECT REF(p) FROM pacote p WHERE p.id_pacote = 3), (SELECT REF(a) FROM apartamento_duplo a WHERE a.id_aco = 13)));
INSERT INTO pacote_apartamento_duplo_tab VALUES (pacote_apartamento_duplo((SELECT REF(p) FROM pacote p WHERE p.id_pacote = 4), (SELECT REF(a) FROM apartamento_duplo a WHERE a.id_aco = 14)));
INSERT INTO pacote_apartamento_duplo_tab VALUES (pacote_apartamento_duplo((SELECT REF(p) FROM pacote p WHERE p.id_pacote = 5), (SELECT REF(a) FROM apartamento_duplo a WHERE a.id_aco = 15)));

/* reserva_acomodacao (aponta para quarto, apartamento_duplo ou apartamento_triplo, mas não chalé) */
INSERT INTO reserva_acomodacao VALUES (reserva_acomodacao_udt(1, (SELECT REF(q) FROM quarto q WHERE q.id_aco = 1), (SELECT REF(h) FROM hospede h WHERE h.id_pessoa = 1)));
INSERT INTO reserva_acomodacao VALUES (reserva_acomodacao_udt(2, (SELECT REF(q) FROM quarto q WHERE q.id_aco = 3), (SELECT REF(h) FROM hospede h WHERE h.id_pessoa = 2)));
INSERT INTO reserva_acomodacao VALUES (reserva_acomodacao_udt(3, (SELECT REF(ad) FROM apartamento_duplo ad WHERE ad.id_aco = 11), (SELECT REF(h) FROM hospede h WHERE h.id_pessoa = 4)));
INSERT INTO reserva_acomodacao VALUES (reserva_acomodacao_udt(4, (SELECT REF(at) FROM apartamento_triplo at WHERE at.id_aco = 16), (SELECT REF(h) FROM hospede h WHERE h.id_pessoa = 5)));
INSERT INTO reserva_acomodacao VALUES (reserva_acomodacao_udt(5, (SELECT REF(ad) FROM apartamento_duplo ad WHERE ad.id_aco = 12), (SELECT REF(m) FROM monitor m WHERE m.id_pessoa = 6)));

/* reserva_chale */
INSERT INTO reserva_chale VALUES (reserva_chale_udt(1, (SELECT REF(c) FROM chale c WHERE c.id_aco = 6), (SELECT REF(g) FROM grupo_familiar g WHERE g.id_grupo = 1)));
INSERT INTO reserva_chale VALUES (reserva_chale_udt(2, (SELECT REF(c) FROM chale c WHERE c.id_aco = 7), (SELECT REF(g) FROM grupo_familiar g WHERE g.id_grupo = 2)));
INSERT INTO reserva_chale VALUES (reserva_chale_udt(3, (SELECT REF(c) FROM chale c WHERE c.id_aco = 8), (SELECT REF(g) FROM grupo_familiar g WHERE g.id_grupo = 3)));
INSERT INTO reserva_chale VALUES (reserva_chale_udt(4, (SELECT REF(c) FROM chale c WHERE c.id_aco = 9), (SELECT REF(g) FROM grupo_familiar g WHERE g.id_grupo = 4)));
INSERT INTO reserva_chale VALUES (reserva_chale_udt(5, (SELECT REF(c) FROM chale c WHERE c.id_aco = 10), (SELECT REF(g) FROM grupo_familiar g WHERE g.id_grupo = 5)));

/* pertencente_grupo */
INSERT INTO pertencente_grupo VALUES (pertencente_grupo_udt((SELECT REF(h) FROM hospede h WHERE h.id_pessoa = 1), (SELECT REF(g) FROM grupo_familiar g WHERE g.id_grupo = 1)));
INSERT INTO pertencente_grupo VALUES (pertencente_grupo_udt((SELECT REF(h) FROM hospede h WHERE h.id_pessoa = 2), (SELECT REF(g) FROM grupo_familiar g WHERE g.id_grupo = 1)));
INSERT INTO pertencente_grupo VALUES (pertencente_grupo_udt((SELECT REF(h) FROM hospede h WHERE h.id_pessoa = 3), (SELECT REF(g) FROM grupo_familiar g WHERE g.id_grupo = 1)));
INSERT INTO pertencente_grupo VALUES (pertencente_grupo_udt((SELECT REF(h) FROM hospede h WHERE h.id_pessoa = 4), (SELECT REF(g) FROM grupo_familiar g WHERE g.id_grupo = 2)));
INSERT INTO pertencente_grupo VALUES (pertencente_grupo_udt((SELECT REF(h) FROM hospede h WHERE h.id_pessoa = 5), (SELECT REF(g) FROM grupo_familiar g WHERE g.id_grupo = 3)));

/* reserva_turma */
INSERT INTO reserva_turma VALUES (reserva_turma_udt((SELECT REF(t) FROM turma t WHERE t.id_turma = 1), (SELECT REF(h) FROM hospede h WHERE h.id_pessoa = 1)));
INSERT INTO reserva_turma VALUES (reserva_turma_udt((SELECT REF(t) FROM turma t WHERE t.id_turma = 2), (SELECT REF(h) FROM hospede h WHERE h.id_pessoa = 2)));
INSERT INTO reserva_turma VALUES (reserva_turma_udt((SELECT REF(t) FROM turma t WHERE t.id_turma = 3), (SELECT REF(h) FROM hospede h WHERE h.id_pessoa = 3)));
INSERT INTO reserva_turma VALUES (reserva_turma_udt((SELECT REF(t) FROM turma t WHERE t.id_turma = 4), (SELECT REF(h) FROM hospede h WHERE h.id_pessoa = 4)));
INSERT INTO reserva_turma VALUES (reserva_turma_udt((SELECT REF(t) FROM turma t WHERE t.id_turma = 5), (SELECT REF(h) FROM hospede h WHERE h.id_pessoa = 5)));

/* coordenacao_atividade */
INSERT INTO coordenacao_atividade VALUES (coordenacao_atividade_udt((SELECT REF(m) FROM monitor m WHERE m.id_pessoa = 6), (SELECT REF(a) FROM atividade a WHERE a.id_atividade = 1)));
INSERT INTO coordenacao_atividade VALUES (coordenacao_atividade_udt((SELECT REF(m) FROM monitor m WHERE m.id_pessoa = 7), (SELECT REF(a) FROM atividade a WHERE a.id_atividade = 2)));
INSERT INTO coordenacao_atividade VALUES (coordenacao_atividade_udt((SELECT REF(m) FROM monitor m WHERE m.id_pessoa = 8), (SELECT REF(a) FROM atividade a WHERE a.id_atividade = 3)));
INSERT INTO coordenacao_atividade VALUES (coordenacao_atividade_udt((SELECT REF(m) FROM monitor m WHERE m.id_pessoa = 9), (SELECT REF(a) FROM atividade a WHERE a.id_atividade = 4)));
INSERT INTO coordenacao_atividade VALUES (coordenacao_atividade_udt((SELECT REF(m) FROM monitor m WHERE m.id_pessoa = 10), (SELECT REF(a) FROM atividade a WHERE a.id_atividade = 5)));

COMMIT;
