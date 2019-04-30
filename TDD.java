import static org.junit.Assert.*;
import org.junit.Test;
import java.time.LocalDateTime;
import java.util.HashMap;

public class TDD{
    @Test
    public void horariosIncompativeis(){
        HashMap<String, Participante> participantes = new HashMap<>();
        Participante p1 = new Participante();
        p1.setEmail("carlos@usp.br");
        p1.adicionaIntervalo(LocalDateTime.of(2019, 4, 18, 9, 30), LocalDateTime.of(2019, 4, 20, 12, 30));
        participantes.put(p1.getEmail(), p1);

        Participante p2 = new Participante();
        p2.setEmail("marcos@usp.br");
        p2.adicionaIntervalo(LocalDateTime.of(2019, 4, 5, 13, 30), LocalDateTime.of(2019, 4, 7, 14, 30));
        participantes.put(p2.getEmail(), p2);

        Participante p3 = new Participante();
        p3.setEmail("carlos@usp.br");
        p3.adicionaIntervalo(LocalDateTime.of(2019, 4, 3, 9, 30), LocalDateTime.of(2019, 4, 5, 12, 30));
        participantes.put(p3.getEmail(), p3);

        Interseccoes interseccao = new Interseccoes(participantes);
        interseccao.calcularInterseccoes(LocalDateTime.of(2019, 4, 1, 0, 0), LocalDateTime.of(2019, 4, 20, 23, 59), 0);
        assertEquals(0, interseccao.getInterseccoes().size());
    }

    @Test
    public void intervaloUnicoComum()
    {
        HashMap<String, Participante> participantes = new HashMap<>();
        Participante p1 = new Participante();
        p1.setEmail("carlos@usp.br");
        p1.adicionaIntervalo(LocalDateTime.of(2019, 5, 1, 10, 0), LocalDateTime.of(2019, 5, 3, 10, 0));
        participantes.put(p1.getEmail(), p1);

        Participante p2 = new Participante();
        p2.setEmail("marcos@usp.br");
        p2.adicionaIntervalo(LocalDateTime.of(2019, 5, 1, 10, 0), LocalDateTime.of(2019, 5, 2, 22, 0));
        participantes.put(p2.getEmail(), p2);

        Participante p3 = new Participante();
        p3.setEmail("daniel@usp.br");
        p3.adicionaIntervalo(LocalDateTime.of(2019, 5, 1, 8, 0), LocalDateTime.of(2019, 5, 1, 18, 0));
        participantes.put(p3.getEmail(), p3);

        Participante p4 = new Participante();
        p4.setEmail("marcelo@usp.br");
        p4.adicionaIntervalo(LocalDateTime.of(2019, 5, 1, 15, 0), LocalDateTime.of(2019, 5, 3, 23, 59));
        participantes.put(p4.getEmail(), p4);

        Interseccoes interseccao = new Interseccoes(participantes);
        
        interseccao.calcularInterseccoes(LocalDateTime.of(2019, 5, 1, 0, 0), LocalDateTime.of(2019, 5, 5, 23, 59), 0);

        assertTrue(interseccao.getInterseccoes().get(0).getInicio().isEqual(LocalDateTime.of(2019, 5, 1, 15, 0)));
        assertTrue(interseccao.getInterseccoes().get(0).getFim().isEqual(LocalDateTime.of(2019, 5, 1, 18, 0)));
    }

    @Test
    public void participanteSemIntervalo()
    {
        HashMap<String, Participante> participantes = new HashMap<>();
        Participante p1 = new Participante();
        p1.setEmail("carlos@usp.br");
        p1.adicionaIntervalo(LocalDateTime.of(2019, 5, 1, 10, 0), LocalDateTime.of(2019, 5, 3, 10, 0));
        participantes.put(p1.getEmail(), p1);

        Participante p2 = new Participante();
        p2.setEmail("marcos@usp.br");
        p2.adicionaIntervalo(LocalDateTime.of(2019, 5, 1, 10, 0), LocalDateTime.of(2019, 5, 2, 22, 0));
        participantes.put(p2.getEmail(), p2);

        Participante p3 = new Participante();
        p3.setEmail("daniel.medanota@usp.br");
        participantes.put(p3.getEmail(), p3);

        Participante p4 = new Participante();
        p4.setEmail("marcelo@usp.br");
        p4.adicionaIntervalo(LocalDateTime.of(2019, 5, 1, 15, 0), LocalDateTime.of(2019, 5, 3, 23, 59));
        participantes.put(p4.getEmail(), p4);

        Interseccoes interseccao = new Interseccoes(participantes);
        
        interseccao.calcularInterseccoes(LocalDateTime.of(2019, 5, 1, 0, 0), LocalDateTime.of(2019, 5, 5, 23, 59), 0);

        assertEquals(0, interseccao.getInterseccoes().size());
    }

    @Test
    public void doisIntervalosEmComum()
    {
        HashMap<String, Participante> participantes = new HashMap<>();
        Participante p1 = new Participante();
        p1.setEmail("carlos@usp.br");
        p1.adicionaIntervalo(LocalDateTime.of(2019, 5, 1, 10, 0), LocalDateTime.of(2019, 5, 3, 10, 0));
        participantes.put(p1.getEmail(), p1);

        Participante p2 = new Participante();
        p2.setEmail("marcos@usp.br");
        p2.adicionaIntervalo(LocalDateTime.of(2019, 5, 1, 10, 0), LocalDateTime.of(2019, 5, 2, 22, 0));
        participantes.put(p2.getEmail(), p2);

        Participante p3 = new Participante();
        p3.setEmail("daniel@usp.br");
        p3.adicionaIntervalo(LocalDateTime.of(2019, 5, 1, 8, 0), LocalDateTime.of(2019, 5, 1, 18, 0));
        p3.adicionaIntervalo(LocalDateTime.of(2019, 5, 2, 12, 0), LocalDateTime.of(2019, 5, 2, 22, 0));
        participantes.put(p3.getEmail(), p3);

        Participante p4 = new Participante();
        p4.setEmail("marcelo@usp.br");
        p4.adicionaIntervalo(LocalDateTime.of(2019, 5, 1, 15, 0), LocalDateTime.of(2019, 5, 3, 23, 59));
        p4.adicionaIntervalo(LocalDateTime.of(2019, 5, 4, 12, 0), LocalDateTime.of(2019, 5, 5, 22, 00));
        participantes.put(p4.getEmail(), p4);

        Interseccoes interseccao = new Interseccoes(participantes);
        
        interseccao.calcularInterseccoes(LocalDateTime.of(2019, 5, 1, 0, 0), LocalDateTime.of(2019, 5, 5, 23, 59), 0);

        assertEquals(2, interseccao.getInterseccoes().size());

        //primeira intersseccao
        assertTrue(interseccao.getInterseccoes().get(0).getInicio().isEqual(LocalDateTime.of(2019, 5, 1, 15, 0)));
        assertTrue(interseccao.getInterseccoes().get(0).getFim().isEqual(LocalDateTime.of(2019, 5, 1, 18, 0)));

        //segunda interseccao
        assertTrue(interseccao.getInterseccoes().get(1).getInicio().isEqual(LocalDateTime.of(2019, 5, 2, 12, 0)));
        assertTrue(interseccao.getInterseccoes().get(1).getFim().isEqual(LocalDateTime.of(2019, 5, 2, 22, 0)));
    }

    @Test
    public void funcionaSetEmail(){
        Participante participante = new Participante();
        participante.setEmail("Daniel....");
        assertEquals(null, participante.getEmail());
    }

}