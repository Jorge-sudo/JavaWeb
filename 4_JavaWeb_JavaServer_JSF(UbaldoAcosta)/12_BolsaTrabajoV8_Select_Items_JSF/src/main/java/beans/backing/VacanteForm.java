package beans.backing;

import beans.helper.ColoniaHelper;
import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named
@RequestScoped
public class VacanteForm {

    //Agregamos la inyeccion del objeto candidato del otro javaBean
    @Inject //Con esto podemos utilizar el obejeto de Candidato
    private Candidato candidato;

    private boolean comentarioEnviado;

    //Injectamos la clase ColoniaHelper para poder hacer las validaciones respectivas con los objetos de tipo colonia
    @Inject
    private ColoniaHelper coloniaHelper;

    Logger log = LogManager.getRootLogger();

    public VacanteForm() {
        log.info("Creando el Objeto VacanteForm");
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    //Haremos un reedireccionamiento a otra pagina
    public String enviar() {
        if (this.candidato.getNombre().equals("Juan")) {
            if (this.candidato.getApellido().equals("Perez")) {
                String msg = "Gracias, pero Juan Perez ya trabaja con nosotros.";
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
                FacesContext facesContext = FacesContext.getCurrentInstance();
                String componetId = null;//Este mensaje va ser de tipo global
                facesContext.addMessage(componetId, facesMessage);//La primera parte es null por que es global 
                return "index";
            }
            log.info("Entrando al caso de exito");
            /*Si el nombre es igual a juan y Es un exito entonces se redirigira a la pagina "exito.xhtml", pero 
            no es necesario que escribamos la extencion "xhtml"*/
            return "exito";
        } else {
            log.info("Entrando al caso de fallo");
            return "fallo";
        }
    }

    public void codigoPostalListener(ValueChangeEvent event) {

        //Con esto podremos acceder a cualquier componente de JavaServerFaces
        FacesContext facescontex = FacesContext.getCurrentInstance();
        UIViewRoot uiViewRoot = facescontex.getViewRoot();

        //Para acceder a los componentes de JSF necesitamos agregar un id a cada componente de nuestra pagina JSF
        //El metodo getNewValue nos regresa un valor de tipo Long, pero con intValue le pedimos que se convierta de tipo Int
        int nuevoCodigoPostal = ((Long) event.getNewValue()).intValue();

        //Si este codigo postal es igual entonces se cargara la ciudad y colonia del codigo postal correspondiente
        //nombreDelFormulario:idDelcampoQueQueremosAcceder
        UIInput coloniaIdInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:coloniaId");
        int coloniaId = this.coloniaHelper.getColoniaIdPorCP(nuevoCodigoPostal);
        //indicamos que si el codigo postal es 08310 la colonia es napolis
        coloniaIdInputText.setValue(coloniaId);
        //Debemos utilizar este metodo para que se refleje el valor en la pagina JSF
        coloniaIdInputText.setSubmittedValue(coloniaId);

        //Ahora hacemos lo mismo para el campo de la ciudad  nombreDelFormulario:idDelcampoQueQueremosAcceder
        UIInput ciudadInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:ciudad");
        String nuevaCiudad = "Ciudad de Mexico";
        ciudadInputText.setValue(nuevaCiudad);
        ciudadInputText.setSubmittedValue(nuevaCiudad);

        //Con esto indicamos que mande la respuesta 
        facescontex.renderResponse();
    }

    public void ocultarComentario(ActionEvent event) {
        //Este metodo lo unico que hace es invertir el valor del metodo comentarioEnviado
        //Si es true se volvera false y viceversa
        this.comentarioEnviado = !this.comentarioEnviado;
    }

    public boolean isComentarioEnviado() {
        return comentarioEnviado;
    }

    public void setComentarioEnviado(boolean comentarioEnvado) {
        this.comentarioEnviado = comentarioEnvado;
    }

    public ColoniaHelper getColoniaHelper() {
        return coloniaHelper;
    }

    public void setColoniaHelper(ColoniaHelper coloniaHelper) {
        this.coloniaHelper = coloniaHelper;
    }

}
