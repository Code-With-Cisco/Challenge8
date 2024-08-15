/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package challenge8;

/**
 *
 * @author mtsguest
 */
public class Pet implements Comparable<Pet> {
    
  
	private int dateOfBirth;
	private String name;
	private String species;
	private long chips;

	// Pet method: set the variable
	public Pet(String name, int dateOfBirth, String species, long chips) {
		this.dateOfBirth = dateOfBirth;
		this.name = name;
		this.species = species;
		this.chips = chips;
	}

	// compareTo method: return value depanding of the comparaison
	public int compareTo(Pet otherPet) {
		if (this.dateOfBirth > otherPet.dateOfBirth)
			return 1;
		else if (this.dateOfBirth < otherPet.dateOfBirth)
			return -1;
		else
			return 0;
	}

	// getDateofBirth method: return dateOfBirth
	public int getDateOfBirth() {
		return dateOfBirth;
	}

	// setDateofBirth method: set dateOfBirth
	public void setDateOfBirth(int dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	// getName method: return name
	public String getName() {
		return name;
	}

	// setName method: set name
	public void setName(String name) {
		this.name = name;
	}

	// getSpecies method: return species
	public String getSpecies() {
		return species;
	}

	// setSpecies method: set species
	public void setSpecies(String species) {
		this.species = species;
	}
        public long getChips() {
        return chips;
        }
	// setChips method: set chips
	public void setChips(long chips) {
		this.chips = chips;
	}

	// equals method: return true if both object are equals else return false
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || this.getClass() != obj.getClass())
			return false;
		Pet p1 = (Pet) obj;

		return this.name.equals(p1.name) && this.dateOfBirth == p1.dateOfBirth && this.species == p1.species;
	}

	// toString method: print
	@Override
	public String toString() {
		return species + " named " + name + ", borned " + dateOfBirth / 10000 + "/" + dateOfBirth / 100 % 100 + "/"
				+ dateOfBirth % 100;
	}
        
        
}
