package football.entities.player;

public class Men extends BasePlayer{
    private static final double KG =85.50;
    public Men(String name, String nationality, int strength) {
        super(name, nationality, KG, strength);
    }


    @Override
    public void stimulation() {

            int newStrength= getStrength()+145;
            super.setStrength(newStrength);

    }
}
