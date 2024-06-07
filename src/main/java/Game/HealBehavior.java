package Game;

import characters.Player;

/**
 * Конкретная стратегия для лечения врага.
 */
public class HealBehavior implements EnemyBehavior {
    /**
     * Выполняет лечение врага.
     *
     * @param game  текущая игра
     * @param enemy текущий враг
     */
    @Override
    public void execute(Game game, Player enemy) {
        enemy.setHealth(enemy.getHealth() + (enemy.getMaxHealth() - enemy.getHealth()) / 2);
        game.setTurnResult(enemy.getName() + " are healing!");
    }
}
