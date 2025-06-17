package models;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class Bloc {
    public static final int NBRE_DEMI_JOURS_SEMAINE = 10;
    private String nom;
    private ModuleInfo[] modules;

    public Bloc(String nom) {
        this.nom = nom;
        this.modules = new ModuleInfo[NBRE_DEMI_JOURS_SEMAINE];
        for (int i = 0; i < 4; i++) {
            if(modules[i]!=null){
            modules[i].setNom("Matu");
            }
        }
    }

    public boolean plannifierModule(ModuleInfo module) {
        boolean reussi = false;
        int nmbreDeDemiJourneeLibres = 0;

        for (int i = 0; i < modules.length; i++) {
            if (modules[i].equals(null)) {
                nmbreDeDemiJourneeLibres++;
                modules[i] = module;
                if (nmbreDeDemiJourneeLibres == 3) {
                    reussi = true;
                    break;
                }
            }
        }

        return reussi;
    }

    public void afficherHoraire() {
        for (int i = 0; i < modules.length; i++) {
            System.out.println(DayOfWeek.values()[i].getDisplayName(TextStyle.FULL, Locale.FRANCE));
        }

    }

    public boolean estTotalementPlanifie() {
        boolean estTotalementPlanifie = false;

        for (int i = 0; i < modules.length; i++) {
            if (modules.equals(null)) {
                break;
            }
            if (i == modules.length) {
                estTotalementPlanifie = true;
                break;
            }
        }

        return estTotalementPlanifie;
    }

    public boolean contientModule(ModuleInfo module) {
        boolean reponse = false;

        for (int i = 0; i < modules.length; i++) {
            if(modules[i] == module){
                reponse = true;
            }
        }

        return reponse;
    }

    public String getNom() {
        return nom;
    }

    public void setModules(ModuleInfo[] modules) {
        this.modules = modules;
    }

    @Override
    public String toString() {
        return nom;
    }

}
