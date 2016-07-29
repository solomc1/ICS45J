//Madeline Chan, 76439804
//Solomon Chan, 40786337

public class Student {

		//private variables
		private int id;
		private String first;
		private String last;
		
		//default constructor
		public Student(){
			id = 0;
			first = "";
			last = "";
		}
		
		//constructor
		public Student(int i, String f, String l){
			id = i;
			first = f;
			last = l;
		}
		
		//id mutator
		public void setId(int i){
			id = i;
		}
		
		//first name mutator
		public void setFirst(String f){
			first = f;
		}
		
		//last name mutator
		public void setLast(String l){
			last = l;
		}
		
		//id accessor
		public int getId(){
			return id;
		}
		
		//first name accessor
		public String getFirst(){
			return first;
		}
		
		//last name accessor
		public String getLast(){
			return last;
		}
}
