package controleestoqueuam;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * Rubens Guarnieri, R.A.: 20303016
 * Erik Henrique, R.A.: 20301986
 */
public class EfetuaPedidoView extends JPanel{
    private JLabel labelCodigo;
    private JTextField textCodigo;
    private JLabel labelQuantidade;
    private JTextField textQuantidade;
    private JButton buttonAdicionar;
    private JPanel painelCampos;
    private JPanel painelPrincipal;
    
    public EfetuaPedidoView(){
        this.painelPrincipal = new JPanel();
        this.painelPrincipal.setSize(400,300);
        this.painelPrincipal.setLayout(new BorderLayout(0,2));
        this.painelCampos = new JPanel();
        this.painelCampos.setSize(400,200);
        this.labelCodigo = new JLabel("Código:");
        this.textCodigo = new JTextField(13);
        this.labelQuantidade = new JLabel("Quantidade:");
        this.textQuantidade = new JTextField(13);
        this.buttonAdicionar = new JButton("Adicionar");
        GridLayout grid = new GridLayout(4,2);
        grid.setHgap(5);
        this.painelCampos.setLayout(grid);
        this.painelCampos.add(labelCodigo);
        this.painelCampos.add(new JLabel(""));
        this.painelCampos.add(textCodigo);
        this.painelCampos.add(new JLabel(""));
        this.painelCampos.add(labelQuantidade);
        this.painelCampos.add(new JLabel(""));
        this.painelCampos.add(textQuantidade);
        this.painelPrincipal.add(painelCampos, BorderLayout.CENTER);
        this.painelPrincipal.add(buttonAdicionar, BorderLayout.PAGE_END);
        this.add(painelPrincipal);  
    }

    //Getter e Setter do campo do código
    public JTextField getTextCodigo() {
        return textCodigo;
    }

    public JTextField getTextQuantidade() {
        return textQuantidade;
    }

    //Listener do botão de adicionar item no pedido
    public void addActionListener(ActionListener l) {
        buttonAdicionar.addActionListener(l);
    }
    
    //Limpa os campos da tela.
    public void limpaCampos() {
        this.textCodigo.setText("");
        this.textQuantidade.setText("");
    }
}
