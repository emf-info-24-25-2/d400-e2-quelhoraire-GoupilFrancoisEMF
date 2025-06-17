package models;

public class ModuleInfo {
    private String nom;
    private Professeur[] professeur;

    public ModuleInfo(String nom) {
        this.nom = nom;
        this.professeur = new Professeur[0];
    }

    public String getNom() {
        return nom;
    }

    public Professeur[] getProfesseur() {
        return professeur;
    }

    

    public void setProfesseur(Professeur[] professeur) {
        this.professeur = professeur;
    }

    @Override
    public String toString() {
        String reponse = null;
        for (int i = 0; i < professeur.length; i++) {
            if (professeur[i].equals(null)) {
                reponse = nom;
                break;
            }
            if (i == professeur.length) {
                reponse = nom + "avec " + professeur[i].getPrenom() + " " + professeur[i] + getNom();
            }
        }
        return reponse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
