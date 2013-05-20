package controleestoqueuam;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * Rubens Guarnieri, R.A.: 20303016
 * Erik Henrique, R.A.: 20301986
 */
public class FecharContaView extends JPanel {

    private JTextArea textRelatorio;
    private JButton buttonGeraRelatorio;
    private JButton buttonFechaConta;
    private JPanel painelPrincipal;
    private JPanel painelCampos;

    public FecharContaView() {
        this.painelPrincipal = new JPanel();
        this.painelPrincipal.setSize(400, 300);
        this.painelPrincipal.setLayout(new BorderLayout(0, 2));
        this.painelCampos = new JPanel();
        this.painelCampos.setLayout(new GridLayout(1, 1));
        this.textRelatorio = new JTextArea();
        this.textRelatorio.setEnabled(false);
        JScrollPane scroll = new JScrollPane(this.textRelatorio,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setPreferredSize(new Dimension(400, 200));
        JPanel painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(1, 3));
        this.buttonFechaConta = new JButton("Fechar Conta");
        this.buttonGeraRelatorio = new JButton("Ver Relatório");
        painelFundo.add(buttonFechaConta);
        painelFundo.add(new JLabel(""));
        painelFundo.add(buttonGeraRelatorio);
        this.painelPrincipal.add(new JLabel("Fechamento de Conta"), BorderLayout.PAGE_START);
        this.painelPrincipal.add(scroll, BorderLayout.CENTER);
        this.painelPrincipal.add(painelFundo, BorderLayout.PAGE_END);
        this.add(painelPrincipal);
    }

    //Adiciona texto do fechamento da conta
    public void setTextRelatorio(String textRelatorio) {
        this.textRelatorio.setText(textRelatorio);
    }

    //Listener do botão para gerar o relatório
    public void addActionListenerRelatorio(ActionListener l) {
        buttonGeraRelatorio.addActionListener(l);
    }

    //Listener do botão que irá fechar a conta
    public void addActionListenerFecharConta(ActionListener l) {
        buttonFechaConta.addActionListener(l);
    }
}
