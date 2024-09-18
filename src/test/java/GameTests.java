import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Game;
import ru.netology.NotRegisteredException;
import ru.netology.Player;

public class GameTests {

    @Test
    public void TheFirstPlayerWins() {
        Player vika = new Player(123, "Вика", 100);
        Player nika = new Player(132, "Ника", 98);

        Game game = new Game();

        game.register(vika);
        game.register(nika);

        int actual = game.round("Вика", "Ника");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TheSecondPlayerWins() {
        Player vika = new Player(1, "Вика", 30);
        Player nika = new Player(2, "Ника", 98);

        Game game = new Game();

        game.register(vika);
        game.register(nika);

        int actual = game.round("Вика", "Ника");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ThePlayersEqual() {
        Player vika = new Player(1, "Вика", 30);
        Player nika = new Player(2, "Ника", 30);

        Game game = new Game();

        game.register(vika);
        game.register(nika);

        int actual = game.round("Вика", "Ника");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void FirstPlayerDoesNotExist() {
        Player vika = new Player(1, "Вика", 30);

        Game game = new Game();

        game.register(vika);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Ника", "Вика")
        );
    }

    @Test
    public void SecondPlayerDoesNotExist() {
        Player vika = new Player(1, "Вика", 30);

        Game game = new Game();

        game.register(vika);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Вика", "Ника")
        );
    }
}
