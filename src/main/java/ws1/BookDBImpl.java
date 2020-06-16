package ws1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDBImpl implements BookDB {

	private ConnectionHelper connetionHelper;

	public BookDBImpl(ConnectionHelper connetionHelper) {
		super();
		this.connetionHelper = connetionHelper;
	}

	public List<Book> getAll() throws SQLException {
		List<Book> books = new ArrayList<Book>();
		String sql = "Select * from Books";
		try (Connection connection = connetionHelper.getConnection();
				Statement statement = connection.createStatement()) {
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getString("BookId"));
				book.setTitle(rs.getString("Title"));
				book.setAuthor(rs.getString("Author"));
				book.setCategory(rs.getString("Category"));
				book.setKeyword(rs.getString("Keyword"));
				books.add(book);
				
				
			}
			
		}
                return books;

	}

	public Book getById(String id) throws SQLException {
		// TODO Auto-generated method stub\
		String sql = "Select * from Books Where BookId = '" + id + "'";
		try (Connection connection = connetionHelper.getConnection();
				Statement statement = connection.createStatement()) {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				Book book = new Book();
				book.setId(rs.getString("BookId"));
				book.setTitle(rs.getString("Title"));
				book.setAuthor(rs.getString("Author"));
				book.setCategory(rs.getString("Category"));
				book.setKeyword(rs.getString("Keyword"));
				return book;
			}
			return null;
		}
	}

	public Book searchByTitle(String Title) throws SQLException {
		// TODO Auto-generated method stub\
		List<Book> books = new ArrayList<Book>();
		String sql = "Select * from Books Where Title = '" + Title + "'";
		try (Connection connection = connetionHelper.getConnection();
				Statement statement = connection.createStatement()) {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				Book book = new Book();
				book.setId(rs.getString("BookId"));
				book.setTitle(rs.getString("Title"));
				book.setAuthor(rs.getString("Author"));
				book.setCategory(rs.getString("Category"));
				book.setKeyword(rs.getString("Keyword"));
				return book;
			}
			return null;
		}
	}

	public Book searchByCategory(String Category) throws SQLException {
		// TODO Auto-generated method stub\
		String sql = "Select * from Books Where Category = '" + Category + "'";
		try (Connection connection = connetionHelper.getConnection();
				Statement statement = connection.createStatement()) {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				Book book = new Book();
				book.setId(rs.getString("BookId"));
				book.setTitle(rs.getString("Title"));
				book.setAuthor(rs.getString("Author"));
				book.setCategory(rs.getString("Category"));
				book.setKeyword(rs.getString("Keyword"));
				return book;
			}
			return null;
		}
	}

	public Book searchByKeyword(String Keyword) throws SQLException {
		// TODO Auto-generated method stub\
		String sql = "Select * from Books Where Keyword = '" + Keyword + "'";
		try (Connection connection = connetionHelper.getConnection();
				Statement statement = connection.createStatement()) {
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				Book book = new Book();
				book.setId(rs.getString("BookId"));
				book.setTitle(rs.getString("Title"));
				book.setAuthor(rs.getString("Author"));
				book.setCategory(rs.getString("Category"));
				book.setKeyword(rs.getString("Keyword"));
				return book;
			}
			return null;
		}
	}

	public void deleteBook(String id) throws SQLException {
		String sql = "Delete From Books Where BookId='" + id + "'";
		try (Connection connection = connetionHelper.getConnection();
				Statement statement = connection.createStatement()) {
			statement.execute(sql);
		}

	}

	public void updateBook(Book book) throws SQLException {
		String sql = "Update Books Set Title=? Author=? Category=? Keyword=? Where BookId='" + book.getId() + "'";
		try (Connection connection = connetionHelper.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, book.getTitle());
			statement.setString(2, book.getAuthor());
			statement.setString(3, book.getCategory());
			statement.setString(4, book.getKeyword());
			statement.execute();
		}

	}

	public void addBook(Book book) throws SQLException {
		String sql = "Insert into Books values (?,?,?,?,?) ";
		try (Connection connection = connetionHelper.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, book.getId());
			statement.setString(2, book.getTitle());
			statement.setString(3, book.getAuthor());
			statement.setString(4, book.getCategory());
			statement.setString(5, book.getKeyword());
			statement.execute();
		}
	}

    public void updateBook(java.awt.print.Book book) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
