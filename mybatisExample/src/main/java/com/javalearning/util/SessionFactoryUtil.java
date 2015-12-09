package com.javalearning.util;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Throwables;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by renqun.yuan on 2015/12/8.
 */
public class SessionFactoryUtil {
    public static Supplier<SqlSessionFactory> getSqlSessionFactory() {
        return Suppliers.memoize(new Supplier<SqlSessionFactory>() {
            @Override
            public SqlSessionFactory get() {
                Reader resourceAsReader = null;
                try {
                    resourceAsReader = Resources.getResourceAsReader("mybatis-config.xml");
                } catch (IOException e) {
                    Throwables.propagate(e);
                }
                SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
                return sqlSessionFactory;
            }
        });
    }
}
