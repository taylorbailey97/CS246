package prove02;

import java.awt.Color;
import java.util.Random;

public class Zombie extends Creature implements Movable, Aggressor {
    Random _rand;

    public Zombie() {
        _rand = new Random();
        _health = 1;
    }
    public void move() {

        switch(_rand.nextInt(2)) {
            case 0:
                _location.x--;
                break;
            case 1:
                _location.x++;
                break;
            default:
                break;

        }
    }

    public void attack(Creature target) {
        if (target instanceof Animal) {
            target.takeDamage(10);
        }
    }

    public Shape getShape() { return Shape.Square; }

    public Color getColor() { return new Color(0, 122, 254); }

    public Boolean isAlive() { return _health >= 0; }
}
