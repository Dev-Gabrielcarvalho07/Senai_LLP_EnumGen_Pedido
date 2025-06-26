import java.util.ArrayList;
import java.util.Scanner;


public class EnumGen {
   
    static class Item {
        String descricao;
        int quantidade;
        String categoria;


        Item(String descricao, int quantidade, String categoria) {
            this.descricao = descricao;
            this.quantidade = quantidade;
            this.categoria = categoria;
        }


        @Override
        public String toString() {
            return categoria + " " + descricao + " " + quantidade;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Item> pedidos = new ArrayList<>();


   
        while (true) {
           
            System.out.print("Digite a descrição do item (Enter para finalizar): ");
            String descricao = scanner.nextLine().trim();
            if (descricao.isEmpty()) {
                break;
            }


           
            System.out.print("Digite a quantidade do item: ");
            int quantidade;
            try {
                quantidade = Integer.parseInt(scanner.nextLine());
                if (quantidade <= 0) {
                    System.out.println("Erro: A quantidade deve ser maior que zero!");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido para a quantidade!");
                continue;
            }


           
            System.out.println("Selecione a categoria:");
            System.out.println("1. Alimento");
            System.out.println("2. Eletrônico");
            System.out.println("3. Outros");
            System.out.print("Digite o número da categoria: ");
            String categoriaInput = scanner.nextLine();
            String categoria;


           
            switch (categoriaInput) {
                case "1":
                    categoria = "Alimento:";
                    break;
                case "2":
                    categoria = "Eletrônico:";
                    break;
                case "3":
                    categoria = "Outros:";
                    break;
                default:
                    System.out.println("Erro: Categoria inválida! Use 1, 2 ou 3.");
                    continue;
            }


           
            pedidos.add(new Item(descricao, quantidade, categoria));
        }


       
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum item foi registrado!");
        } else {
           
            System.out.println("\nLista de Pedidos:");
            for (Item item : pedidos) {
                System.out.println(item);
            }
            System.out.println("Processamento concluído com sucesso!");
        }


        scanner.close();
    }
}
