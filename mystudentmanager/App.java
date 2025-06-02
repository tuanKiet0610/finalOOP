package mystudentmanager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 7) {
                    continue;
                }

                if (dataList.get(0).equals("id")) {
                    continue;
                }

                String id = dataList.get(0);
                String lastname = dataList.get(1);
                String firstname = dataList.get(2);
                int yearOfBirth = Integer.parseInt(dataList.get(3));
                double mathGrade = Double.parseDouble(dataList.get(4));
                double physicGrade = Double.parseDouble(dataList.get(5));
                double chemistryGrade = Double.parseDouble(dataList.get(6));

                /*
                TODO

                - Đọc được dữ liệu, tạo ra các đối tượng sinh viên ở đây, và cho vào đối tượng được tạo ra từ
                lớp StudentManager để quản lý.
                - Đối tượng tạo ra từ lớp StudentManager là duy nhất trong chương trình, do dùng Singleton Pattern,
                và được tạo ra bằng cách gọi hàm StudentManager.getInstance().
                */

                Student newStudent = new Student.StudentBuilder(id)
                        .withLastname(lastname)
                        .withFirstname(firstname)
                        .withYearOfBirth(yearOfBirth)
                        .withMathsGrade(mathGrade)
                        .withPhysicsGrade(physicGrade)
                        .withChemistryGrade(chemistryGrade)
                        .build();
                StudentManager.getInstance().append(newStudent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream("phantanson_20002090_studentManager.txt"));
        System.setOut(out);
        init();

        /* Yêu cầu:
        - Hoàn thiện code chương trình theo mẫu và theo yêu cầu đã cho.
        - Viết code để test cho tất cả các hàm test.

        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_StudentManager>.txt (Ví dụ, NguyenVanA_123456_StudentManager.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_StudentManager>.zip (Ví dụ, NguyenVanA_123456_StudentManager.zip),
          nộp lên classroom.
         */
        System.out.println("Test original: ");
        testOriginalData();
        System.out.println("Test filter by average: ");
        testFilterStudentsByAverageGrade();
        System.out.println("Test filter by math grade: ");
        testFilterStudentsByMathGrade();
    }

    public static void init() {
        String filePath = "D:\\OOP\\Cuối kì OOP\\OOP_HK2_2324_FinalExam_De2\\data\\students.csv";
        readListData(filePath);
    }

    public static void testOriginalData() {
        MyList studentList = StudentManager.getInstance().getStudentList();
        for (int i = 0; i < studentList.size(); i++) {
            Student student = (Student) studentList.get(i);
            System.out.println(student);
        }
    }

    public static void testFilterStudentsByAverageGrade() {
        MyList result = StudentManager.getInstance().filterStudentsByAverageGrade();
        for (int i = 0; i < result.size(); i++) {
            Student student = (Student) result.get(i);
            System.out.println(student);
        }
    }

    public static void testFilterStudentsByMathGrade() {
        MyList result = StudentManager.getInstance().filterStudentsByMathGrade();
        for (int i = 0; i < result.size(); i++) {
            Student student = (Student) result.get(i);
            System.out.println(student);
        }
    }
}
