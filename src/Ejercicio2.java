public class Ejercicio2 {

    static abstract class AbstractionNotificacion {

        private ImplementationPlataforma implementationPlataforma;

        AbstractionNotificacion (ImplementationPlataforma implementationPlataforma) {
            this.implementationPlataforma = implementationPlataforma;
        }

        public void generarNotificacion (String mensaje) {
            this.implementationPlataforma.mostrarMensaje(mensaje);
        }
    }

    interface ImplementationPlataforma {

        void mostrarMensaje(String mensaje);

    }

    static class Mensaje extends AbstractionNotificacion {

        Mensaje(ImplementationPlataforma implementationPlataforma) {
            super(implementationPlataforma);

        }
    }

    static class Alerta extends AbstractionNotificacion {

        Alerta(ImplementationPlataforma implementationPlataforma) {

            super(implementationPlataforma);

        }
    }

    static class Advertencia extends AbstractionNotificacion {


        Advertencia(ImplementationPlataforma implementationPlataforma) {

            super(implementationPlataforma);

        }
    }

    static class Confirmacion extends AbstractionNotificacion {

        Confirmacion(ImplementationPlataforma implementationPlataforma) {

            super(implementationPlataforma);

        }
    }

    static class Web implements ImplementationPlataforma {

        @Override
        public void mostrarMensaje(String mensaje) {
            System.out.println("Plataforma : Web" );
            System.out.println("Mensaje : " +mensaje );
        }
    }

    static class Movil implements ImplementationPlataforma {

        @Override
        public void mostrarMensaje(String mensaje) {
            System.out.println("Plataforma : Movil" );
            System.out.println("Mensaje : " +mensaje );
        }
    }

    static class Escritorio implements ImplementationPlataforma {

        @Override
        public void mostrarMensaje(String mensaje) {
            System.out.println("Plataforma : Escritorio" );
            System.out.println("Mensaje : " +mensaje );
        }
    }

    static class Cliente {

        public void crearNotificacion (String mensaje) {
            ImplementationPlataforma implementationPlataforma = new Web();
            AbstractionNotificacion abstractionNotificacion = new Mensaje(implementationPlataforma);
            abstractionNotificacion.generarNotificacion(mensaje);

        }
    }

    public static void main(String[] args) {
        Cliente c = new Cliente();
        c.crearNotificacion("Tienes un notificacion de pago pendiente");
    }
}
