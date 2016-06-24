package game;

public class Character {
	public String name;
	public int hp;
	public String weapon;
	
	public Character(){
		name = "Teddy";
		hp = 10;
		weapon = "knife";
	}
	
	public Character(String name, int hp, String weapon){
		this.name = name;
		this.hp = hp;
		this.weapon = weapon;
	}
	
	public void setName(String name){this.name= name;}
	public String getName(){return this.name;}
	public void sethp (int hp){this.hp=hp;}
	public int gethp(){return hp;}
	public void setWeapon(String weapon){this.weapon=weapon;}
	public String getWeapon(){return this.weapon;}
	public String toString(){
		return this.name + " HP:" + this.hp + " Weapon: " + this.weapon;
	}

}
