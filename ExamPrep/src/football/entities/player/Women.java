package football.entities.player;

public class Women extends  BasePlayer{
    private static double KG =60.0;

    public Women(String name, String nationality, int strength) {
        super(name, nationality, KG, strength);
    }

    @Override
    public void stimulation() {
        int newStrength= getStrength()+115;
        super.setStrength(newStrength);
    }
}
