package beans.helper;

import beans.model.Colonia;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

//Esta es una clase intermediaria que es como el puente para interactuar informacion desde una base de datos o otros.

@RequestScoped //Alcance
@Named//Para que se reconozca como beans
public class ColoniaHelper {

    public List<Colonia> getColonias() {
        List<Colonia> colonias = new ArrayList<>();
        //En java queremos poner el valor de "03810" pero como hay un 0 por delante java lo toma
        //Como un valor octal entonces debemos poner solo "3810"
        Colonia colonia = new Colonia(1, "Napoles", 3810);
        //Agregamos el obejto colonia a la lista 
        colonias.add(colonia);

        colonia = new Colonia(2, "Polanco", 11530);
        colonias.add(colonia);

        colonia = new Colonia(3, "Del valle Centro", 3100);
        colonias.add(colonia);

        return colonias;
    }

    //Definimos este metodo para encontrar una colonia por nombre 
    public int getColoniaIdPorNombre(String nombre) {
        int coloniaId = 0;
        List<Colonia> colonias = this.getColonias();

        for (Colonia colonia : colonias) {
            if (colonia.getNombreColonia().equals(nombre)) {
                coloniaId = colonia.getColoniaId();
                break;
            }
        }
        return coloniaId;
    }

    //Definimos este metodo para encontrar una colonia por codigo postal
    public int getColoniaIdPorCP(int codigoPostal) {
        int coloniaId = 0;
        List<Colonia> colonias = this.getColonias();
        for (Colonia colonia : colonias) {
            if (colonia.getCodigoPostal() == codigoPostal) {
                coloniaId = colonia.getColoniaId();
                break;
            }
        }
        return coloniaId;
    }

    //Agregamos un metodo mas para recuperar el Obejto de colonia, pero 
    //lo convertimos de tipo SelectItem para mandarlo al index.xhtml
    public List<SelectItem> getSelectItems() {
        List<SelectItem> selectItems = new ArrayList<>();
        List<Colonia> colonias = this.getColonias();
        for (Colonia colonia : colonias) {
            SelectItem selectItem = new SelectItem(colonia.getColoniaId(),
                    colonia.getNombreColonia());
            selectItems.add(selectItem);
        }
        return selectItems;
    }
}
