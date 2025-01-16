import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaCrud extends metodosCRUD{
    private JButton eliminarButton;
    private JButton leerButton;
    private JButton actualizarButton;
    private JButton ingresarButton;
    private JTextField textNombre;
    private JTextField textCorreo;
    private JTextField textEdad;
    private JLabel lbName;
    private JLabel lbEmail;
    private JLabel lbAge;
    private JLabel lbLeer;
    public JPanel crudPanel;
    private JTextField textID;
    private JLabel lbID;

    public ventanaCrud() {
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                metodosCRUD mc = new metodosCRUD();
                mc.insertarUsuario(textNombre.getText(),textCorreo.getText(),Integer.parseInt(textEdad.getText()));

            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                metodosCRUD mc1 = new metodosCRUD();
                mc1.modificarUsuario(Integer.parseInt(textID.getText()),textNombre.getText(),textCorreo.getText(),Integer.parseInt(textEdad.getText()));
            }
        });
        leerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbLeer.setText("No pude :(");
//
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                metodosCRUD mc3 = new metodosCRUD();
                int id = Integer.parseInt(textID.getText());
                mc3.eliminarUsuario(id);


            }
        });
    }
}
