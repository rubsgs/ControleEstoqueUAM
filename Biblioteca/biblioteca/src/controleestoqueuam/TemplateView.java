package controleestoqueuam;

/**
 *
 * Rubens Guarnieri, R.A.: 20303016
 * Erik Henrique, R.A.: 20301986
 */
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TemplateView extends JFrame {
    
    private JMenuBar menuBar;
    private JMenu cadastros;
    private JMenu relatorios;
    private JMenu pedidos;
    private JMenuItem sair;
    private JMenuItem adicionaLivro;
    private JMenuItem atualizaQtd;
    private JMenuItem fecharConta;
    private JMenuItem cadastraProduto;
    private JMenuItem relatorioEstoque;
    private JMenuItem relatorioEstoqueMin;
    private JPanel janelaPrincipal;
    
    
    public TemplateView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.menuBar = new JMenuBar();
        this.cadastros = new JMenu("Cadastros");
        this.relatorios = new JMenu("Relatórios");
        this.pedidos = new JMenu("Pedidos");
        this.sair = new JMenuItem("Sair");
        this.cadastraProduto = new JMenuItem("Inserir");
        this.atualizaQtd = new JMenuItem("Atualiza Quantidade");
        this.relatorioEstoque = new JMenuItem("Relatório estoque");
        this.relatorioEstoqueMin = new JMenuItem("Relatório estoque min.");
        this.adicionaLivro = new JMenuItem("Adicionar Livros no pedido");
        this.fecharConta = new JMenuItem("Fechar conta");
        cadastros.add(cadastraProduto);
        cadastros.add(atualizaQtd);
        relatorios.add(this.relatorioEstoque);
        relatorios.add(this.relatorioEstoqueMin);
        pedidos.add(this.adicionaLivro);
        pedidos.add(this.fecharConta);
        menuBar.add(cadastros);
        menuBar.add(relatorios);
        menuBar.add(pedidos);
        menuBar.add(sair);
        this.setJMenuBar(menuBar);
        this.janelaPrincipal = new JPanel();
        this.janelaPrincipal.setSize(500, 320);
        this.janelaPrincipal.setLayout(new BorderLayout());
        this.setContentPane(this.janelaPrincipal);
        this.setResizable(false);
        this.setMinimumSize(new Dimension(500,320));
    }
    
    //Altera o painel exibido na janela principal.
    public void addJanelaPrincipal(JPanel janela) {
        this.janelaPrincipal.removeAll();
        this.janelaPrincipal.add(janela,BorderLayout.CENTER);
        this.setContentPane(janelaPrincipal);
    }

    //Inicio adiciona listener nos botões do JMenu
    public void cadastroAddActionListener(ActionListener l) {
        cadastraProduto.addActionListener(l);
    }
    public void relatorioEstoqueAddActionListener(ActionListener l) {
        relatorioEstoque.addActionListener(l);
    }
    public void relatorioEstoqueMinimoAddActionListener(ActionListener l) {
        relatorioEstoqueMin.addActionListener(l);
    }

    public void adicionaItemAddActionListener(ActionListener l) {
        adicionaLivro.addActionListener(l);
    }

    public void fecharContaAddActionListener(ActionListener l) {
        fecharConta.addActionListener(l);
    }
    
    public void atualizaQtdAddActionListener(ActionListener l) {
        atualizaQtd.addActionListener(l);
    }
    
    public void sairAddActionListener(ActionListener l) {
        sair.addActionListener(l);
    }
    //Fim dos listeners no JMenu.
    
}

