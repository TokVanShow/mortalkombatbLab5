
package game.lab5;


public class LiuKangFabric implements EnemyFabricInterface {

    @Override
    public Player create(int i) {
        Player enemy;
        enemy = new LiuKang(1, 70, 20, 1);
        return enemy;
    }
}
