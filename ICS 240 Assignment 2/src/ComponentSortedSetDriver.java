import java.util.Iterator;
public class ComponentSortedSetDriver {

	public static void main(String[] args) {
		
		//create several instances of Component class
		System.out.println("creating instances of the Component class...");
		Component c1 = new Component("resistor", 1000);
		Component c2 = new Component("capacitor", 100);
		Component c3 = new Component("inductor", 30);
		Component c4 = new Component("resistor", 2000);
		Component c5 = new Component("capacitor", 200);
		Component c6 = new Component("inductor", 50);
		Component c7 = new Component("resistor", 3000);
		Component c8 = new Component("resistor", 2000);
		
		System.out.println("testing toString()...");
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());
		System.out.println(c4.toString());
		System.out.println(c5.toString());
		System.out.println(c6.toString());
		System.out.println(c7.toString());
		System.out.println(c8.toString());
		
		System.out.println();
		
		System.out.println("testing equals method...");
		System.out.print(c1.toString() + "  =  " +  c2.toString() + "\t");
		System.out.println(c1.equals(c2));
		System.out.print(c4.toString() + "  =  " +  c4.toString() + "\t");
		System.out.println(c4.equals(c8));
		
		System.out.println();
		
		System.out.println("testing ComponentSortedArraySet class...");
		System.out.println("\nadd method...");
		ComponentSortedArraySet cSet = new ComponentSortedArraySet(10);
		cSet.add("resistor", 1000);
		cSet.add("capacitor", 100);
		cSet.add("inductor", 30);
		cSet.add("resistor", 2000);
		cSet.add("capacitor", 200);
		cSet.add("inductor", 50);
		cSet.add("resistor", 3000);
		System.out.println(cSet.toString());
		
		System.out.println("adding same type and size already in collection ...");
		cSet.add("resistor", 2000);
		System.out.println("toString()...");
		System.out.println(cSet.toString());
		
		System.out.println("c7.toString(): " + c7.toString());
		System.out.println("indexOf c7: " + cSet.indexOf(c7));
		
		System.out.println();
		
		System.out.println("c3.toString(): " + c3.toString());
		System.out.println("removing c3: " + cSet.remove(c3));
		System.out.println(cSet.toString());
		
		System.out.println("grab index 3: " + cSet.grab(3));
		
		System.out.println();
		
		System.out.println("adding 4 more Components...");
		cSet.add("resistor", 4000);
		cSet.add("capacitor", 300);
		cSet.add("inductor", 60);
		cSet.add("inductor", 70);
		System.out.println(cSet.toString());
		
		System.out.println("creating new Component object c9 to test replace method");
		Component c9 = new Component("resistor", 5000);
		System.out.println("c9.toString(): " + c9.toString());
		
		System.out.println();
		
		System.out.println("current Components in set:");
		System.out.println(cSet.toString());
		System.out.println("c7 = " + c7.toString());
		System.out.println("c9 = " + c9.toString());
		System.out.print("replace c7 with c9 = ");
		System.out.print(cSet.replace(c7, c9));
		System.out.println(cSet.toString());
		
	
		System.out.println("creating new collection of Component objects...\n");
		ComponentSortedArraySet cSet2 = new ComponentSortedArraySet(10);
		cSet2.add("capacitor", 100);
		cSet2.add("capacitor", 200);
		cSet2.add("capacitor", 300);
		cSet2.add("inductor", 50);
		cSet2.add("inductor", 60);
		cSet2.add("inductor", 70);
		cSet2.add("resistor", 1000);
		cSet2.add("resistor", 2000);
		cSet2.add("resistor", 4000);
		cSet2.add("resistor", 5000);
		
		System.out.print("Set 1: " + cSet.toString());
		System.out.print("Set 2: " + cSet2.toString());
		
		System.out.println("are both sets equal: " + cSet2.equals(cSet));
		
		System.out.println();
		
		System.out.println("get total of all integer values in set: " + ComponentSortedArraySet.total(cSet2));
		
		System.out.println();
		
		System.out.println("while loop: ");
		Iterator<Component> itr = cSet2.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println();
		
		System.out.println("enhanced for loop:");
		for(Component i : cSet) {
			System.out.println(i);
		}
	}
}
