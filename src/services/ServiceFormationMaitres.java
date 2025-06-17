package services;

import models.ModuleInfo;
import models.Professeur;

public class ServiceFormationMaitres {
    public static void attribuerModules(Professeur[] professeurs, ModuleInfo[] modules) {
        boolean moduleAAtrribuerTrouver = false;

        while (moduleAAtrribuerTrouver = !true) {
            int nbre = (int) (Math.random() * (modules.length - 0 + 1)) + 0;
            String moduleAAttribuer = modules[nbre].getNom();
            for (int i = 0; i < professeurs.length; i++) {
                if (professeurs[i].enseigneCeModule(moduleAAttribuer)) {
                    break;
                }
                if (i == professeurs.length) {
                    moduleAAtrribuerTrouver = true;
                    professeurs[i].ajouterModuleEnseigne(modules[nbre]);
                    break;
                }
            }
        }
    }

    public static boolean tousModulesCouverts(Professeur[] profs, ModuleInfo[] modules) {
        boolean resultat = false;

        for (int i = 0; i < modules.length; i++) {
            if (modules[i].getProfesseur().equals(null)) {
                break;
            }
            if (i == modules.length) {
                resultat = true;
            }
        }
        return resultat;
    }

}
