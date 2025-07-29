import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    private JTextField userField;
    private JPasswordField passField;

    public LoginFrame() {
        setTitle("Login - Oficina Mecânica");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel userLabel = new JLabel("Usuário:");
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(userLabel, gbc);

        userField = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(userField, gbc);

        JLabel passLabel = new JLabel("Senha:");
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(passLabel, gbc);

        passField = new JPasswordField(20);
        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(passField, gbc);

        JButton loginBtn = new JButton("Entrar");
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        panel.add(loginBtn, gbc);

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });

        add(panel);
    }

    private void handleLogin() {
        String user = userField.getText().trim();
        String pass = new String(passField.getPassword()).trim();

        // Simple validation only
        if (!user.isEmpty() && !pass.isEmpty()) {
            SwingUtilities.invokeLater(() -> {
                dispose();
                new DashboardFrame(user).setVisible(true);
            });
        } else {
            JOptionPane.showMessageDialog(this, "Usuário e senha obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}