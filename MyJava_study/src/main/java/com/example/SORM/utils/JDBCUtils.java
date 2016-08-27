package com.example.SORM.utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Administrator on 2016/8/24.
 */
public class JDBCUtils {
    public static void handleParam(PreparedStatement preparedStatement, Object[] parma) throws SQLException {
        for (int i = 0; i < parma.length; i++) {
            preparedStatement.setObject(1 + i, parma[i]);
        }
    }

    public static void closeAll(AutoCloseable... ios) {
        for (AutoCloseable cc : ios
                ) {
            if (cc != null)
                try {
                    cc.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }
}
