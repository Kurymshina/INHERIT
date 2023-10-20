import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;


class TaskTest {

    @ParameterizedTest
    @CsvSource(value = {"1, Выучить java, true", "2, Купить слона, false"})
    void shouldFindSimpleTaskWhichMatchesTheSearchQuery(int id, String title, boolean expected) {
        SimpleTask simpleTask = new SimpleTask(id, title);

        boolean actual = simpleTask.matches("java");
        Assertions.assertEquals(expected, actual);
    }


    @ParameterizedTest
    @CsvFileSource(files = "src/test/java/resources/tasks.csv")
    void shouldFindMeetingWhichMatchesTheSearchQuery(int id, String topic, String project, String start, String query, boolean expected) {
        Meeting meet = new Meeting(id, topic, project, start);

        boolean actual = meet.matches(query);
        Assertions.assertEquals(expected, actual);
    }


    @ParameterizedTest
    @CsvSource(value = {"1, Сыр, true, Колбаса Сыр Хлеб Майонез", "2, TestNG, false, J-Unit5 Selenium Selenide"})
    void shouldFindEpicWhichMatchesTheSearchQuery(int id, String query, boolean expected, String a) {
        String[] subtasks = a.split(" ");
        Epic epic = new Epic(id, subtasks);

        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }
}
