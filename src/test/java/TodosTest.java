import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TodosTest {
    SimpleTask simpleTask = new SimpleTask(5, "Купить хлеб");
    Todos todos = new Todos();
    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);
    Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник");

    @BeforeEach
    public void setup() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
    }

    @Test
    public void shouldAddThreeTasksOfDifferentType() {

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchWhenNoTasks() {
        Task[] expected = {};
        Task[] actual = todos.search("Любовь");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneTasks() {
        Task[] expected = {epic};
        Task[] actual = todos.search("Яйца");
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchFewTasks() {
        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search("хлеб");

        Assertions.assertArrayEquals(expected, actual);
    }
}