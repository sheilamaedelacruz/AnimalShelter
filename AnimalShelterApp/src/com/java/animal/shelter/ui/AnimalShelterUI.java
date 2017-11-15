package com.java.animal.shelter.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.java.animal.shelter.bean.Animal;
import com.java.animal.shelter.manager.AnimalShelterManager;

public class AnimalShelterUI {
	AnimalShelterManager animalShelterManager = new AnimalShelterManager();
	List<Animal> animals = new ArrayList<Animal>();

	public String name;
	public String age;
	public String gender;

	public void homePageUi() {
		Scanner input = new Scanner(System.in);

		do {

			System.out.println("Welcome to Shei’s Animal Shelter!");
			System.out.println("Please select an option:");

			boolean isAnimalListFull = animalShelterManager.isListFull;
			if (!isAnimalListFull) {
				System.out.println("[1] Add an Animal");
			}
			List<String> listOfAnimals = animalShelterManager.viewAnimals(animals);
			if (!listOfAnimals.isEmpty()) {
				System.out.println("[2] Remove an Animal");
				System.out.println("[3] View all Animals");
			}

			String menuInput = input.nextLine();

			switch (menuInput) {
			case "1":
				if (animals.size() < 10) {
					System.out.println("Welcome to Add Animal Page");
					System.out.println("What animal you are trying to add?");
					System.out.println("[1] A Dog");
					System.out.println("[2] A Cat");
					System.out.println("[3] A Parrot");

					String animalInput = input.nextLine();

					animalDetailsConstruction(animalInput);
				} else {
					System.out.println("The animal shelter is currently full. Thank you!");
				}
				break;

			case "2":
				System.out.println("Please enter the reference ID of the animal to remove: ");
				int animalTobeRemoved = input.nextInt();

				boolean isRemoved = animalShelterManager.removeAnimal(animalTobeRemoved, animals);
				if (isRemoved) {
					System.out.println("The animal is now removed.");
				} else {
					System.out.println("Animal ID not found.");
				}

				break;

			case "3":
				List<String> listOfAnimalDetails = animalShelterManager.viewAnimals(animals);

				if (!listOfAnimalDetails.isEmpty()) {

					System.out.println("Meet our lovely animal friends!");
					for (String animalDetails : listOfAnimalDetails) {
						if (animalDetails != null) {
							System.out.println(animalDetails);
						}
					}
				} else {
					System.out.println("The shelter is currently empty");
				}
				break;
			}

		} while (animals.size() < 11);
	}

	public void animalDetailsConstruction(String animalInput) {

		switch (animalInput) {
		case "1":
			getAnimalDetails();
			boolean isDogAdded = animalShelterManager.dogManager(name, age, gender, animals);
			if (isDogAdded) {
				System.out.println("Dog is added");
			} else {
				System.out.println("Cannot add dog");
			}

			break;

		case "2":
			getAnimalDetails();
			boolean isCatAdded = animalShelterManager.catManager(name, age, gender, animals);
			if (isCatAdded) {
				System.out.println("Cat is added");
			} else {
				System.out.println("Cannot add cat");
			}

			break;

		case "3":
			getAnimalDetails();
			boolean isParrotAdded = animalShelterManager.parrotManager(name, age, gender, animals);
			if (isParrotAdded) {
				System.out.println("Cat is added");
			} else {
				System.out.println("Cannot add cat");
			}

			break;
		}
	}

	public void getAnimalDetails() {
		Scanner animalDetailsInput = new Scanner(System.in);

		System.out.println("Please enter animal name: ");
		name = animalDetailsInput.nextLine();

		System.out.println("Please enter animal age: ");
		age = animalDetailsInput.nextLine();

		System.out.println("Please enter animal gender: ");
		gender = animalDetailsInput.nextLine();

	}

}
