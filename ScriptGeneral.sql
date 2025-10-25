CREATE DATABASE IF NOT EXISTS manuel_pruebatecnica;
USE manuel_pruebatecnica;

-- Tabla Cliente
CREATE TABLE IF NOT EXISTS cliente (
    id_cliente BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    email VARCHAR(255),
    telefono VARCHAR(255)
);

-- Tabla Comercio
CREATE TABLE IF NOT EXISTS comercio (
    id_comercio BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    direccion VARCHAR(255),
    rubro VARCHAR(255)
);

-- Tabla MedioPago
CREATE TABLE IF NOT EXISTS medio_pago (
    id_medio_pago BIGINT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(255)
);

-- Tabla Compra
CREATE TABLE IF NOT EXISTS compra (
    id_compra BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE,
    lugar VARCHAR(255),
    monto_total DOUBLE,
    id_cliente BIGINT,
    id_comercio BIGINT,
    id_medio_pago BIGINT,
    CONSTRAINT fk_compra_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    CONSTRAINT fk_compra_comercio FOREIGN KEY (id_comercio) REFERENCES comercio(id_comercio),
    CONSTRAINT fk_compra_medio FOREIGN KEY (id_medio_pago) REFERENCES medio_pago(id_medio_pago)
);

-- Insertar Comercios (solo si no existen)
INSERT INTO comercio (nombre, direccion, rubro)
SELECT * FROM (SELECT 'Super Selectos', 'Av. Independencia #123, Santa Ana', 'Supermercado') AS tmp
WHERE NOT EXISTS (SELECT 1 FROM comercio WHERE nombre = 'Super Selectos')
UNION ALL
SELECT * FROM (SELECT 'Farmacia San Benito', 'Calle Real #45, San Salvador', 'Farmacia') AS tmp
WHERE NOT EXISTS (SELECT 1 FROM comercio WHERE nombre = 'Farmacia San Benito')
UNION ALL
SELECT * FROM (SELECT 'ElectroHogar', 'Boulevard Los Próceres #99, San Salvador', 'Electrónica') AS tmp
WHERE NOT EXISTS (SELECT 1 FROM comercio WHERE nombre = 'ElectroHogar');

-- Insertar Clientes (solo si no existen)
INSERT INTO cliente (nombre, email, telefono)
SELECT * FROM (SELECT 'Ana Pérez', 'ana.perez@email.com', '7777-1111') AS tmp
WHERE NOT EXISTS (SELECT 1 FROM cliente WHERE email = 'ana.perez@email.com')
UNION ALL
SELECT * FROM (SELECT 'Luis Gómez', 'luis.gomez@email.com', '7777-2222') AS tmp
WHERE NOT EXISTS (SELECT 1 FROM cliente WHERE email = 'luis.gomez@email.com')
UNION ALL
SELECT * FROM (SELECT 'Marta López', 'marta.lopez@email.com', '7777-3333') AS tmp
WHERE NOT EXISTS (SELECT 1 FROM cliente WHERE email = 'marta.lopez@email.com');

-- Insertar Medios de Pago (solo si no existen)
INSERT INTO medio_pago (tipo)
SELECT * FROM (SELECT 'Efectivo') AS tmp
WHERE NOT EXISTS (SELECT 1 FROM medio_pago WHERE tipo = 'Efectivo')
UNION ALL
SELECT * FROM (SELECT 'Tarjeta') AS tmp
WHERE NOT EXISTS (SELECT 1 FROM medio_pago WHERE tipo = 'Tarjeta')
UNION ALL
SELECT * FROM (SELECT 'Plazos') AS tmp
WHERE NOT EXISTS (SELECT 1 FROM medio_pago WHERE tipo = 'Plazos');

-- Insertar Compras (ejemplo simple, sin validación de duplicados)
INSERT INTO compra (id_comercio, id_cliente, id_medio_pago, fecha, lugar, monto_total) VALUES
(1, 1, 2, '2025-10-20', 'Sucursal Centro', 150.00),
(1, 2, 1, '2025-10-21', 'Sucursal Centro', 75.50),
(2, 3, 2, '2025-10-22', 'Sucursal Norte', 35.00),
(3, 1, 3, '2025-10-23', 'Sucursal San Salvador', 450.00),
(3, 2, 1, '2025-10-24', 'Sucursal San Salvador', 120.00);

SELECT*FROM compra
