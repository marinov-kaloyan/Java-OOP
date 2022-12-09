package football.core;


import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.player.repositories.SupplementRepository;
import football.entities.player.repositories.SupplementRepositoryImpl;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;

import java.util.*;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private SupplementRepository supplement;
    private Map<String, Field> fields;

    public ControllerImpl() {
        this.supplement = new SupplementRepositoryImpl();
        this.fields = new LinkedHashMap<>();

    }


    @Override
    public String addField(String fieldType, String fieldName) {
        Field field;
        if (fieldType.equals("ArtificialTurf")) {
            field = new ArtificialTurf(fieldName);
        } else if (fieldType.equals("NaturalGrass")) {
            field = new NaturalGrass(fieldName);
        } else {
            throw new NullPointerException(ExceptionMessages.INVALID_FIELD_TYPE);

        }
        fields.put(fieldName, field);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
    }

    @Override
    public String deliverySupplement(String type) {
        Supplement s;
        if (type.equals("Liquid")) {
            s = new Liquid();
        } else if (type.equals("Powdered")) {
            s = new Powdered();
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }
        supplement.add(s);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Supplement s = supplement.findByType(supplementType);
        if (s == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType));
        }
        Field field = fields.get(fieldName);
        field.addSupplement(s);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Player p;
        if (playerType.equals("Women")) {
            p = new Women(playerName, nationality, strength);
        } else if (playerType.equals("Men")) {
            p = new Men(playerName, nationality, strength);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
        }
        Field field = fields.get(fieldName);
        String output;
        if(!playerCanPlayOnFieldType(playerType,field)){

output =ConstantMessages.FIELD_NOT_SUITABLE;
        }
        else {
            field.addPlayer(p);
            output = String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
        }
        return output;
    }

    private boolean playerCanPlayOnFieldType(String playerType, Field field) {
        boolean canPlay= playerType.equals("Women")&&field.getClass().getSimpleName().equals("ArtificialTurf");

        if(!canPlay){
            canPlay= playerType.equals("Men")&&field.getClass().getSimpleName().equals("NaturalGrass");
        }
            return canPlay;
    }

    @Override
    public String dragPlayer(String fieldName) {
        Field field = fields.get(fieldName);
        field.drag();
        return String.format(ConstantMessages.PLAYER_DRAG,field.getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = fields.get(fieldName);
        int sum = field.getPlayers().stream().mapToInt(Player::getStrength).sum();
        return String.format(ConstantMessages.STRENGTH_FIELD,fieldName,sum);
    }

    @Override
    public String getStatistics() {

        return fields.values().stream().map(Field::getInfo).collect(Collectors.joining("\n"));
    }
}
