package models;

public class Horaire {
    public static final int NBRE_DE_BLOCS = 6;
    private Bloc[] blocs;

    public Horaire() {
        this.blocs = new Bloc[NBRE_DE_BLOCS];
        blocs[0] = new Bloc("B1S1");
        blocs[1] = new Bloc("B2S1");
        blocs[2] = new Bloc("B3S1");
        blocs[3] = new Bloc("B4S2");
        blocs[4] = new Bloc("B5S2");
        blocs[5] = new Bloc("B6S2");
    }

    public boolean plannifier(ModuleInfo[] modules, Professeur[] profs) {
        boolean reussi = false;

        for (int i = 0; i < modules.length; i++) {
            for (int a = 0; a < profs.length; a++) {
                if (profs[a].enseigneCeModule(modules[i].getNom())) {
                    profs[a].ajouterModuleEnseigne(modules[i]);
                    break;
                }
            }

        }
        for (int i = 0; i < blocs.length; i++) {
            for (int j = 0; j < profs.length; j++) {
                blocs[i].plannifierModule(modules[j]);
            }    
        }
        return reussi;
    }

    public void afficherHoraire() {
        for (int i = 0; i < blocs.length; i++) {
            blocs[i].afficherHoraire();
        }
    }

    public Bloc[] getBlocs() {
        return blocs;
    }

    public Bloc moduleDansQuelBloc(ModuleInfo module) {
        Bloc blocReponse = null;

        for (int i = 0; i < blocs.length; i++) {
            if (blocs[i].contientModule(module)) {
                blocReponse = blocs[i];
                break;
            }
        }
        return blocReponse;
    }
}
