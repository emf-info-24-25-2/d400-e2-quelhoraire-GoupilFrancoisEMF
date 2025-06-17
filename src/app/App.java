package app;

import models.Horaire;
import models.ModuleInfo;
import models.Professeur;
import services.ServiceFormationMaitres;
import models.Bloc;

public class App {

    public static final String[] NOMS_MODULES = {"G300","187","162","123","293","117","164","216","106", "231","122","431"};

    public static void main(String[] args) {
        Horaire horaire = new Horaire();
        ModuleInfo[] modules1ere = new ModuleInfo[12];
        for (int i = 0; i < modules1ere.length; i++) {
            modules1ere[i] = new ModuleInfo(NOMS_MODULES[i]);
        }
        Professeur[] profs = new Professeur[5];
        profs[0] = new Professeur("Ronaldo", "Christiano");
        profs[1] = new Professeur("Muriset", "Philippe");
        profs[2] = new Professeur("Berset", "Alain");
        profs[3] = new Professeur("Federrer", "Roger");
        profs[4] = new Professeur("Roosvelt", "Teddy");

        while (!ServiceFormationMaitres.tousModulesCouverts(profs, modules1ere)) {
            ServiceFormationMaitres.attribuerModules(profs, modules1ere);
            ServiceFormationMaitres.tousModulesCouverts(profs, modules1ere);
        }
        System.out.println("L'école a engagé les professeurs suivants");
        for (int i = 0; i < profs.length; i++) {
            System.out.println("- "+ profs[i].toString()+" peut enseigner les modules :");
            for (int j = 0; j < profs.length; j++) {
            System.out.println(profs[j].getModulesEnseignes());
            }
            System.out.println();
        }
        System.out.println("\nIl est temps de préparer l'horaire.\n");
        horaire.plannifier(modules1ere, profs);
        if(horaire.plannifier(modules1ere, profs)){
            System.out.println("Modules planifiés avec succès!");
            horaire.afficherHoraire();
        }


    }

}
