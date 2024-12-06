package HQL;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

public class HQLOperations {
    public static void main(String[] args) {
        HQLOperations operations = new HQLOperations();
       // operations.addDeveloper();
        operations.updateDeveloper();
        // operations.viewAllDevelopers();
    }

    // Adding a Developer object
    public void addDeveloper() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();

        Transaction t = session.beginTransaction();

        Developer developer = new Developer();
        developer.setId(3);
        developer.setName("RAVI");
        developer.setTechnology("C");
        developer.setExperience(4);
        developer.setSalary(2000);

        session.persist(developer); // Persisting Developer object
        t.commit();
        System.out.println("Developer Added Successfully");

        session.close();
        sf.close();
    }

    // Updating a Developer object using positional parameters
    public void updateDeveloper() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();

        Transaction t = session.beginTransaction();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Developer ID:");
        int devId = sc.nextInt();
        System.out.println("Enter Developer Name:");
        String devName = sc.next();
        System.out.println("Enter Developer Salary:");
        double devSalary = sc.nextDouble();

        String hql = "update Developer set name=?1, salary=?2 where id=?3";
        MutationQuery qry = session.createMutationQuery(hql);
        qry.setParameter(1, devName);
        qry.setParameter(2, devSalary);
        qry.setParameter(3, devId);

        int n = qry.executeUpdate();

        t.commit();
        System.out.println(n + " Developer(s) Updated Successfully");

        sc.close();
        session.close();
        sf.close();
    }

    // Viewing all Developer objects
    public void viewAllDevelopers() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        SessionFactory sf = configuration.buildSessionFactory();
        Session session = sf.openSession();

        String hql = "from Developer"; // HQL to fetch all developers
        Query<Developer> qry = session.createQuery(hql, Developer.class);
        List<Developer> developerList = qry.getResultList();
        System.out.println("Total Developers = " + developerList.size());

        for (Developer dev : developerList) {
            System.out.println("ID: " + dev.getId());
            System.out.println("Name: " + dev.getName());
            System.out.println("Technology: " + dev.getTechnology());
            System.out.println("Experience: " + dev.getExperience() + " years");
            System.out.println("Salary: " + dev.getSalary());
        }

        session.close();
        sf.close();
    }
}
