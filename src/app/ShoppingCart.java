package app;

import subClass.Tool;
import subClass.Toy;
import superClass.Product;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import java.util.Scanner;

public class ShoppingCart {

    private int totalQuantity = 0;
    private int toyQuantity = 0;
    private int totalToyAmount = 0;
    private boolean payWithCC;
    private float parcialAmount;
    private float sumOfDiscount;


    public ShoppingCart() {

    }

    public void setProductsList() {
    }

    public void addProducts(Product product, ArrayList<Product> productsList) {
        productsList.add(product);
    }

    public void removeProducts(ArrayList<Product> productsList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Que producto desea eliminar?");
        for (int i = 0; i < productsList.size(); i++) {
            System.out.println((i + 1) + ". " + productsList.get(i).getName() + "(" + productsList.get(i).getQuantity() + "u)");
        }
        System.out.print("opcion: ");
        int opc = sc.nextInt();
        opc -= 1;

        if (productsList.get(opc).getQuantity() > 1) {
            System.out.print("usted tiene: " + productsList.get(opc).getQuantity() + " unidades en el carrito, Cuantos desea elimnar?\nopc: ");
            int quantity = sc.nextInt();
            while (quantity > productsList.get(opc).getQuantity()) {
                System.out.print("Debe elegir una cantidad entre 1 y " + productsList.get(opc).getQuantity() + "\nopc: ");
                quantity = sc.nextInt();
            }
            System.out.println("está seguro que quiere elimnar: " + quantity + "u de " + productsList.get(opc).getName() + " ? 1.SI  2.NO");
            int opcDelete = sc.nextInt();
            if (opcDelete == 1) {
                if (quantity != productsList.get(opc).getQuantity()) {
                    productsList.get(opc).setQuantity(productsList.get(opc).getQuantity() - 1);
                    System.out.println("Se ha eliminado " + opc + "u de " + productsList.get(opc).getName());
                } else {
                    productsList.remove(opc);
                    System.out.println("Se han eliminado todas las unidades de su producto");
                }
            }

        } else {

            System.out.println("está seguro que quiere elimnar el producto: " + productsList.get(opc).getName() + " ? 1.SI  2.NO");
            int opcDelete = sc.nextInt();
            if (opcDelete == 1) {
                productsList.remove(opc);
                System.out.println("Se ha eliminado su producto");
            }
        }
        showShoppingCart(productsList);
    }

    public void clearShopingCart(ArrayList<Product> productsList) {
        productsList.clear();
        showShoppingCart(productsList);
    }


    public void showShoppingCart(ArrayList<Product> productsList) {
        totalQuantity = 0;
        if (productsList.isEmpty()) {
            System.out.println("Su carrito de compras está vacío");
            System.out.println("Vuelva prontos");
            System.exit(0);
        } else {
            System.out.println("----Productos en su carrito de compra----\n ");
            for (int i = 0; i < productsList.size(); i++) {
                for (int j = i + 1; j < productsList.size(); j++) {
                    if (Objects.equals(productsList.get(i).getName(), productsList.get(j).getName())) {
                        productsList.get(i).setQuantity((productsList.get(i).getQuantity()) + 1);
                        productsList.remove(j);
                        j--;
                    }
                }
            }

            for (Product product : productsList) {
                System.out.println(product.toString());
                totalQuantity += product.getQuantity();
            }

        }
        System.out.println("*Productos totales: " + totalQuantity);
        System.out.println("-----------------------------------------------");
    }

