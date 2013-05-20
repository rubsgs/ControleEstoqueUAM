
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
 * Rubens Guarnieri, R.A.: 20303016 Erik Henrique, R.A.: 20301986
 */
public class AtualizaQuantidadeView extends JPanel {

    private JLabel labelCodigo;
    private JTextField textCodigo;
    private JLabel labelQuantidade;
    private JTextField textQuantidade;
    private JButton buttonAtualizar;
    private JPanel painelCampos;
    private JPanel painelPrincipal;

    public AtualizaQuantidadeView() {
        this.painelPrincipal = new JPanel();
        this.painelPrincipal.setSize(400, 300);
        this.painelPrincipal.setLayout(new BorderLayout(0, 2));
        this.painelCampos = new JPanel();
        this.painelCampos.setSize(400, 200);
        this.labelCodigo = new JLabel("Código:");
        this.textCodigo = new JTextField(13);
        this.labelQuantidade = new JLabel("Quantidade:");
        this.textQuantidade = new JTextField(13);
        this.buttonAtualizar = new JButton("Alterar Quantidade");
        GridLayout grid = new GridLayout(4, 2);
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
        this.painelPrincipal.add(buttonAtualizar, BorderLayout.PAGE_END);
        this.add(painelPrincipal);
    }

    /*getTextCodigo() e getTextQuantidade() retornam os valores 
     * dos campos de texto da interface
     * */
    public String getTextCodigo() {
        return textCodigo.getText();
    }

    public String getTextQuantidade() {
        return textQuantidade.getText();
    }

    //Listener do botão de atualizar quantidade.
    public void addActionListener(ActionListener l) {
        buttonAtualizar.addActionListener(l);
    }
    
    //Limpa campos de texto.
    public void limpaCampos() {
        this.textCodigo.setText("");
        this.textQuantidade.setText("");
    }
}
