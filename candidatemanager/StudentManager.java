package candidatemanager;

public class StudentManager {
    // Singleton pattern
    private static StudentManager instance;

    private MyList studentList;

    private StudentManager() {
        studentList = new MyArrayList();
    }

    public static StudentManager getInstance() {
        /* TODO */
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    public MyList getStudentList() {
        return this.studentList;
    }

    /**
     * Thêm sinh viên vào cuối danh sách.
     * @param student
     */
    public void append(Student student) {
        /* TODO */
        if (student != null) {
            this.studentList.append(student);
        }
    }

    /**
     * Thêm sinh viên vào danh sách ở vị trí index.
     * @param student
     * @param index
     */
    public void add(Student student, int index) {
        /* TODO */
        if (index < 0 || index > studentList.size()) {
            return;
        }
        if (student != null) {
            this.studentList.insert(student,index);
        }
    }

    /**
     * Bỏ sinh viên ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        if (index < 0 || index > studentList.size()) {
            return;
        }
        this.studentList.remove(index);
    }

    /**
     * Bỏ sinh viên như tham số truyền vào.
     * @param student
     */
    public void remove(Student student) {
        /* TODO */
        if (student == null) {
            return;
        }
        int i = 0;
        while (i < studentList.size()) {
            if (studentList.get(i).equals(student)) {
                remove(i);
            }
            else {
                i++;
            }
        }
    }

    /**
     * Lấy ra sinh viên ở vị trí index
     * @param index
     * @return
     */
    public Student studentAt(int index) {
        /* TODO */
        if (index < 0 || index > studentList.size()) {
            return null;
        }
        return (Student) studentList.get(index);
    }

    public MyList sortMathsGradeIncreasing() {
        /* TODO */
        MyList result = this.studentList;
        int n = result.size();
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i+1; j < n; j++)
                if (((Student)result.get(j)).getMathsGrade() > ((Student)result.get(i)).getMathsGrade() )
                    minIndex = j;

            // Swap the found minimum element with the first
            // element
            Object temp = result.get(minIndex);
            result.set(result.get(i),minIndex);
            result.set(temp,i);
        }
        return result;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm toán giảm dần.
     * @return
     */
    public MyList sortMathsGradeDecreasing() {
        /* TODO */
        MyList result = this.studentList;
        int n = result.size();
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i+1; j < n; j++)
                if (((Student)result.get(j)).getMathsGrade() > ((Student)result.get(i)).getMathsGrade() )
                    minIndex = j;

            // Swap the found minimum element with the first
            // element
            Object temp = result.get(minIndex);
            result.set(result.get(i),minIndex);
            result.set(temp,i);
        }
        return result;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm trung bình tăng dần.
     * @return
     */
    public MyList sortAverageGradeIncreasing() {
        /* TODO */
        MyList result = this.studentList;
        int n = result.size();
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i+1; j < n; j++)
                if (((Student)result.get(j)).getAverageGrade() < ((Student)result.get(i)).getAverageGrade() )
                    minIndex = j;

            // Swap the found minimum element with the first
            // element
            Object temp = result.get(minIndex);
            result.set(result.get(i),minIndex);
            result.set(temp,i);
        }
        return result;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự điểm trung bình giảm dần.
     * @return
     */
    public MyList sortAverageGradeDecreasing() {
        /* TODO */
        MyList result = this.studentList;
        int n = result.size();
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i+1; j < n; j++)
                if (((Student)result.get(j)).getAverageGrade() > ((Student)result.get(i)).getAverageGrade() )
                    minIndex = j;

            // Swap the found minimum element with the first
            // element
            Object temp = result.get(minIndex);
            result.set(result.get(i),minIndex);
            result.set(temp,i);
        }
        return result;
    }

    /**
     * Lọc ra howMany sinh viên có điểm toán cao nhất.
     * @param howMany
     * @return
     */
    public MyList filterStudentsHighestMathsGrade(int howMany) {
        /* TODO */
        MyList result = new MyLinkedList();
        MyList sort = sortMathsGradeDecreasing();
        for (int i = 0; i < Math.min(howMany,sort.size()); i++) {
            result.append(sort.get(i));
        }
        return result;
    }

    /**
     * Lọc ra howMany sinh viên có điểm toán thấp nhất.
     * @param howMany
     * @return
     */
    public MyList filterStudentsLowestMathsGrade(int howMany) {
        /* TODO */
        MyList result = new MyLinkedList();
        MyList sort = sortMathsGradeIncreasing();
        for (int i = 0; i < Math.min(howMany,sort.size()); i++) {
            result.append(sort.get(i));
        }
        return result;
    }

    /**
     * Lọc ra howMany sinh viên có điểm trung bình cao nhất.
     * @param howMany
     * @return
     */
    public MyList filterStudentsHighestAverageGrade(int howMany) {
        /* TODO */
        MyList result = new MyLinkedList();
        MyList sort = sortAverageGradeDecreasing();
        for (int i = 0; i < Math.min(howMany,sort.size()); i++) {
            result.append(sort.get(i));
        }
        return result;
    }

    /**
     * Lọc ra howMany sinh viên có điểm trung bình thấp nhất.
     * @param howMany
     * @return
     */
    public MyList filterStudentsLowestAverageGrade(int howMany) {
        /* TODO */
        MyList result = new MyLinkedList();
        MyList sort = sortAverageGradeIncreasing();
        for (int i = 0; i < Math.min(howMany,sort.size()); i++) {
            result.append(sort.get(i));
        }
        return result;
    }

    public static String idOfStudentsToString(MyList studentList) {
        StringBuilder idOfStudents = new StringBuilder();
        idOfStudents.append("[");
        MyIterator it = studentList.iterator();
        while (it.hasNext()) {
            Student student = (Student) it.next();
            idOfStudents.append(student.getId()).append(" ");
        }
        return idOfStudents.toString().trim() + "]";
    }

    public static void print(MyList studentList) {
        StringBuilder studentsString = new StringBuilder();
        studentsString.append("[\n");
        MyIterator it = studentList.iterator();
        while (it.hasNext()) {
            Student student = (Student) it.next();
            studentsString.append(student.toString()).append("\n");
        }
        System.out.print(studentsString.toString().trim() + "\n]");
    }
}
