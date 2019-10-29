import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Map<Integer, Payment> payments = new HashMap<>();
    static int choice=6;

    public static void main(String[] args) {
            //salary
        Payment salary10 = new Payment(1018, "Salary", 2700, 10, 2018);
        Payment salary11 = new Payment(1118, "Salary", 2300, 11, 2018);
        Payment salary12 = new Payment(1218, "Salary", 1900, 12, 2018);
        Payment salary01 = new Payment(119, "Salary", 1700, 1, 2019);
        Payment salary02 = new Payment(219, "Salary", 2000, 2, 2019);
        Payment salary03 = new Payment(319, "Salary", 900, 3, 2019);
        Payment salary04 = new Payment(419, "Salary", 2900, 4, 2019);
        //cafe
        Payment Café10 = new Payment(20001018, "Café ", -210, 10, 2018);
        Payment Café11 = new Payment(20001118, "Café ", -110, 11, 2018);
        Payment Café12 = new Payment(20001218, "Café ", -230, 12, 2018);
        Payment Café01 = new Payment(2000119, "Café ", -170, 1, 2019);
        Payment Café02 = new Payment(2000219, "Café ", -150, 2, 2019);
        Payment Café03 = new Payment(2000319, "Café ", -90, 3, 2019);
        Payment Café04 = new Payment(2000419, "Café ", -220, 4, 2019);

        //healthInsurance
        Payment healthInsurance10 = new Payment(3001018, "healthInsurance", -310, 10, 2018);
        Payment healthInsurance11 = new Payment(3001118, "healthInsurance", -310, 11, 2018);
        Payment healthInsurance12 = new Payment(3001218, "healthInsurance", -310, 12, 2018);
        Payment healthInsurance01 = new Payment(300119, "healthInsurance", -350, 1, 2019);
        Payment healthInsurance02 = new Payment(300219, "healthInsurance", -350, 2, 2019);
        Payment healthInsurance03 = new Payment(300319, "healthInsurance", -350, 3, 2019);
        Payment healthInsurance04 = new Payment(300419, "healthInsurance", -350, 4, 2019);


        //SalaryIncomes
        payments.put(salary10.getId(), salary10);
        payments.put(salary11.getId(), salary11);
        payments.put(salary12.getId(), salary12);
        payments.put(salary01.getId(), salary01);
        payments.put(salary02.getId(), salary02);
        payments.put(salary03.getId(), salary03);
        payments.put(salary04.getId(), salary04);
        //cafe
        payments.put(Café10.getId(), Café10);
        payments.put(Café11.getId(), Café11);
        payments.put(Café12.getId(), Café12);
        payments.put(Café01.getId(), Café01);
        payments.put(Café02.getId(), Café02);
        payments.put(Café03.getId(), Café03);
        payments.put(Café04.getId(), Café04);
        //health
        payments.put(healthInsurance10.getId(), healthInsurance10);
        payments.put(healthInsurance11.getId(), healthInsurance11);
        payments.put(healthInsurance12.getId(), healthInsurance12);
        payments.put(healthInsurance01.getId(), healthInsurance01);
        payments.put(healthInsurance02.getId(), healthInsurance02);
        payments.put(healthInsurance03.getId(), healthInsurance03);
        payments.put(healthInsurance04.getId(), healthInsurance04);


            Scanner scanner = new Scanner(System.in);



            try {
                System.out.println("Enter what statistics you want to see:");
                System.out.println("1 -My biggest payment");
                System.out.println("2 -My total income");
                System.out.println("3 -How do I spend my money");
                System.out.println("4 -My Total month ");
                System.out.println("5 -My total in year");
                System.out.println("0 -exit");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("My biggest payment : ");
                        maximumPayment();
                        break;
                    case 2:
                        System.out.println("My total income :");
                        totalIncome();
                        break;
                    case 3:
                        System.out.println("How do I spend my money :");
                        categeorTotal();
                        break;
                    case 4:
                        System.out.println("My Total month :");

                        monthTotal();
                        break;

                    case 0:
                        break;
                    case 5:
                        System.out.println("My total in year :");
                        inYear();
                        break;


                }
            } catch (Exception ee ) {

                System.out.println("Invalid value");

            }



    }

    static void maximumPayment() {
        Payment theBiggestPayment = null;
        for (Map.Entry<Integer, Payment> entry : payments.entrySet()) {
            if (entry.getValue().getAmount() >= 0) {
                continue;
            }
            if (theBiggestPayment == null) {
                theBiggestPayment = entry.getValue();
            }
            if (theBiggestPayment.getAmount() > entry.getValue().getAmount()) {
                theBiggestPayment = entry.getValue();
            }
        }
        System.out.println(theBiggestPayment);
        double totalSpending = 0;
        for (Map.Entry<Integer, Payment> entry : payments.entrySet()) {
            Payment payment = entry.getValue();


            if (entry.getValue().getAmount() <= 0) {
                totalSpending += entry.getValue().getAmount();

            }


        }
        System.out.println("The total payments is: " + totalSpending + " €");
    }

    static void totalIncome() {
        double sum = 0;
        for (Map.Entry<Integer, Payment> entry : payments.entrySet()) {
            Payment payment = entry.getValue();


            if (entry.getValue().getAmount() >= 0) {
                sum += entry.getValue().getAmount();
            }


        }
        System.out.println("Total inCome is :" + sum + " €");

    }

    static void categeorTotal() {
        Map<String, Double> inCategories = new HashMap<>();
        for (Map.Entry<Integer, Payment> entry : payments.entrySet()) {
            Payment payment = entry.getValue();
            String category = payment.getCategory();

            double categorySum = inCategories.getOrDefault(category, 0.0);
            categorySum += payment.getAmount();
            inCategories.put(category, categorySum);
        }

        System.out.println(inCategories);
    }

    static void monthTotal() {
        Map<Integer, Double> inMonths = new HashMap<>();
        for (Map.Entry<Integer, Payment> entry : payments.entrySet()) {
            Payment payment = entry.getValue();
            Integer month = payment.getMonth();

            double monthSum = inMonths.getOrDefault(month, 0.0);
            monthSum += payment.getAmount();
            inMonths.put(month, monthSum);

        }


        //SwitchDemo monthStringName = new SwitchDemo();
        //monthStringName.monthMethod(inMonths.keySet());
        System.out.println(inMonths);
    }

    static void inYear() {
        Map<Integer, Double> inYears = new HashMap<>();
        for (Map.Entry<Integer, Payment> entry : payments.entrySet()) {
            Payment payment = entry.getValue();
            Integer year = payment.getYear();

            double yearSum = inYears.getOrDefault(year, 0.0);
            yearSum += payment.getAmount();
            inYears.put(year, yearSum);

        }

        System.out.println(inYears);
    }

}













