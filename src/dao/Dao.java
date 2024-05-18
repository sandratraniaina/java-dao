package dao;

import java.sql.Connection;

import dao.exception.DaoException;
import sql.criteria.Pagination;
import sql.criteria.Range;
import sql.SQLBuilder;
import utils.SQLUtils;

public class Dao {
    //Class method
    public void save (Connection connection, Object object) throws Exception {
        if (connection == null) {
            throw new DaoException("Connection cannot be null (save).");
        }
        String query = SQLBuilder.getInsertingQuery(object);
        SQLUtils.execute(connection, object, query);
    }
    
    public void save (Object object) throws Exception {
        Connection connection = SQLUtils.getConnection();
        save(connection, object);
        if (connection != null) {
            connection.close();
        }
    }
}