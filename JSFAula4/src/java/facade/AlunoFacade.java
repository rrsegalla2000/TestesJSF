package facade;

import dao.AlunoDao;
import entidade.Aluno;
import java.util.List;

public class AlunoFacade {

    public List<Aluno> getAll() {
        AlunoDao dao = new AlunoDao();
        return dao.getAll();
    }

    public void excluir(Aluno aluno) {
        AlunoDao dao = new AlunoDao();
        dao.excluir(aluno);
    }

    public Aluno getById(Integer id) {
        AlunoDao dao = new AlunoDao();
        return dao.getById(id);
    }

    public Aluno salvar(Aluno aluno) {
        AlunoDao dao = new AlunoDao();
        return dao.salvar(aluno);
    }
}
