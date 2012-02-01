/************************************************
 * This file was generated by ....
 ************************************************/

package prototype;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * DAO class to map a Author object to the AUTHOR table of the
 * database.
 */
public class AuthorDAO {

    /**
     * Connection to the database.
     */
    private Connection connection = null;


    /**
     * To instanciate the Author DAO.
     * @param dbConnection The connection to the database. Must be
     *                     opened and valid.
     */
    public AuthorDAO(final Connection dbConnection) {
        connection = dbConnection;
    }


    /**
     * Retrieve a Author by Id.
     * @param id Id of the Author to retrieve.
     * @return The Author retrieved.
     * @throws DAOException Exception that occured during the execution of the
     *                      query.
     */
    public final Author getAuthor(final Integer id) throws DAOException {
        try {
            PreparedStatement query = connection.prepareStatement(
                                    "select * from AUTHOR where AUTHOR_ID=?");
            query.setInt(1, id.intValue());

            ResultSet result = query.executeQuery();
            result.beforeFirst();
            if (result.next()) {
                Author author = new Author();

                author.setId(result.getInt("AUTHOR_ID"));
                author.setFirstname(result.getString("firstname"));
                author.setLastname(result.getString("lastname"));
                author.setBirthdate(result.getDate("birthdate"));
                author.setDeath(result.getDate("death"));

                PreparedStatement books = connection.prepareStatement(
                           "select BOOK_ID from AUTHOR_BOOK where AUTHOR_ID=?");
                books.setInt(1, author.getId().intValue());

                ResultSet booksResult = books.executeQuery();
                booksResult.beforeFirst();
                while (booksResult.next()) {
                    author.addBook(booksResult.getInt("BOOK_ID"));
                }

                return author;
            }
        } catch (SQLException e) {
            throw new DAOException("Unable to perform query on database.", e);
        }
        return null;
    }

    /**
     * Retrieve all Author.
     * @return A list of all Authors.
     * @throws DAOException Exception that occured during the execution of the
     *                      query.
     */
    public final ArrayList<Author> getAllAuthors() throws DAOException {
        try {
            PreparedStatement query = connection.prepareStatement(
                                                       "select * from AUTHOR");

            ResultSet result = query.executeQuery();
            result.beforeFirst();
            ArrayList<Author> list = new ArrayList<Author>();

            while (result.next()) {
                Author author = new Author();

                author.setId(result.getInt("AUTHOR_ID"));
                author.setFirstname(result.getString("firstname"));
                author.setLastname(result.getString("lastname"));
                author.setBirthdate(result.getDate("birthdate"));
                author.setDeath(result.getDate("death"));

                PreparedStatement books = connection.prepareStatement(
                           "select BOOK_ID from AUTHOR_BOOK where AUTHOR_ID=?");
                books.setInt(1, author.getId().intValue());

                ResultSet booksResult = books.executeQuery();
                booksResult.beforeFirst();
                while (booksResult.next()) {
                    author.addBook(booksResult.getInt("BOOK_ID"));
                }

                list.add(author);
            }

            return list;
        } catch (SQLException e) {
            throw new DAOException("Unable to perform query on database.", e);
        }
    }

    /**
     * Delete a Author by Id.
     * @param id The Id of the Author to delete.
     * @throws DAOException Exception that occured during the execution of the
     *                      query.
     */
    public final void delete(final Integer id) throws DAOException {
        try {
            PreparedStatement books = connection.prepareStatement(
                                  "delete from AUTHOR_BOOK where AUTHOR_ID=?");
            books.setInt(1, id);
            books.executeUpdate();

            PreparedStatement query = connection.prepareStatement(
                                      "delete from AUTHOR where AUTHOR_ID=?");
            query.setInt(1, id);
            query.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Unable to perform delete on database.", e);
        }
    }


