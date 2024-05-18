package dao;

import java.sql.Connection;
import java.util.ArrayList;

import dao.exception.DaoException;
import sql.criteria.Pagination;
import sql.criteria.Range;
import sql.SQLBuilder;
import utils.SQLUtils;

public class Dao {
    SQLUtils sqlUtils;

    //Class method
    public ArrayList<Object> readAll(Object object) throws Exception {
        Connection connection = getSqlUtils().getConnection();
        ArrayList<Object> result =  readAll(connection, object);
        if (connection != null) {
            connection.close();
        }
        return result;
    }

    public ArrayList<Object> readAll(Connection connection, Object object) throws Exception {
        if (connection == null) {
            throw new DaoException("Connection cannot be null (readAll false).");
        }
        String query = SQLBuilder.getReadingQuery(object, false);
        return getSqlUtils().executeQuery(connection, object, query);
    }

    public void save (Connection connection, Object object) throws Exception {
        if (connection == null) {
            throw new DaoException("Connection cannot be null (save).");
        }
        String query = SQLBuilder.getInsertingQuery(object);
        getSqlUtils().execute(connection, object, query);
    }
    
    public void save (Object object) throws Exception {
        Connection connection = getSqlUtils().getConnection();
        save(connection, object);
        if (connection != null) {
            connection.close();
        }
    }

    //Constructors
    public Dao() {}
    public Dao(SQLUtils sqlUtils) {
        setSqlUtils(sqlUtils);
    }

    //Getters and setters
    public SQLUtils getSqlUtils() {
        return sqlUtils;
    }

    public void setSqlUtils(SQLUtils sqlUtils) {
        this.sqlUtils = sqlUtils;
    }
}