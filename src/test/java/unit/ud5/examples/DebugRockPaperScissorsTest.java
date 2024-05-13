package unit.ud5.examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ud5.examples.DebugRockPaperScissors;

import static org.junit.jupiter.api.Assertions.*;

class DebugRockPaperScissorsTest {
    @Test
    void givenPaperVsPaper_shouldEmpat(){
        Assertions.assertEquals(1, DebugRockPaperScissors.guanya("paper", "paper"));
    }

    @Test
    void givenRockVsRock_shouldEmpat(){
        assertEquals(0, DebugRockPaperScissors.guanya("pedra", "pedra"));
    }

    @Test
    void givenTisoresVsTisores_shouldEmpat(){
        assertEquals(0, DebugRockPaperScissors.guanya("tisores", "tisores"));
    }

    @Test
    void givenPaperVsPedra_shouldWinJugador1(){
        assertEquals(1, DebugRockPaperScissors.guanya("paper", "pedra"));
    }
    @Test
    void givenPedraVsTisores_shouldWinJugador1(){
        assertEquals(1, DebugRockPaperScissors.guanya("pedra", "tisores"));
    }
    @Test
    void givenTisoresVsPaper_shouldWinJugador1(){
        assertEquals(1, DebugRockPaperScissors.guanya("tisores", "paper"));
    }

    @Test
    void givenPaperVsTisores_shouldWinJugador2(){
        assertEquals(2, DebugRockPaperScissors.guanya("paper", "tisores"));
    }
    @Test
    void givenPedraVsPaper_shouldWinJugador2(){
        assertEquals(2, DebugRockPaperScissors.guanya("pedra", "paper"));
    }
    @Test
    void givenTisoresVsPedra_shouldWinJugador2(){
        assertEquals(2, DebugRockPaperScissors.guanya("tisores", "pedra"));
    }
}