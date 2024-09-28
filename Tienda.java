
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author andre
 */
public class Tienda {  // Definición de la clase principal del programa.

    static final double IGV = 0.18; // Define una constante que representa el porcentaje del IGV (18%).

    // Clase Producto
    static class Producto {         // Define una clase interna Producto que representa cada instrumento.
        String nombre;              // Variable para almacenar el nombre del producto.
        double precio;              // Variable para almacenar el precio del producto.

        Producto(String nombre, double precio) {   // Constructor de la clase Producto que inicializa sus atributos.
            this.nombre = nombre;   // Asigna el nombre del producto.
            this.precio = precio;   // Asigna el precio del producto.
        }
    }

   
    
    public static void main(String[] args) {   // Método principal, donde comienza la ejecución del programa.
        Scanner scanner = new Scanner(System.in);  // Crea un objeto Scanner para leer la entrada del usuario.

        // Pedir datos del cliente
        System.out.println("Bienvenido a la tienda de instrumentos musicales.");   // Mensaje de bienvenida.
        System.out.println("Ingrese sus datos personales:");  // Solicita al usuario sus datos.
        System.out.print("Nombre: ");           // Solicita el nombre del cliente.
        String nombre = scanner.nextLine();     // Lee la entrada del nombre.
        System.out.print("Direccion: ");        // Solicita la dirección del cliente.
        String direccion = scanner.nextLine();  // Lee la entrada de la dirección.
        System.out.print("Telefono: ");         // Solicita el teléfono del cliente.
        String telefono = scanner.nextLine();   // Lee la entrada del teléfono.

        Cliente cliente = new Cliente(nombre, direccion, telefono);  // Crea un objeto Cliente con los datos ingresados.

        ArrayList<Producto> carrito = new ArrayList<>(); // Crea una lista para almacenar los productos seleccionados.
        boolean seguirComprando = true;  // Variable de control para decidir si el cliente seguirá comprando.

        while (seguirComprando) {    // Inicia un bucle que se repetirá mientras el cliente quiera seguir comprando.
            // Mostrar opciones de productos
            System.out.println("\nSeleccione un producto para agregar al carrito:");  // Muestra el menú de productos.
            System.out.println("1. Guitarra - $150.00");  // Opción 1: Guitarra.
            System.out.println("2. Bateria - $300.00");   // Opción 2: Batería.
            System.out.println("3. Teclado - $250.00");   // Opción 3: Teclado.
            System.out.println("4. Violin - $100.00");    // Opción 4: Violín.
            System.out.println("5. Finalizar compra");    // Opción 5: Finalizar compra y salir.

            int opcion = scanner.nextInt();  // Lee la opción seleccionada por el cliente.

            switch (opcion) {  // Estructura de control que actúa según la opción seleccionada.
                case 1:
                    carrito.add(new Producto("Guitarra", 150.00));  // Agrega una guitarra al carrito.
                    System.out.println("Guitarra aniadida al carrito.");  // Confirma que se ha añadido.
                    break;
                case 2:
                    carrito.add(new Producto("Bateria", 300.00));  // Agrega una batería al carrito.
                    System.out.println("Bateria aniadida al carrito.");  // Confirma que se ha añadido.
                    break;
                case 3:
                    carrito.add(new Producto("Teclado", 250.00));  // Agrega un teclado al carrito.
                    System.out.println("Teclado aniadido al carrito.");  // Confirma que se ha añadido.
                    break;
                case 4:
                    carrito.add(new Producto("Violin", 100.00));  // Agrega un violín al carrito.
                    System.out.println("Violín aniadido al carrito.");  // Confirma que se ha añadido.
                    break;
                case 5:
                    seguirComprando = false;  // Cambia la variable a false para salir del bucle.
                    break;
                default:
                    System.out.println("Opcion no valida, intente nuevamente.");  // Mensaje de error si la opción no es válida.
                    break;
            }

            if (opcion != 5) {  // Si no ha finalizado la compra, pregunta si desea seguir comprando.
                System.out.print("Desea seguir comprando? (s/n): ");  // Pregunta si desea continuar.
                String seguir = scanner.next();  // Lee la respuesta del usuario (s/n).
                seguirComprando = seguir.equalsIgnoreCase("s");  // Evalúa si la respuesta es 's' (sí).
            }
        }

        // Calcular el total
        double subtotal = 0.0;  // Inicializa la variable subtotal.
        for (Producto producto : carrito) {  // Recorre el carrito de compras y suma los precios.
            subtotal += producto.precio;  // Suma el precio del producto al subtotal.
        }
        double impuesto = subtotal * IGV;  // Calcula el impuesto (IGV) basado en el subtotal.
        double total = subtotal + impuesto;  // Calcula el total (subtotal + impuesto).

        // Mostrar datos de la compra
        System.out.println("\n----- Resumen de la Compra -----");  // Muestra el título del resumen de compra.
        System.out.println("Cliente: " + cliente.nombre);  // Muestra el nombre del cliente.
        System.out.println("Direcciin: " + cliente.direccion);  // Muestra la dirección del cliente.
        System.out.println("Telefono: " + cliente.telefono);  // Muestra el teléfono del cliente.
        System.out.println("\nProductos comprados:");  // Muestra los productos comprados.
        for (Producto producto : carrito) {  // Recorre el carrito y muestra cada producto con su precio.
            System.out.println("- " + producto.nombre + ": $" + producto.precio);  // Muestra cada producto.
        }

        // Muestra los totales con formato de dos decimales
        System.out.printf("\nSubtotal: $%.2f\n", subtotal);  // Muestra el subtotal.
        System.out.printf("IGV (18%%): $%.2f\n", impuesto);  // Muestra el valor del IGV.
        System.out.printf("Total: $%.2f\n", total);  // Muestra el total a pagar.
        System.out.println("Gracias por su compra! ___vuelva pronto___");  // Agradecimiento final.

        scanner.close();  // Cierra el Scanner para liberar los recursos.
    }
}
