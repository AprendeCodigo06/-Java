/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {

    public Container contenedor;
    public JLabel lblfondo, lblcomponentes;
    public JTextField txtusuario;
    public JPasswordField jpass;
    public JButton btnenviar;
    public String imagen = "C:\\Users\\rober\\OneDrive\\Documentos\\NetBeansProjects\\ProyectoGit\\src\\Imagenes\\fondo.jpg";

    public Login() {
        contenedor = this.getContentPane();
        setLayout(null);
        //color del contenedor
        contenedor.setBackground(Color.decode("#343A40"));
        //imagen de fondo
        lblfondo = new JLabel(new ImageIcon(imagen));
        //cajas de texto
        txtusuario = new JTextField();
        txtusuario.setBackground(Color.decode("#343A40"));
        txtusuario.setForeground(Color.WHITE);
        jpass = new JPasswordField();
        jpass.setBackground(Color.decode("#343A40"));
        jpass.setForeground(Color.WHITE);
        //boton
        btnenviar = new JButton("Enviar");
        btnenviar.setBackground(Color.decode("#88E1F2"));
        btnenviar.setBorder(null);

        //TextPromp
        TextPrompt usuario = new TextPrompt(" Usuario", txtusuario);
        TextPrompt pass = new TextPrompt("Contraseña", jpass);

        //agregar componentes al contenedor
        contenedor.add(lblfondo);
        lblfondo.setBounds(0, 0, 500, 748);
        contenedor.add((txtusuario));
        txtusuario.setBounds(600, 150, 200, 25);
        contenedor.add(jpass);
        jpass.setBounds(600, 200, 200, 25);
        contenedor.add(btnenviar);
        btnenviar.setBounds(600, 250, 200, 25);
        
        setSize(900, 748);
        setVisible(true);
        setLocationRelativeTo(null);
        
        //evento al boton
        btnenviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == btnenviar) {
                    //declaracion de variables
                    String usuario = "";
                    char contra[] = jpass.getPassword();
                    String pass = new String(contra);
                    usuario = txtusuario.getText();
                    //asignamos nombre de usuario y contrasena
                    if (usuario.equals("admin") && pass.equals("admin123")) {
                        JOptionPane.showMessageDialog(null, "Credenciales Correctas");
                        System.out.println("Login Correcto");
                        limpiar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Credenciales Incorectas");
                        System.out.println("Login incorrecto");
                        limpiar();
                    }

                }

            }

        });        
        
        
    }

    public static void main(String[] args) {
        Login login = new Login();
    }

    public void limpiar() {
        txtusuario.setText(" ");
        jpass.setText("");
    }

}
