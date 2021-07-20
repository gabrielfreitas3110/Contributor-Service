/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Gabriel Augusto
 */
public class Individual extends Person {

    private Double healthExpense;
    private final Double lowTax = 0.15;
    private final Double averageTax = 0.25;
    private final Double highTax = 0.50;
    public Individual() {
        super();
    }

    public Individual(Double healthExpense, String name, Double annualIncome) {
        super(name, annualIncome);
        this.healthExpense = healthExpense;
    }

    public Double getHealthExpense() {
        return healthExpense;
    }

    public void setHealthExpense(Double healthExpense) {
        this.healthExpense = healthExpense;
    }
    
    @Override
    public Double tax() {
        if(super.getAnnualIncome() < 2000) {
            return (super.getAnnualIncome()*lowTax) - (healthExpense*highTax);
        }
        return (super.getAnnualIncome()*averageTax) - (healthExpense*highTax);
    }
    
}
