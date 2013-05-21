package controleestoqueuam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jxl.write.WriteException;

/**
 *
 * Rubens Guarnieri, R.A.: 20303016
 * Erik Henrique, R.A.: 20301986
 */
public class AppLivrariaController {

    private CadastraLivroView viewCadastro;
    private AtualizaQuantidadeView viewAtualizaQtd;
    private EfetuaPedidoView viewPedido;
    private FecharContaView viewConta;
    private RelatorioView viewRelatorioEstoque;
    private RelatorioView viewRelatorioEstoqueMinimo;
    private RelatorioView viewRelatorioFecharConta;
    private TemplateView viewPrincipal;
    private ControlaEstoqueModel controlaEstoque;
    private LivroModel livro;
    private PedidoModel pedido;

    public AppLivrariaController() {
        this.controlaEstoque = new ControlaEstoqueModel();
        this.pedido = new PedidoModel();
        viewPrincipal = new TemplateView();
        viewCadastro = new CadastraLivroView();
        viewCadastro.addActionListener(new EventoCadastrarLivro());
        viewAtualizaQtd = new AtualizaQuantidadeView();
        viewAtualizaQtd.addActionListener(new EventoAtualizaQuantidade());
        viewRelatorioEstoque = new RelatorioView();
        viewRelatorioEstoque.addActionListener(new EventoGeraRelatorioEstq());
        viewRelatorioEstoqueMinimo = new RelatorioView();
        viewRelatorioEstoqueMinimo.addActionListener(new EventoGeraRelatorioEstqMinimo());
        viewRelatorioEstoque.adicionaTitulo("Relatorio Estoque");
        viewRelatorioEstoqueMinimo.adicionaTitulo("Relatorio Estoque Minimo");
        viewConta = new FecharContaView();
        viewConta.addActionListenerRelatorio(new EventoGerarFechamento());
        viewConta.addActionListenerFecharConta(new EventoFechaConta());
        viewPedido = new EfetuaPedidoView();
        viewPedido.addActionListener(new EventoAdicionaItemPedido());
        viewPrincipal.salvarAddActionListener(new EventoSalvarLivros());
        viewPrincipal.cadastroAddActionListener(new EventoCadastrarMenu());
        viewPrincipal.relatorioEstoqueAddActionListener(new EventoRelatorioMenu());
        viewPrincipal.relatorioEstoqueMinimoAddActionListener(new EventoRelatorioEstoqueMinimoMenu());
        viewPrincipal.adicionaItemAddActionListener(new EventoAdicionarItemMenu());
        viewPrincipal.fecharContaAddActionListener(new EventoFecharContaMenu());
        viewPrincipal.atualizaQtdAddActionListener(new EventoAtualizaQtdMenu());
        viewPrincipal.sairAddActionListener(new EventoSairMenu());
        viewPrincipal.setVisible(true);
    }

    //Inicio das classes de eventos.
    
