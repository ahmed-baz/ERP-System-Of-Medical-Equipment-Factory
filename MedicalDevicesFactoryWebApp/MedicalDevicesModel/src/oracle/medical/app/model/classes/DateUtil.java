package oracle.medical.app.model.classes;

import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class DateUtil {

    public static java.util.Date convertDateFromSqlToUtil(java.sql.Date myDate) {
        return new java.util.Date(myDate.getTime());
    }

    public static java.sql.Date convertDateFromUtilToSql(java.util.Date myDate) {
        return new java.sql.Date(myDate.getTime());
    }

    public static oracle.jbo.domain.Date convertDateFromSqlToJbo(java.sql.Date myDate) {
        return new oracle.jbo.domain.Date(myDate);
    }

    public static java.sql.Date convertDateFromJboToSql(oracle.jbo.domain.Date myDate) {
        return myDate.dateValue();
    }

    public static java.util.Date convertDateFromJboToUtil(oracle.jbo.domain.Date myDate) {
        java.sql.Date sqlDate = convertDateFromJboToSql(myDate);
        return convertDateFromSqlToUtil(sqlDate);
    }


    public static oracle.jbo.domain.Date convertDateFromUtilToJbo(java.util.Date myDate) throws SQLException {
        java.sql.Date sqlDate = convertDateFromUtilToSql(myDate);
        return convertDateFromSqlToJbo(sqlDate);
    }

}
