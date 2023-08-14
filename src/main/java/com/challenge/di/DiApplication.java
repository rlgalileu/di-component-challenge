package com.challenge.di;

import com.challenge.di.entities.Order;
import com.challenge.di.services.OrderService;
import com.challenge.di.services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DiApplication implements CommandLineRunner {

    @Autowired
    private OrderService orderService;


	public static void main(String[] args) {
		SpringApplication.run(DiApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Dados do pedido");

        Order order = new Order();

        System.out.print("Código: ");
        order.setCode(sc.nextInt());

        System.out.print("Valor básico: ");
        order.setBasic(sc.nextDouble());

        System.out.print("Porcentagem do disconto: ");
        order.setDiscount(sc.nextDouble());

        System.out.printf("Pedido código: %d%n", order.getCode());
        System.out.printf("Valor total: R$ %.2f%n", orderService.total(order));
    }
}
