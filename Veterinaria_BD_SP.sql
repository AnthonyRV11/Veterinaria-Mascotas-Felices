USE MASCOTAS_FELICES
GO

--******************************************************************************************************
--CREAMOS TODOS LOS PROCEDIMIENTOS ALMACENADOS

--CLIENTES
--Procedimiento almacenado para poder insertar un cliente
CREATE PROCEDURE InsertarCliente(
    @Nombre VARCHAR(20),
    @Apellido1 VARCHAR(20),
    @Apellido2 VARCHAR(20),
    @Cedula VARCHAR(20),
    @Telefono VARCHAR(20),
    @Correo VARCHAR(50),
    @Mensaje VARCHAR(100) OUTPUT
)
AS
BEGIN
    IF NOT EXISTS (SELECT 1 FROM CLIENTES WHERE CEDULA = @Cedula)
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM CLIENTES WHERE TELEFONO = @Telefono)
        BEGIN
            IF NOT EXISTS (SELECT 1 FROM CLIENTES WHERE CORREO = @Correo)
            BEGIN
                INSERT INTO CLIENTES (NOMBRE, APELLIDO1, APELLIDO2, CEDULA, TELEFONO, CORREO)
                VALUES (@Nombre, @Apellido1, @Apellido2, @Cedula, @Telefono, @Correo);

                SET @Mensaje = 'Cliente insertado correctamente!';
                RETURN 1;
            END
            ELSE
            BEGIN
                SET @Mensaje = 'El correo ya existe en la base de datos, prueba con otro!';
                RETURN 0;
            END
        END
        ELSE
        BEGIN
            SET @Mensaje = 'El teléfono ya existe en la base de datos, prueba con otro!';
            RETURN 0;
        END
    END
    ELSE
    BEGIN
        SET @Mensaje = 'La cédula ya existe en la base de datos, prueba con otra!';
        RETURN 0;
    END
END;
GO

--Procedimiento almacenado para poder actualizar un cliente
CREATE PROCEDURE ActualizarCliente(
    @ID_CLIENTE INT,
    @NuevoNombre VARCHAR(20),
    @NuevoApellido1 VARCHAR(20),
    @NuevoApellido2 VARCHAR(20),
    @NuevaCedula VARCHAR(20),
    @NuevoTelefono VARCHAR(20),
    @NuevoCorreo VARCHAR(50),
    @Mensaje VARCHAR(100) OUTPUT
)
AS
BEGIN
    DECLARE @CedulaActual VARCHAR(20);
    SELECT @CedulaActual = CEDULA FROM CLIENTES WHERE ID_CLIENTE = @ID_CLIENTE;

    IF @CedulaActual <> @NuevaCedula
    BEGIN
        SET @Mensaje = 'La cédula no se puede actualizar!';
        RETURN 0;
    END

    DECLARE @Cambios INT;

    -- Verificar si hay cambios en los datos
    SELECT @Cambios = CASE WHEN NOMBRE = @NuevoNombre AND APELLIDO1 = @NuevoApellido1 AND APELLIDO2 = @NuevoApellido2
                               AND TELEFONO = @NuevoTelefono AND CORREO = @NuevoCorreo THEN 0 ELSE 1 END
    FROM CLIENTES
    WHERE ID_CLIENTE = @ID_CLIENTE;

    IF @Cambios = 1
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM CLIENTES WHERE ID_CLIENTE != @ID_CLIENTE AND CEDULA = @NuevaCedula)
        BEGIN
            IF NOT EXISTS (SELECT 1 FROM CLIENTES WHERE ID_CLIENTE != @ID_CLIENTE AND TELEFONO = @NuevoTelefono)
            BEGIN
                IF NOT EXISTS (SELECT 1 FROM CLIENTES WHERE ID_CLIENTE != @ID_CLIENTE AND CORREO = @NuevoCorreo)
                BEGIN
                    UPDATE CLIENTES
                    SET NOMBRE = @NuevoNombre,
                        APELLIDO1 = @NuevoApellido1,
                        APELLIDO2 = @NuevoApellido2,
                        TELEFONO = @NuevoTelefono,
                        CORREO = @NuevoCorreo
                    WHERE ID_CLIENTE = @ID_CLIENTE;

                    SET @Mensaje = 'Cliente actualizado correctamente!';
                    RETURN 1;
                END
                ELSE
                BEGIN
                    SET @Mensaje = 'El nuevo correo ya existe en la base de datos, prueba con otro!';
                    RETURN 0;
                END
            END
            ELSE
            BEGIN
                SET @Mensaje = 'El nuevo teléfono ya existe en la base de datos, prueba con otro!';
                RETURN 0;
            END
        END
        ELSE
        BEGIN
            SET @Mensaje = 'El nuevo número de cédula ya existe en la base de datos, prueba con otro!';
            RETURN 0;
        END
    END
    ELSE
    BEGIN
        SET @Mensaje = 'No hay cambios para realizar en los datos del cliente!';
        RETURN 0;
    END
