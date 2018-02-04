Exercise 1 Interface List of strings
MyList.java: Create an interface called MyList with the following methods:
• public void add(String str) // adds a new string at the list
• public boolean contains(String str) // checks the given str exists in the list
• public boolean remove(String str) // removes the given str in the list
• public String get(int index) // gets the String value the given index
• public int size() // counts the number of strings in the list
Exercise 2 Linked list of strings
Node.java: Create a class called Node. The class should have the two fields value and next. The
value is of type String and the next field represents a link to the next node. Add a boolean hasNext()
method that tests whether or not next is null. Add two constructors: the default constructor and a
constructor with a String value as parameter.
MyLinkedList.java: Implement a class called MyLinkedList that implements MyList. The class has a
single instance variable called root of type Node. The class should have the following public methods:
• public void add(String str) // follows the existing chain of nodes and adds a new node at the
end with the given str
• public boolean contains(String str) // checks if a node exists with the given str
• public boolean remove(String str) // removes the node with the given str if it exists. Returns
true if it was removed, false if it was not found
• public String get(int index) // gets the String value of the node at the given index
• public int size() // gets the number of nodes
Exercise 3 Testing
Test.java: Create a new class called Test.
• Add a main method that creates an instance of MyArrayList.
• Add the following strings to the list: “Tea”, “Coffee”, “Coke”, “Sprite”, “Water”.
• Print out the results of calling contains(“Tea”) and contains(“Frappu”)
• Use a for loop to print out each value using the size() and get(index) methods.
• Call remove(“Coke”), remove(“Sprite”)
• Use a for loop to print out each value using the size() and get(index) methods.