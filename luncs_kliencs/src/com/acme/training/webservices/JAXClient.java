package com.acme.training.webservices;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.xml.ws.WebServiceRef;

public class JAXClient {

    @WebServiceRef(wsdlLocation = "http://10.0.13.240:8080/menu?wsdl")
    static private MenuWebService service = new MenuWebService();
    static private MenuWeb menu;

    static private int cartId = 0;

    public static void main(String[] args) throws Exception {

        if (service == null)
            throw new RuntimeException("could not reach server");

        menu = service.getMenuWebPort();

        if (menu == null)
            throw new RuntimeException("baj van");
        MainMenu();

    }

    public static void MainMenu() {
        Address address;
        while (true) {
            System.out.println("s) set customer name");
            System.out.println("b) set billing address");
            System.out.println("d) set delivery address");
            System.out.println("m) menu");
            System.out.println("o) send order");
            System.out.println("c) check order");
            System.out.println("q) quit");
            char choice = userInput().charAt(0);
            switch (choice) {
            case 's':
                System.out.println("enter your name:");
                String name = userInput();
                cartId = menu.setCustomer(name, cartId);
                break;
            case 'b':
                System.out.println("enter billing address:");
                address = addressInput();
                cartId = menu.setBillingAddress(address, cartId);
                break;
            case 'd':
                System.out.println("enter delivery address:");
                address = addressInput();
                cartId = menu.setDeliveryAddress(address, cartId);
                break;
            case 'm':
                addFood();
                break;
            case 'o':
                menu.sendOrder(cartId);
                System.out.println("order has been sent");
                break;
            case 'c':
                System.out.println(menu.viewOrder(cartId));
                break;
            case 'q':
                System.exit(0);
                break;
            }
        }

    }

    public static void addFood() {
        for (FoodView f : menu.getFoods()) {
            System.out.println(String.format("%d) %s (%d,-)", f.getId(), f.getName(), f.getPrice()));
        }
        System.out.println("m) back to menu");
        System.out.println("make your choice: ");
        String choice = userInput();
        if ( choice.charAt(0) != 'm') {
            cartId = menu.addFood(Integer.parseInt(choice), 1, cartId);
        }
    }

    public static Address addressInput() {
        Address result = new Address();

        System.out.println("city: ");
        result.setCity(userInput());

        System.out.println("country: ");
        result.setCountry(userInput());

        System.out.println("street: ");
        result.setStreet(userInput());

        System.out.println("zip: ");
        result.setZip(userInput());

        return result;
    }

    public static String userInput() {
        InputStreamReader inStream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inStream);
        String input = null;
        try {
            while (input == null) {
                input = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return input;
    }

}