END;
GO

--Procedimiento almacenado para poder eliminar un cliente
CREATE PROCEDURE EliminarCliente(
    @ID_CLIENTE INT,
    @Mensaje VARCHAR(100) OUTPUT
)
AS
BEGIN
    IF NOT EXISTS (SELECT 1 FROM FACTURA_VENTA WHERE ID_CLIENTE = @ID_CLIENTE)
    BEGIN
        DELETE FROM CLIENTES
        WHERE ID_CLIENTE = @ID_CLIENTE;

        SET @Mensaje = 'Cliente eliminado correctamente.';
        RETURN 1;
    END
    ELSE
    BEGIN
        SET @Mensaje = 'No se puede eliminar el cliente porque tiene facturas asociadas.';
        RETURN 0;
    END
END;
GO
--******************************************************************************************************
--PROVEDORES
--Procedimiento almacenado para poder insertar un provedor
CREATE PROCEDURE InsertarProveedor
    @Nombre VARCHAR(20),
    @Telefono VARCHAR(20),
    @Correo VARCHAR(50),
    @Mensaje VARCHAR(100) OUTPUT
AS
BEGIN
    IF NOT EXISTS (SELECT 1 FROM PROVEEDORES WHERE NOMBRE = @Nombre)
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM PROVEEDORES WHERE TELEFONO = @Telefono)
        BEGIN
            IF NOT EXISTS (SELECT 1 FROM PROVEEDORES WHERE CORREO = @Correo)
            BEGIN
                INSERT INTO PROVEEDORES (NOMBRE, TELEFONO, CORREO)
                VALUES (@Nombre, @Telefono, @Correo);

                SET @Mensaje = 'Proveedor insertado correctamente!';
                RETURN 1;
            END
            ELSE
            BEGIN
                SET @Mensaje = 'El correo ya existe para otro proveedor, prueba con otro!';
                RETURN 0;
            END
        END
        ELSE
        BEGIN
            SET @Mensaje = 'El teléfono ya existe para otro proveedor, prueba con otro!';
            RETURN 0;
        END
    END
    ELSE
    BEGIN
        SET @Mensaje = 'El nombre ya existe para otro proveedor, prueba con otro!';
        RETURN 0;
    END
END;
GO

--Procedimiento almacenado para poder modificar un provedor
CREATE PROCEDURE ActualizarProveedor
    @id INT,
    @NuevoNombre VARCHAR(20),
    @NuevoTelefono VARCHAR(20),
    @NuevoCorreo VARCHAR(50),
    @Mensaje VARCHAR(100) OUTPUT
