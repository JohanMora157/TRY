import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Clase abstracta Persona
abstract class Persona {
    String nombre;
    int numero;

    public Persona(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public abstract void mostrarInformacion();  // Método abstracto
}

// Clase Empleado
class Empleado extends Persona {
    String puesto;
    double salario;
    int aniosDeServicio;

    public Empleado(String nombre, int numero, String puesto, double salario, int aniosDeServicio) {
        super(nombre, numero);
        this.puesto = puesto;
        this.salario = salario;
        this.aniosDeServicio = aniosDeServicio;
    }

    public int calcularDiasVacaciones() {
        int diasVacaciones = 5 + (aniosDeServicio - 1) * 2;
        return Math.min(diasVacaciones, 20);  // Máximo de 20 días
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Empleado: " + nombre + " | Puesto: " + puesto + " | Días de vacaciones: " + calcularDiasVacaciones());
    }
}

// Clase Cliente
class Cliente extends Persona {
    CuentaBancaria cuenta;

    public Cliente(String nombre, int numero, CuentaBancaria cuenta) {
        super(nombre, numero);
        this.cuenta = cuenta;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Cliente: " + nombre + " | Tipo de cuenta: " + cuenta.getTipoCuenta() + " | Saldo: " + cuenta.saldo);
    }
}

// Clase abstracta CuentaBancaria
abstract class CuentaBancaria {
    double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public abstract void depositar(double cantidad);
    public abstract void retirar(double cantidad);
    public abstract String getTipoCuenta();
}

// Clase CuentaAhorro
class CuentaAhorro extends CuentaBancaria {
    double porcentajeInteresAnual;

    public CuentaAhorro(double saldoInicial, double porcentajeInteresAnual) {
        super(saldoInicial);
        this.porcentajeInteresAnual = porcentajeInteresAnual;
        if (saldoInicial < 1000) {
            throw new IllegalArgumentException("El saldo inicial debe ser al menos 1000");
        }
    }

    @Override
    public void depositar(double cantidad) {
        saldo += cantidad;
    }

    @Override
    public void retirar(double cantidad) {
        if (saldo - cantidad < 500) {
            System.out.println("No puedes dejar la cuenta con menos de $500.");
        } else {
            saldo -= cantidad;
        }
    }

    @Override
    public String getTipoCuenta() {
        return "Cuenta de Ahorro";
    }
}

// Clase CuentaInversion
class CuentaInversion extends CuentaBancaria {
    public CuentaInversion(double saldoInicial) {
        super(saldoInicial);
        if (saldoInicial < 25000) {
            throw new IllegalArgumentException("El saldo inicial debe ser al menos 25000");
        }
    }

    @Override
    public void depositar(double cantidad) {
        saldo += cantidad;
    }

    @Override
    public void retirar(double cantidad) {
        if (saldo - cantidad < 10000) {
            System.out.println("No puedes dejar la cuenta con menos de $10000.");
        } else {
            saldo -= cantidad;
        }
    }

    @Override
    public String getTipoCuenta() {
        return "Cuenta de Inversión";
    }
}

// Clase Banco
class Banco {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Empleado> empleados = new ArrayList<>();

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }
}

// Clase principal para el menú
public class BancoApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco bancoquete = new Banco();

        while (true) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Agregar Empleado");
            System.out.println("3. Mostrar Información de Clientes");
            System.out.println("4. Realizar Depósito");
            System.out.println("5. Realizar Retiro");
            System.out.println("6. Calcular Días de Vacaciones de Empleado");
            System.out.println("0. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese nombre del cliente:");
                    String nombreCliente = scanner.nextLine();
                    System.out.println("Ingrese número del cliente:");
                    int numeroCliente = scanner.nextInt();
                    System.out.println("Ingrese saldo inicial de la cuenta de ahorro:");
                    double saldoAhorro = scanner.nextDouble();
                    Cliente cliente = new Cliente(nombreCliente, numeroCliente, new CuentaAhorro(saldoAhorro, 5.0));
                    bancoquete.agregarCliente(cliente);
                    break;

                case 2:
                    System.out.println("Ingrese nombre del empleado:");
                    String nombreEmpleado = scanner.nextLine();
                    System.out.println("Ingrese número del empleado:");
                    int numeroEmpleado = scanner.nextInt();
                    System.out.println("Ingrese puesto del empleado:");
                    String puesto = scanner.next();
                    System.out.println("Ingrese salario del empleado:");
                    double salario = scanner.nextDouble();
                    System.out.println("Ingrese años de servicio del empleado:");
                    int aniosServicio = scanner.nextInt();
                    Empleado empleado = new Empleado(nombreEmpleado, numeroEmpleado, puesto, salario, aniosServicio);
                    bancoquete.agregarEmpleado(empleado);
                    break;

                case 3:
                    for (Cliente c : bancoquete.getClientes()) {
                        c.mostrarInformacion();
                    }
                    break;

                case 4:
                    System.out.println("Ingrese número del cliente para depósito:");
                    int numeroClienteDeposito = scanner.nextInt();
                    System.out.println("Ingrese monto a depositar:");
                    double montoDeposito = scanner.nextDouble();
                    for (Cliente c : bancoquete.getClientes()) {
                        if (c.numero == numeroClienteDeposito) {
                            c.cuenta.depositar(montoDeposito);
                            System.out.println("Depósito realizado.");
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("Ingrese número del cliente para retiro:");
                    int numeroClienteRetiro = scanner.nextInt();
                    System.out.println("Ingrese monto a retirar:");
                    double montoRetiro = scanner.nextDouble();
                    for (Cliente c : bancoquete.getClientes()) {
                        if (c.numero == numeroClienteRetiro) {
                            c.cuenta.retirar(montoRetiro);
                            System.out.println("Retiro realizado.");
                            break;
                        }
                    }
                    break;

                case 6:
                    System.out.println("Ingrese número del empleado para calcular vacaciones:");
                    int numeroEmpleadoVacaciones = scanner.nextInt();
                    for (Empleado e : bancoquete.getEmpleados()) {
                        if (e.numero == numeroEmpleadoVacaciones) {
                            System.out.println("Días de vacaciones: " + e.calcularDiasVacaciones());
                            break;
                        }
                    }
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }
}
