package ws1;

import java.sql.SQLException;
import java.util.List;

public interface BookDB {
	List<Book> getAll() throws SQLException;

	Book getById(String id) throws SQLException;

	void deleteBook(String id) throws SQLException;

	void updateBook(Book book) throws SQLException;
        
        void addBook(Book book) throws SQLException;
}
