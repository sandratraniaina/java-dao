package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import dao.exception.DaoException;
import sql.criteria.Pagination;
import sql.criteria.Range;
import sql.SQLBuilder;
import utils.SQLUtils;
import utils.XMLHandler;

public class Dao {
    SQLUtils sqlUtils;

    //Class method
    public ArrayList<Object> readAllPagination(Connection connection, Object object, Pagination pagination) throws Exception {
        if (connection == null) {
            throw new DaoException("Connection cannot be null (readAllPagination).");
        }
        String query = SQLBuilder.getReadingQuery(object, false);
        query += pagination.toQuery(getSqlUtils().getEngineType());
        return getSqlUtils().executeQuery(connection, object, query);
    }

    public ArrayList<Object> readAllPagination(Object object, Pagination pagination) throws Exception {
        Connection connection = getSqlUtils().getConnection();
        ArrayList<Object> result =  readAllPagination(connection, object, pagination);
        if (connection != null) {
            connection.close();
        }
        return result;
    }

    public ArrayList<Object> readAllRange(Connection connection, Object object, ArrayList<Range> ranges) throws Exception {
        if (connection == null) {
            throw new DaoException("Connection cannot be null (readAllRange).");
        }
        String query = SQLBuilder.getReadingQuery(object, false);
        for (Range range : ranges) {
            query += range.toQuery(null);
        }
        return getSqlUtils().executeQuery(connection, object, query);
    }

    public ArrayList<Object> readAllRange(Object object, ArrayList<Range> ranges) throws Exception {
        Connection connection = getSqlUtils().getConnection();
        ArrayList<Object> result =  readAllRange(connection, object, ranges);
        if (connection != null) {
            connection.close();
        }
        return result;
    }

    public ArrayList<Object> readAllCriteria(Object object) throws Exception {
        Connection connection = getSqlUtils().getConnection();
        ArrayList<Object> result =  readAllCriteria(connection, object);
        if (connection != null) {
            connection.close();
        }
        return result;
    }

    public ArrayList<Object> readAllCriteria(Connection connection, Object object) throws Exception {
        if (connection == null) {
            throw new DaoException("Connection cannot be null (readAll true).");
        }
        String query = SQLBuilder.getReadingQuery(object, true);
        return getSqlUtils().executeQuery(null, object, query);
    }

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
    public Dao(String contextPath) throws Exception {
        HashMap<String, String> dbInfo = XMLHandler.getRootValues(contextPath);
        
        SQLUtils sqlUtils = new SQLUtils();

        sqlUtils.setUrl(dbInfo.get("url"));
        sqlUtils.setDriver(dbInfo.get("driver"));
        sqlUtils.setEngineType(dbInfo.get("engine"));
        sqlUtils.setPassword(dbInfo.get("password"));
        sqlUtils.setUser(dbInfo.get("user"));

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