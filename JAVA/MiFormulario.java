import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class MiFormulario extends JFrame {

    public MiFormulario() {
        initComponents();
    }

    private void initComponents() {
        // Configurar JFrame
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mi Formulario");
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Crear y añadir un panel
        JPanel panel = new JPanel();
        panel.add(new JLabel("Hola, Mundo!"));
        getContentPane().add(panel);

        JPanel boton = new JPanel();
        panel.add(new JButton());
        
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MiFormulario().setVisible(true);
            }
        });
    }
}
