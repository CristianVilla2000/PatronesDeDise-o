import java.util.ArrayList;
import java.util.List;

public class Ejercicio3 {

    static class Cliente {

        private String nombre;
        private MediatorSala mediatorSala;

        Cliente(String nombre, MediatorSala mediatorSala) {
            this.nombre = nombre;
            this.mediatorSala = mediatorSala;
        }

        public void enviarMensaje(String mensaje) {
            this.mediatorSala.enviarMensaje(mensaje, this);
        }

        public void recibirMensaje(String mensaje) {
            System.out.println(nombre + " recibe > " + mensaje);
        }

        public String getNombre() {
            return nombre;
        }
    }

    interface MediatorSala {
        void enviarMensaje(String mensaje, Cliente emisor);
        void agregarCliente(Cliente c);
        void eliminarCliente(Cliente c);
    }

    static class ConcreteChat implements MediatorSala {

        private List<Cliente> listaClientes = new ArrayList<>();

        @Override
        public void enviarMensaje(String mensaje, Cliente emisor) {
            for (Cliente cliente : listaClientes) {
                if (cliente != emisor) {
                    cliente.recibirMensaje(emisor.getNombre() + ": " + mensaje);
                }
            }
        }

        @Override
        public void agregarCliente(Cliente c) {
            listaClientes.add(c);
        }

        @Override
        public void eliminarCliente(Cliente c) {
            listaClientes.remove(c);
        }
    }

    public static void main(String[] args) {
        MediatorSala sala = new ConcreteChat();

        Cliente cliente1 = new Cliente("Cristian", sala);
        Cliente cliente2 = new Cliente("Julian", sala);
        Cliente cliente3 = new Cliente("Marta", sala);

        sala.agregarCliente(cliente1);
        sala.agregarCliente(cliente2);
        sala.agregarCliente(cliente3);

        cliente1.enviarMensaje("hola");

        System.out.println("Julian ha sido eliminado de la sala!");
        sala.eliminarCliente(cliente2);

        cliente3.enviarMensaje("eliminamos a Juian");
    }
}