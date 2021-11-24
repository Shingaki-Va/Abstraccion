package app;

import superClass.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static Product productsMenu() {

        Product product = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("1.Ropa \n2.Alimentos \n3.Herramientas \n4.Jueguetes");
        System.out.print("Opción: ");
        int opc = sc.nextInt();
        System.out.print(" ");
        while (opc < 1 || opc > 4) {
            System.out.println("opción invalida\n\n1.Ropa \n2.Alimentos \n3.Herramientas \n4.Jueguetes");
            System.out.print("opción: ");
            opc = sc.nextInt();
        }
        switch (opc) {
            case 1:
                System.out.print(" ");
                product = Stock.clotheStock();
                break;

            case 2:
                System.out.print(" ");
                product = Stock.foodStock();
                break;
            case 3:
                System.out.print(" ");
                product = Stock.toolStock();
                break;
            case 4:
                System.out.print(" ");
                product = Stock.toyStock();
                break;
            default:
                System.out.println("opción inválida");
                break;
        }
        return product;
    }

    public static void finalMenu(ArrayList<Product> productsList) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Scanner sc = new Scanner(System.in);
        boolean goToPay = true;

        while (goToPay) {
            System.out.println("1. Eliminar producto\n2. Agregar Producto\n3. Vaciar carrito y salir \n4. Pagar");
            System.out.print("opción: ");
            int opc = sc.nextInt();
            while (opc < 1 || opc > 4) {
                System.out.println("opción invalida\n 1. Eliminar producto\n2. Agregar Producto\n3. Vaciar carrito y salir \n4. Pagar");
                System.out.print("opción: ");
                opc = sc.nextInt();
            }
            switch (opc) {
                case 1:
                    shoppingCart.removeProducts(productsList);
                    break;

                case 2:
                    shoppingCart.addProducts(Menu.productsMenu(), productsList);
                    break;

                case 3:
                    System.out.print("Perderá toda su compra, está seguro de salir?  1.SI 2.NO\nOpción: ");
                    int comfirm = sc.nextInt();
                    if (comfirm == 2){
                        finalMenu(productsList);
                    }else {
                        shoppingCart.clearShopingCart(productsList);
                    }
                    break;

                case 4:
                    shoppingCart.ticket(productsList);
                    goToPay = false;
                    break;

                default:
                    System.out.println("opcion inválida");
                    break;

            }
            if (opc == 2) {
                shoppingCart.showShoppingCart(productsList);
            }
        }
    }

    public static void finishSoppingMenu(ArrayList<Product> productsList) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setProductsList();
        System.out.println("-----------------------------------------------");
        System.out.println("Gracias por venir al mercado Loco");
        shoppingCart.showShoppingCart(productsList);

    }
}
