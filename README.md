Tabelas Postgres:

CREATE TABLE lancheria (
    codigo SERIAL PRIMARY KEY,
    endereco VARCHAR(255) NOT NULL,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE lanche (
    codigo SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT
);

CREATE TABLE cardapio (
    codigo SERIAL PRIMARY KEY,

    codigo_lancheria INTEGER NOT NULL,
    codigo_lanche INTEGER NOT NULL,

    preco NUMERIC(10,2) NOT NULL,

    CONSTRAINT fk_cardapio_lancheria
        FOREIGN KEY (codigo_lancheria)
        REFERENCES lancheria(codigo),

    CONSTRAINT fk_cardapio_lanche
        FOREIGN KEY (codigo_lanche)
        REFERENCES lanche(codigo)
);

CREATE TABLE usuario (
    codigo SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    ativo BOOLEAN NOT NULL DEFAULT TRUE
);
