package app;

import subClass.Clothe;
import subClass.Food;
import subClass.Tool;
import subClass.Toy;

import java.util.Scanner;

public class Stock {

    public static Clothe clotheStock() {
        Scanner sc = new Scanner(System.in);
        Clothe clothe = new Clothe();
        System.out.println("\n1.Ropa de Mujer \n2.Ropa de Hombre \n3.Ropa de niños ");
        System.out.print("Opción: ");
        int opc = sc.nextInt();
        while (opc < 1 || opc > 3) {
            System.out.println("");
            System.out.println("opcion inválida");
            System.out.println("\n1.Ropa de Mujer \n2.Ropa de Hombre \n3.Ropa de niños ");
            System.out.print("Opción: ");
            opc = sc.nextInt();
        }
        System.out.println("");

        switch (opc) {
            case 1:
                clothe.setType("W");
                System.out.println("\n1.Vestido $2000\n2.Corpiño $1200\n3.Tacos stiletos $3000");
                System.out.print("Opción: ");
                opc = sc.nextInt();
                while (opc < 1 || opc > 3) {
                    System.out.println("\nopción invalida\n1.Vestido $2000\n2.Corpiño $1200\n3.Tacos stiletos $3000");
                    System.out.print("opcoón: ");
                    opc = sc.nextInt();
                }
                switch (opc) {
                    case 1:
                        clothe.setName("Vestido");
                        clothe.setPrice(2000);
                        clothe.setQuantity(1);
                        System.out.println("Se agregó " + clothe.getName() + " a su carrito!");
                        break;
                    case 2:
                        clothe.setName("Corpiño");
                        clothe.setPrice(1200);
                        clothe.setQuantity(1);
                        System.out.println("Se agregó " + clothe.getName() + " a su carrito!");
                        break;
                    case 3:
                        clothe.setName("Tacos stiletos");
                        clothe.setPrice(3000);
                        clothe.setQuantity(1);
                        System.out.println("Se agregó " + clothe.getName() + " a su carrito!");
                        break;
                    default:
                        System.out.println("opcion inválida");
                }
                break;

            case 2:
                clothe.setType("M");
                System.out.println("\n1.Traje $2000\n2.Calzoncillo $1200\n3.Zapatos naúticos $3000 ");
                System.out.print("Opción: ");
                opc = sc.nextInt();
                while (opc < 1 || opc > 3) {
                    System.out.println("\nopción invalida\n1.Traje $2000\n2.Calzoncillo $1200\n3.Zapatos naúticos $3000");
                    System.out.print("opcoón: ");
                    opc = sc.nextInt();
                }
                switch (opc) {
                    case 1:
                        clothe.setName("Traje");
                        clothe.setPrice(2000);
                        clothe.setQuantity(1);
                        System.out.println("Se agregó " + clothe.getName() + " a su carrito!");
                        break;
                    case 2:
                        clothe.setName("Calzoncillo");
                        clothe.setPrice(1200);
                        clothe.setQuantity(1);
                        System.out.println("Se agregó " + clothe.getName() + " a su carrito!");
                        break;
                    case 3:
                        clothe.setName("Zapatos");
                        clothe.setPrice(3000);
                        clothe.setQuantity(1);
                        System.out.println("Se agregó " + clothe.getName() + " a su carrito!");
                        break;
                    default:
                        System.out.println("opcion inválida");
                }
                break;

            case 3:
                clothe.setType("K");
                System.out.println("1.Remera SuperHéroes $2000 \n2.Zapatillas con luces $12000\n3.Pijama dibujos animados $3000");
                System.out.print("Opción: ");
                opc = sc.nextInt();
                while (opc < 1 || opc > 3) {
                    System.out.println("opción invalida\n1.Remera SuperHéroes $2000 \n2.Zapatillas con luces $12000\n3.Pijama dibujos animados $3000");
                    System.out.print("opcoón: ");
                    opc = sc.nextInt();
                }
                switch (opc) {
                    case 1:
                        clothe.setName("Remera SuperHéroes");
                        clothe.setPrice(2000);
                        clothe.setQuantity(1);
                        System.out.println("Se agregó " + clothe.getName() + " a su carrito!");
                        break;
                    case 2:
                        clothe.setName("Zapatillas con luces");
                        clothe.setPrice(12000);
                        clothe.setQuantity(1);
                        System.out.println("Se agregó " + clothe.getName() + " a su carrito!");
                        break;
                    case 3:
                        clothe.setName("Pijama dibujos animados");
                        clothe.setPrice(3000);
                        clothe.setQuantity(1);
                        System.out.println("Se agregó " + clothe.getName() + " a su carrito!");
                        break;
                    default:
                        System.out.println("opcion inválida");
                        break;
                }
                break;
        }
        return clothe;
    }

