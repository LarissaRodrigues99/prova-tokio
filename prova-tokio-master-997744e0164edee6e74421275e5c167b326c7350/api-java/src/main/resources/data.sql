
CREATE TABLE clients (
	id INT NOT NULL PRIMARY KEY,
	first_name VARCHAR(250) NOT NULL,
	last_name VARCHAR(250),
	email VARCHAR(250) NOT NULL
);

CREATE TABLE addresses (
	id INT NOT NULL PRIMARY KEY,
	id_client INT NOT NULL,
	address VARCHAR(250) NOT NULL,
	number VARCHAR(20) NOT NULL,
	complement VARCHAR(250),
	postal_code VARCHAR(10),
	city VARCHAR(250),
	state VARCHAR(250),
	country VARCHAR(250),
	FOREIGN KEY (id_client) REFERENCES public.clients(id)
);

-- Dados iniciais para a tabela de clientes
INSERT INTO clients (id, first_name, last_name, email) VALUES (1, 'Ana', 'Solza', 'ana@exemplo.com');
INSERT INTO clients (id, first_name, last_name, email) VALUES (2, 'Junior', 'Sézar', 'junior@exemplo.com');

-- Dados iniciais para a tabela de endereços
INSERT INTO addresses (id, id_client, address, number, complement, postal_code, city, state, country)
VALUES (1, 1, 'Rua Exemplo', '123', 'apto 1', '01001000', 'São Paulo', 'SP', 'Brasil');
