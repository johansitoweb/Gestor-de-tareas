import java.sql.Connection
import java.sql.DriverManager
import java.sql.Statement

fun main() {
    val connection: Connection = DriverManager.getConnection("jdbc:sqlite:tasks.db")
    val statement: Statement = connection.createStatement()
    
    statement.execute("CREATE TABLE IF NOT EXISTS tasks (id INTEGER PRIMARY KEY, task TEXT)")
    
    // Ejemplo de agregar una tarea
    statement.execute("INSERT INTO tasks (task) VALUES ('Comprar leche')")
    
    // Mostrar tareas
    val resultSet = statement.executeQuery("SELECT * FROM tasks")
    while (resultSet.next()) {
        println("ID: ${resultSet.getInt("id")}, Tarea: ${resultSet.getString("task")}")
    }
    
    connection.close()
}
