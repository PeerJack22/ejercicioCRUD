import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class metodosCRUD {

    //Conectar con la base de datos
    String url = "jdbc:mysql://localhost:3306/ejemplo_crud";
    String user = "root";
    String password = "123456";

    //Metodo para insertar datos
    public void insertarUsuario(String nombre, String correo, int edad){
        String query = "insert into usuarios (nombre, correo, edad) values (?,?,?)";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, nombre);
            ps.setString(2, correo);
            ps.setInt(3, edad);
            ps.executeUpdate();
            System.out.println("Insertado exitosamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Metodo para seleccionar datos
    public void leerUsuario(){
        String query = "select * from usuarios";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
                System.out.println(rs.getString("correo"));
                System.out.println(rs.getInt("edad"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Metodo para actualizar datos
    public void modificarUsuario(int id, String nombre, String correo, int edad){
        String query = "UPDATE usuarios set nombre=?, correo=?, edad=? where id=?";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, nombre);
            ps.setString(2, correo);
            ps.setInt(3, edad);
            ps.setInt(4, id);
            ps.executeUpdate();
            System.out.println("Modificado exitosamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Metodo para eliminar datos
    public void eliminarUsuario(int id){
        String query = "delete from usuarios where id=?";
        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Eliminado exitosamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
