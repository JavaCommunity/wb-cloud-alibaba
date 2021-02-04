package com.wb.dynamic.datasource.component.config;

/**
 * @ClassName: DynamicDataSourceContext
 * @Package: com.wb.dynamic.datasource.component.config
 * @Description: the dynamic datasource context
 * @Author：[bo.wang]
 * @Date: 2021/2/2
 * @Version: 1.0
 */
public class DynamicDataSourceContext {

    //  the default dynamic context
    private static final ThreadLocal<String> DEFAULT_DYNAMIC_CONTEXT = new ThreadLocal<>();

    /**
     * get current datasource
     *
     * @return the datasource
     */
    public static String getCurrentDataSource() {
        return DEFAULT_DYNAMIC_CONTEXT.get();
    }

    /**
     * set current datasource
     *
     * @param currentDataSource the current datasource
     */
    public static void setCurrentDataSource(String currentDataSource) {
        DEFAULT_DYNAMIC_CONTEXT.set(currentDataSource);
    }

    /**
     * remove current datasource
     */
    public static void removeCurrentDataSource() {
        DEFAULT_DYNAMIC_CONTEXT.remove();
    }
}
