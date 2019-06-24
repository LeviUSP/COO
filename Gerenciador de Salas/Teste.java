import java.time.LocalDateTime;

public class Teste {
    public static void main (String[] args){
        GerenciadorDeSalas gerenciador = GerenciadorDeSalas.getGerenciadorDeSalas();



        Sala sala = new Sala("Azul", "Na cantina", 200, "Um dos auditorios");
        gerenciador.adicionaSala(sala);
        
        
        Reserva reserva1 = gerenciador.reservaSalaChamada("Azul", LocalDateTime.of(2019, 6, 3, 15, 0, 0), LocalDateTime.of(2019, 6, 3, 16, 0, 0));
        Reserva reserva2 = gerenciador.reservaSalaChamada("Azul", LocalDateTime.of(2019, 7, 3, 15, 0, 0), LocalDateTime.of(2019, 8, 3, 16, 0, 0));
        

        gerenciador.imprimeReservasDaSala(sala);

    }
}