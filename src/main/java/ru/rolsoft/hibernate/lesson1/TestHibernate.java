package ru.rolsoft.hibernate.lesson1;

import com.google.common.collect.Sets;
import org.hibernate.Session;

/**
 * Created by rolenof on 29.12.16.
 */
public class TestHibernate {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        DepartmentEntity dep = new DepartmentEntity();
        dep.setName("dep1");
        dep.setNumber(1);

        RoleEntity role = new RoleEntity();
        role.setName("junior");

        EmployeeEntity emp = new EmployeeEntity();
        emp.setEmail("demo-user@mail.com");
        emp.setFirstName("demo");
        emp.setLastName("user");
        emp.setDepartment(dep);

        role.setEmployees(Sets.newHashSet(emp));

        session.save(dep);
        session.save(emp);
        session.save(role);

        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