AS
BEGIN
    DECLARE @Cambios INT;

    -- Verificar si hay cambios en los datos
    SELECT @Cambios = CASE WHEN NOMBRE = @NuevoNombre AND TELEFONO = @NuevoTelefono AND CORREO = @NuevoCorreo THEN 0 ELSE 1 END
    FROM PROVEEDORES
    WHERE ID_PROVEEDOR = @id;

    IF @Cambios = 1
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM PROVEEDORES WHERE ID_PROVEEDOR != @id AND NOMBRE = @NuevoNombre)
        BEGIN
            IF NOT EXISTS (SELECT 1 FROM PROVEEDORES WHERE ID_PROVEEDOR != @id AND TELEFONO = @NuevoTelefono)
            BEGIN
                IF NOT EXISTS (SELECT 1 FROM PROVEEDORES WHERE ID_PROVEEDOR != @id AND CORREO = @NuevoCorreo)
                BEGIN
                    UPDATE PROVEEDORES
                    SET NOMBRE = @NuevoNombre,
                        TELEFONO = @NuevoTelefono,
                        CORREO = @NuevoCorreo
                    WHERE ID_PROVEEDOR = @id;

                    SET @Mensaje = 'Proveedor actualizado correctamente!';
                    RETURN 1;
                END
                ELSE
                BEGIN
                    SET @Mensaje = 'El nuevo correo ya existe en la base de datos, prueba con otro!';
                    RETURN 0;
                END
            END
            ELSE
            BEGIN
                SET @Mensaje = 'El nuevo teléfono ya existe en la base de datos, prueba con otro!';
                RETURN 0;
            END
        END
        ELSE
        BEGIN
            SET @Mensaje = 'El nuevo nombre ya existe en la base de datos, prueba con otro!';
            RETURN 0;
        END
    END
    ELSE
    BEGIN
        SET @Mensaje = 'No hay cambios para realizar en los datos del proveedor!';
        RETURN 0;
    END
END;
GO

--Procedimiento almacenado para poder eliminar un provedor
CREATE PROCEDURE EliminarProveedor
    @id INT,
    @Mensaje VARCHAR(100) OUTPUT
AS
BEGIN
    -- Verificar si hay facturas de compra relacionadas con el proveedor
    IF NOT EXISTS (SELECT 1 FROM FACTURA_COMPRA WHERE ID_PROVEEDOR = @id)
    BEGIN
        -- No hay facturas de compra, eliminar el proveedor
        DELETE FROM PROVEEDORES
        WHERE ID_PROVEEDOR = @id;

        SET @Mensaje = 'Proveedor eliminado correctamente!';
        RETURN 1;
    END
    ELSE
    BEGIN
        -- Hay facturas de compra, no se puede eliminar el proveedor
        SET @Mensaje = 'No se puede eliminar el proveedor ya que tiene facturas de compra asociadas, elimina la factura y vuelve!';
        RETURN 0;
    END
END;
GO
--******************************************************************************************************
--PRODUCTOS

--Procedimiento almacenado para poder ingresar un producto
CREATE PROCEDURE InsertarProducto
    @Nombre VARCHAR(20),
    @PrecioCompra DECIMAL(10, 2),
    @Cantidad INT,
    @Mensaje VARCHAR(100) OUTPUT
AS
BEGIN
    IF NOT EXISTS (SELECT 1 FROM PRODUCTOS WHERE NOMBRE = @Nombre)
    BEGIN
        DECLARE @PrecioVenta DECIMAL(10, 2);
        SET @PrecioVenta = @PrecioCompra * 1.20;

        INSERT INTO PRODUCTOS (NOMBRE, PRECIO_COMPRA, PRECIO_VENTA, CANTIDAD)
        VALUES (@Nombre, @PrecioCompra, @PrecioVenta, @Cantidad);

        SET @Mensaje = 'Producto insertado correctamente!';
        RETURN 1;
    END
    ELSE
    BEGIN
        SET @Mensaje = 'Ya existe un producto con este nombre, prueba con otro!';
        RETURN 0;
    END
END;
GO

--Procedimiento almacenado para poder eliminar un producto
CREATE PROCEDURE BorrarProducto
    @ID_PRODUCTO INT,
    @Mensaje VARCHAR(100) OUTPUT
AS
BEGIN
    IF NOT EXISTS (
        SELECT 1
        FROM DETALLE_FACTURA_COMPRA
        WHERE ID_PRODUCTO = @ID_PRODUCTO
    ) AND NOT EXISTS (
        SELECT 1
        FROM DETALLE_FACTURA_VENTA
        WHERE ID_PRODUCTO = @ID_PRODUCTO
    )
    BEGIN
        DELETE FROM PRODUCTOS
        WHERE ID_PRODUCTO = @ID_PRODUCTO;
        
        SET @Mensaje = 'Producto eliminado correctamente!';
        RETURN 1;
    END
    ELSE
    BEGIN
        SET @Mensaje = 'No se puede eliminar el producto porque se encuentra en algun detalle de factura, borra los detalles enlazados y vuelve a intentar!';
        RETURN 0;
    END
