package com.SkyBlue.common.util;


import oracle.jdbc.driver.OracleConnection;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;


import java.sql.*;

public class OracleCallBackHandler implements TypeHandler<Object> {

    Connection conn;

    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        // TODO Auto-generated method stub
        //커넥션 획득
        if (ps.getConnection().isWrapperFor(OracleConnection.class)) {
            this.conn = ps.getConnection().unwrap(OracleConnection.class);
        }
        ArrayDescriptor desc = ArrayDescriptor.createDescriptor("MPS_NO_ARRAY", conn);
        parameter = new ARRAY(desc, conn, parameter);
        ps.setArray(i, (oracle.sql.ARRAY) parameter);
    }

    @Override
    public Object getResult(ResultSet rs, String columnName) {
        // TODO Auto-generated method stub
        String value = "";
        try {

            if (StringUtils.isNotEmpty(rs.getString(columnName))) {
                value = new String(rs.getString(columnName).
                        getBytes("8859_1"), "KSC5601");
            }

        } catch (Exception e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        }

        return value;

    }

    @Override
    public Object getResult(ResultSet resultSet, int i) {
        return null;
    }

    @Override
    public Object getResult(CallableStatement callableStatement, int i)throws SQLException{
        return callableStatement.getString(i);
    }

}
