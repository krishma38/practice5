package cpen221practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class DnDCharacter {

    private int Strength;
    private int Dexterity;
    private int Constitution;
    private int Intelligence;
    private int Wisdom;
    private int Charisma;

    DnDCharacter(){
      this.Strength = ability();
      this.Dexterity = ability();
      this.Constitution = ability();
      this.Intelligence = ability();
      this.Wisdom = ability();
      this.Charisma = ability();
    }


    int ability() {

        Random rand = new Random();
        int NumRolls = 4;
        int RollValue = 0;
        int maxDie = 6;
        int minDie = 1;
        List<Integer> values = new ArrayList<>();


        int minIndex = 0;
        int bound = (maxDie - minDie) + 1;

        for(int i = 0; i < NumRolls; i++){

            Integer r = rand.nextInt(bound) + minDie;
            values.add(r);
        }

        int min = values.get(0);
        for( int j = 0; j < NumRolls; j++){
            if( values.get(j) <= min) {
                min = values.get(j);
                minIndex = j;
            }
        }

        values.remove(minIndex);

        for(int i = 0; i < NumRolls - 1; i++) {
            RollValue += values.get(i);
        }
        return RollValue;

    }

    int modifier(int input) {

     double modifierFactor = (((double)input - 10.0)/2.0);
     double rounded;

     if(modifierFactor < 0){
         modifierFactor = modifierFactor * -1;
         rounded = Math.round(modifierFactor);
         rounded = rounded * -1;
     }
     else {
         rounded = (int) modifierFactor;

     }

        return (int)rounded;
    }

    int getStrength() {
     return Strength;
    }

    int getDexterity() {
        return Dexterity;
    }

    int getConstitution() {
        return Constitution;
    }

    int getIntelligence() {
        return Intelligence;
    }

    int getWisdom() {
        return Wisdom;
    }

    int getCharisma() {
        return Charisma;
    }

    int getHitpoints() {

        int Hitpoints =  10 + modifier(Constitution);

      return Hitpoints;
    }

}
