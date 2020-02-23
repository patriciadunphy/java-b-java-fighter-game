package org.program.fighter;

public class FighterController {
    private Fighter model;
    private FighterView view;

    public FighterController(Fighter model, FighterView view){
        this.model = model;
        this.view = view;
    }
//    public String getName(){
//        return model.getName();
//    }
//    public void switchFighter(Fighter model){
//        this.model = model;
//    }

//    public String getDefenceMethod(int chosenDefence){
//        return model.getDefences().get(chosenDefence);
//    }
//    public int getAttackMethod(int chosenAttack){
//        return model.getAttacks().get(chosenAttack).getDamage();
//    }
//
    public int getHp(){
        return model.getHp();
    }

    public int attack(int chosenAttack) {
        view.printFighterAttack(model.getName(), model.getAttacks().get(chosenAttack).getStrategyDescription());
        return model.attack(chosenAttack);
    }
    public void receiveAttack(int damage){
        model.receiveAttack(damage);
        view.printReceivedAttack(model.getName(), model.getHp());
    }
    public void defend(int chosenDefence){
        view.printDefence(model.getName(), model.getDefences().get(chosenDefence));
    }
}
