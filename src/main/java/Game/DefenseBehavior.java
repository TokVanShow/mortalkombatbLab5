package Game;

import characters.Player;

/**
 * Конкретная стратегия для защиты врага.
 */
public class DefenseBehavior implements EnemyBehavior {
    /**
     * Выполняет защиту врага.
     *
     * @param game  текущая игра
     * @param enemy текущий враг
     */
    @Override
    public void execute(Game game, Player enemy) {
        game.setTurnResult(enemy.getName() + " defended");
    }
}
