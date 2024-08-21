package Controller;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> livros = new ArrayList<>();

        String user = "Uelisson321";
        String senha = "Uelzim123";
        int opcao, logado;
        boolean loggedIn = false;

        do {
            System.out.println("Menu:");
            System.out.println("1. Login");
            System.out.println("2. Listar Conteúdos");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome de usuário: ");
                    String inputUser = scanner.nextLine();
                    System.out.print("Digite a senha: ");
                    String inputSenha = scanner.nextLine();

                    if (inputUser.equals(user) && inputSenha.equals(senha)) {
                        System.out.println("Login bem-sucedido!");
                        loggedIn = true;

                        do {
                            System.out.println("Menu:");
                            System.out.println("1. Criar Conteúdo");
                            System.out.println("2. Listar Conteúdos");
                            System.out.println("3. Sair");
                            System.out.println("4. Excluir Conteúdo");
                            System.out.println("5. Atualizar Conteúdo");
                            logado = scanner.nextInt();
                            scanner.nextLine(); 
                           
                            switch (logado) {
                                case 1:
                                    System.out.print("Digite o nome do livro: ");
                                    String inputLivro = scanner.nextLine();
                                    livros.add(inputLivro);  
                                    System.out.println("Livro adicionado com sucesso!");
                                    break;
                                    
                                case 2:
                                    System.out.println("Lista de Livros:");
                                    for (int i = 0; i < livros.size(); i++) {
                                        System.out.println((i + 1) + ". " + livros.get(i));
                                    }
                                    break;
                                    
                                case 5:
                                    if (livros.isEmpty()) {
                                        System.out.println("Nenhum livro para atualizar.");
                                    } else {
                                        System.out.println("Digite o número do livro que deseja atualizar:");
                                        for (int i = 0; i < livros.size(); i++) {
                                            System.out.println((i + 1) + ". " + livros.get(i));
                                        }
                                        int indiceAtualizar = scanner.nextInt();
                                        scanner.nextLine();  

                                        if (indiceAtualizar > 0 && indiceAtualizar <= livros.size()) {
                                            System.out.print("Digite o novo nome do livro: ");
                                            String novoNome = scanner.nextLine();
                                            livros.set(indiceAtualizar - 1, novoNome); 
                                            System.out.println("Livro atualizado com sucesso!");
                                        } else {
                                            System.out.println("Índice inválido.");
                                        }
                                    }
                                    break;
                                    
                                case 4:
                                    if (livros.isEmpty()) {
                                        System.out.println("Nenhum livro para remover.");
                                    } else {
                                        System.out.println("Digite o número do livro que deseja remover:");
                                        for (int i = 0; i < livros.size(); i++) {
                                            System.out.println((i + 1) + ". " + livros.get(i));
                                        }
                                        int indiceRemover = scanner.nextInt();
                                        scanner.nextLine();  

                                        if (indiceRemover > 0 && indiceRemover <= livros.size()) {
                                            livros.remove(indiceRemover - 1);  
                                            System.out.println("Livro removido com sucesso!");
                                        } else {
                                            System.out.println("Índice inválido.");
                                        }
                                    }
                                    break;

                                case 3:
                                    System.out.println("Saindo...");
                                    loggedIn = false;
                                    break;

                                default:
                                    System.out.println("Opção inválida. Tente novamente.");
                            } 
                        } while (logado != 3);
                        
                    } else {
                        System.out.println("Usuário ou senha incorretos.");
                    }
                    break;

                case 2:
                    if (loggedIn) {
                        System.out.println("Lista de Livros:");
                        for (int i = 0; i < livros.size(); i++) {
                            System.out.println((i + 1) + ". " + livros.get(i));
                        }
                    } else {
                        System.out.println("Você deve estar logado para listar conteúdos.");
                    }
                    break;

                case 3:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);

        scanner.close();
    }
}

