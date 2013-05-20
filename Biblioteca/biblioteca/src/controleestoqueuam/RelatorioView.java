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
public class RelatorioView extends JPanel {

    private JTextArea textRelatorio;
    private JButton buttonGeraRelatorio;
    private JPanel painelPrincipal;
    private JPanel painelCampos;

    public RelatorioView() {
        this.painelPrincipal = new JPanel();
        this.painelPrincipal.setSize(400, 300);
        this.painelPrincipal.setLayout(new BorderLayout(0, 2));
        this.painelCampos = new JPanel();
        this.painelCampos.setLayout(new GridLayout(1, 1));
        this.textRelatorio = new JTextArea();
        this.textRelatorio.setEnabled(false);
        
        //scroll fará com que o JTextArea tenha uma barra de scroll
        JScrollPane scroll = new JScrollPane(this.textRelatorio,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setPreferredSize(new Dimension(400, 200));
        this.buttonGeraRelatorio = new JButton("Gerar Relatório");
        this.painelPrincipal.add(scroll, BorderLayout.CENTER);
        this.painelPrincipal.add(buttonGeraRelatorio, BorderLayout.PAGE_END);
        this.add(painelPrincipal);
    }
    
    //Adiciona texto no JTextArea
    public void setTextRelatorio(String textRelatorio) {
        this.textRelatorio.setText(textRelatorio);
    }
    
    //Titulo do relatório
    public void adicionaTitulo(String texto) {
        this.painelPrincipal.add(new JLabel(texto), BorderLayout.PAGE_START);
    }
    
    //Adiciona listener no botão para gerar o relatório.
    public void addActionListener(ActionListener l) {
        buttonGeraRelatorio.addActionListener(l);
    }
}
