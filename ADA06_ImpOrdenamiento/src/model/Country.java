package model;

/**
 * Crea instancias de tipo {@code Country} para
 * representar cada una de las filas del dataset.
 * 
 * @version 31/03/2023
 * @author Ruben Alvarado
 * @author Monica Garcilazo
 */
public class Country {
    private Integer serialNumber;
    private String countryName;
    private Double totalCases;
    private Double totalDeaths;
    private Double totalRecovered;
    private Double activeCases;
    private Double totalTest;
    private Double population;

    /**
     * Constructor para generar las instancias con sus atributos
     * Cada atributo corresponde a una columna del dataset
     */
    public Country(Integer serialNumber, String country, Double totalCases, Double totalDeaths, Double totalRecovered,
            Double activeCases, Double totalTest, Double population) {
        this.serialNumber = serialNumber;
        this.countryName = country;
        this.totalCases = totalCases;
        this.totalDeaths = totalDeaths;
        this.totalRecovered = totalRecovered;
        this.activeCases = activeCases;
        this.totalTest = totalTest;
        this.population = population;
    }

 
    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String country) {
        this.countryName = country;
    }

    public Double getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(Double totalCases) {
        this.totalCases = totalCases;
    }

    public Double getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(Double totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public Double getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(Double totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public Double getActiveCases() {
        return activeCases;
    }

    public void setActiveCases(Double activeCases) {
        this.activeCases = activeCases;
    }

    public Double getTotalTest() {
        return totalTest;
    }

    public void setTotalTest(Double totalTest) {
        this.totalTest = totalTest;
    }

    public Double getPopulation() {
        return population;
    }

    public void setPopulation(Double population) {
        this.population = population;
    }

}
