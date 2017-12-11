package com.bskyb.db.repository;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.bskyb.db.config.ApplicationConfig;
import com.bskyb.db.entity.Address;
import com.bskyb.db.entity.Department;
import com.bskyb.db.entity.Employee;
import com.bskyb.db.entity.Person;
import com.bskyb.db.entity.Sex;
import com.github.javafaker.Faker;

@ActiveProfiles("unit-test")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback
@ContextConfiguration(classes = { ApplicationConfig.class })
@WebAppConfiguration
public class PersonRepositoryTest {

	public static final Faker fake = Faker.instance();

    @PersistenceContext
    protected EntityManager entityManager;
    
	@Autowired
	PersonRepository personRepository;

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Before
	public void init() throws Exception {
		Person p = new Employee();
		p.setName("nnn");
		p.setAge(100);
		p.setSex(Sex.MALE);
		((Employee)p).setSalary(10000L);
		
		Address a1 = new Address();
		a1.setDoorNo(101);
		a1.setCity("ccc");
		a1.setPerson(p);
		p.setAddress(Arrays.asList(a1));

		Person merge = entityManager.merge(p);
		entityManager.flush();

		
		
		
		
		Department dept = new Department();
		dept.setName("ddd");
		Person dbPerson = entityManager.find(Person.class, merge.getId());
		dept.setPersons(Arrays.asList(dbPerson));
		Department mergeD = entityManager.merge(dept);
		entityManager.flush();

		Department dept2 = new Department();
		dept2.setName("ddd222");
		entityManager.merge(dept2);
		entityManager.flush();
		
		Department dbDept = entityManager.find(Department.class, mergeD.getId());
		dbPerson.setDepartment(dbDept);
		entityManager.merge(dbPerson);
	}
	
	@Test
	public void getAllPerson() throws Exception {
		List<Person> persons = personRepository.getAll();
		
		for (Person person : persons) {
			System.out.println("Name: " + person.getName() + " Age: " + person.getAge());
			System.out.println(person);
			
			List<Address> address = person.getAddress();
			for (Address addr : address) {
				System.out.println(addr);
			}
			
			Department dept = person.getDepartment();
			
			System.out.println(dept);
		}
	}
	
	@Test
	public void getAllDepartments() throws Exception {
		List<Department> departments = departmentRepository.getAll();
		for (Department department : departments) {
			System.out.println(department);
			System.out.println(department.getPersons());
		}
	}
	
}
