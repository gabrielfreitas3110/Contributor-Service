/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import entities.Corporation;
import entities.Individual;
import entities.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Gabriel Augusto
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Person> list = new ArrayList<>();
        
        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();
        
        for(int i=1; i<=n; i++) {
            System.out.println("Tax payer #"+i+" data: ");   
            System.out.print("Individual or company (i/c)? ");
            char op = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            double income = sc.nextDouble();
            
            if(op == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpense = sc.nextDouble();
                list.add(new Individual(healthExpense,name,income));
            }
            if(op == 'c') {
                System.out.print("Number of employees: ");
                int nEmployees = sc.nextInt();
                list.add(new Corporation(nEmployees,name,income));
            }
        }
        System.out.println();
        System.out.println("TAX PAID: ");
        for(Person p: list) {
            System.out.println(p.getName() + ": $ " + String.format("%.2f",p.tax()));
        }
        double sum = 0.0;
        for(Person p: list) {
            sum += p.tax();
        }
        System.out.println();
        System.out.println("TOTAL TAXES: $ " + String.format("%.2f",sum));
    }
}
