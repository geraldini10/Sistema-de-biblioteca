import javax.sql.rowset.serial.SQLOutputImpl;
import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] livros = {
                "Dom Casmurro",
                "O Pequeno Principe",
                "1984",
                "Harry Potter",
                "O Senhor dos Aneis",
                "A Revolucao dos Bichos",
                "Cem Anos de Solidao",
                "O Codigo Da Vinci",
                "Orgulho e Preconceito",
                "Crime e Castigo"
        };

        int[] estoqueTotal = {1,1,1,1,1,1,1,1,1,1};
        int[] estoqueDisponivel = {1,1,1,1,1,1,1,1,1,1};

        String loginBiblio = "bibliotecario";
        String senhaBiblio = "biblio123";
        String loginUser = "visitante";
        String senhaUser = "visita123";

        boolean bibliotecarioLogado = false;
        boolean usuarioLogado  = false;

        int opcao = 0;

        do{
            System.out.println("\n====================");
            System.out.println("Sistema de biblioteca");
            System.out.println("\n====================");

            if(!usuarioLogado){
                System.out.println("1 - Logar");
            }else{
                if(bibliotecarioLogado == true){
                    System.out.println("2 - Cadastrar Livro");
                }
                System.out.println("3 - Exibir livros");
                System.out.println("4 - Emprestar livro");
                System.out.println("Devolver livro");
                System.out.println("6 - Logout");
            }

            System.out.println("99 - Sair");
            System.out.println("Digite a sua opção: ");
            if(!scanner.hasNextInt()){
                scanner.nextLine();
                System.out.println("\nEntrada inválida. Digite apenas números.");
                continue;
            }
            opcao = scanner.nextInt();
            scanner.nextLine();

            //login
            if(opcao == 1){
                System.out.println("===== LOGIN =====");
                System.out.println("Insira seu login: ");
                String login = scanner.nextLine();
                System.out.println("Insira sua senha: ");
                String senha = scanner.nextLine();

                if(login.equals(loginBiblio) && senha.equals(senhaBiblio)){
                    System.out.println("\nSucesso! Você logou como um Bibliotecario!");
                    bibliotecarioLogado = true;
                    usuarioLogado = true;
                }else if(login.equals(loginUser) && senha.equals(senhaUser)){
                    System.out.println("\nSucesso! Você logou como visitante!");
                    bibliotecarioLogado = false;
                    usuarioLogado = true;
                }else{
                    System.out.println("\nFalha no login! Usuario ou senha incorretos");
                }
                //Cadastrar livros
            }else if(opcao == 2){
                if(bibliotecarioLogado){
                    System.out.println("\n===== LISTA DE LIVROS CADASTRADOS =====");
                    for(int i = 0; i < 10; i++){
                        System.out.println((i + 1) + " - " + livros[i]);
                    }
                    System.out.println("Insira o espaço que deseja cadastrar: ");
                    if(!scanner.hasNextInt()){
                        scanner.nextLine();
                        System.out.println("\nEntrada inválida. Digite apenas números.");
                        continue;
                    }
                    int espacoLivro = scanner.nextInt();
                    scanner.nextLine();

                    if(espacoLivro >= 1 && espacoLivro <= 10){
                        if(estoqueDisponivel[espacoLivro - 1] == estoqueTotal[espacoLivro - 1]){
                            System.out.println("Informe o nome do livro: ");
                            livros[espacoLivro - 1] = scanner.nextLine();
                            estoqueTotal[espacoLivro - 1] = 1;
                            estoqueDisponivel[espacoLivro - 1] = 1;
                            System.out.println("\nLivro cadastrado com sucesso!");
                        }else{
                            System.out.println("\nNão é possível trocar um livro que está emprestado.");
                        }
                    }else{
                        System.out.println("Posição inválida.");
                    }
                }else{
                    System.out.println("\nApenas bibliotecarios podem usar essa função.");
                }
                //Exibir livros
            }else if(opcao == 3){
                if(usuarioLogado){
                    System.out.println("\n===== LISTA DE LIVROS =====");
                    for(int i = 0; i < 10; i++){
                        System.out.println((i + 1) + " - " + livros[i] + ". Estoque disponivel: " + estoqueDisponivel[i]);
                    }
                }else{
                    System.out.println("\nVocê precisa estar logado para exibir livros");
                }
                //emprestar livros
            }else if(opcao == 4){
                if(usuarioLogado){
                    System.out.println("===== LISTA DE LIVROS =====");
                    for(int i = 0; i < 10; i++){
                        System.out.println((i + 1) + " - " + livros[i] + ". Estoque disponivel: " + estoqueDisponivel[i]);
                    }
                    System.out.println("\nInsira o espaço do livro que deseja emprestar: ");
                    if(!scanner.hasNextInt()){
                        scanner.nextLine();
                        System.out.println("\nEntrada inválida. Digite apenas números.");
                        continue;
                    }
                    int espacoLivro = scanner.nextInt();
                    scanner.nextLine();

                    if(espacoLivro >= 1 && espacoLivro <= 10){
                        if(estoqueDisponivel[espacoLivro - 1] > 0){
                            estoqueDisponivel[espacoLivro - 1]--;
                            System.out.println("\nAproveite! Você emprestou o: " + livros[espacoLivro - 1]);
                        }else{
                            System.out.println("Estamos sem estoque desse livro.");
                        }
                    }else{
                        System.out.println("\nPosição inválida.");
                    }
                }else{
                    System.out.println("\nVocê precisa estar logado para emprestar livros.");
                }
                // Devolver livro
            }else if(opcao == 5){
                if(usuarioLogado){
                    System.out.println("\n===== LISTA DE LIVROS =====");
                    for(int i = 0; i < 10; i++){
                        System.out.println((i + 1) + " - " + livros[i] + ". Estoque disponivel: " + estoqueDisponivel[i]);
                    }
                    System.out.println("\nInsira o espaço do livro que deseja devolver: ");
                    if(!scanner.hasNextInt()){
                        scanner.nextLine();
                        System.out.println("\nEntrada inválida. Digite apenas números.");
                        continue;
                    }
                    int espacoLivro = scanner.nextInt();
                    scanner.nextLine();

                    if(espacoLivro >= 1 && espacoLivro <= 10){
                        if(estoqueDisponivel[espacoLivro - 1] < estoqueTotal[espacoLivro - 1]){
                            estoqueDisponivel[espacoLivro - 1]++;
                            System.out.println("\nObrigado! Você devolveu o: " + livros[espacoLivro - 1]);
                        }else{
                            System.out.println("\nEsse livro não foi emprestado.");
                        }
                    }else{
                        System.out.println("\nPosição inválida.");
                    }
                }else{
                    System.out.println("\nVocê precisar estar logado para devolver livros.");
                }

                // Logout
            }else if(opcao == 6){
                if(usuarioLogado){
                    usuarioLogado = false;
                    bibliotecarioLogado = false;
                    System.out.println("\nLogout realizado com sucesso.");
                }else{
                    System.out.println("\nNenhum usuario está logado.");
                }
            }else if(opcao != 99){
                System.out.println("\nOpção inválida.");
            }

        }while(opcao != 99);
        System.out.println("\nSistema encerrado.");
        scanner.close();
    }
};