END;
GO

--Procedimiento almacenado para poder actualizar un producto
CREATE PROCEDURE ActualizarProducto
    @ID_PRODUCTO INT,
    @NOMBRE VARCHAR(20),
    @PRECIO_COMPRA DECIMAL(10, 2),
    @CANTIDAD INT,
    @MENSAJE VARCHAR(100) OUTPUT
AS
BEGIN
    IF NOT EXISTS (SELECT 1 FROM PRODUCTOS WHERE NOMBRE = @NOMBRE AND ID_PRODUCTO != @ID_PRODUCTO)
    BEGIN
        DECLARE @PRECIO_VENTA DECIMAL(10, 2);
        SET @PRECIO_VENTA = @PRECIO_COMPRA * 1.20;

        UPDATE PRODUCTOS
        SET NOMBRE = @NOMBRE,
            PRECIO_COMPRA = @PRECIO_COMPRA,
            PRECIO_VENTA = @PRECIO_VENTA,
            CANTIDAD = @CANTIDAD
        WHERE ID_PRODUCTO = @ID_PRODUCTO;

        SET @MENSAJE = 'Producto actualizado correctamente!';
        RETURN 1;
    END
    ELSE
    BEGIN
        SET @MENSAJE = 'Ya existe un producto con este nombre, prueba con otro!';
        RETURN 0;
    END
END;
GO

--******************************************************************************************************
--FUNCIONARIOS
--Procedimiento almacenado para insertar un funcionario
CREATE PROCEDURE InsertarFuncionario(
    @Nombre VARCHAR(20),
    @Apellido1 VARCHAR(20),
    @Apellido2 VARCHAR(20),
    @Cedula VARCHAR(20),
    @Puesto VARCHAR(20),
    @Telefono VARCHAR(20),
    @Correo VARCHAR(50),
    @Mensaje VARCHAR(100) OUTPUT
)
AS
BEGIN
    IF NOT EXISTS (SELECT 1 FROM FUNCIONARIOS WHERE CEDULA = @Cedula)
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM FUNCIONARIOS WHERE TELEFONO = @Telefono)
        BEGIN
            IF NOT EXISTS (SELECT 1 FROM FUNCIONARIOS WHERE CORREO = @Correo)
            BEGIN
                INSERT INTO FUNCIONARIOS (NOMBRE, APELLIDO1, APELLIDO2, CEDULA, PUESTO, TELEFONO, CORREO)
                VALUES (@Nombre, @Apellido1, @Apellido2, @Cedula, @Puesto, @Telefono, @Correo);

                SET @Mensaje = 'Funcionario/Veterinario insertado correctamente!';
                RETURN 1;
            END
            ELSE
            BEGIN
                SET @Mensaje = 'El correo ya existe en la base de datos, prueba con otro!';
                RETURN 0;
            END
        END
        ELSE
        BEGIN
            SET @Mensaje = 'El teléfono ya existe en la base de datos, prueba con otro!';
            RETURN 0;
        END
    END
    ELSE
    BEGIN
        SET @Mensaje = 'La cédula ya existe en la base de datos, prueba con otra!';
        RETURN 0;
    END
END;
GO

--Procedimiento almacenado para eliminar un funcionario
CREATE PROCEDURE BorrarFuncionario
    @ID_FUNCIONARIO INT,
    @Mensaje VARCHAR(100) OUTPUT
AS
BEGIN
    -- Verificar si el funcionario tiene agendas
    IF EXISTS (
        SELECT 1
        FROM AGENDA
        WHERE ID_FUNCIONARIO = @ID_FUNCIONARIO
    )
    BEGIN
        SET @Mensaje = 'El funcionario tiene agendas programadas. Borra las agendas enlazadas y vuelve a intentar!';
        RETURN 0;
    END
    ELSE
    BEGIN
        -- Verificar si el funcionario tiene citas
        IF EXISTS (
            SELECT 1
            FROM CITAS
            INNER JOIN AGENDA ON CITAS.ID_AGENDA = AGENDA.ID_AGENDA
            WHERE AGENDA.ID_FUNCIONARIO = @ID_FUNCIONARIO
        )
        BEGIN
            SET @Mensaje = 'El funcionario tiene citas programadas en la agenda!';
            RETURN 0;
        END
        ELSE
        BEGIN
            -- Si no hay agendas ni citas, eliminar el funcionario
            DELETE FROM FUNCIONARIOS
            WHERE ID_FUNCIONARIO = @ID_FUNCIONARIO;
            
            SET @Mensaje = 'Funcionario eliminado correctamente!';
            RETURN 1;
        END
    END
