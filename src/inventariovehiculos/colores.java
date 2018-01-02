package inventariovehiculos;
import java.sql.ResultSet;
public class colores {
    conexion conect= new conexion();
    public void Insertar(String color,String nombreColor){
        conect.UID("insert into colores(color,nombreColor)values('" + color + "','" + nombreColor + "')");
    }
    public void Modificar(String color, String nombreColor){
        conect.UID("Update colores set nombreColor='" + nombreColor +"' where color='" + color +"'");
    }
    public ResultSet buscar (String color){
        return(conect.getValores("select nombreColor from colores where color='" + color +"'"));
    }
    public ResultSet cuantosRegistros(){
        return(conect.getValores("select count(color) from colores"));
    }
    public ResultSet MayorRegistro(){
        return(conect.getValores("select max(color) from colores"));
    }
}
