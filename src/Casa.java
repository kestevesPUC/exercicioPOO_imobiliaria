/**
 * Para casas, o valor inicial do aluguel é de 0,5% do valor de venda. Para apartamentos, esta alíquota é
 * de 0,4%. Estes valores sofrem modificações dependendo da idade do imóvel: a partir de 5 anos da construção
 * e a cada 5 anos de idade, o aluguel de um apartamento sofre desconto de 5%; já o de uma casa sofre desconto
 * de 10%. Para qualquer tipo de imóvel, o desconto máximo é 30%.
 * Os valores dos aluguéis ainda podem sofrer acréscimos de acordo com benefícios ou serviços
 * disponíveis: se há piscina, área de lazer, área privativa, elevador, entre outros.
 */
public class Casa extends Imovel {    
    protected double fireInsurance;
    /**

    * @param saleValue valor de venda
    * @param address endereço
    * @param fireInsurance valor do seguro contra incêndio
    * @param propertyAddition Se a casa tiver area de lazer será passado o valor como acrescimo
    */
    public Casa(double saleValue, String address, double fireInsurance, double propertyAddition)
    {
        super(saleValue, address);
        this.description = "Casa";
        this.fireInsurance = fireInsurance;
        this.propertyAddition = propertyAddition;
    }
    public double saleValue()
    {
        return this.saleValue;
    }

    public String address()
    {
        return this.address;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setConstructionYear(int year)
    {
        this.year = year;
    } 

    public double calculateRent()
    {
        return ((saleValue() * 0.5/100) - this.calculateDiscount() + (fireInsurance/12) + propertyAddition);
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
                dicount += 10/100;
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
        return (this.calculateRent() - this.realEstateCommission());
    }
}
