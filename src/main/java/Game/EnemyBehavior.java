package Game;

import characters.Player;

/**
 * Интерфейс для поведения врага.
 */
public interface EnemyBehavior {
    /**
     * Метод для выполнения поведения врага.
     *
     * @param game  текущая игра
     * @param enemy текущий враг
     */
    void execute(Game game, Player enemy);
}
