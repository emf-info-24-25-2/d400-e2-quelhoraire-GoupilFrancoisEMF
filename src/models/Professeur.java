package models;

public class Professeur {
    private String nom;
    private String prenom;
    private ModuleInfo[] modulesEnseignes;

    public Professeur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.modulesEnseignes = new ModuleInfo[0];
    }

    public boolean enseigneCeModule(String nomDuModule) {
        boolean reponse = false;
        for (int i = 0; i < modulesEnseignes.length; i++) {
            if (modulesEnseignes[i].getNom() == nomDuModule) {
                reponse = true;
                break;
            }
        }
        return reponse;
    }

    public void ajouterModuleEnseigne(ModuleInfo module) {
        ModuleInfo[] moduleEnseignes2 = new ModuleInfo[modulesEnseignes.length + 1];
        for (int i = 0; i < modulesEnseignes.length; i++) {
            moduleEnseignes2[i] = modulesEnseignes[i];
        }
        moduleEnseignes2[moduleEnseignes2.length - 1] = module;
        modulesEnseignes = moduleEnseignes2;
    }

    public void viderModules() {
        for (int i = 0; i < modulesEnseignes.length; i++) {
            modulesEnseignes[i] = null;
        }
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public ModuleInfo[] getModulesEnseignes() {
        return modulesEnseignes;
    }

    @Override
    public String toString() {
        return prenom + " " + nom.toUpperCase();
    }

}
