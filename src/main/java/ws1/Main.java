package ws1;

import java.sql.SQLException;
import java.util.List;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ConnectionHelper connetionHelper = new ConnectionHelper("sa", "123456789");
		BookDBImpl bookDBImpl = new BookDBImpl(connetionHelper) {};
		List<Book> books = bookDBImpl.getAll();
		System.out.println(books);
		bookDBImpl.deleteBook("B0002");
	}

}
