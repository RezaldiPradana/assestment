package com.assestment.fruit.config.properties;

import lombok.Data;

@Data
public class AppProperties {

    /* App Config */
    private String APP_NAME = "fruit";
    private String APP_VERSION = "v1";

    /* Query */
    private String QUERY_FIND_BY_SEQID = "SELECT * FROM tb_fruit WHERE \"seqId\" = ?";
    private String QUERY_INSERT_FRUIT = "INSERT INTO tb_fruit (\"buah\", \"harga\") VALUES (:buah, :harga)";
    private String QUERY_UPDATE_FRUIT = "UPDATE tb_fruit SET \"buah\" = :buah, \"harga\" = :harga WHERE \"seqId\" = :seqId";
    private String QUERY_DELETE_FRUIT = "DELETE FROM tb_fruit WHERE \"seqId\" = ?";


    public static final String BEAN_APP_CONF = "app-config";
    public static final String BEAN_DS_FRUIT = "DS-FRUIT";
    public static final String BEAN_JDBC_FRUIT = "JDBC-FRUIT";

}
