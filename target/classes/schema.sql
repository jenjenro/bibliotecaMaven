CREATE TABLE IF NOT EXISTS libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    autor VARCHAR(255),
    editorial VARCHAR(255),
    anio INT,
    fecha_ingreso TIMESTAMP,
    activo BOOLEAN
);

CREATE TABLE IF NOT EXISTS periodicos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    fecha_publicacion DATE,
    editorial VARCHAR(255),
    fecha_ingreso TIMESTAMP,
    activo BOOLEAN
);

CREATE TABLE IF NOT EXISTS computadores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    marca VARCHAR(255),
    modelo VARCHAR(255),
    sistema_operativo VARCHAR(255),
    fecha_ingreso TIMESTAMP,
    activo BOOLEAN
);