END;
GO

--Procedimiento almacenado para modificar un funcionario
CREATE PROCEDURE ActualizarFuncionario(
    @ID_FUNCIONARIO INT,
    @NuevoNombre VARCHAR(20),
    @NuevoApellido1 VARCHAR(20),
    @NuevoApellido2 VARCHAR(20),
    @NuevaCedula VARCHAR(20),
    @NuevoPuesto VARCHAR(20),
    @NuevoTelefono VARCHAR(20),
    @NuevoCorreo VARCHAR(50),
    @Mensaje VARCHAR(100) OUTPUT
)
AS
BEGIN
    DECLARE @CedulaActual VARCHAR(20);
    SELECT @CedulaActual = CEDULA FROM FUNCIONARIOS WHERE ID_FUNCIONARIO = @ID_FUNCIONARIO;

    IF @CedulaActual <> @NuevaCedula
    BEGIN
        SET @Mensaje = 'La cédula no se puede actualizar!';
        RETURN 0;
    END

    DECLARE @Cambios INT;

    -- Verificar si hay cambios en los datos
    SELECT @Cambios = CASE WHEN NOMBRE = @NuevoNombre AND APELLIDO1 = @NuevoApellido1 AND APELLIDO2 = @NuevoApellido2
                               AND PUESTO = @NuevoPuesto AND TELEFONO = @NuevoTelefono AND CORREO = @NuevoCorreo THEN 0 ELSE 1 END
    FROM FUNCIONARIOS
    WHERE ID_FUNCIONARIO = @ID_FUNCIONARIO;

    IF @Cambios = 1
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM FUNCIONARIOS WHERE ID_FUNCIONARIO != @ID_FUNCIONARIO AND CEDULA = @NuevaCedula)
        BEGIN
            IF NOT EXISTS (SELECT 1 FROM FUNCIONARIOS WHERE ID_FUNCIONARIO != @ID_FUNCIONARIO AND TELEFONO = @NuevoTelefono)
            BEGIN
                IF NOT EXISTS (SELECT 1 FROM FUNCIONARIOS WHERE ID_FUNCIONARIO != @ID_FUNCIONARIO AND CORREO = @NuevoCorreo)
                BEGIN
                    UPDATE FUNCIONARIOS
                    SET NOMBRE = @NuevoNombre,
                        APELLIDO1 = @NuevoApellido1,
                        APELLIDO2 = @NuevoApellido2,
                        PUESTO = @NuevoPuesto,
                        TELEFONO = @NuevoTelefono,
                        CORREO = @NuevoCorreo
                    WHERE ID_FUNCIONARIO = @ID_FUNCIONARIO;

                    SET @Mensaje = 'Funcionario actualizado correctamente!';
                    RETURN 1;
                END
                ELSE
                BEGIN
                    SET @Mensaje = 'El nuevo correo ya existe en la base de datos, prueba con otro!';
                    RETURN 0;
                END
            END
            ELSE
            BEGIN
                SET @Mensaje = 'El nuevo teléfono ya existe en la base de datos, prueba con otro!';
                RETURN 0;
            END
        END
        ELSE
        BEGIN
            SET @Mensaje = 'El nuevo número de cédula ya existe en la base de datos, prueba con otro!';
            RETURN 0;
        END
    END
    ELSE
    BEGIN
        SET @Mensaje = 'No hay cambios para realizar en los datos del funcionario!';
        RETURN 0;
    END
END;
GO

