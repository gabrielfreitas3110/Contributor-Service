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
public class Corporation extends Person {

    private int numberEmployees;
    private final Double lowTax   = 0.16;
    private final Double normalTax = 0.14;

    public Corporation() {
        super();
    }

    public Corporation(int numberEmployees, String name, Double annualIncome) {
        super(name, annualIncome);
        this.numberEmployees = numberEmployees;
    }

    public int getNumberEmployees() {
        return numberEmployees;
    }

    public void setNumberEmployees(int numberEmployees) {
        this.numberEmployees = numberEmployees;
    }
    
    @Override
    public Double tax() {
        if(numberEmployees < 10) {
            return(super.getAnnualIncome()*lowTax);
        }
        return(super.getAnnualIncome()*normalTax);
    }
    
}
