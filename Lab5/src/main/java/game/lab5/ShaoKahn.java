
package game.lab5;


public class ShaoKahn extends Player{
    
    public ShaoKahn(int level, int health, int  damage, int attack){
        super (level, health, damage, attack);
    }
    
    @Override
    public String getName(){
        return "Shao Kahn";
    }
}