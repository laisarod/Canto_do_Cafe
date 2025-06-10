CREATE TABLE IF NOT EXISTS pedido(
    id serial PRIMARY KEY,
    nome varchar(50),
    produto varchar(50),
    quantidade int,
    obs varchar(75)
);