package cn.north.web;

import java.util.List;

import javax.annotation.Resource;

import cn.north.bean.Person;
import cn.north.service.PersonService;

public class PersonAction {
	
	@Resource PersonService personService;
	private String message;
	private List<Person> persons;
	private Person person;

	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person){
		this.person = person;
	}
	
	/**
	 * 人员列表显示
	 */
	public String list(){
		this.persons = personService.getPersons();
		return "list";
	}
	/**
	 * 人员添加界面
	 */
	public String addUI(){
		return "add";
	}
	/**
	 * 人员添加
	 */
	public String add(){
		this.personService.save(this.person);
		this.message="添加成功";
		return "message";
	}
	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
