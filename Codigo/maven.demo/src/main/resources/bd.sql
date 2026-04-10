CREATE TABLE empresa (
    cnpj CHAR(14) PRIMARY KEY,
    nomeEmpresa VARCHAR(100) NOT NULL
);

CREATE TABLE fornecedor (
    cnpj CHAR(14) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE usuario (
    cpf CHAR(11) PRIMARY KEY,
    cnpj_empresa CHAR(14),
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    CONSTRAINT fk_usuario_empresa FOREIGN KEY (cnpj_empresa) 
        REFERENCES empresa(cnpj)
);

CREATE TABLE documento_fiscal (
    id SERIAL PRIMARY KEY,
    cnpj_fornecedor CHAR(14),
    nome_fornecedor VARCHAR(100),
    cnpj CHAR(14) NOT NULL,
    dataVencimento DATE NOT NULL,
    status BOOLEAN NOT NULL,
    descricao VARCHAR(300),
    valor FLOAT NOT NULL,
    numeroNota INTEGER NOT NULL,
    CONSTRAINT fk_doc_fornecedor FOREIGN KEY (cnpj_fornecedor) 
        REFERENCES fornecedor(cnpj)
);

CREATE TABLE pagamento (
    id SERIAL PRIMARY KEY,
    data DATE NOT NULL,
    valor FLOAT NOT NULL,
    id_nota INTEGER NOT NULL,
    CONSTRAINT fk_pagamento_documento FOREIGN KEY (id_nota) 
        REFERENCES documento_fiscal(id)
);