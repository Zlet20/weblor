package com.example.weblor.feature.model;

import java.time.LocalDate;
import java.util.UUID;

import com.example.weblor.item.model.Item;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
@Table(name = "usage_info")
public class UsageInfo {
@Id	
private UUID id;
@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
@JoinColumn(name = "item_id",referencedColumnName = "id")
private Item item;

private LocalDate time;
@OneToOne
@JoinColumn(name = "student_id")
private StudentInfo student; 
}
