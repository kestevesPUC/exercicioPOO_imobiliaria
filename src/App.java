import java.util.ArrayList;

/**
* Para casas, o valor inicial do aluguel é de 0,5% do valor de venda. Para apartamentos, esta alíquota é
* de 0,4%. Estes valores sofrem modificações dependendo da idade do imóvel: a partir de 5 anos da construção
* e a cada 5 anos de idade, o aluguel de um apartamento sofre desconto de 5%; já o de uma casa sofre desconto
* de 10%. Para qualquer tipo de imóvel, o desconto máximo é 30%.
* Os valores dos aluguéis ainda podem sofrer acréscimos de acordo com benefícios ou serviços
* disponíveis: se há piscina, área de lazer, área privativa, elevador, entre outros.
*
* Todo apartamento paga uma taxa mensal, pré-definida, de condomínio. Este valor será cobrado junto
* ao valor do aluguel, porém não é repassado nem ao proprietário nem à imobiliária. Já as casas precisam
* contratar um seguro contra incêndio. O valor anual deste seguro é definido no momento do aluguel, e o
* locatário o paga em 12 parcelas mensais, junto com o aluguel. Este valor também não é repassado nem ao
* locatário, nem à imobiliária
* É necessário responder às questões:
* • Calcular o valor recebido pela imobiliária por um aluguel (12% de comissão)
* • Mostrar o ganho total da administradora com todos os imóveis.
* • Mostrar, para os proprietários dos imóveis, o valor total arrecadado com aluguéis de suas
* propriedades, e os valores líquidos a serem repassados a eles.
* 1) Tendo em vista os paradigmas e boas práticas da programação modular, crie um diagrama de classes que
* resolva adequadamente o problema exposto. Não é necessário indicar construtores e métodos get/set, mas
* fique atento para deixar claros atributos e métodos relevantes para a solução correta do problema.
* 2) Crie as classes modeladas por você na questão (1). Não é necessário haver um aplicativo, porém tenha
* certeza de que suas classes respondem aos requisitos do sistema corretamente.
 */
public class App {
    public static int currentYear = 2023;
    public static ArrayList<Imovel> imoveis = new ArrayList<Imovel>();
    public static void main(String[] args) throws Exception {
        double sum = 0;
        // for (Imovel imovel : imoveis) {
        //     sum += imovel.realEstateCommission();   
        // }
        sum = imoveis.stream()
                .mapToDouble(i -> i.realEstateCommission())
                .sum();
        System.out.println("O total recebido pelas imobiliarias é " + sum);
    }
}