    /**
     * Save a Author to database. If the Id of the object is null, a new
     * row is created. If the Id of the object is specified, an update is done
     * on this record.
     * @param author The Author object to save.
     * @throws DAOException Exception that occured during the execution of the
     *                      query.
     * @throws NullityException Raised if a required field is null in the
     *                          object.
     */
    public final void save(final Author author) throws DAOException,
                                                       NullityException {
        checkNullity(author);

        if (author.getId() == null) {
            author.setId(getNewId());

            try {
                PreparedStatement query = connection.prepareStatement(
                    "insert into AUTHOR(AUTHOR_ID, firstname, lastname, "
                    + "birthdate, death) "
                    + "values(?, ?, ?, ?, ?)");
                query.setInt(1, author.getId().intValue());
                query.setString(2, author.getFirstname());
                query.setString(3, author.getLastname());
                query.setDate(4,
                        new java.sql.Date(author.getBirthdate().getTime()));

                if (author.getDeath() == null) {
                    query.setNull(5, java.sql.Types.DATE);
                } else {
                    query.setDate(5,
                            new java.sql.Date(author.getDeath().getTime()));
                }

                query.executeUpdate();
            } catch (SQLException e) {
                throw new DAOException("Unable to perform insert on database.",
                                       e);
            }
        } else {
            try {
                PreparedStatement query = connection.prepareStatement(
                                "update AUTHOR set firstname=?, lastname=?, "
                              + "birthdate=?, "
                              + "death=? where AUTHOR_ID=?");
                query.setString(1, author.getFirstname());
                query.setString(2, author.getLastname());
                query.setDate(3,
                        new java.sql.Date(author.getBirthdate().getTime()));

                if (author.getDeath() == null) {
                    query.setNull(4, java.sql.Types.DATE);
                } else {
                    query.setDate(4,
                             new java.sql.Date(author.getDeath().getTime()));
                }
                query.setInt(5, author.getId().intValue());

                query.executeUpdate();

                PreparedStatement deleteBooks = connection.prepareStatement(
                                   "delete from AUTHOR_BOOK where AUTHOR_ID=?");
                deleteBooks.setInt(1, author.getId());
                deleteBooks.executeUpdate();
            } catch (SQLException e) {
                throw new DAOException("Unable to perform update on database.",
                                       e);
            }
        }

        try {
            for (Integer bookId : author.getBookList()) {
                PreparedStatement link = connection.prepareStatement(
                        "insert into AUTHOR_BOOK(AUTHOR_ID, BOOK_ID) "
                        + "values(?, ?)");
                link.setInt(1, author.getId());
                link.setInt(2, bookId);
                link.executeUpdate();
            }
        } catch (SQLException e) {
            throw new DAOException("Unable to perform insert on database.",
                    e);
        }
    }


    /**
     * Fetch a new Id for an object based on the max Id in the table.
     * @return The new Id.
     * @throws DAOException Exception that occured during the execution of the
     *                      query.
     */
    protected final Integer getNewId() throws DAOException {
        try {
            PreparedStatement query = connection.prepareStatement(
                                "select max(AUTHOR_ID) as NEWID from AUTHOR");
            ResultSet result = query.executeQuery();

            if (result.next()) {
                 return new Integer(result.getInt("NEWID") + 1);
            } else {
                 return new Integer(0);
            }
         } catch (SQLException e) {
             throw new DAOException("Unable to perform query on database.", e);
         }
    }


    /**
     * Verify if any required field is null in the object.
     * @param author The instance to verify.
     * @throws NullityException Raised if a required field is null in the
     *                          object.
     */
    protected final void checkNullity(final Author author)
                                                       throws NullityException {
        if (author.getFirstname() == null) {
            throw new NullityException("Author", "firstname");
        }
        if (author.getLastname() == null) {
            throw new NullityException("Author", "lastname");
        }
        if (author.getBirthdate() == null) {
            throw new NullityException("Author", "birthdate");
        }
    }
}
