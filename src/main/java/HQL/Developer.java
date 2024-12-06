package HQL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="developer_table")
public class Developer 
{
  @Id
     private int id;
  @Column(name="dname", length=50, nullable = false)
     private String name;
  @Column(name="dtechnology", length=50, nullable = false)
     private String technology;
  @Column(name="dexperience", nullable = false)
     private int experience;
  @Column(name="dsalary", nullable = false)
     private double salary;
     
  @Override
  public String toString() {
	return "Developer [id=" + id + ", name=" + name + ", technology=" + technology + ", experience=" + experience
			+ ", salary=" + salary + "]";
  }

  public int getId() 
  {
    return id;
  }
  public void setId(int id) 
  {
    this.id = id;
  }
  public String getName() 
  {
    return name;
  }
  public void setName(String name) 
  {
    this.name = name;
  }
  public String getTechnology() 
  {
    return technology;
  }
  public void setTechnology(String technology) 
  {
    this.technology = technology;
  }
  public int getExperience() 
  {
    return experience;
  }
  public void setExperience(int experience) 
  {
    this.experience = experience;
  }
  public double getSalary() 
  {
    return salary;
  }
  public void setSalary(double salary) 
  {
    this.salary = salary;
  }
}
