package managedBean;

import entidade.Aluno;
import facade.AlunoFacade;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "alunoMB")
@SessionScoped
public class AlunoMB implements Serializable {

    private Aluno aluno = new Aluno();

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
        return listar();
    }

    public String excluir() {
        AlunoFacade facade = new AlunoFacade();
        facade.excluir(aluno);
        return listar();
    }

    public String editar() {
        return "editAluno.xhtml";
    }
}
