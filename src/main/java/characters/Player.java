package characters;

import javax.swing.ImageIcon;

/**
 * Класс, представляющий игрока или противника.
 */
public class Player {

    private int level;
    private int health;
    private int maxHealth;
    private int damage;
    private int attack;
    private ImageIcon icon;
    private boolean isStunned;
    private boolean isBoss = false;

    /**
     * Конструктор для создания игрока или противника.
     *
     * @param level   уровень
     * @param health  здоровье
     * @param damage  урон
     * @param attack  атака
     * @param icon    иконка
     */
    public Player(int level, int health, int damage, int attack, ImageIcon icon) {
        this.level = level;
        this.health = health;
        this.damage = damage;
        this.attack = attack;
        this.maxHealth = health;
        this.icon = icon;
    }

    /**
     * Возвращает имя игрока или противника.
     *
     * @return имя игрока или противника
     */
    public String getName() {
        return "";
    }

    // Getters and Setters
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    public boolean isStunned() {
        return isStunned;
    }

    public void setStunned(boolean stunned) {
        isStunned = stunned;
    }

    public boolean isBoss() {
        return isBoss;
    }

    public void setBoss(boolean boss) {
        isBoss = boss;
    }
}
