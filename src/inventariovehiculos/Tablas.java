package inventariovehiculos;

import java.sql.ResultSet;
public class Tablas {
    conexion conect =new conexion();
    
    // Tabla Empleados
    public void insertarEmpleado(String IdEmpleado,String primerNombre,String segundoNombre,String primerApellido,String segundoApellido,String Direccion,String Edad,String Sexo,String Cargo, String Contraseña) {
        conect.UID("INSERT INTO Empleados(IdEmpleado,primerNombre,segundoNombre,primerApellido,segundoApellido,direccion,Edad,sexo,IdCargo,contraseña) VALUES('" + IdEmpleado + "','" + primerNombre + "','" + segundoNombre + "','" + primerApellido + "','" + segundoApellido + "','" + Direccion + "','" + Edad + "','" + Sexo + "','" + Cargo + "','" + Contraseña + "')");
    }
   
    public void modificar(String codigo, String apellido1, String apellido2, String nombre, String fechaNacimiento, String sexo, String celular) {
        conect.UID("UPDATE empleados SET apellido1='" + apellido1 + "',apellido2='" + apellido2 + "',nombre='" + nombre + "',fechaNacimiento='" + fechaNacimiento + "',sexo='" + sexo + "',celular='" + celular + "' WHERE codigo='" + codigo + "'");
    }

    public void eliminar(String IdEmpleado) {
        conect.UID("DELETE  FROM empleados WHERE IdEmpleado='" + IdEmpleado + "'");
    }

    public ResultSet buscarEmpleados(String IdEmpleado) {
        return (conect.getValores("SELECT * FROM empleados WHERE IdEmpleado='" + IdEmpleado + "'"));
    }
    public ResultSet contarEmpleados() {
        return (conect.getValores("SELECT COUNT(IdEmpleado) FROM Empleados"));
    }

    public ResultSet mayorRegistroEmpleados() {
        return (conect.getValores("SELECT MAX(IdEmpleado) FROM Empleados"));
    }
    
    
    
    
    //Tabla Marcas
    public ResultSet buscarMarcas() {
        return (conect.getValores("SELECT nombreMarca FROM marcas"));
    }
    public ResultSet contarMarcas() {
        return (conect.getValores("SELECT COUNT(IdMarca) FROM Marcas"));
    }

    public ResultSet mayorRegistro() {
        return (conect.getValores("SELECT MAX(IdMarca) FROM Marcas"));
    }

    //Modelos
    public ResultSet llenarTabla(String IdModelo) {
        return (conect.getValores("select marcas.nombreMarca,nombreModelo,colores.nombreColor,combustibles.nombreCombustible,motores.nombreMotor,tipos.nombreTipo,cantidad,precio,version from modelos inner join marcas on modelos.Idmarca=Marcas.IdMarca inner join colores on modelos.IdColor=colores.IdColor inner join combustibles on modelos.IdCombustible=combustibles.IdCombustible inner join motores on modelos.IdMotor=motores.Idmotor inner join tipos on modelos.IdTipo=tipos.IdTipo where IdModelo='" + IdModelo + "'"));
    }    
    public ResultSet buscarModelos(String modelos) {
        return (conect.getValores("SELECT nombreModelo FROM modelos where IdMarca='" + modelos + "'"));
    }
    public void insertarModelo(String IdMarca,String IdModelo,String nombreModelo,String IdColor,String IdCombustible,String IdMotor,String IdTipo,String cantidad,String precio, String version) {
        conect.UID("INSERT INTO modelos(IdMarca,IdModelo,nombreModelo,IdColor,IdCombustible,IdMotor,IdTipo,cantidad,precio,version) VALUES('" + IdMarca + "','" + IdModelo + "','" + nombreModelo + "','" + IdColor + "','" + IdCombustible + "','" + IdMotor + "','" + IdTipo + "','" + cantidad + "','" + precio + "','" + version + "')");
    }
    public ResultSet BuscarModelo(String IdMarca,String nombreModelo){
        return(conect.getValores("Select IdModelo,nombreModelo from Modelos where IdMarca='" +IdMarca + "' and nombreModelo='" + nombreModelo+ "'"));
    }
    public ResultSet MayorIdModelo(String IdMarca){
        return(conect.getValores("Select max(Idmodelo) from Modelos where IdMarca='"+ IdMarca+"'"));
    }
    //Colores
     public ResultSet buscarColores() {
        return (conect.getValores("SELECT nombreColor FROM colores"));
    }
    public ResultSet contarColores() {
        return (conect.getValores("SELECT COUNT(IdColor) FROM colores"));
    }

    public ResultSet mayorRegistroColores() {
        return (conect.getValores("SELECT MAX(IdColor) FROM Colores"));
    }
        public void nuevoColor(int IdColor,String nombreColor){
        conect.UID("Insert into colores(IdColor,nombreColor)values('" + IdColor + "','" + nombreColor + "')");
    }
        public ResultSet buscarColor(int IdColor){
            return(conect.getValores("select nombreColor color from colores where IdColor= '" + IdColor+"'"));
        }
    
    
    //Combustibles
    public ResultSet buscarCombustibles() {
        return (conect.getValores("SELECT nombreCombustible FROM combustibles"));
    }
    public ResultSet contarCombustibles() {
        return (conect.getValores("SELECT COUNT(IdCombustible) FROM combustibles"));
    }

    public ResultSet mayorRegistroCombustibles() {
        return (conect.getValores("SELECT MAX(IdCombustible) FROM Combustibles"));
    }
    
    
    //Motores
    
    public ResultSet buscarMotores() {
        return (conect.getValores("SELECT nombreMotor FROM motores"));
    }
    public ResultSet contarMotores() {
        return (conect.getValores("SELECT COUNT(IdMotor) FROM motores"));
    }

    public ResultSet mayorRegistroMotores() {
        return (conect.getValores("SELECT MAX(IdMotor) FROM motores"));
    }

    
    //Tipos
    
    public ResultSet buscarTipos() {
        return (conect.getValores("SELECT nombreTipo FROM tipos"));
    }
    public ResultSet contarTipos() {
        return (conect.getValores("SELECT COUNT(IdTipo) FROM tipos"));
    }

    public ResultSet mayorRegistroTipos() {
        return (conect.getValores("SELECT MAX(IdTipo) FROM tipos"));
    }
}
