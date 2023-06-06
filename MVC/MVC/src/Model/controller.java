package Model;

import Model.mvc.Student;
import Model.mvc.StudentController;
import Model.mvc.StudentView;

public class controller {



	public static void main(String[] args) {
		 
		        Student model  = retriveStudentFromDatabase();
		 
		        StudentView view = new StudentView();
		 
		        StudentController controller = new StudentController(model, view);
		 
		        controller.updateView();
		 
		        controller.setStudentName("Rolex");
		 
		        controller.updateView();
		    }
		 
		    private static Student retriveStudentFromDatabase()
		    {
		        Student student = new Student();
		        student.setName("Dilli");
		        student.setRollNo("15UCS157");
		        return student;
		    }
		     


}
