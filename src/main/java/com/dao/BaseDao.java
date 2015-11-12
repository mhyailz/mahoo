package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;
import java.util.Map;

/**
 * Created by mahoo on 2015/11/12.
 */
public class BaseDao {

    @Autowired
    private SqlMapClientTemplate sqlMapClientTemplate;


    public Object queryForObject(String statementName) throws DataAccessException {
        return sqlMapClientTemplate.queryForObject(statementName);
    }

    public Object queryForObject(final String statementName, final Object parameterObject) throws DataAccessException {
        return sqlMapClientTemplate.queryForObject(statementName, parameterObject);
    }

    public Object queryForObject(final String statementName, final Object parameterObject, final Object resultObject) throws DataAccessException {
        return sqlMapClientTemplate.queryForObject(statementName, parameterObject, resultObject);
    }

    public List queryForList(String statementName) throws DataAccessException {
        return sqlMapClientTemplate.queryForList(statementName);
    }

    public List queryForList(final String statementName, final Object parameterObject) throws DataAccessException {
        return sqlMapClientTemplate.queryForList(statementName,parameterObject);
    }

    public List queryForList(String statementName, int skipResults, int maxResults) throws DataAccessException {
        return sqlMapClientTemplate.queryForList(statementName, skipResults, maxResults);
    }

    public List queryForList(final String statementName, final Object parameterObject, final int skipResults, final int maxResults) throws DataAccessException {
        return sqlMapClientTemplate.queryForList(statementName,parameterObject,skipResults,maxResults);
    }


    public Map queryForMap(final String statementName, final Object parameterObject, final String keyProperty) throws DataAccessException {
        return sqlMapClientTemplate.queryForMap(statementName,parameterObject,keyProperty);
    }

    public Map queryForMap(final String statementName, final Object parameterObject, final String keyProperty, final String valueProperty) throws DataAccessException {
        return sqlMapClientTemplate.queryForMap(statementName,parameterObject,keyProperty,valueProperty);
    }

    public Object insert(String statementName) throws DataAccessException {
        return sqlMapClientTemplate.insert(statementName);
    }

    public Object insert(final String statementName, final Object parameterObject) throws DataAccessException {
        return sqlMapClientTemplate.insert(statementName,parameterObject);
    }

    public int update(String statementName) throws DataAccessException {
        return sqlMapClientTemplate.update(statementName);
    }

    public int update(final String statementName, final Object parameterObject) throws DataAccessException {
        return sqlMapClientTemplate.update(statementName,parameterObject);
    }

    public void update(String statementName, Object parameterObject, int requiredRowsAffected) throws DataAccessException {
        sqlMapClientTemplate.update(statementName,parameterObject,requiredRowsAffected);
    }

    public int delete(String statementName) throws DataAccessException {
        return sqlMapClientTemplate.delete(statementName);
    }

    public int delete(final String statementName, final Object parameterObject) throws DataAccessException {
        return sqlMapClientTemplate.delete(statementName, parameterObject);
    }

    public void delete(String statementName, Object parameterObject, int requiredRowsAffected) throws DataAccessException {
         sqlMapClientTemplate.delete(statementName, parameterObject, requiredRowsAffected);
    }


}
