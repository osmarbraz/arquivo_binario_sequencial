
/**
 * Classe base de cliente.
 */
public class Cliente {

    private int codigo;
    private String nome;
    private String endereco;
    private double salario;
    private int idade;

    /**
     * Construtor sem parâmetro.
     */
    public Cliente() {
        this(0, "", "", 0.0, 0);
    }

    /**
     * Construtor com parâmetros.
     *
     * @param codigo Código de um cliente.
     * @param nome Nome de um cliente.
     * @param endereco Endereço de um cliente.
     * @param salario Salário de um cliente.
     * @param idade Idade de um cliente
     * @param proximo Próximo registro de cliente.
     */
    public Cliente(int codigo, String nome, String endereco, double salario, int idade) {
        setCodigo(codigo);
        setNome(nome);
        setEndereco(endereco);
        setSalario(salario);
        setIdade(idade);
    }

    // Get´s e Set´s
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public double getSalario() {
        return salario;
    }

    public int getIdade() {
        return idade;
    }

    /**
     * Retorna os dados de cliente em uma String.
     *
     * @return Uma String com os dados.
     */
    @Override
    public String toString() {
        return ("Código: " + getCodigo() + " \\ Nome: " + getNome() + "\\ Endereço: " + getEndereco() + " \\ Salário: " + getSalario() + " \\ Idade : " + getIdade());
    }
}
