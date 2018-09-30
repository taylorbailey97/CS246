package prove02;

import java.awt.*;
import java.util.Random;

public class Wolf extends Creature implements Movable, Aware, Aggressor, Spawner {
    Random rand = new Random();
    int _direction;
    Boolean hasKilled = false;
    Boolean hasSpawned = true;

    public Wolf() {
        _health = 1;
    }

    public void attack(Creature target) {
        if (target instanceof Animal) {
            target.takeDamage(5);
            if (target._health < 1) {
                hasKilled = true;
            }
        }
    }

    public Boolean isAlive() { return _health > 0; }

    public Color getColor() { return new Color(127, 130, 132); }

    public Shape getShape() { return Shape.Square; }


    public void move() {
        switch (_direction = rand.nextInt(4)) {
            case 0:
                _location.y++;
                break;
            case 1:
                _location.x++;
                break;
            case 2:
                _location.y--;
                break;
            case 3:
                _location.x--;
                break;
            default:
                break;
        }
    }


    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {

        switch (_direction) {
            //if going in an upward direction check up first
            case 0:
                if (above instanceof Animal) {
                    _location.y++;
                } else if (right instanceof Animal) {
                    _location.x++;
                } else if (below instanceof Animal) {
                    _location.y--;
                } else if (left instanceof Animal) {
                    _location.x--;
                }
                break;
            //if going in an right direction check right first
            case 1:
                if (right instanceof Animal) {
                    _location.x++;
                } else if (below instanceof Animal) {
                    _location.y--;
                } else if (left instanceof Animal) {
                    _location.x--;
                } else if (above instanceof Animal) {
                    _location.y++;
                }
                break;
            //if going in an downward direction check down first
            case 2:
                if (below instanceof Animal) {
                    _location.y--;
                } else if (left instanceof Animal) {
                    _location.x--;
                } else if (above instanceof Animal) {
                    _location.y++;
                } else if (right instanceof Animal) {
                    _location.x++;
                }
                break;
            //if going in an left direction check left first
            case 3:
                if (left instanceof Animal) {
                    _location.x--;
                } else if (above instanceof Animal) {
                    _location.y++;
                } else if (right instanceof Animal) {
                    _location.x++;
                } else if (below instanceof Animal) {
                    _location.y--;
                }
                break;
            default:
                break;
        }
    }

    /************************************
     * Method: spawn new creature
     * When this is called it creates a new wolf
     * and returns that wolf from one cell to the
     * left of the current wolf
     ****************************************/
    public Creature spawnNewCreature() {
        hasSpawned = false;
        Wolf w = new Wolf();
        w._location.x = this.getLocation().x--;
        return w;
    }

    /************************************
     * Method: hasKilled
     * Checks to see if the current wolf
     * has killed an animal yet
     ***************************************/
    public Boolean hasKilled() {
        return hasKilled;
    }

    /************************************
     * Method: hasSpawned
     * Checks to see if current wolf has
     * already spawned another wolf
     ****************************************/
    public Boolean hasSpawned() {
        return hasSpawned;
    }



}
