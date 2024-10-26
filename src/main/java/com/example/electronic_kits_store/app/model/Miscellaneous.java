package com.example.electronic_kits_store.app.model;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

import java.util.HashMap;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "miscellaneous")
@PrimaryKeyJoinColumn(name = "miscellaneous_id")
public class Miscellaneous extends Product{
    @Type(JsonType.class)
    @Column(name = "otherInfo", columnDefinition = "json")
    private Map<String, String> otherInfo = new HashMap<>();

}
