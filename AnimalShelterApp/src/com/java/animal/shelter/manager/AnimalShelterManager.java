package com.java.animal.shelter.manager;

import java.util.ArrayList;
import java.util.List;

import com.java.animal.shelter.bean.Animal;
import com.java.animal.shelter.bean.Cat;
import com.java.animal.shelter.bean.Dog;
import com.java.animal.shelter.bean.Parrot;

public class AnimalShelterManager {
	public boolean isListFull = false;

	public boolean dogManager(String name, String age, String gender, List<Animal> animals) {
		Animal dog = new Dog();

		System.out.println("You're trying to add a Dog with " + name + " " + age + " " + gender);

		dog.setName(name);
		dog.setAge(age);
		dog.setGender(gender);

		boolean isDogAdded = addAnimal(animals, dog);

		return isDogAdded;
	}

	public boolean catManager(String name, String age, String gender, List<Animal> animals) {

		Animal cat = new Cat();

		System.out.println("You're trying to add a Cat with " + name + " " + age + " " + gender);

		cat.setName(name);
		cat.setAge(age);
		cat.setGender(gender);

		boolean isCatAdded = addAnimal(animals, cat);

		return isCatAdded;
	}

	public boolean parrotManager(String name, String age, String gender, List<Animal> animals) {

		Animal parrot = new Parrot();

		System.out.println("You're trying to add a parrot with " + name + " " + age + " " + gender);

		parrot.setName(name);
		parrot.setAge(age);
		parrot.setGender(gender);

		boolean isParrotAdded = addAnimal(animals, parrot);

		return isParrotAdded;
	}

	public boolean addAnimal(List<Animal> animals, Animal animal) {
		boolean isAnimalAdded = false;

		System.out.println(animals.size());
		if (animals.size() < 10) {
			animals.add(animal);
			isAnimalAdded = true;
			isListFull = false;
		}else {
			isListFull = true;
		}
		
		setReferenceId(animal);
		

		return isAnimalAdded;
	}
	

	public void setReferenceId(Animal animal) {
		animal.setReferenceId(animal.staticId);
		animal.staticId++;
	}

	public boolean removeAnimal(int animalTobeRemoved, List<Animal> animals) {
		boolean isRemoved = false;
		int index = 0;

		for (Animal animal : animals) {
			if (animal.getReferenceId() == animalTobeRemoved) {
				animals.remove(index);
				isRemoved = true;
				break;
			}else {
				isRemoved = false;
			}
			index++;
		}
		return isRemoved;
	}

	public List<String> viewAnimals(List<Animal> animals) {
		List<String> animalDetails = new ArrayList<String>();

		for (Animal animal : animals) {
			if (animal == null) {
				break;
			}
			animalDetails.add(animal.sound() + " " + animal.getReferenceId() + " " + animal.getName() + " "
					+ animal.getAge() + " " + animal.getGender());
		}
		return animalDetails;
	}

}
