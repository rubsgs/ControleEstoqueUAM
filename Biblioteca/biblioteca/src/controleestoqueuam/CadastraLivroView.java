package controleestoqueuam;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * Rubens Guarnieri, R.A.: 20303016
 * Erik Henrique, R.A.: 20301986
 */
public class CadastraLivroView extends JPanel{
     private JPanel painelPrincipal;
     private JPanel painelCampos;
     private JLabel labelTitulo;
     private JLabel labelCodigo;
     private JLabel labelAutor;
     private JLabel labelCategoria;
     private JLabel labelAnoEdicao;
     private JLabel labelPreco;
     private JLabel labelQtdInicial;
     private JTextField textTitulo;
     private JTextField textCodigo;
     private JTextField textAutor;
     private JTextField textCategoria;
     private JTextField textAnoEdicao;
     private JTextField textPreco;
     private JTextField textQtdInicial;
     private JButton buttonCadastra;
     
     public CadastraLivroView(){
         this.painelPrincipal = new JPanel();
         this.painelPrincipal.setLayout(new BorderLayout());
         this.painelPrincipal.setSize(400,300);
         this.painelCampos = new JPanel();
         GridLayout grid = new GridLayout(8,2);
         grid.setHgap(5);
         this.painelCampos.setLayout(grid);
         this.painelCampos.setSize(400,300);
         this.labelCodigo = new JLabel("Codigo*:");
         this.labelTitulo = new JLabel("Titulo*:");
         this.labelAutor = new JLabel("Autor:");
         this.labelCategoria = new JLabel("Categoria:");
         this.labelAnoEdicao = new JLabel("Ano da Edição:");
         this.labelPreco = new JLabel("Preço*:");
         this.labelQtdInicial = new JLabel("Quantidade Inicial:");
         this.textCodigo = new JTextField(15);
         this.textTitulo = new JTextField(15);
         this.textAutor = new JTextField(15);
         this.textCategoria = new JTextField(15);
         this.textAnoEdicao = new JTextField(15);
         this.textPreco = new JTextField(15);
         this.textQtdInicial = new JTextField(15);
         this.buttonCadastra = new JButton("Cadastrar");
         this.painelCampos.add(this.labelCodigo);
         this.painelCampos.add(this.labelTitulo);
         this.painelCampos.add(this.textCodigo);
         this.painelCampos.add(this.textTitulo);
         this.painelCampos.add(this.labelAutor);
         this.painelCampos.add(this.labelCategoria);
         this.painelCampos.add(this.textAutor);
         this.painelCampos.add(this.textCategoria);
         this.painelCampos.add(this.labelAnoEdicao);
         this.painelCampos.add(this.labelPreco);
         this.painelCampos.add(this.textAnoEdicao);
         this.painelCampos.add(this.textPreco);
         this.painelCampos.add(this.labelQtdInicial);
         this.painelCampos.add(new JLabel(" "));
         this.painelCampos.add(this.textQtdInicial);
         this.painelPrincipal.add(this.painelCampos, BorderLayout.CENTER);
         this.painelPrincipal.add(this.buttonCadastra, BorderLayout.PAGE_END);
         this.add(this.painelPrincipal);
     }

    //Inicio Getters e Setters
    public JTextField getTextTitulo() {
        return textTitulo;
    }

    public JTextField getTextCodigo() {
        return textCodigo;
    }

    public JTextField getTextAutor() {
        return textAutor;
    }

    public JTextField getTextCategoria() {
        return textCategoria;
    }

    public JTextField getTextAnoEdicao() {
        return textAnoEdicao;
    }

    public JTextField getTextPreco() {
        return textPreco;
    }

    public JTextField getTextQtdInicial() {
        return textQtdInicial;
    }
    //Fim Getters e Setters
    
    //Listener do botão de cadastrar.
    public void addActionListener(ActionListener l) {
        buttonCadastra.addActionListener(l);
    }
    
    //Limpa os campos de texto.
    public void limpaCampos(){
        this.textCodigo.setText("");
        this.textTitulo.setText("");
        this.textAutor.setText("");
        this.textCategoria.setText("");
        this.textQtdInicial.setText("");
        this.textPreco.setText("");
        this.textAnoEdicao.setText("");
    }
     
}
