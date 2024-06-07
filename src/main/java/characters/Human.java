package characters;

import javax.swing.ImageIcon;

/**
 * Класс, представляющий игрока-человека.
 */
public class Human extends Player {

    private final int[] nextLevelExperience = {40, 90, 180, 260, 410, 1000, 100000};
    private int points;
    private int experience;
    private int nextExperience;

    /**
     * Конструктор для создания игрока-человека.
     *
     * @param level   уровень игрока
     * @param health  здоровье игрока
     * @param damage  урон игрока
     * @param attack  атака игрока
     * @param icon    иконка игрока
     */
    public Human(int level, int health, int damage, int attack, ImageIcon icon) {
        super(level, health, damage, attack, icon);
        this.points = 0;
        this.experience = 0;
        this.nextExperience = nextLevelExperience[0];
    }

    /**
     * Проверяет, достиг ли опыт игрока значения для перехода на следующий уровень,
     * и назначает новое значение параметру nextExperience в соответствии с полученным уровнем.
     *
     * @return true, если достиг нового уровня, false, если не достиг
     */
    public boolean checkNewLevel() {
        if (getExperience() >= getNextExperience()) {
            setLevel(getLevel() + 1);
            setNextExperience(nextLevelExperience[getLevel()]);
            return true;
        }
        return false;
    }

    /**
     * Метод, вызываемый при достижении игроком нового уровня, увеличивает выбранную игроком характеристику.
     *
     * @param chosenCharacteristic выбранная игроком характеристика (0 - здоровье, 1 - урон)
     */
    public void improveCharacteristic(int chosenCharacteristic) {
        if (chosenCharacteristic == 0) {
            setMaxHealth(getMaxHealth() + 20 + getLevel() * 5);
        } else if (chosenCharacteristic == 1) {
            setDamage(getDamage() + 3 + getLevel());
        }
        setHealth(getMaxHealth());
    }

    public int getPoints() {
        return this.points;
    }

    public int getExperience() {
        return this.experience;
    }

    public int getNextExperience() {
        return this.nextExperience;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setNextExperience(int nextExperience) {
        this.nextExperience = nextExperience;
    }

    @Override
    public String getName() {
        return "You";
    }
}
