package tp_6;

import javax.swing.SwingUtilities;

public class TP_6 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new GestionProductos().setVisible(true);
            }
        }
        );
    }
}