    public static Tool toolStock() {
        Scanner sc = new Scanner(System.in);
        Tool tool = new Tool();
        System.out.println("\n1.Martillo $800 \n2.Pinza $900 \n3.Serrucho $1200");
        System.out.print("Opción: ");
        int opc = sc.nextInt();
        while (opc < 1 || opc > 3) {
            System.out.println("\nopción invalida\n1.Martillo $800 \n2.Pinza $900 \n3.Serrucho $1200");
            System.out.print("opción: ");
            opc = sc.nextInt();
        }
        System.out.println("");

        switch (opc) {
            case 1:
                tool.setName("Martillo");
                tool.setPrice(800);
                tool.setQuantity(1);
                System.out.println("Se agregó " + tool.getName() + " a su carrito!");
                break;
            case 2:
                tool.setName("Pinza");
                tool.setPrice(900);
                tool.setQuantity(1);
                System.out.println("Se agregó " + tool.getName() + " a su carrito!");
                break;
            case 3:
                tool.setName("Serrucho");
                tool.setPrice(1200);
                tool.setQuantity(1);
                System.out.println("Se agregó " + tool.getName() + " a su carrito!");
                break;
            default:
                System.out.println("opcion inválida");
        }
        return tool;
    }

    public static Food foodStock() {
        Scanner sc = new Scanner(System.in);
        Food food = new Food();
        System.out.println("\n1.Milanesa $800\n2.Pizza $900 \n3.Arroz $100");
        System.out.print("Opción: ");
        int opc = sc.nextInt();

        while (opc < 1 || opc > 3) {
            System.out.println("\nopción invalida\n1.Milanesa $800\n2.Pizza $900 \n3.Arroz $100");
            System.out.print("opción: ");
            opc = sc.nextInt();
        }
        System.out.println("");

        switch (opc) {
            case 1:
                food.setName("Milanesa");
                food.setPrice(800);
                food.setQuantity(1);
                System.out.println("Se agregó " + food.getName() + " a su carrito!");
                break;
            case 2:
                food.setName("Pizza");
                food.setPrice(900);
                food.setQuantity(1);
                System.out.println("Se agregó " + food.getName() + " a su carrito!");
                break;
            case 3:
                food.setName("Arroz");
                food.setPrice(100);
                food.setQuantity(1);
                System.out.println("Se agregó " + food.getName() + " a su carrito!");
                break;
            default:
                System.out.println("opcion inválida");
        }
        return food;
    }

    public static Toy toyStock() {
        Scanner sc = new Scanner(System.in);
        Toy toy = new Toy();
        System.out.println("1.Auto $100 \n2.Barbie $1000\n3.Transformer $2000");
        System.out.print("Opción: ");
        int opc = sc.nextInt();
        while (opc < 1 || opc > 3) {
            System.out.println("opción invalida\n1.Auto $100 \n2.Barbie $1000\n3.Transformer $2000");
            System.out.print("opción: ");
            opc = sc.nextInt();
        }
        System.out.println("");

        switch (opc) {
            case 1:
                toy.setName("Auto");
                toy.setPrice(100);
                toy.setQuantity(1);
                System.out.println("Se agregó " + toy.getName() + " a su carrito!");
                break;
            case 2:
                toy.setName("Barbie");
                toy.setPrice(1000);
                toy.setQuantity(1);
                System.out.println("Se agregó " + toy.getName() + " a su carrito!");
                break;
            case 3:
                toy.setName("Transformer");
                toy.setPrice(2000);
                toy.setQuantity(1);
                System.out.println("Se agregó " + toy.getName() + " a su carrito!");
                break;
            default:
                System.out.println("opción inválida");
        }
        return toy;
    }


}
