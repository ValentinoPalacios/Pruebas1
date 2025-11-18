
package ec.espe.edu.jsonfiles.controller;

/**
 *
 * @author Paulo Ramos
 */


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.jsonfiles.model.Doll;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DollController {
    private ArrayList<Doll> dolls = new ArrayList<>();

    public boolean addDoll(Doll doll) {
        for (Doll d : dolls) {
            if (d.getId() == doll.getId()) {
                System.out.println("Error: ID " + doll.getId() + " already exists.");
                return false;
            }
        }
        dolls.add(doll);
        return true;
    }

    public void displayDolls() {
        if (dolls.isEmpty()) {
            System.out.println("No dolls available.");
        } else {
            System.out.println("\n--- All Dolls ---");
            for (Doll d : dolls) {
                System.out.println(d);
            }
        }
    }

    public void saveToJson(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            new Gson().toJson(dolls, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadFromJson(String filename) {
        try (FileReader reader = new FileReader(filename)) {
            Type listType = new TypeToken<ArrayList<Doll>>() {}.getType();
            dolls = new Gson().fromJson(reader, listType);
            if (dolls == null) dolls = new ArrayList<>();
        } catch (Exception e) {
            dolls = new ArrayList<>();
        }
    }

    public ArrayList<Doll> getDolls() {
        return dolls;
    }
}