--******************************************************************************************************
--AGENDA
--Procedimiento almacenado para insertar una agenda
CREATE OR ALTER PROCEDURE InsertarAgenda(
    @IdFuncionario INT,
    @Fecha DATE,
    @HoraEntrada TIME,
    @HoraSalida TIME,
    @Mensaje VARCHAR(100) OUTPUT
)
AS
BEGIN
    DECLARE @HoraMinima TIME = '07:00:00';
    DECLARE @HoraMaxima TIME = '20:00:00';
    DECLARE @FechaActual DATE = GETDATE();

    -- Validar fecha
    IF @Fecha > @FechaActual
    BEGIN
        -- Validar hora de entrada y salida
        IF @HoraEntrada < @HoraSalida AND @HoraEntrada >= @HoraMinima AND @HoraSalida >= @HoraMinima AND @HoraSalida <= @HoraMaxima
        BEGIN
            -- Validar si ya existe una agenda para el funcionario en la misma fecha
            IF NOT EXISTS (SELECT 1 FROM AGENDA WHERE ID_FUNCIONARIO = @IdFuncionario AND FECHA = @Fecha)
            BEGIN
                INSERT INTO AGENDA (ID_FUNCIONARIO, FECHA, HORA_ENTRADA, HORA_SALIDA)
                VALUES (@IdFuncionario, @Fecha, @HoraEntrada, @HoraSalida);

                SET @Mensaje = 'Agenda insertada correctamente!';
                RETURN 1;
            END
            ELSE
            BEGIN
                SET @Mensaje = 'Ya existe una agenda para ese funcionario en la misma fecha!';
                RETURN 0;
            END
        END
        ELSE
        BEGIN
            SET @Mensaje = 'El horario de atención es de 7 a las 20 horas horario militar!';
            RETURN 0;
        END
    END
    ELSE
    BEGIN
        SET @Mensaje = 'La fecha debe ser mayor a la fecha actual!';
        RETURN 0;
    END
END;
GO

--Procedimiento almacenado para eliminar una agenda
CREATE PROCEDURE BorrarAgenda
    @ID_AGENDA INT,
    @Mensaje VARCHAR(100) OUTPUT
AS
BEGIN
    -- Verificar si la agenda tiene citas
    IF EXISTS (
        SELECT 1
        FROM CITAS
        WHERE ID_AGENDA = @ID_AGENDA
    )
    BEGIN
        SET @Mensaje = 'La agenda tiene citas programadas. Borra las citas enlazadas y vuelve a intentar!';
        RETURN 0;
    END
    ELSE
    BEGIN
        -- Si no hay citas, eliminar la agenda
        DELETE FROM AGENDA
        WHERE ID_AGENDA = @ID_AGENDA;
        
        SET @Mensaje = 'Agenda eliminada correctamente!';
        RETURN 1;
    END
END;
GO

--******************************************************************************************************
--FACTURA_COMPRA
--Procedimiento almacenado para crear factura
CREATE OR ALTER PROCEDURE CrearFacturaCompra
    @ID_PROVEEDOR INT,
	@NuevaFacturaID INT OUTPUT
AS
BEGIN
    --DECLARE @NuevaFacturaID INT; -- Declarar la variable para el ID generado
    DECLARE @TOTAL_PAGO DECIMAL(10, 2);
    
    INSERT INTO FACTURA_COMPRA (ID_PROVEEDOR)
    VALUES (@ID_PROVEEDOR);
    
    -- Obtener el ID generado para la factura recién insertada
    SET @NuevaFacturaID = SCOPE_IDENTITY();
    
    RETURN 1
END;
GO

--******************************************************************************************************
--DETALLE_FACTURA_COMPRA
--Procedimiento almacenado para ingresar un detalle de factura y se sume el total de cantidad que tiene mas el que se ingreso
CREATE OR ALTER PROCEDURE InsertarDetalleFacturaCompra
    @ID_FACTURA INT,
    @ID_PRODUCTO INT,
    @CANTIDAD_PRODUCTO INT
