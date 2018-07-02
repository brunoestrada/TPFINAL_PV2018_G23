
package aplicacion.controlador.beans;

import aplicacion.modelo.dominio.Actor;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ActorBean implements Serializable {

    private Actor actor;

    public ActorBean() {
        actor = new Actor();
    }

    public ActorBean(Actor actor) {
        this.actor = actor;
    }

    /**
     * @return the actor
     */
    public Actor getActor() {
        return actor;
    }

    /**
     * @param actor the actor to set
     */
    public void setActor(Actor actor) {
        this.actor = actor;
    }

}