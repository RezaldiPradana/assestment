package com.assestment.fruit.repository.implement;

import com.assestment.fruit.config.properties.AppProperties;
import com.assestment.fruit.model.Fruit;
import com.assestment.fruit.repository.FruitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class FruitImplement implements FruitRepository {
    private final AppProperties appProperties;
    private final JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public FruitImplement (@Qualifier(AppProperties.BEAN_APP_CONF) AppProperties appProperties,
                           @Qualifier(AppProperties.BEAN_JDBC_FRUIT) JdbcTemplate jdbcTemplate){
        this.appProperties = appProperties;
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
    }

    @Override
    public Fruit findFruitBySeqId(String seqId) {
        log.info("[----EXECQUERY {} :: {} -> {}]", "findDataBarangBySeqId", appProperties.getQUERY_FIND_BY_SEQID(), seqId);
        return jdbcTemplate.query(appProperties.getQUERY_FIND_BY_SEQID(), new BeanPropertyRowMapper<>(Fruit.class), seqId).stream().findFirst().orElse(null);
    }


    @Autowired
    public void insertFruit(Fruit fruit){
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("buah",fruit.getBuah());
        mapSqlParameterSource.addValue("harga",fruit.getHarga());
        namedParameterJdbcTemplate.update(appProperties.getQUERY_INSERT_FRUIT(),mapSqlParameterSource );
        log.info("[----EXECQUERY {} :: {} -> {} | {} | {}]", "insertBuah", appProperties.getQUERY_INSERT_FRUIT(), fruit.getBuah(),fruit.getHarga());

    }

    @Autowired
    public void updateFruit(Fruit fruit){
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("seqId", fruit.getSeqId());
        mapSqlParameterSource.addValue("buah",fruit.getBuah());
        mapSqlParameterSource.addValue("harga",fruit.getHarga());
        namedParameterJdbcTemplate.update(appProperties.getQUERY_UPDATE_FRUIT(),mapSqlParameterSource );
        log.info("[----EXECQUERY {} :: {} -> {} | {} | {}]", "updateBuah", appProperties.getQUERY_UPDATE_FRUIT(), fruit.getBuah(),fruit.getHarga());
    }

    @Autowired
    public  void deleteFruit(String seqId){
        jdbcTemplate.update(appProperties.getQUERY_DELETE_FRUIT(), seqId);
        log.info("[----EXECQUERY {} :: {} -> {}]", "deleteDataBarang", appProperties.getQUERY_DELETE_FRUIT(), seqId);

    }
}
