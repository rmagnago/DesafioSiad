CREATE TABLE pessoa_fisica (
    pessoa_fisica_id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    dt_Nascimento VARCHAR(255),
    cpf VARCHAR(255)
);

CREATE TABLE pessoa_juridica (
    pessoa_juridica_id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    dt_Nascimento VARCHAR(255),
    cnpj VARCHAR(255)
);

CREATE TABLE Endereco (
    endereco_id SERIAL PRIMARY KEY,
    cep VARCHAR(10) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    bairro VARCHAR(255) NOT NULL,
    rua VARCHAR(255) NOT NULL,
    numero INT NOT NULL,
    pessoa_fisica_id INT,
    FOREIGN KEY (pessoa_fisica_id) REFERENCES pessoa_fisica(pessoa_fisica_id)
);

CREATE TABLE Produto (
    produto_id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    pessoa_juridica_id INT,
    FOREIGN KEY (pessoa_juridica_id) REFERENCES pessoa_juridica(pessoa_juridica_id)
);

CREATE TABLE Venda (
    venda_id SERIAL PRIMARY KEY,
    total DECIMAL(10, 2) NOT NULL,
    qt INT NOT NULL,
    pessoa_fisica_id INT,
    produto_id INT,
    FOREIGN KEY (pessoa_fisica_id) REFERENCES pessoa_fisica(pessoa_fisica_id),
    FOREIGN KEY (produto_id) REFERENCES produto(produto_id)
);

CREATE TABLE pessoa_fisica_vendas (
    pessoa_fisica_id INT,
    venda_id INT,
    PRIMARY KEY (pessoa_fisica_id, venda_id),
    FOREIGN KEY (pessoa_fisica_id) REFERENCES pessoa_fisica(pessoa_fisica_id),
    FOREIGN KEY (venda_id) REFERENCES venda(venda_id)
);

CREATE TABLE pessoa_fisica_enderecos (
    pessoa_fisica_id INT,
    endereco_id INT,
    PRIMARY KEY (pessoa_fisica_id, endereco_id),
    FOREIGN KEY (pessoa_fisica_id) REFERENCES pessoa_fisica(pessoa_fisica_id),
    FOREIGN KEY (endereco_id) REFERENCES endereco(endereco_id)
);

CREATE TABLE pessoa_juridica_produtos (
    pessoa_juridica_id INT,
    produto_id INT,
    PRIMARY KEY (pessoa_juridica_id, produto_id),
    FOREIGN KEY (pessoa_juridica_id) REFERENCES pessoa_juridica(pessoa_juridica_id),
    FOREIGN KEY (produto_id) REFERENCES produto(produto_id)
);