AS
BEGIN
    -- Actualizar el detalle de factura
    INSERT INTO DETALLE_FACTURA_COMPRA (ID_FACTURA, ID_PRODUCTO, CANTIDAD_PRODUCTO)
    VALUES (@ID_FACTURA, @ID_PRODUCTO, @CANTIDAD_PRODUCTO);

    -- Actualizar el TOTAL_PAGO en FACTURA_COMPRA
    UPDATE FACTURA_COMPRA
    SET TOTAL_PAGO = (SELECT ISNULL(SUM(P.PRECIO_COMPRA * DF.CANTIDAD_PRODUCTO), 0) FROM DETALLE_FACTURA_COMPRA DF INNER JOIN PRODUCTOS P ON DF.ID_PRODUCTO = P.ID_PRODUCTO WHERE DF.ID_FACTURA = @ID_FACTURA)
    WHERE ID_FACTURA = @ID_FACTURA;

    -- Actualizar la cantidad en PRODUCTOS
    UPDATE PRODUCTOS
    SET CANTIDAD = CANTIDAD + @CANTIDAD_PRODUCTO
    WHERE ID_PRODUCTO = @ID_PRODUCTO;
END;
GO

--******************************************************************************************************
--CITAS

CREATE OR ALTER PROCEDURE InsertarCita(
    @ID_AGENDA INT,
    @HORA_CITA TIME,
    @ID_CLIENTE INT,
    @COSTO DECIMAL(10,2),
    @DESCRIPCION_CITA VARCHAR(100),
    @Mensaje VARCHAR(100) OUTPUT,
    @ID_CITA INT OUTPUT
)
AS
BEGIN
    -- Verificar si ya existe una cita en la misma hora en la agenda
    IF NOT EXISTS (
        SELECT 1
        FROM CITAS C
        INNER JOIN AGENDA A ON C.ID_AGENDA = A.ID_AGENDA
        WHERE A.ID_AGENDA = @ID_AGENDA
            AND C.HORA_CITA = @HORA_CITA
    )
    BEGIN
        -- Insertar la cita si no hay conflicto de horario en la agenda
        INSERT INTO CITAS (ID_AGENDA, ID_CLIENTE, HORA_CITA, COSTO, DESCRIPCION_CITA)
        VALUES (@ID_AGENDA, @ID_CLIENTE, @HORA_CITA, @COSTO, @DESCRIPCION_CITA);

        SET @Mensaje = 'Cita agendada correctamente!';
        SET @ID_CITA = SCOPE_IDENTITY(); -- Recuperar el ID de la cita recién insertada
        RETURN 1;
    END
    ELSE
    BEGIN
        SET @Mensaje = 'Ya existe una cita agendada en la misma hora, agende con otra hora!';
        SET @ID_CITA = NULL; -- No se pudo insertar la cita, el ID es nulo
        RETURN 0;
    END
END;
GO


--******************************************************************************************************
--FACTURA_VENTA
--Agregar factura de venta nueva
CREATE OR ALTER PROCEDURE CrearFacturaVenta
    @ID_CLIENTE INT,
    @NuevaFacturaID INT OUTPUT
AS
BEGIN
    --DECLARE @NuevaFacturaID INT; -- Declarar la variable para el ID generado
    DECLARE @TOTAL_PAGO DECIMAL(10, 2) = 0.0; -- Inicializar el total de pago
    
    INSERT INTO FACTURA_VENTA (ID_CLIENTE, TOTAL_PAGO)
    VALUES (@ID_CLIENTE, @TOTAL_PAGO);
    
    -- Obtener el ID generado para la factura recién insertada
    SET @NuevaFacturaID = SCOPE_IDENTITY();
    
    RETURN 1;
END;
GO
--******************************************************************************************************
--DETALLE_FACTURA_VENTA
--Agregar detalle factura de venta nueva
CREATE OR ALTER PROCEDURE InsertarDetalleVentaProducto
    @ID_FACTURA INT,
    @ID_PRODUCTO INT,
    @CANTIDAD_PRODUCTO INT,
    @Mensaje VARCHAR(100) OUTPUT
