INSERT INTO FILMES (ID, NOME, GENERO, PRECO) VALUES(1, 'LAGOA AZUL', 'LANCAMENTO', 1.00);

INSERT INTO CLIENTES (ID, NOME, TELEFONE, ENDERECO) VALUES(1, 'JOAO DA SILVA', '9988-7766', 'RUA GERAL, CENTRO, NOVA VENEZA');

INSERT INTO LOCACOES (ID, DATA, I_CLIENTES) VALUES(1, '2014-01-02', 1);

INSERT INTO ITENS_LOCACAO (ID, I_LOCACOES, I_FILMES) VALUES(1, 1, 1);
