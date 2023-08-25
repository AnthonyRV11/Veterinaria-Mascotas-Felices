USE MASCOTAS_FELICES
GO

INSERT INTO FUNCIONARIOS (NOMBRE, APELLIDO1, APELLIDO2, CEDULA, PUESTO, TELEFONO, CORREO)
VALUES
    ('Juan', 'Perez', 'Garcia', '1234567890', 'Gerente', '123-456-7890', 'juan@example.com'),
    ('Maria', 'Rodriguez', 'Martinez', '9876543210', 'Recepcionista', '987-654-3210', 'maria@example.com'),
    ('Carlos', 'Sanchez', 'Lopez', '4567890123', 'Contador', '456-789-0123', 'carlos@example.com');

INSERT INTO CLIENTES (NOMBRE, APELLIDO1, APELLIDO2, CEDULA, TELEFONO, CORREO)
VALUES
    ('Ana', 'Gomez', 'Lopez', '3456789012', '234-567-8901', 'ana@example.com'),
    ('Luis', 'Torres', 'Perez', '5678901234', '345-678-9012', 'luis@example.com'),
    ('Elena', 'Martinez', 'Rodriguez', '7890123456', '456-789-0123', 'elena@example.com');

INSERT INTO PROVEEDORES (NOMBRE, TELEFONO, CORREO)
VALUES
    ('Proveedor1', '111-111-1111', 'proveedor1@example.com'),
    ('Proveedor2', '222-222-2222', 'proveedor2@example.com'),
    ('Proveedor3', '333-333-3333', 'proveedor3@example.com');

INSERT INTO PRODUCTOS (NOMBRE, PRECIO_COMPRA, PRECIO_VENTA, CANTIDAD)
VALUES
    ('Producto1', 10.00, 15.00, 50),
    ('Producto2', 20.00, 30.00, 100),
    ('Producto3', 5.00, 8.00, 75);

INSERT INTO AGENDA (ID_FUNCIONARIO, FECHA, HORA_ENTRADA, HORA_SALIDA)
VALUES
    (1, '2023-08-25', '09:00:00', '18:00:00'),
    (2, '2023-08-25', '08:30:00', '17:30:00'),
    (3, '2023-08-25', '09:30:00', '18:30:00');

