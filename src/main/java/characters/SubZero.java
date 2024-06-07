package characters;

import javax.swing.ImageIcon;

/**
 * Класс, представляющий врага Sub-Zero.
 */
public class SubZero extends Player {

    /**
     * Конструктор для создания врага Sub-Zero.
     *
     * @param level   уровень врага
     * @param health  здоровье врага
     * @param damage  урон врага
     * @param attack  атака врага
     * @param icon    иконка врага
     */
    public SubZero(int level, int health, int damage, int attack, ImageIcon icon) {
        super(level, health, damage, attack, icon);
    }

    /**
     * Возвращает имя врага.
     *
     * @return имя врага "Sub-Zero"
     */
    @Override
    public String getName() {
        return "Sub-Zero";
    }
}
