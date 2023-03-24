package model;

import java.util.Comparator;

@SuppressWarnings("unused")
public class Country implements Comparator<Country>, Comparable<Country>{
    private Integer serialNumber;
    private String countryName;
    private Double totalCases;
    private Double totalDeaths;
    private Double totalRecovered;
    private Double activeCases;
    private Double totalTest;
    private Float population;

    public Country(Integer serialNumber, String country, Double totalCases, Double totalDeaths, Double totalRecovered,
            Double activeCases, Double totalTest, Float population) {
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

    public Float getPopulation() {
        return population;
    }

    public void setPopulation(Float population) {
        this.population = population;
    }

    // Ejemplos del uso de compare y compareTo, para utilizar
    // en la implementacion de los metodos de ordenamiento
    @Override
    public int compare(Country o1, Country o2) {
        return o1.getTotalCases().compareTo(o2.getTotalCases());
    }

    @Override
    /**
     * 
     * @param country
     * @return
     */
    public int compareTo(Country country) {
        int output;

        if (country.getCountryName().compareToIgnoreCase(this.countryName) > 0) {
            output = 1;
        } else if(country.countryName.compareToIgnoreCase(this.countryName) < 0){
            output = -1;
        } else{
            output = 0;
        }
        
        return output;
    }

}
