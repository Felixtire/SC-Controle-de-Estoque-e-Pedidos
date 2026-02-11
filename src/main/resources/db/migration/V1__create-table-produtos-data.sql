create table produtos (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    status_produto VARCHAR(50) NOT NULL,
    estoque INT NOT NULL,
    PRIMARY KEY (id)
)