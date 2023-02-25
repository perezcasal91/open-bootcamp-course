package com.perezcasal.designpatterns.patterns.behavioral.template;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DataBaseConnectionMain {

    public static void main(String[] args) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.query("SELECT * FROM books", new BookRowMapper());
    }
}

abstract class DatabaseQuery {
    public void execute() {
        Connection connection = createConnection();
    }

    protected Connection createConnection() {
        return Connection.getInstance();
    }

    protected void closeConnection(Connection connection) {
        connection.close();
    }

    protected abstract void executeQuery(Connection connection);

    public <T> T execute(String query, ResultsMapper<T> mapper) {
        Connection connection = createConnection();
        Results results = executeQuery(connection, query);
        closeConnection(connection);
        return mapper.map(results);
    }

        protected Results executeQuery(Connection connection, String query) {
           return null;
        }
}

class Connection {

    private static Connection connection;

    public static Connection getInstance() {
        if (connection == null){
            connection = new Connection();
        }
        return connection;
    }

    public void close() {
        System.out.println("Connection closed");
    }
}

interface ResultMapper<T> {
    public T map(Results results);
}

class Results {}
class ResultsMapper<T> {
    public T map(Results results) {
        return null;
    }
}

class JdbcTemplate {

    public <T> T result(final String sql, final ResultSetExtractor<T> rse) throws DataAccessException {
       return null;
    }

    public <T> List<T> query(String sql, RowMapper<T> rowMapper) throws DataAccessException {
        return (List<T>) result(query(sql, (RowMapper<T>) new RowMapperResultSetExtractor<>(rowMapper)));
    }

    private <T> Object result(List<T> query) {
        return null;
    }
}

@FunctionalInterface
interface ResultSetExtractor<T> {
    T extractData(ResultSet rs) throws SQLException, DataAccessException;
}

@FunctionalInterface
interface RowMapper<T> extends org.springframework.jdbc.core.RowMapper<T> {
    T mapRow(ResultSet rs, int rowNum) throws SQLException;
}

class BookRowMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {

        Book book = new Book();

        book.setId(rs.getLong("id"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));

        return book;
    }
}

class Book {
    private Long id;
    private String title;
    private String author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

