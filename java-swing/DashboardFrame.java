import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {
    public DashboardFrame(String user) {
        setTitle("Dashboard - Oficina Mecânica");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI(user);
    }

    private void initUI(String user) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel welcome = new JLabel("Bem-vindo, " + user + "!");
        welcome.setFont(new Font("Arial", Font.BOLD, 18));
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(welcome);

        panel.add(Box.createRigidArea(new Dimension(0, 15)));

        String[] options = {
                "Nova Ordem de Serviço",
                "Veículos",
                "Clientes",
                "Peças / Estoque",
                "Relatórios"
        };

        for (String op : options) {
            JButton btn = new JButton(op);
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
            panel.add(btn);
            panel.add(Box.createRigidArea(new Dimension(0, 10)));
        }

        add(panel);
    }
}