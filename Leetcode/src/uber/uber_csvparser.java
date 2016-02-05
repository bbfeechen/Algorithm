package uber;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class uber_csvparser {
	public static class Student {
	    private long id;
	    private String firstName;
	    private String lastName;
	    private String gender;
	    private int age;

	    public Student(long id, String firstName, String lastName, String gender,
	            int age) {
	        super();
	        this.id = id;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.gender = gender;
	        this.age = age;
	    }

	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public String getGender() {
	        return gender;
	    }

	    public void setGender(String gender) {
	        this.gender = gender;
	    }

	    public int getAge() {
	        return age;
	    }

	    public void setAge(int age) {
	        this.age = age;
	    }

	    @Override
	    public String toString() {
	        return "Student [id=" + id + ", firstName=" + firstName
	                + ", lastName=" + lastName + ", gender=" + gender + ", age="
	                + age + "]";
	    }
	}
	
	public static class CSVReader {
		private static final String DELIMITER = ",";
		private static final int STUDENT_ID_IDX = 0;
		private static final int STUDENT_FNAME_IDX = 1;
		private static final int STUDENT_LNAME_IDX = 2;
		private static final int STUDENT_GENDER = 3;
		private static final int STUDENT_AGE = 4;
		
		public static void read(String fileName) {
			BufferedReader reader = null;
			try {
				List<Student> students = new ArrayList<Student>();
				String line = "";
				reader = new BufferedReader(new FileReader(fileName));
				reader.readLine();
				while((line = reader.readLine()) != null) {
					StringBuilder builder = new StringBuilder(line);
					boolean inQuotes = false;
					for (int currentIndex = 0; currentIndex < builder.length(); currentIndex++) {
					    char currentChar = builder.charAt(currentIndex);
					    if (currentChar == '\"') {
					    	inQuotes = !inQuotes; // toggle state
					    }
					    if (currentChar == ',' && inQuotes) {
					        builder.setCharAt(currentIndex, ';'); 
					    }
					}
					line = builder.toString();
					String[] tokens = line.split(DELIMITER);
					if(tokens.length > 0) {
						Student student = new Student(Long.parseLong(tokens[STUDENT_ID_IDX]), 
								tokens[STUDENT_FNAME_IDX], tokens[STUDENT_LNAME_IDX], 
								tokens[STUDENT_GENDER], Integer.parseInt(tokens[STUDENT_AGE]));
						students.add(student);
					}
				}
				for(Student student : students) {
					System.out.println(student.toString());
				}
			} catch(IOException e) {
				System.out.println("Error in CsvFileReader !!!");
				e.printStackTrace();
			} finally {
				try {
					reader.close();
				} catch(IOException e) {
					System.out.println("Error in CsvFileReader !!!");
					e.printStackTrace();
				}
			}
		}
	}
	
	public static class CSVWriter {
		private static final String DELIMITER = ",";
		private static final String LINE_SEPARATOR = "\n";
		
		private static final String HEADER = "";
		private static void write(String fileName, List<Student> students) {
			FileWriter writer = null;
			try {
				writer = new FileWriter(fileName);
				writer.append(HEADER);
				writer.append(LINE_SEPARATOR);
				for(Student student : students) {
					writer.append(String.valueOf(student.getId()));
					writer.append(DELIMITER);
					writer.append("\"");
					writer.append(student.getFirstName());
					writer.append("\"");
					writer.append(DELIMITER);
					writer.append("\"");
					writer.append(student.getLastName());
					writer.append("\"");
					writer.append(DELIMITER);
					writer.append("\"");
					writer.append(student.getGender());
					writer.append("\"");
					writer.append(DELIMITER);
					writer.append(String.valueOf(student.getAge()));
					writer.append(LINE_SEPARATOR);
				}
				System.out.println("CSV file was created successfully !!!");
			} catch (IOException e) {
				System.out.println("Error in CsvFileWriter !!!");
				e.printStackTrace();
			} finally {
			    try {
			    	writer.flush();
			    	writer.close();
			    } catch (IOException e) {
			        System.out.println("Error while flushing/closing fileWriter !!!");
			        e.printStackTrace();
			    }
			}
		}
	}

	public static void main(String[] args) {
		Student student1 = new Student(1, "Ahmed", "Mo,hamed", "M", 25);
		Student student2 = new Student(2, "Sara", "Said", "F", 23);
		Student student3 = new Student(3, "Ali", "Hassan", "M", 24);
		Student student4 = new Student(4, "Sama", "Karim", "F", 20);
		Student student5 = new Student(5, "Khaled", "Mohamed", "M", 22);
		Student student6 = new Student(6, "Ghada", "Sarhan", "F", 21);

		//Create a new list of student objects
		List students = new ArrayList();
		students.add(student1);
		students.add(student2);
		students.add(student3);
		students.add(student4);
		students.add(student5);
		students.add(student6);
		
		String fileName = "./student.csv";
		System.out.println("Write CSV file:");
		CSVWriter.write(fileName, students);
		System.out.println("\nRead CSV file:");
		CSVReader.read(fileName);
	}
}