    public void ticket(ArrayList<Product> productsList) {
        Calendar c = Calendar.getInstance();
        Scanner sc = new Scanner(System.in);
        System.out.print("Check Out - Como desea abonar?\n 1.Efectivo 2.Tarjeta de Debito 3.Tarjeta de Credito \nOpcion: ");
        int opc = sc.nextInt();
        if (opc == 3) {
            this.payWithCC = true;
        }

        for (Product product : productsList) {
            if (product instanceof Toy) {
                toyQuantity += product.getQuantity();
                totalToyAmount += product.getPrice() * product.getQuantity();
            }
            if (toyQuantity > 3 || totalToyAmount > 3000) {
                assert product instanceof Toy;
                ((Toy) product).setHasDiscount(true);
            }
            if (product instanceof Tool) {
                ((Tool) product).setPayWithCC(payWithCC);
            }
        }

        for (Product product : productsList) {
            product.CalculateDiscount();
            parcialAmount += product.getPrice() * product.getQuantity();
            sumOfDiscount += product.getDiscount() * product.getQuantity();
            System.out.println("-" + product.getName() + " (" + product.getQuantity() + "u) " + " $" + product.getPrice() + "c/u" + "\ntotal $" + product.getQuantity() * product.getPrice() + " | descuento: " + product.getDiscount() * product.getQuantity() + "\n");
            totalQuantity += product.getQuantity();
        }
        float totalAmount = parcialAmount - sumOfDiscount;
        System.out.printf("*Productos %d unidades\nSubTotal:     $%.2f \nDescuentos:   $%.2f \nTotal:        $%.2f\n--------------------------------------", totalQuantity, parcialAmount, sumOfDiscount, totalAmount);
        switch (opc) {

            case 1:
                System.out.println("\nMétodo de pago: EFECTIVO");
                System.out.print("Ingrese su Pago: ");
                float efectivo = sc.nextInt();
                while (efectivo < totalAmount) {
                    System.out.printf("El monto a pagar es: $%.2f y ud está pagando: $%.2f --> le hacen falta: $%.2f más", totalAmount, efectivo, (totalAmount - efectivo));
                    System.out.print("\nIngrese el dinero faltante: ");
                    efectivo += sc.nextInt();
                }
                if (efectivo == totalAmount) {
                    System.out.println("Gracias por pagar justo ");
                } else
                    System.out.printf("----------------------\nPago: $%.2f su vuelto es: $%.2f", efectivo, (efectivo - totalAmount));
                break;

            case 2:
                System.out.println("\nMétodo de pago: TARJETA DE DEBITO");
                isCardExpired(c, sc);
                System.out.printf("Su pago de $%.2f fue exitoso", totalAmount);
                break;

            case 3:
                System.out.println("\nMétodo de pago: TARJETA DE CREDITO");
                System.out.print("Ingrese cantidad de cuotas: ");
                int cuotas = sc.nextInt();

                isCardExpired(c, sc);
                System.out.printf("Su pago de $%.2f fue exitoso\n", totalAmount);
                System.out.println(cuotas + " cuotas de: " + totalAmount / cuotas + " cada una");
                break;
        }
        System.out.println("\nMuchas gracias por su compra, vuelva prontos");
    }

    private void isCardExpired(Calendar c, Scanner sc) {
        boolean expiredCard = true;
        while (expiredCard) {
            System.out.println("ingrese los 16 numeros de tarjeta(para nuestra clase son 5 numeros)");
            BigInteger numero = sc.nextBigInteger();

            while (numero.toString(1).length() != 5) {
                System.out.println("usted ingresó: " + numero.toString(1).length() + " numéros, deben ser 16");
                System.out.println("reingrese los 16 numeros de tarjeta (para nuestra clase son 5 numeros)");
                numero = sc.nextBigInteger();
            }
            System.out.println("ingrese mes de vencimiento: ");
            int mes = sc.nextInt();
            System.out.println("ingrese año de vencimiento: ");
            int anio = sc.nextInt();

            if (anio > c.get(Calendar.YEAR)) {
                expiredCard = false;
            } else if (anio == c.get(Calendar.YEAR) && mes > (c.get(Calendar.MONTH) + 1)) {
                expiredCard = false;
            } else {
                System.out.println("TARJETA VENCIDA INGRESE OTRA");
            }
        }
    }
}
