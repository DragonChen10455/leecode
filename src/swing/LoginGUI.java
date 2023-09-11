package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame implements ActionListener {

    private JLabel userLabel, passwordLabel, languageLabel, fontSizeLabel;
    private JTextField userTextField, passwordTextField;
    private JButton loginButton, cancelButton;
    private JCheckBox rememberCheckBox;
    private JRadioButton chineseRadioButton, englishRadioButton;
    private ButtonGroup languageButtonGroup;
    private JComboBox fontSizeComboBox;

    public LoginGUI() {

        // 设置窗口标题
        setTitle("登录");

        // 设置布局
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // 初始化组件
        userLabel = new JLabel("用户名:");
        passwordLabel = new JLabel("密码:");
        languageLabel = new JLabel("语言:");
        fontSizeLabel = new JLabel("字体大小:");

        userTextField = new JTextField(20);
        passwordTextField = new JPasswordField(20);

        loginButton = new JButton("登录");
        cancelButton = new JButton("取消");

        rememberCheckBox = new JCheckBox("记住密码");

        chineseRadioButton = new JRadioButton("中文");
        englishRadioButton = new JRadioButton("英文");

        languageButtonGroup = new ButtonGroup();
        languageButtonGroup.add(chineseRadioButton);
        languageButtonGroup.add(englishRadioButton);

        fontSizeComboBox = new JComboBox<>(new String[]{"10", "12", "14", "16", "18", "20"});

        // 添加组件
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(userLabel, gbc);
        gbc.gridx = 1;
        add(userTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(passwordLabel, gbc);
        gbc.gridx = 1;
        add(passwordTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(languageLabel, gbc);
        gbc.gridx = 1;
        JPanel languagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        languagePanel.add(chineseRadioButton);
        languagePanel.add(englishRadioButton);
        add(languagePanel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(fontSizeLabel, gbc);
        gbc.gridx = 1;
        add(fontSizeComboBox, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(rememberCheckBox, gbc);
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        add(loginButton, gbc);
        gbc.gridx = 1;
        add(cancelButton, gbc);

        // 给按钮添加事件监听器
        loginButton.addActionListener(this);
        cancelButton.addActionListener(this);

        // 设置窗口大小并居中显示
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent event) {
        // 处理按钮点击事件
        if (event.getSource() == loginButton) {
            String user = userTextField.getText();
            String password = passwordTextField.getText();
            boolean remember = rememberCheckBox.isSelected();
            String language = chineseRadioButton.isSelected() ? "中文" : "英文";
            String fontSize = (String) fontSizeComboBox.getSelectedItem();
            String message = "用户名: " + user + "\n" +
                    "密码: " + password + "\n" +
                    "记住密码: " + remember + "\n" +
                    "语言: " + language + "\n" +
                    "字体大小: " + fontSize;
            System.out.println(message);
            // 显示登录结果
            JOptionPane.showMessageDialog(this, message);
        } else if (event.getSource() == cancelButton) {
            // 清空文本框内容
            userTextField.setText("");
            passwordTextField.setText("");
        }
    }

    public static void main(String[] args) {
        new LoginGUI();
    }
}






