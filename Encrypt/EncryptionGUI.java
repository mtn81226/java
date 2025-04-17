import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EncryptionGUI extends JFrame {
    private JTextArea inputArea, outputArea;
    private JButton encryptButton, decryptButton;
    private JComboBox<String> algorithmComboBox;
    private Encryptable encryptor;

    public EncryptionGUI() {
        setTitle("Encrypt/Decrypt Tool");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        inputArea = new JTextArea(5, 40);
        outputArea = new JTextArea(5, 40);
        outputArea.setEditable(false);

        encryptButton = new JButton("Encrypt");
        decryptButton = new JButton("Decrypt");

        String[] algorithms = {"AES", "RSA"};
        algorithmComboBox = new JComboBox<>(algorithms);

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Algorithm:"));
        topPanel.add(algorithmComboBox);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(encryptButton);
        buttonPanel.add(decryptButton);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(inputArea), BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        try {
            encryptor = new AESEncryptor(); // Default
        } catch (Exception e) {
            showError(e.getMessage());
        }

        algorithmComboBox.addActionListener(e -> {
            try {
                if (algorithmComboBox.getSelectedItem().equals("AES")) {
                    encryptor = new AESEncryptor();
                } else {
                    encryptor = new RSAEncryptor();
                }
            } catch (Exception ex) {
                showError("Error initializing algorithm: " + ex.getMessage());
            }
        });

        encryptButton.addActionListener(e -> {
            try {
                String input = inputArea.getText();
                String encrypted = encryptor.encrypt(input);
                outputArea.setText(encrypted);
            } catch (Exception ex) {
                showError("Encryption failed: " + ex.getMessage());
            }
        });

        decryptButton.addActionListener(e -> {
            try {
                String input = inputArea.getText();
                String decrypted = encryptor.decrypt(input);
                outputArea.setText(decrypted);
            } catch (Exception ex) {
                showError("Decryption failed: " + ex.getMessage());
            }
        });
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EncryptionGUI().setVisible(true));
    }
}
