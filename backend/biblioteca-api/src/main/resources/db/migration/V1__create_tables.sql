CREATE TABLE pessoa (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    cep VARCHAR(9),
    logradouro VARCHAR(150),
    bairro VARCHAR(100),
    cidade VARCHAR(100),
    uf VARCHAR(2),
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL
);

CREATE TABLE livro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    autor VARCHAR(100) NOT NULL
);

CREATE TABLE emprestimo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    devolvido BOOLEAN NOT NULL,
    pessoa_id BIGINT,
    livro_id BIGINT,

    CONSTRAINT fk_emprestimo_pessoa
        FOREIGN KEY (pessoa_id)
        REFERENCES pessoa(id),

    CONSTRAINT fk_emprestimo_livro
        FOREIGN KEY (livro_id)
        REFERENCES livro(id)
);