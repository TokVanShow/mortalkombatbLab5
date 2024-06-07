package Game;

import characters.Player;

/**
 * Конкретная стратегия для атаки врага.
 */
public class AttackBehavior implements EnemyBehavior {
    /**
     * Выполняет атаку врага.
     *
     * @param game  текущая игра
     * @param enemy текущий враг
     */
    @Override
    public void execute(Game game, Player enemy) {
        Player human = game.getHuman();
        human.setHealth(human.getHealth() - enemy.getDamage());
        game.setTurnResult(enemy.getName() + " attacked");
    }
}
