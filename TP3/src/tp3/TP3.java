package tp3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
        JPanel visibilityJPanel = new JPanel();
        JButton hideButton = new JButton();
        JButton showButton = new JButton();
        visibilityPanel.add(hideButton);
        visibilityPanel.add();
    }
}
