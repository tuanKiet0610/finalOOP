package mystudentmanager;

public class StudentManager {
    // Singleton pattern
    private static StudentManager instance;

    private MyList studentList;

    private StudentManager() {
        this.studentList = new MyLinkedList();
    }

    public static StudentManager getInstance() {
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    public MyList getStudentList() {
        return studentList;
    }

    /**
     * Thêm sinh viên vào cuối danh sách.
     * @param student
     */
    public void append(Student student) {
        this.studentList.insertAtEnd(student);
    }

    /**
     * Thêm sinh viên vào danh sách ở vị trí index.
     * @param student
     * @param index
     */
    public void add(Student student, int index) {
        this.studentList.insertAtPosition(student, index);
    }

    /**
     * Bỏ sinh viên ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        this.studentList.remove(index);
    }

    /**
     * Bỏ sinh viên như tham số truyền vào.
     * @param student
     */
    public void remove(Student student) {
        this.studentList.remove(student);
    }

    /**
     * Lấy ra sinh viên ở vị trí index
     * @param index
     * @return
     */
    public Student studentAt(int index) {
        return (Student) this.studentList.get(index);
    }

    /**
     * Lọc ra những sinh viên có điểm trung bình trên 15 điểm.
     * @return
     */
    public MyList filterStudentsByAverageGrade() {
        MyList result = new MyLinkedList();
        for (int i = 0; i < this.studentList.size(); i++) {
            Student currentStudent = (Student) this.studentList.get(i);
            if (currentStudent.getAverageGrade() > 1.5) {
                result.insertAtEnd(currentStudent);
            }
        }
        return result;
    }

    /**
     * Lọc ra những sinh viên có điểm toán trên 5 điểm.
     * @return
     */
    public MyList filterStudentsByMathGrade() {
        MyList result = new MyLinkedList();
        for (int i = 0; i < this.studentList.size(); i++) {
            Student currentStudent = (Student) this.studentList.get(i);
            if (currentStudent.getMathsGrade() > 5) {
                result.insertAtEnd(currentStudent);
            }
        }
        return result;
    }
}
