
import java.io.IOException;
import java.io.RandomAccessFile;

public class RegistroCliente extends Cliente {

    /**
     * Construtor sem parâmetros.
     */
    public RegistroCliente() {
        super();
    }

    /**
     * Construtor com parâmetros
     *
     * @param codigo Código de um cliente
     * @param nome Nome de um cliente
     * @param endereco Endereço de um cliente
     * @param salario Salário de um cliente
     * @param idade Idade de um cliente
     */
    public RegistroCliente(int codigo, String nome, String endereco, double salario, int idade) {
        super(codigo, nome, endereco, salario, idade);
    }

    /**
     * Realiza a leitura dos dados do arquivo especificado.
     *
     * Preenche os atributos de cliente utilizado o arquivo especificado.
     *
     * @param arquivo Referência ao arquivo com os dados do cliente.
     * @throws IOException
     */
    public void leitura(RandomAccessFile arquivo) throws IOException {
        setCodigo(arquivo.readInt());
        //Retira os espaços da leitura da String com método trim
        setNome(montaPalavra(arquivo, 30).trim());
        //Retira os espaços da leitura da String com o método trim
        setEndereco(montaPalavra(arquivo, 15).trim());
        setSalario(arquivo.readDouble());
        setIdade(arquivo.readInt());
    }

    /**
     * Lê do arquivo caracter a caracter e monta uma string.
     *
     * @param arquivo Referência ao arquivo com os caracteres a serem lidos.
     * @return
     * @throws IOException
     */
    private String montaPalavra(RandomAccessFile arquivo, int tamanho) throws IOException {
        //Vetor de char da palavra a ser montada
        char palavra[] = new char[tamanho];
        char temp;
        // Recupera do arquivo 15 caracteres
        for (int i = 0; i < palavra.length; i++) {
            temp = arquivo.readChar();
            palavra[i] = temp;
        }
        return new String(palavra).replace('\0', ' ');
    }

    public void escrita(RandomAccessFile arquivo) throws IOException {
        arquivo.writeInt(getCodigo());
        // Escreve 15 caracteres do nome no arquivo
        escrevePalavra(arquivo, getNome(), 30);
        // Escreve 15 caracteres do endereço no arquivo
        escrevePalavra(arquivo, getEndereco(), 15);
        arquivo.writeDouble(getSalario());
        arquivo.writeInt(getIdade());
    }

    // Escreve a palavra no arquivo atrav�s de um Buffer de String
    private void escrevePalavra(RandomAccessFile arquivo, String palavra, int tamanho) throws IOException {
        StringBuffer buf = null;
        if (palavra != null) {
            buf = new StringBuffer(palavra);
        } else {
            buf = new StringBuffer(tamanho);
        }

        // Tamanho da String a ser gravada
        buf.setLength(tamanho);
        arquivo.writeChars(buf.toString());
    }

    /**
     * Retorna o getTamanhoRegistro do registro de cliente.
     *
     * @return Um inteiro com o getTamanhoRegistro do registro do cliente.
     */
    public int getTamanhoRegistro() {
        // 4 código + 30 nome + 15 endereco + 8 salario + 4 idade
        // código int = 4 bytes
        // nome String = 30 caracteres = 1 caracter ocupada 2 bytes = 60 bytes
        // endereço String = 20 caracteres = 1 caracter ocupada 2 bytes = 30 bytes        
        // salario double = 8 bytes
        // idade int = 4 bytes
        //Total 106 bytes
        return (4 + (2 * 30) + (2 * 15) + 8 + 4);
    }
}
