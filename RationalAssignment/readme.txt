1.	Make a class Rational to provide at least following methods and constructors:
Rational r1= new Rational (3,5);
Rational r2= new Rational (4,7);
Rational r3=r1.add(r2);
// also sub,mult,divide methods

	Other that four operations you should provide methods that you think is useful for user of your class.
 

        2. Write a JFrame or JApplet (file name: TestRational.java) that performs the following tasks:

	a) Define two arrays of size 10. Each element in the array references to a Rational object that you wrote in 	Problem 1 above.

		Rational a[], b[];
		a = new Rational[10];
		b = new Rational[10];
                 
Rational
Numerator                                                                                                                              
                            

Denominator
                                       
           
               

   .
   .
   .
   .
   .



	b) Initialize the arrays in Question a) by creating random Rational numbers. Do this by generating two 	random numbers between 1 and 9 for each Rational and using the numbers as the numerator and 	denominator. Denominator should be greater than Numerator. You should generate random numbers with 	Math.random.

	c) Display the contents of both arrays on the screen using  JTextArea.

	d) Add a Scrollbar to JTextArea for scrolling up or down.

	e) For each public method in Rational class, create a corresponding JButton object. When the user clicks on a button, the  actionPerformed listener should execute the corresponding Rational method for all the elements in the two arrays and store the results in a new array. You should then display the result array in the JTextArea using the setText method. For example, if the user hits the add button you should loop 	through all the elements in arrays and execute: 
   
		c[i] = a[i].add(b[i]);

	
	f) If the user hits the sort button, uses the JTextArea method append to append the results of sorting.
