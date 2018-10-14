package managedBean;

import entidade.Aluno;
import facade.AlunoFacade;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name = "alunoMB")
@SessionScoped
public class AlunoMB implements Serializable {

    private Aluno aluno = new Aluno();
    private List<Aluno> alunos = new ArrayList<>();
    
    public void adicionar(){
        alunos.add(aluno);
    }
    
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String listar() {
        return "listAluno.xhtml";
    }

    public List<Aluno> getLista() {
        AlunoFacade facade = new AlunoFacade();
        return facade.getAll();
    }

    public String novoAluno() {
        aluno = new Aluno();
        return "editAluno.xhtml";
    }

    public String salvar() {
        AlunoFacade facade = new AlunoFacade();
        facade.salvar(aluno);
        adicionar();
        return listar();
    }

    public String excluir() {
        AlunoFacade facade = new AlunoFacade();
        facade.excluir(aluno);
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        try {
            ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
        } catch (IOException ex) {
            Logger.getLogger(AlunoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listar();
    }

    public String editar() {
        return "editAluno.xhtml";
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
    
}
