package org.cofincafe;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Cliente> clientes = Arrays.asList(
                new Cliente(1, "Ana", 5000),
                new Cliente(2, "Juan", -200),
                new Cliente(3, "Luis", 12000),
                new Cliente(4, "Marta", -3000),
                new Cliente(5, "Pedro", -1500),
                new Cliente(6, "Sofía", 8000),
                new Cliente(7, "Sebastian", 3500),
                new Cliente(8, "Alejandra", 5500),
                new Cliente(9, "Jose", 6000),
                new Cliente(10, "David", -2000)
        );

        ClienteService service = new ClienteService();

        System.out.println("Clientes con balance negativo:");
        service.obtenerClientesConBalanceNegativo(clientes).forEach(System.out::println);

        System.out.println("\nTop 3 clientes con mayor balance:");
        service.obtenerTopClientesConMayorBalance(clientes, 3).forEach(System.out::println);

        //Versión dinámica del top de clientes con mayor balance
        System.out.println("\nTop 5 clientes con mayor balance:");
        service.obtenerTopClientesConMayorBalance(clientes, 5).forEach(System.out::println);

        System.out.println("\nLista en formato JSON:");
        System.out.println(service.convertirListaAJson(clientes));
    }
}