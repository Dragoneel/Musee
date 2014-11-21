

package musee;

/**
 *
 * @author yirou
 */
public class Photo {
    String adresseImage;
    boolean valider;

    public Photo(String adresseImage, boolean valider) {
        this.adresseImage = adresseImage;
        this.valider = valider;
    }

    public boolean isValider() {
        return valider;
    }

    public void setValider(boolean valider) {
        this.valider = valider;
    }
   
    public String getAdresseImage() {
        return adresseImage;
    }

    public void setAdresseImage(String adresseImage) {
        this.adresseImage = adresseImage;
    }
    
}