AS
BEGIN
    DECLARE @PRECIO_PRODUCTO DECIMAL(10, 2);
    
    -- Obtener el precio del producto
    SELECT @PRECIO_PRODUCTO = PRECIO_VENTA
    FROM PRODUCTOS
    WHERE ID_PRODUCTO = @ID_PRODUCTO;

    -- Validar existencia suficiente
    DECLARE @EXISTENCIA_ACTUAL INT;
    SELECT @EXISTENCIA_ACTUAL = CANTIDAD
    FROM PRODUCTOS
    WHERE ID_PRODUCTO = @ID_PRODUCTO;

    IF @CANTIDAD_PRODUCTO <= @EXISTENCIA_ACTUAL
    BEGIN
        -- Insertar en DETALLE_FACTURA_VENTA
        INSERT INTO DETALLE_FACTURA_VENTA (ID_FACTURA, ID_PRODUCTO, CANTIDAD_PRODUCTO, FECHA_VENTA, HORA)
        VALUES (@ID_FACTURA, @ID_PRODUCTO, @CANTIDAD_PRODUCTO, GETDATE(), GETDATE());

        -- Actualizar el TOTAL_PAGO en FACTURA_VENTA
        UPDATE FACTURA_VENTA
        SET TOTAL_PAGO = TOTAL_PAGO + (@PRECIO_PRODUCTO * @CANTIDAD_PRODUCTO)
        WHERE ID_FACTURA = @ID_FACTURA;

        -- Actualizar la cantidad en PRODUCTOS
        UPDATE PRODUCTOS
        SET CANTIDAD = CANTIDAD - @CANTIDAD_PRODUCTO
        WHERE ID_PRODUCTO = @ID_PRODUCTO;

        SET @Mensaje = 'Detalle de venta de producto insertado correctamente!';
    END
    ELSE
    BEGIN
        SET @Mensaje = 'No hay suficiente cantidad en existencia para vender este producto';
    END;
END;
GO

CREATE OR ALTER PROCEDURE InsertarDetalleVentaServicio
    @ID_FACTURA INT,
    @ID_CITA INT,
    @Mensaje VARCHAR(100) OUTPUT
AS
BEGIN
    DECLARE @COSTO_SERVICIO DECIMAL(10, 2);
    
    -- Obtener el costo del servicio desde la tabla CITAS
    SELECT @COSTO_SERVICIO = COSTO
    FROM CITAS
    WHERE ID_CITA = @ID_CITA;

    -- Insertar en DETALLE_FACTURA_VENTA
    INSERT INTO DETALLE_FACTURA_VENTA (ID_FACTURA, ID_CITA, FECHA_VENTA, HORA)
    VALUES (@ID_FACTURA, @ID_CITA, GETDATE(), GETDATE());

    -- Actualizar el TOTAL_PAGO en FACTURA_VENTA
    UPDATE FACTURA_VENTA
    SET TOTAL_PAGO = TOTAL_PAGO + @COSTO_SERVICIO
    WHERE ID_FACTURA = @ID_FACTURA;

    SET @Mensaje = 'Detalle de venta de servicio insertado correctamente!';
END;
GO

--******************************************************************************************************
--Triggers para la Bitacora
GO
CREATE TRIGGER Trg_RegistrarVenta
ON FACTURA_VENTA
AFTER INSERT
AS
BEGIN
    DECLARE @ID_FACTURA INT;
    SELECT @ID_FACTURA = inserted.ID_FACTURA FROM inserted;

    DECLARE @DESCRIPCION VARCHAR(150);
    SET @DESCRIPCION = 'Se realizó una venta';

    INSERT INTO BITACORA (FECHA, HORA, DESCRIPCION_MOVIMIENTO)
    VALUES (GETDATE(), GETDATE(), @DESCRIPCION + ' (ID Factura: ' + CAST(@ID_FACTURA AS VARCHAR) + ')');
END;
GO

GO
CREATE TRIGGER Trg_RegistrarCompra
ON FACTURA_COMPRA
AFTER INSERT
AS
BEGIN
    DECLARE @ID_FACTURA INT;
    SELECT @ID_FACTURA = inserted.ID_FACTURA FROM inserted;

    DECLARE @DESCRIPCION VARCHAR(150);
    SET @DESCRIPCION = 'Se realizó una compra';

    INSERT INTO BITACORA (FECHA, HORA, DESCRIPCION_MOVIMIENTO)
    VALUES (GETDATE(), GETDATE(), @DESCRIPCION + ' (ID Factura: ' + CAST(@ID_FACTURA AS VARCHAR) + ')');
END;
GO




