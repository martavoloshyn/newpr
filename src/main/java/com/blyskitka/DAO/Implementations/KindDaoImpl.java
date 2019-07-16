package com.blyskitka.DAO.Implementations;

import com.blyskitka.DAO.Interfaces.KindDao;
import com.blyskitka.Entity.Kind;
import com.blyskitka.Enums.Category;
import com.blyskitka.JDBC.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KindDaoImpl implements KindDao {

    private Connection connection ;

    public KindDaoImpl() {
        connection= DBConnection.getConnection();
    }


    @Override
    public List<Kind> getKindByCategory(Integer idCategory) throws SQLException {
        String query = "SELECT * FROM kinds WHERE category=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,idCategory);
        List<Kind> kinds = new ArrayList<>();
        ResultSet set = statement.executeQuery();
        while(set.next()){
            Kind kind = new Kind();
            kind.setId(set.getInt("id"));
            kind.setKind(set.getString("kind"));
            kind.setIdCategory(set.getInt("idCategory"));
            kinds.add(kind);
        }
        set.close();
        statement.close();
        return kinds;
    }

    @Override
    public void insert(Kind obj) throws SQLException {
        String query = "INSERT INTO kinds (id, kind, category ) VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,obj.getId());
        statement.setString(2,obj.getKind());
        statement.setInt(3,obj.getIdCategory());
        statement.execute();
        statement.close();
    }

    @Override
    public Kind getById(int id) throws SQLException {
        String query = "SELECT * FROM kinds WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,id);
        ResultSet set = statement.executeQuery();
        Kind kind = new Kind();
        if(set.next()){
            kind.setId(set.getInt("id"));
            kind.setKind(set.getString("kind"));
            kind.setIdCategory(set.getInt("category"));
        }
        set.close();
        statement.close();
        return kind;
    }

    @Override
    public void update(Kind obj) throws SQLException {
        String query = "UPDATE kinds SET kind=?, category=?  WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,obj.getKind());
        statement.setInt(2,obj.getIdCategory());
        statement.setInt(3,obj.getId());
        statement.execute();
        statement.close();
    }

    @Override
    public void delete(Kind obj) throws SQLException {
        String query = "DELETE FROM kinds WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1,obj.getId());
        statement.execute();
        statement.close();
    }

    @Override
    public List getAll() throws SQLException {
        String query = "SELECT * FROM kinds";
        PreparedStatement statement = connection.prepareStatement(query);
        List<Kind> kinds = new ArrayList<>();
        ResultSet set = statement.executeQuery();
        while(set.next()){
            Kind kind = new Kind();
            kind.setId(set.getInt("id"));
            kind.setKind(set.getString("kind"));
            kind.setIdCategory(set.getInt("idCategory"));
            kinds.add(kind);
        }
        set.close();
        statement.close();
        return kinds;
    }
}
