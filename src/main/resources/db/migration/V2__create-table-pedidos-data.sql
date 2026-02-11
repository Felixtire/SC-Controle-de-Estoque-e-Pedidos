create table pedidos (
   id BIGINT NOT NULL AUTO_INCREMENT,
   valor_total DECIMAL(10, 2) NOT NULL,
    data_pedido TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
)