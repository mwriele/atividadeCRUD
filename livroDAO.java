package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProdutoDAO {
    private List<Produto> produtos = new ArrayList<>();
    private int currentId = 1;
    private Scanner scanner = new Scanner(System.in);

    // Create
    public void addProduto() {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();
        System.out.print("Digite a quantidade do produto: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); 

        Produto produto = new Produto(currentId++, nome, quantidade, preco);

        produtos.add(produto);
        System.out.println("Produto adicionado: " + produto);
    }

    // Read
    public void listAllProdutos() {
        System.out.println("Todos os produtos:");
        for (Produto p : produtos) {
            System.out.println(p);
        }
    }

    public Produto getProdutoById(int id) {
        return produtos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    // Update
    public void updateProduto() {
        System.out.print("Digite o ID do produto a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        Produto produto = getProdutoById(id);
        if (produto != null) {
            System.out.print("Digite o novo nome do produto: ");
            String nome = scanner.nextLine();
            System.out.print("Digite o novo preço do produto: ");
            double preco = scanner.nextDouble();
            System.out.print("Digite a nova quantidade do produto: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); 

            produto.setNome(nome);
            produto.setPreco(preco);
            produto.setQuantidade(quantidade);
            System.out.println("Produto atualizado: " + produto);
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }

    // Delete
    public void deleteProduto() {
        System.out.print("Digite o ID do produto a ser deletado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        Produto produto = getProdutoById(id);
        if (produto != null) {
            produtos.remove(produto);
            System.out.println("Produto deletado.");
        } else {
            System.out.println("Produto com ID " + id + " não encontrado.");
        }
    }

    // Menu de Operações
    public void menuOperacoes() {
        while (true) {
            System.out.println("Escolha uma operação: 1 - Adicionar, 2 - Listar, 3 - Atualizar, 4 - Deletar, 5 - Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    addProduto();
                    break;
                case 2:
                    listAllProdutos();
                    break;
                case 3:
                    updateProduto();
                    break;
                case 4:
                    deleteProduto();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
