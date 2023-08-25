package Config;
//Anthony Rodriguez Valverde 18/08/2023
public class Config {
    //Creamos el metodo de la configuracion para la conexion
    public static String getConnectionString() throws ClassNotFoundException{
        //Registramos el controlador(Driver)
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        
        //Retornamos la cadena de conexion
        return "jdbc:sqlserver://localhost;databaseName=MASCOTAS_FELICES;user=sa;password=sa";
    }
}
