package candidatemanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

                /*
                TODO

                Đọc được dữ liệu, tạo ra các đối tượng sinh viên ở đây, và cho vào StudentManager để quản lý.
                */
                Student student = new Student.StudentBuilder(dataList.get(0))
                        .withLastname(dataList.get(1))
                        .withFirstname(dataList.get(2))
                        .withYearOfBirth(Integer.parseInt(dataList.get(3)))
                        .withMathsGrade(Double.parseDouble(dataList.get(4)))
                        .withPhysicsGrade(Double.parseDouble(dataList.get(5)))
                        .withChemistryGrade(Double.parseDouble(dataList.get(6)))
                        .build();
                StudentManager.getInstance().append(student);
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

    public static void main(String[] args) {
        init();
        testOriginalData();
        System.out.println("\n===============================");
        testSortMathsGradeDecreasing();
        testFilterStudentsLowestMathsGrade();
        System.out.println("Sort math");
        System.out.println("Math decreasing");
        testSortMathsGradeDecreasing();
        System.out.println("Math increasing");
        testSortMathsGradeIncreasing();
        System.out.println("Five highest math student");
        testFilterStudentsHighestMathsGrade();
        System.out.println("Five lowest math student");
        testFilterStudentsLowestMathsGrade();
        System.out.println("\n===============================");
        System.out.println("Sort average");
        testSortAverageGradeDecreasing();
        testSortAverageGradeIncreasing();
        testFilterStudentsHighestAverageGrade();
        testFilterStudentsLowestAverageGrade();


    }

    public static void init() {
        String filePath = "D:\\FinalsOOP\\src\\finals\\data\\students.csv";
        readListData(filePath);
    }

    public static void testOriginalData() {
        String studentIds = StudentManager.getInstance().idOfStudentsToString(StudentManager.getInstance().getStudentList());
        System.out.println(studentIds);
    }

    public static void testSortMathsGradeIncreasing() {
        /* TODO */
        String studentIds = StudentManager.getInstance().idOfStudentsToString(StudentManager.getInstance().sortMathsGradeIncreasing());
        System.out.println(studentIds);
    }

    public static void testSortMathsGradeDecreasing() {
        /* TODO */
        String studentIds = StudentManager.getInstance().idOfStudentsToString(StudentManager.getInstance().sortMathsGradeDecreasing());
        System.out.println(studentIds);
    }

    public static void testSortAverageGradeIncreasing() {
        /* TODO */
        String studentIds = StudentManager.getInstance().idOfStudentsToString(StudentManager.getInstance().sortMathsGradeIncreasing());
        System.out.println(studentIds);
    }

    public static void testSortAverageGradeDecreasing() {
        /* TODO */
        String studentIds = StudentManager.getInstance().idOfStudentsToString(StudentManager.getInstance().sortAverageGradeDecreasing());
        System.out.println(studentIds);
    }

    public static void testFilterStudentsHighestMathsGrade() {
        /* TODO */
        String studentIds = StudentManager.getInstance().idOfStudentsToString(StudentManager.getInstance().filterStudentsHighestMathsGrade(5));
        System.out.println(studentIds);
    }

    public static void testFilterStudentsLowestMathsGrade() {
        /* TODO */
        String studentIds = StudentManager.getInstance().idOfStudentsToString(StudentManager.getInstance().filterStudentsLowestMathsGrade(5));
        System.out.println(studentIds);
    }

    public static void testFilterStudentsHighestAverageGrade() {
        /* TODO */
        String studentIds = StudentManager.getInstance().idOfStudentsToString(StudentManager.getInstance().filterStudentsHighestAverageGrade(5));
        System.out.println(studentIds);
    }

    public static void testFilterStudentsLowestAverageGrade() {
        /* TODO */
        String studentIds = StudentManager.getInstance().idOfStudentsToString(StudentManager.getInstance().filterStudentsLowestAverageGrade(5));
        System.out.println(studentIds);
    }


}
