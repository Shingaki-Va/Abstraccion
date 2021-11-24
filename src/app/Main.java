package app;

import superClass.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("-----BIENVENIDO AL MERCADO LOCO----- \n ¿Qué desea comprar?");

        ArrayList<Product> productsList = compraActiva();
        Menu.finishSoppingMenu(productsList);
        Menu.finalMenu(productsList);
    }

    public static ArrayList<Product> compraActiva() {
        Scanner sc = new Scanner(System.in);
        ShoppingCart shoppingCart = new ShoppingCart();
        ArrayList<Product> productsList = new ArrayList<>();
        boolean stillShopping = true;

        shoppingCart.setProductsList();
        while (stillShopping) {

            shoppingCart.addProducts(Menu.productsMenu(), productsList);
            System.out.println("\n*¿Desea seguir comprando?----> 1.SI  2.NO ");
            System.out.print("Opcion: ");
            int exit = sc.nextShort();

            if (exit == 2) {
                stillShopping = false;
            }
        }
        return productsList;
    }


}
