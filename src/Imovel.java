/**
 * Estes imóveis estão divididos entre casas e apartamentos. Sobre qualquer imóvel se necessita
 * saber: o valor de venda, o endereço e ano de construção.
 */
public abstract class Imovel {
    
    protected final double MAXIMUM_DISCOUNT = 30/100;
    protected String address;
    protected String description;
    protected double saleValue;
    protected int year;
    protected double propertyAddition;

    public Imovel(double saleValue, String address)
    {
        this.saleValue = saleValue;
        this.address = address;
    }

    /**
     * Retorna o valor de venda do imóvel
     * @return double
     */
    public abstract double saleValue();

    /**
     * Retorna o endereço 
     * @return String
     */
    public abstract String address();

    /**
     * Atribui o valor do ano de construção
     * @return int
     */
    public abstract void setConstructionYear(int year);

    /**
     * Tipo de imóvel
     * @return String
     */
    public abstract String getDescription();

    /**
     * Calcula o valor do aluguel e o retorna
     * @return double
     */
    public abstract double calculateRent();

    /**
     * Calcula a comissão da imobiliaria neste imóvel
     * @return double
     */
    public abstract double realEstateCommission();

    /**
     * Calcula o total recebido pelo proprietário
     * @return
     */
    public abstract double calculateOwnerTotal();


}
