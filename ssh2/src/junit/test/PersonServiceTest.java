package junit.test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.north.bean.Person;
import cn.north.service.PersonService;

public class PersonServiceTest {
	private static PersonService personService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
			personService = (PersonService)applicationContext.getBean("personService");
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSave() {
		personService.save(new Person("小张"));
	}

	@Test
	public void testUpdate() {
		Person person = personService.getPerson(1);
		//....
		person.setName("小丽");
		personService.update(person);
	}

	@Test
	public void testGetPerson() {
		Person person = personService.getPerson(2);
		System.out.println(person.getName());
		try {
			System.out.println("请关闭数据库");
			Thread.sleep(1000*15);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("第二次开始获取");
		person = personService.getPerson(2);
		System.out.println(person.getName());
	}

	@Test
	public void testDelete() {
		personService.delete(1);
	}

	@Test
	public void testGetPersons() {
		List<Person> persons = personService.getPersons();
		for(Person person : persons){
			System.out.println(person.getName());
		}
	}

}
