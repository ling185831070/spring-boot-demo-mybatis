package org.ling.springboot.tk.mybatis.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class MapperConfig {

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("dataSource") DataSource dataSource) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // domain所在package
//        bean.setTypeAliasesPackage("org.ling.springboot.tk.mybatis.domain");
        // 分页插件---由于引用的jar使用了自动配置，因此不需创建插件填充属性，jar自动创建
//        PageInterceptor pageInterceptor = new PageInterceptor();
//        pageInterceptor.setProperties(properties);
        // 添加插件
//        bean.setPlugins(new Interceptor[]  { pageInterceptor});
        // 添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        try {
            //这样配置mapper.xml是否可用，待验证
            bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
        } catch (Exception e) {
        }

        try {
            return bean.getObject();
        } catch (Exception e) {
            throw new IllegalArgumentException("org.mybatis.spring.SqlSessionFactoryBean init N ", e);
        }
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        // 配置多个的时候，最后一个需要以分号结尾，一个的时候是不需要分号的
        mapperScannerConfigurer.setBasePackage("org.ling.springboot.tk.mybatis.mapper");
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        Properties properties = new Properties();
        properties.setProperty("mappers", "tk.mybatis.mapper.common.Mapper");
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }
}
