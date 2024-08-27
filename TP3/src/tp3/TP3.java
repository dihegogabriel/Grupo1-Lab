package tp3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TP3 {
    public static void main(String[] args) {
        
        //Crear JFrame
        JFrame frame = new JFrame("Credenciales");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());
        
        //Crear el panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        
        //Componentes
        JLabel emailLabel = new JLabel("Usuario:");
        JTextField emailField = new JTextField();
        JLabel passwordLabel = new JLabel("Contraseña:");
        JPasswordField passwordField = new JPasswordField();
        JButton registerButton = new JButton("Registrar");
        
        //Añadir componentes al panel
        panel.add(emailField);
        panel.add(emailLabel);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(registerButton);
        
        //Panel para botones de contrasenia
        JPanel visibilityPanel = new JPanel();
        JButton hideButton = new JButton("Ocultar");
        JButton showButton = new JButton("Ver");
        visibilityPanel.add(hideButton);
        visibilityPanel.add(showButton);
        
        //Añadir al JFrame
        frame.add(panel, BorderLayout.CENTER);
        frame.add(visibilityPanel, BorderLayout.SOUTH);
        
        //Accion ocultar
        hideButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                passwordField.setEchoChar('*');
            }
        });
        
        //Accion mostrar
        showButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                passwordField.setEchoChar((char) 0);
            }
        });
        
        //Accion registrar
        registerButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                if(email.equals("alumno@ulp.edu.ar") && password.equals("12345678")){
                    JOptionPane.showMessageDialog(frame, "Bienvenido!");
                }else{
                    JOptionPane.showMessageDialog(frame, "Usuario y/o contraseña incorrectos");
                }
            }
        });
<<<<<<< Updated upstream
        //configuracion frame
=======
        
        //configuracion frame
>>>>>>> Stashed changes
        frame.setLocationRelativeTo(null); //centrar frame
        frame.setVisible(true);
    }
}