    /*
     * Eventos da janela principal, cada evento serve para alterar o painel
     * exibido no JFrame.
     */
    public class EventoSalvarLivros implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                controlaEstoque.salvaPlanilha();
            } catch (IOException ex) {
                Logger.getLogger(AppLivrariaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (WriteException ex) {
                Logger.getLogger(AppLivrariaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public class EventoCadastrarMenu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            viewPrincipal.addJanelaPrincipal(viewCadastro);
        }
    }

    public class EventoAtualizaQtdMenu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            viewPrincipal.addJanelaPrincipal(viewAtualizaQtd);
        }
    }

    public class EventoRelatorioMenu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            viewPrincipal.addJanelaPrincipal(viewRelatorioEstoque);
        }
    }

    public class EventoRelatorioEstoqueMinimoMenu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            viewPrincipal.addJanelaPrincipal(viewRelatorioEstoqueMinimo);
        }
    }

    public class EventoAdicionarItemMenu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            viewPrincipal.addJanelaPrincipal(viewPedido);
        }
    }

    public class EventoFecharContaMenu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            viewPrincipal.addJanelaPrincipal(viewConta);
        }
    }
    
    public class EventoSairMenu implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    
    //Fim dos eventos do menu.

    //Eventos de click dos botões.
    public class EventoCadastrarLivro implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            instanciaLivro();
        }
    }

    public class EventoAtualizaQuantidade implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String cod = viewAtualizaQtd.getTextCodigo();
            String qtd = viewAtualizaQtd.getTextQuantidade();
            if (qtd.equals("") || cod.equals("")) {
                JOptionPane.showMessageDialog(null,"Preencha todos os campos");
            } else {
                controlaEstoque.atualizaQuantidade(Integer.parseInt(cod),Integer.parseInt(qtd));
                viewAtualizaQtd.limpaCampos();
            }
        }
    }

    public class EventoGeraRelatorioEstq implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            viewRelatorioEstoque.setTextRelatorio(controlaEstoque.geraRelatorio());
        }
    }

    public class EventoGeraRelatorioEstqMinimo implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            viewRelatorioEstoqueMinimo.setTextRelatorio(controlaEstoque.relatorioEstoqueMin());
        }
    }

    public class EventoAdicionaItemPedido implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String stCodigo = viewPedido.getTextCodigo().getText();
            String stQuantidade = viewPedido.getTextQuantidade().getText();
            if (stCodigo.equals("") || stQuantidade.equals("")) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            } else {
                int cod = Integer.parseInt(stCodigo);
                int qtd = Integer.parseInt(stQuantidade);
                if (controlaEstoque.verificaLivro(cod)) {
                    if (pedido.adicionaLivro(controlaEstoque.buscaLivro(cod), qtd)) {
                        controlaEstoque.baixaPedido(controlaEstoque.buscaLivro(cod), qtd);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Código inválido!");
                }
            }
            viewPedido.limpaCampos();
        }
    }

    public class EventoFechaConta implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (pedido.getLivros().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não existe nenhum pedido");
            } else {
                pedido = new PedidoModel();
                JOptionPane.showMessageDialog(null, "Conta fechada com sucesso");
            }
        }
    }

    public class EventoGerarFechamento implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            viewConta.setTextRelatorio(pedido.fecharConta());
        }
    }    
    //Fim dos eventos.

    //Método para instanciar o livro que será adicionado no estoque.
    public void instanciaLivro() {
        String codigo = viewCadastro.getTextCodigo().getText();
        String titulo = viewCadastro.getTextTitulo().getText();
        String autor = viewCadastro.getTextAutor().getText();
        String categoria = viewCadastro.getTextCategoria().getText();
        String anoEdicao = viewCadastro.getTextAnoEdicao().getText();
        String preco = viewCadastro.getTextPreco().getText();
        preco = preco.replaceAll(",", ".");
        String qtdEstoque = viewCadastro.getTextQtdInicial().getText();

        if ((!(codigo.equals(""))) && (!(titulo.equals("")) && (!(preco.equals(""))))) {
            if (controlaEstoque.verificaLivro(Integer.parseInt(codigo))) {
                JOptionPane.showMessageDialog(null, "Livro ja existente!");
            } else {
                int qtdInicial;
                int ano;
                
                if (qtdEstoque.equals("")) {
                    qtdInicial = 0;
                } else {
                    qtdInicial = Integer.parseInt(qtdEstoque);
                }
                if (anoEdicao.equals("")) {
                    ano = 0;
                } else {
                    ano = Integer.parseInt(qtdEstoque);
                }
                livro = new LivroModel(Integer.parseInt(codigo), titulo, autor,
                        categoria, ano,
                        Double.parseDouble(preco), qtdInicial);
                controlaEstoque.cadastraLivro(livro);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
        }
        viewCadastro.limpaCampos();
    }
}
