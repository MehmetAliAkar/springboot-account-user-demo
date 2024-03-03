package com.mehmetaliakar.springbootaccountuserdemo.model;

import com.mehmetaliakar.springbootaccountuserdemo.core.endpoint.BaseEndpoints;
import com.mehmetaliakar.springbootaccountuserdemo.core.model.BaseModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Account extends BaseModel {
    private String name;

    @OneToMany(mappedBy = "account", cascade = CascadeType.MERGE, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<User> users = new ArrayList<>();

}
