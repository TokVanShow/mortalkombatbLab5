package characters;

import javax.swing.ImageIcon;

/**
 * Класс, представляющий врага Baraka.
 */
public class Baraka extends Player {

    /**
     * Конструктор для создания врага Baraka.
     *
     * @param level   уровень врага
     * @param health  здоровье врага
     * @param damage  урон врага
     * @param attack  атака врага
     * @param icon    иконка врага
     */
    public Baraka(int level, int health, int damage, int attack, ImageIcon icon) {
        super(level, health, damage, attack, icon);
    }

    /**
     * Возвращает имя врага.
     *
     * @return имя врага "Baraka"
     */
    @Override
    public String getName() {
        return "Baraka";
    }
}
