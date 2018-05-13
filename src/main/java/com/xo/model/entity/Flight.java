package com.xo.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Audited
@EqualsAndHashCode(callSuper = true)
public class Flight extends AbstractEntity {

    @ManyToOne(optional = false)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private City from;

    @ManyToOne(optional = false)
    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    private City to;

    @Column(unique = true, nullable = false)
    private String flightNo;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

}
