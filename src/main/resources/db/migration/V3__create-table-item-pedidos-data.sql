create table item_pedidos (
    id BIGINT NOT NULL AUTO_INCREMENT,

    pedido_id BIGINT NOT NULL,
    produto_id BIGINT NOT NULL,

    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10, 2) NOT NULL,

    CONSTRAINT fk_pedido FOREIGN KEY (pedido_id) REFERENCES pedidos(id),
    CONSTRAINT fk_produto FOREIGN KEY (produto_id) REFERENCES produtos(id),
    PRIMARY KEY (id)
)