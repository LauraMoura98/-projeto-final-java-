import java.util.Scanner;
import com.projeto.dao.ProjetoFinalDAO;
import com.projeto.classes.Garcom;
public class Main {



    public static void main(String[] args) throws Exception {
        int id_garcom;
        String nome,cpf,email,telefone;
        String dataNascimento;
        String sexo;
        float salarioFixo;
        int opcao,continua;
        continua = 1;
        Scanner ler = new Scanner(System.in);

        while(continua == 1) {
            System.out.println("SOFTWARE DE GERENCIAMENTO\n\nSELECIONE UMA OPÇÃO: \n\n1.CADASTRAR GARÇOM\n2.BUSCAR GARÇOM\n3.REMOVER GARÇOM\n4.ALTERAR DADOS DO GARÇOM\n5.OPÇÕES ADICIONAIS\n6.CRÉDITOS DO APLICATIVO");
            opcao = ler.nextInt();
            ler.nextLine();
            switch(opcao) {
                case 1:

                    System.out.println("REGISTRO DE GARÇONS");
                    System.out.println("\nCódigo do Garçom: ");
                    id_garcom = ler.nextInt();
                    ler.nextLine();
                    System.out.println("\nNome: ");
                    nome = ler.nextLine();
                    System.out.println("\nCPF: ");
                    cpf = ler.nextLine();
                    System.out.println("\nData de Nascimento: ");
                    dataNascimento = ler.nextLine();
                    System.out.println("\nE-mail: ");
                    email = ler.nextLine();
                    System.out.println("\nTelefone: ");
                    telefone = ler.nextLine();
                    System.out.println("\nSexo (F ou M): ");
                    sexo = ler.nextLine().toUpperCase();
                    System.out.println("\nSalário Fixo: ");
                    salarioFixo = ler.nextFloat();

                    Garcom d = new Garcom(id_garcom,nome,cpf,dataNascimento,email,telefone,sexo,salarioFixo);
                    ProjetoFinalDAO.inserirGarcom(d);

                    break;

                case 2:
                    System.out.println("BUSCA DE GARÇOM:");
                    System.out.println("Digite o Email do Garçom: ");
                    String emailBusca = ler.next();
                    Garcom gnome = ProjetoFinalDAO.buscarGarcom(emailBusca);


                    if(gnome == null) {
                        System.out.println("Garçom não encontrado! Verifique os dados e tente novamente.");
                    } else {
                        System.out.println("DADOS DO GARÇOM:");
                        System.out.println("NOME: " + gnome.getNome());
                        System.out.println("CPF: " + gnome.getCpf());
                        System.out.println("DATA DE NASCIMENTO: " + gnome.getDataNascimento());
                        System.out.println("EMAIL: " + gnome.getEmail());
                        System.out.println("TELEFONE: " + gnome.getTelefone());
                        System.out.println("SEXO: " + gnome.getSexo());
                        System.out.println("SALÁRIO: " + gnome.getSalarioFixo());
                    }
                    break;

                case 3:
                    System.out.println("REMOÇÃO DE GARÇOM:");
                    System.out.println("Digite o Email do garçom que deseja remover: ");
                    String emailRemov = ler.nextLine();

                    ProjetoFinalDAO.deletarGarcom(emailRemov);
                    System.out.println("Garçom removido com sucesso!");
                    break;

                case 4:
                    System.out.println("Digite o ID do Garçom que deseja alterar os dados: ");
                    id_garcom = ler.nextInt();
                    ler.nextLine();
                    System.out.println("\nALTERAR GARÇOM");
                    System.out.println("\nNome: ");
                    nome = ler.nextLine();
                    System.out.println("\nCPF: ");
                    cpf = ler.nextLine();
                    System.out.println("\nData de Nascimento: ");
                    dataNascimento = ler.nextLine();
                    System.out.println("\nE-mail: ");
                    email = ler.nextLine();
                    System.out.println("\nTelefone: ");
                    telefone = ler.nextLine();
                    System.out.println("\nSexo (F ou M): ");
                    sexo = ler.nextLine().toUpperCase();
                    System.out.println("\nSalário Fixo: ");
                    salarioFixo = ler.nextFloat();

                    Garcom e = new Garcom(id_garcom,nome,cpf,dataNascimento,email,telefone,sexo,salarioFixo);

                    ProjetoFinalDAO.alterarGarcom(e);
                    break;
                case 5:
                    System.out.println("OPÇÕES ADICIONAIS:");
                    System.out.println("1.MÉDIA DOS SALÁRIOS ");
                    int salarioM = ler.nextInt();

                    if(salarioM == 1) {
                        String name = "MEDIA";
                        ProjetoFinalDAO.MediaSalario();
                    }
                    break;
                case 6:
                    System.out.println("Projeto Realizado por: LAURA MOURA SILVA (RA:972311036) E MIGUEL ALGUSTO DA SILVA COSTA (RA:972310324)");
                    break;
                default:
                    System.out.println("Digite uma opção válida! ");
            }

            System.out.println("\nDESEJA CONTINUAR NO APLICATIVO?\n1.SIM\n2.NÃO ");
            continua = ler.nextInt();
        }
    }
}
