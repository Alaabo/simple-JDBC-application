public class books {
    private String auteur;
    private String titre;
    private int annee;

    public books(String auteur, String titre, int annee) {
        this.auteur = auteur;
        this.titre = titre;
        this.annee = annee;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
}
