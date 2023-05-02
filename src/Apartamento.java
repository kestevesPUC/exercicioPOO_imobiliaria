/**
 * Os valores dos aluguéis ainda podem sofrer acréscimos de acordo com benefícios ou serviços
 * disponíveis: se há piscina, área de lazer, área privativa, elevador, entre outros.
 * Todo apartamento paga uma taxa mensal, pré-definida, de condomínio. Este valor será cobrado junto
 * ao valor do aluguel, porém não é repassado nem ao proprietário nem à imobiliária. Já as casas precisam
 * contratar um seguro contra incêndio. O valor anual deste seguro é definido no momento do aluguel, e o
 * locatário o paga em 12 parcelas mensais, junto com o aluguel. Este valor também não é repassado nem ao
 * locatário, nem à imobiliária
 */
public class Apartamento extends Imovel{
    protected double condominium;
    /**
     * @param saleValue valor de venda
     * @param address endereço
     * @param condominium valor do condomínio
     * @param propertyAddition Se o Apartamento tiver area de lazer será passado o valor como acrescimo
     */
    public Apartamento(double saleValue, String address, double condominium, double propertyAddition)
    {
        super(saleValue, address);
        this.description = "Apartamento";
        this.condominium = condominium;
        this.propertyAddition = propertyAddition;
    }
    public double saleValue()
    {
        return this.saleValue;
    }

    public String address()
    {
        return address;
    }

    public void setConstructionYear(int year)
    {
        this.year = year;
    }    

    public String description()
    {
        return this.description;
    }

    public double calculateRent()
    {
        return (saleValue() * 0.4/100 - this.calculateDiscount() + this.condominium + propertyAddition);
    }

    public String getDescription()
    {
        return this.description;
    }

    /**
     * Calcula o desconto por idade no aluguel
     * @return
     */
    private double calculateDiscount()
    {
        return (App.currentYear -  this.year > 5 ? this.calculateDiscountPercentage() : 0);
    }

    private double calculateDiscountPercentage()
    {
        double dicount = 0;
        int discountYears = App.currentYear-this.year/5;
        for (int i=0; i<=discountYears; i++)
        {
            if(MAXIMUM_DISCOUNT <= dicount){
                dicount += 5/100;
            }
        }
        return dicount;
    }

    public double realEstateCommission()
    {
        return (calculateRent() * 12/100);
    }

    public double calculateOwnerTotal()
    {
        return (this.calculateRent() - (this.realEstateCommission() + this.condominium));
    }
}
