public class Ejercicio1 {

    static class Automovil{

        private String motor;
        private String color;
        private String llantas;
        private String sistemaSonido;
        private String interiores;
        private String techoSolar;
        private String navegacion;
        private String gps;

        public void mostrarDetalles(){
            System.out.println("Caracteristicas de su carro elegido");
            System.out.println("motor > " + motor);
            System.out.println("color > " + color);
            System.out.println("llantas > " + llantas);
            System.out.println("sistemaSonido > " + sistemaSonido);
            System.out.println("interiores > " + interiores);
            System.out.println("techoSolar > " + techoSolar);
            System.out.println("navegacion > " + navegacion);
            System.out.println("gps > " + gps);
        }
    }

    interface BuilderAutomovil {
        void reset();
        void setMotor(String motor);
        void setColor(String color);
        void setLlantas(String lLantas);
        void setSistemaSonido(String sistemaSonido);
        void setInteriores(String interiores);
        void setTechoSolar(String techoSolar);
        void setNavegacion(String navegacion);
        void setGPS(String GPS);
        Automovil obtenerAutomovil ();
    }

    static class BuilderAutomovilConcreto implements BuilderAutomovil {

        private Automovil automovil;

        BuilderAutomovilConcreto(){
            reset();
        }

        @Override
        public void reset() {
            automovil  = new Automovil();
        }

        @Override
        public void setMotor(String motor) {
            automovil.motor = motor;
        }

        @Override
        public void setColor(String color) {
            automovil.color = color;
        }

        @Override
        public void setLlantas(String lLantas) {
            automovil.llantas = lLantas;
        }

        @Override
        public void setSistemaSonido(String sistemaSonido) {
            automovil.sistemaSonido = sistemaSonido;
        }

        @Override
        public void setInteriores(String interiores) {
            automovil.interiores = interiores;
        }

        @Override
        public void setTechoSolar(String techoSolar) {
            automovil.techoSolar = techoSolar;
        }

        @Override
        public void setNavegacion(String navegacion) {
            automovil.navegacion = navegacion;
        }

        @Override
        public void setGPS(String GPS) {
            automovil.gps = GPS;
        }

        @Override
        public Automovil obtenerAutomovil() {
            Automovil resultado = automovil;
            reset();
            return resultado;
        }

    }

    static class Cliente {

        private String nombre;

        public void solicitarAutomovil(String motor, String color, String llantas, String sistemaSonido,
                                       String interiores,String techoSolar,String navegacion,String gps)
        {
            BuilderAutomovilConcreto builderAutomovilConcreto = new BuilderAutomovilConcreto();
            DirectorAutomotriz directorAutomotriz = new DirectorAutomotriz(builderAutomovilConcreto);
            directorAutomotriz.construirAutomovil(motor,color,llantas,sistemaSonido,interiores,techoSolar,navegacion,
                                                  gps);
            Automovil automovil = builderAutomovilConcreto.obtenerAutomovil();
            automovil.mostrarDetalles();
        }
    }

    static class DirectorAutomotriz {

        private BuilderAutomovil builderAutomovil;

        DirectorAutomotriz (BuilderAutomovil builderAutomovil) {
            this.builderAutomovil = builderAutomovil;
        }

        public void construirAutomovil(String motor, String color, String llantas, String sistemaSonido,
                                       String interiores,String techoSolar,String navegacion,String gps)
        {

            builderAutomovil.reset();
            builderAutomovil.setMotor(motor);
            builderAutomovil.setColor(color);
            builderAutomovil.setLlantas(llantas);
            builderAutomovil.setSistemaSonido(sistemaSonido);
            builderAutomovil.setInteriores(interiores);
            builderAutomovil.setTechoSolar(techoSolar);
            builderAutomovil.setNavegacion(navegacion);
            builderAutomovil.setGPS(gps);

        }
    }

    public static void main(String[] args) {
        Cliente c = new Cliente();
        c.solicitarAutomovil("V8",
                "Verde","mixtas",
                "Sony","Seda",
                "No","Digital",
                "No");
    }
}
