package dao;

import entidade.Aluno;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class AlunoDao {
    List<Aluno> lista = new ArrayList();
    public List<Aluno> getAll() {
        lista = HibernateUtil.getSessionFactory().openSession().createQuery("from Aluno").list();
        return lista;
    }

    public Aluno salvar(Aluno aluno) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(aluno);
        session.getTransaction().commit();
        return aluno;
    }

    public Aluno getById(Integer id) {
        Aluno aluno = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        aluno = (Aluno) session.get(Aluno.class, id);
        session.getTransaction().commit();
        return aluno;
    }

    public void excluir(Aluno aluno) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.delete(aluno);
        session.getTransaction().commit();
    }
}
