
/**
 * Programa que armazena um registro de tamanho fixo em um arquivo binário.
 *
 * Realiza as operações de inclusão, exclusão, pesquisa, posição e listagem dos registros.
 *
 */
import javax.swing.JOptionPane;

public class Principal {

    public static RegistroCliente leitura(String mensagem) {
        //Mostra a mensagem se ela for diferente de vazio
        if (!mensagem.equals("")) {
            JOptionPane.showMessageDialog(null, mensagem);
        }
        //Instancia o cliente a ser preenchido
        RegistroCliente cliente = new RegistroCliente();
        //Preenche o cliente com os dados lidos
        cliente.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite o Código")));
        cliente.setNome(JOptionPane.showInputDialog("Digite o Nome"));
        cliente.setEndereco(JOptionPane.showInputDialog("Digite o Endereço"));
        cliente.setSalario(Double.parseDouble(JOptionPane.showInputDialog("Digite o Salário")));
        cliente.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Digite o Idade")));
        //Retorna o cliente preenchido
        return cliente;
    }

    public static void main(String Arg[]) {
        //Classe que gerencia o arquivo de cliente
        GerenciadorCliente gerente = new GerenciadorCliente();
        //Recebe a opção do menu
        int opcao = -1;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("\t### Arquivo Binário Sequencial ###\n"
                    + " 1 - Incluir \n "
                    + " 2 - Atualizar \n "
                    + " 3 - Excluir Lógico\n "
                    + " 4 - Excluir Físico\n "
                    + " 5 - Pesquisar Chave\n "
                    + " 6 - Pesquisar Posição\n "
                    + " 7 - Listar Lógico\n "
                    + " 8 - Listar Físico \n "
                    + " 9 - Informações \n "
                    + "10 - Zera Arquivo \n "
                    + "99 - Sair\n"
                    + "Digite uma Opção: "));

            switch (opcao) {
                case 1: {
                    //Chama o método leitura para retornar um cliente instanciado e preenchido
                    RegistroCliente cliente = leitura("");                    
                    if (gerente.inserir(cliente) == true) {
                        JOptionPane.showMessageDialog(null, "Registro inserido com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Registro não foi inserido.");
                    }
                    break;
                }
                case 2: {
                    //Pergunta qual o código a ser atualizado
                    int codigoAtualizar = Integer.parseInt(JOptionPane.showInputDialog(" Digite o código a ser atualizado: "));
                    //Instancia um novo cliente com os novos dados
                    RegistroCliente cliente = leitura("Digite os dados do novo cliente");
                    //Atualiza o arquivo cliente com os dados para o código especificado
                    if (gerente.atualizar(codigoAtualizar, cliente) == true) {
                        JOptionPane.showMessageDialog(null, "Registro " + codigoAtualizar + " atualizado com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Registro " + codigoAtualizar + " não foi atualizado.");
                    }
                    break;
                }
                case 3: {
                    //Pergunta qual o código a ser excluído logicamente
                    int codigoExcluir = Integer.parseInt(JOptionPane.showInputDialog(" Digite o codigo a ser excluído: "));
                    gerente.excluirLogico(codigoExcluir);
                    break;
                }
                case 4: {
                    //Pergunta qual o código a ser excluído fisicamente
                    int codigoExcluir = Integer.parseInt(JOptionPane.showInputDialog(" Digite o codigo a ser excluído: "));
                    gerente.excluirFisico(codigoExcluir);
                    break;
                }
                case 5: {
                    // Pergunta qual a chave do cliente deve ser procurada no arquivo
                    int chave = Integer.parseInt(JOptionPane.showInputDialog(" Digite o código do cliente a ser perquisado: "));
                    // Procura o registro do cliente com a chave no arquivo
                    RegistroCliente cliente = gerente.pesquisar(chave);
                    // Se cliente != null encontrou o registro
                    if (cliente != null) {
                        JOptionPane.showMessageDialog(null, "Achei o cliente \n" + cliente.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Não Achei");
                    }
                    break;
                }
                case 6: {
                    // Pergunta qual a chave do cliente deve ser procurada sua posição no arquivo
                    int chave = Integer.parseInt(JOptionPane.showInputDialog(" Digite o código do cliente a ser procurado a posição: "));
                    // Procura a posição do registro com chave no arquivo
                    int posicao = gerente.posicao(chave);
                    //Se posição é -1 não encontrou
                    if (posicao != -1) {
                        JOptionPane.showMessageDialog(null, "Achei o cliente na posição " + (posicao + 1));
                    } else {
                        JOptionPane.showMessageDialog(null, "Não Achei");
                    }
                    break;
                }
                case 7: {
                    //Lista logicamente os dados do arquivo. Não inclui chave com -1                    
                    String saida = gerente.listarLogico();
                    JOptionPane.showMessageDialog(null, "Lista Lógico:\n" + saida);
                    break;
                }
                case 8: {
                    //Lista fisicamente os dados do arquivo
                    String saida = gerente.listarFisico();
                    JOptionPane.showMessageDialog(null, "Lista Físico:\n" + saida);
                    break;
                }
                case 9: {
                    //Retorna as informações do arquivo
                    String informacoes = gerente.informacoes();
                    JOptionPane.showMessageDialog(null, informacoes);
                    break;
                }
                case 10: {
                    //Esvazia o arquivo de dados
                    if (gerente.zeraArquivo() == true) {
                        JOptionPane.showMessageDialog(null, "Arquivo zerado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Arquivo não foi zerado!");
                    }
                    break;
                }
                case 99: {
                    System.out.println("Saindo do Sistema!");
                    break;
                }
                default: {
                    System.out.println("Opção inválida!");
                    break;
                }
            }
        } while (opcao != 99);
    }
}
